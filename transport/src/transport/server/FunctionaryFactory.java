package transport.server;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import transport.logic.*;

public class FunctionaryFactory {
	private Logger logger;

	public FunctionaryFactory() {
		logger=Logger.getLogger("transport.server.FunctionaryFactory");
	}

	protected static Functionary[] getFunctionariesForTransport(int transportId) throws
		SQLException {
		ArrayList a=new ArrayList();

		Connection conn=ConnectionFactory.getConnection();

		PreparedStatement st=conn.prepareStatement(
			"select * from functionary_transport where transport_id = ?");
		st.setInt(1, transportId);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			a.add(new FunctionaryFactory().getFunctionary(rs.getInt(
				"functionary_id")));
		}

		return (Functionary[])a.toArray();
	}

	public Functionary[] getFunctionariesFreeBetween(java.util.Date from,
		java.util.Date to) {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from functionaries where functionaries.id not in (select functionary_id from functionary_transport, transports where transports.return_time <= ? and (transports.start_time>= ? or transports.actual_return_time >= ? ) and functionary_transport.transport_id=transports.id)");

			java.sql.Date d1=new java.sql.Date(from.getTime());
			java.sql.Date d2=new java.sql.Date(to.getTime());

			st.setDate(1, d1);
			st.setDate(2, d2);
			st.setDate(3, d2);

			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				a.add(new Functionary(rs.getInt(1), rs.getString(2),
									  rs.getDate(3),
									  rs.getDate(4),
									  new RoleFactory().getRole(rs.getInt(5))));
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return (Functionary[])a.toArray();
	}

	public Functionary getFunctionary(int id) {
		Functionary f=null;

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"select * from functionaries where id = ?");

			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			rs.first();
			f=new Functionary(rs.getInt(1), rs.getString(2), rs.getDate(3),
							  rs.getDate(4),
							  new RoleFactory().getRole(rs.getInt(5)));
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return f;
	}

	public Functionary[] getAllFunctionaries() {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"select * from functionaries");
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				a.add(new Functionary(rs.getInt(1), rs.getString(2),
									  rs.getDate(3),
									  rs.getDate(4),
									  new RoleFactory().getRole(rs.getInt(5))));
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		Functionary[] ar=new Functionary[a.size()];
		a.toArray(ar);

		return ar;
	}

	public Functionary newFunctionary(Functionary newFunctionary) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("insert into functionaries (name, begins_work, stops_work, role_id) values ( ? , ? , ? , ? )");
			st.setString(1, newFunctionary.getName());
			st.setDate(2,
					   new java.sql.Date(newFunctionary.getBeginsWork().getTime()));
			st.setDate(3,
					   new java.sql.Date(newFunctionary.getStopsWork().getTime()));
			st.setInt(4, newFunctionary.getRole().getId());

			// FIXME: error checking, damnit!
			st.executeUpdate();

			Statement st2=conn.createStatement();
			ResultSet rs=st2.executeQuery(
				"select currval('functionaries_id_seq')");
			rs.next();

			newFunctionary.setId(rs.getInt(1));

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return newFunctionary;
	}

	public void updateFunctionary(Functionary updatedFunctionary) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("update cars set name = ? , begins_work = ? , stops_work = ? , role_id = ? where id = ?");
			st.setString(1, updatedFunctionary.getName());
			st.setDate(2,
					   new java.sql.Date(updatedFunctionary.getBeginsWork().getTime()));
			st.setDate(3,
					   new java.sql.Date(updatedFunctionary.getStopsWork().getTime()));
			st.setInt(4, updatedFunctionary.getRole().getId());
			st.setInt(5, updatedFunctionary.getId());

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public void deleteFunctionary(int id) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"delete from functionaries where id = ?");
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
