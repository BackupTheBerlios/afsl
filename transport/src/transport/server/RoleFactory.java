package transport.server;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import transport.logic.*;

public class RoleFactory {
	private Logger logger;

	public RoleFactory() {
		logger=Logger.getLogger("transport.server.RoleFactory");
	}

	public Role getRole(int id) {
		Role c=null;

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"select * from roles where id = ?");

			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			rs.first();
			c=new Role(id, rs.getString(2), rs.getString(3));

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return c;
	}

	public Role[] getAllRoles() {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from roles");
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				a.add(new Role(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		Role[] ar=new Role[a.size()];

		a.toArray(ar);

		return ar;
	}

	public Role newRole(Role newRole) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"insert into roles (short_descr, long_descr) values ( ? , ? )");
			st.setString(1, newRole.getShortDescr());
			st.setString(2, newRole.getLongDescr());
			// FIXME: error checking, damnit!
			st.executeUpdate();

			Statement st2=conn.createStatement();
			ResultSet rs=st2.executeQuery("select currval('roles_id_seq')");
			rs.next();

			newRole.setId(rs.getInt(1));

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return newRole;
	}

	public void updateRole(Role updatedRole) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"update roles set short_descr = ? , long_descr = ?  where id = ?");
			st.setString(1, updatedRole.getShortDescr());
			st.setString(2, updatedRole.getLongDescr());
			st.setInt(3, updatedRole.getId());

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public void deleteRole(int id) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"delete from roles where id = ?");

		   st.setInt(1,id);

			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public void deleteRole(Role deletedRole) {
		deleteRole(deletedRole.getId());
	}
}
