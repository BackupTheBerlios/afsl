package transport.server;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import transport.logic.*;

/**
 * This factory class produces transport objects.
 * @author Ola Sundell
 */

public class TransportFactory {
	private Logger logger;

	public TransportFactory() {
		logger=Logger.getLogger("transport.server.TransportFactory");
	}

	private void calcDistance(Transport t, Connection conn) {
	}

	private Transport newTransport(int id, java.util.Date startTime,
								   java.util.Date returnTime,
								   java.util.Date actualReturnTime,
								   boolean internal,
								   int mobilePhoneId,
								   String miscInfo,
								   Connection conn) throws SQLException {
		Transport t;

		MobilePhoneFactory mpf=new MobilePhoneFactory();

		t=new Transport(id,
						startTime,
						returnTime,
						actualReturnTime,
						internal,
						MobilePhoneFactory.getMobilePhonesForTransport(id),
						TransportWaypointFactory.getDropoffs(id),
						CarFactory.getCarsForTransport(id),
						ArtistFactory.getArtistsForTransport(id),
						FunctionaryFactory.getFunctionariesForTransport(id),
						0,
						miscInfo);

		calcDistance(t, conn);

		return t;
	}

	/**
	 * This method gets a transport according to its corresponding id.
	 * @param id the id of the transport
	 */

	public Transport getTransport(int id) {
		Transport t=null;

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"select * from transports where id = ?");

			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			rs.first();

			t=newTransport(rs.getInt(1),
						   rs.getDate(2),
						   rs.getDate(3),
						   rs.getDate(4),
						   rs.getBoolean(5),
						   rs.getInt(6),
						   rs.getString(7),
						   conn);

		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return t;
	}

	/**
	 * Gets all transports currently in the database.
	 */

	public Transport[] getAllTransports() {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"select * from transports");
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				newTransport(rs.getInt(1), rs.getDate(2), rs.getDate(3),
							 rs.getDate(4),
							 rs.getBoolean(5), rs.getInt(6), rs.getString(7),
							 conn);
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return (Transport[])a.toArray();
	}

	private void insertCars(Transport newTransport, Connection conn) throws
		SQLException {
		Car[] cars=newTransport.getCars();
		PreparedStatement st=conn.prepareStatement(
			"insert into car_transport (car_id, transport_id) values ( ? , ? )");

		for (int i=0; i < cars.length; i++) {
			st.setInt(1, cars[i].getId());
			st.setInt(2, newTransport.getId());
			st.executeUpdate();
		}
	}

	private void insertArtists(Transport newTransport, Connection conn) throws
		SQLException {
		Artist[] artists=newTransport.getArtists();
		PreparedStatement st=conn.prepareStatement(
			"insert into artist_transport (artist_id, transport_id) values ( ? , ? )");

		for (int i=0; i < artists.length; i++) {
			st.setInt(1, artists[i].getId());
			st.setInt(2, newTransport.getId());
			st.executeUpdate();
		}
	}

	private void insertFunctionaries(Transport newTransport, Connection conn) throws
		SQLException {
		Functionary[] functionaries=newTransport.getFunctionaries();
		PreparedStatement st=conn.prepareStatement("insert into functionary_transport (functionary_id, transport_id) values ( ? , ? )");

		for (int i=0; i < functionaries.length; i++) {
			st.setInt(1, functionaries[i].getId());
			st.setInt(2, newTransport.getId());
			st.executeUpdate();
		}
	}

	private void insertTransportDropoffs(Transport newTransport,
										 Connection conn) throws SQLException {
		TransportWaypoint[] dropoffs=newTransport.getWaypoints();
		PreparedStatement st=conn.prepareStatement("insert into transport_dropoffs (transport_id, place_id, dropoff_time) values ( ? , ? )");

		for (int i=0; i < dropoffs.length; i++) {
			st.setInt(1, newTransport.getId());
			st.setInt(2, dropoffs[i].getPlace().getId());
			st.setDate(3, new java.sql.Date(dropoffs[i].getTime().getTime()));
			st.executeUpdate();
		}
	}

	/**
	 * Creates a new transport according to Transport object
	 * @param newTransport the corresponging transport to create.
	 */

	public Transport newTransport(Transport newTransport) {
		try {
			Connection conn=ConnectionFactory.getConnection();

			PreparedStatement st=conn.prepareStatement("insert into transports (start_time, return_time, internal, misc_info ) values ( ? , ? , ? , ? )");

			st.setDate(1, new java.sql.Date(newTransport.getStartTime().getTime()));
			st.setDate(2,
					   new java.sql.Date(newTransport.getReturnTime().getTime()));
			st.setBoolean(3, newTransport.getInternal());
			st.setString(4, newTransport.getMiscInfo());

			// FIXME: error checking, damnit!
			st.executeUpdate();

			Statement st2=conn.createStatement();
			ResultSet rs=st2.executeQuery("select currval('roles_id_seq')");
			rs.next();

			newTransport.setId(rs.getInt(1));

			insertCars(newTransport, conn);
			insertArtists(newTransport, conn);
			insertFunctionaries(newTransport, conn);
			insertTransportDropoffs(newTransport, conn);

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return newTransport;
	}

	private void updateCars(Transport updatedTransport, Connection conn) {
	}

	private void updateArtists(Transport updatedTransport, Connection conn) {
	}

	private void updateFunctionaries(Transport updatedTransport,
									 Connection conn) {
	}

	private void updateTransportDropoffs(Transport updatedTransport,
										 Connection conn) {
	}

	public void updateTransport(Transport updatedTransport) {
		try {
			Connection conn=ConnectionFactory.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement st=conn.prepareStatement("update transports set start_time = ? , return_time = ? , internal = ? , misc_info = ? where id = ?");

			st.setDate(1,
					   new java.sql.Date(updatedTransport.getStartTime().getTime()));
			st.setDate(2,
					   new java.sql.Date(updatedTransport.getReturnTime().getTime()));
			st.setBoolean(3, updatedTransport.getInternal());
			st.setString(4, updatedTransport.getMiscInfo());
			st.setInt(5, updatedTransport.getId());

			st.executeUpdate();

			updateCars(updatedTransport, conn);
			updateArtists(updatedTransport, conn);
			updateFunctionaries(updatedTransport, conn);
			updateTransportDropoffs(updatedTransport, conn);

			conn.commit();

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public void deleteTransport(int id) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
						 "delete from transports where id = ?");
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
}

	public void deleteTransport(Transport deletedTransport) {
		deleteTransport(deletedTransport.getId());
	}
}
