package transport.server;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import transport.logic.*;

public class ArtistFactory {
	PlaceFactory pf;
	Logger logger;

	public ArtistFactory() {
		pf=new PlaceFactory();
		logger=Logger.getLogger("transport.server.ArtistFactory");
		logger.setLevel(Level.ALL);
	}

	protected static Artist[] getArtistsForTransport(int transportId) throws
		SQLException {
		ArrayList a=new ArrayList();

		Connection conn=ConnectionFactory.getConnection();

		PreparedStatement st=conn.prepareStatement(
			"select * from artist_transport where transport_id = ?");
		st.setInt(1, transportId);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			a.add(new ArtistFactory().getArtist(rs.getInt(1)));
		}

		conn.close();

		Artist[] ar=new Artist[a.size()];
		a.toArray(ar);

		return ar;
	}

	private Artist createArtist(ResultSet rs) throws SQLException {
		Artist a=new Artist(rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getTimestamp(5),
							pf.getPlace(rs.getInt(6)),
							pf.getPlace(rs.getInt(7)),
							rs.getTimestamp(8),
							pf.getPlace(rs.getInt(9)),
							rs.getInt(10),
							rs.getInt(11),
							rs.getInt(12),
							rs.getString(13));

		return a;
	}

	public Artist getArtist(int id) {
		Artist a=null;

		logger.fine("getArtist(" + id + ")");

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"select * from artists where id = ?");

			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			rs.first();
			a=createArtist(rs);

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		logger.fine("getArtist() done.");

		return a;
	}

	public Artist[] getAllArtists() {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from artists order by name");
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				a.add(createArtist(rs));
			}

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		Artist[] ar=new Artist[a.size()];

		a.toArray(ar);

		return ar;
	}

	public Artist newArtist(Artist newArtist) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"insert into artists (name, contact_name, phone_no," +
				"arrival_time, arrival_place_id, hotel_id," +
				"departure_time, departure_place_id, no_of_artists, no_of_crew," +
				"no_of_guests, extra_info) values " +
				"( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )");

			st.setString(1, newArtist.getName());
			st.setString(2, newArtist.getContactName());
			st.setString(3, newArtist.getTelephoneNo());
			st.setTimestamp(4, new Timestamp(newArtist.getArrivalTime().getTime()));
			st.setInt(5, newArtist.getArrival().getId());
			st.setInt(6, newArtist.getHotel().getId());
			st.setTimestamp(7, new Timestamp(newArtist.getDepartureTime().getTime()));
			st.setInt(8, newArtist.getDeparture().getId());
			st.setInt(9, newArtist.getNoOfArtists());
			st.setInt(10, newArtist.getNoOfCrew());
			st.setInt(11, newArtist.getNoOfGuests());
			st.setString(12, newArtist.getExtraInfo());
			st.executeUpdate();

			Statement st2=conn.createStatement();
			ResultSet rs=st2.executeQuery("select currval('artists_id_seq')");
			rs.next();

			newArtist.setId(rs.getInt(1));

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return newArtist;
	}

	public void updateArtist(Artist updatedArtist) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"update artists "+
				"set name = ?, " +
				"contact_name = ?, " +
				"phone_no = ?," +
				"arrival_time = ?, " +
				"arrival_place_id = ?, " +
				"hotel_id = ?," +
				"departure_time = ?, " +
				"departure_place_id = ?, " +
				"no_of_artists = ?, " +
				"no_of_crew = ?," +
				"no_of_guests = ?, " +
				"extra_info = ? "+
				"where id = ?");

			st.setString(1, updatedArtist.getName());
			st.setString(2, updatedArtist.getContactName());
			st.setString(3, updatedArtist.getTelephoneNo());
			if (updatedArtist.getArrivalTime()!=null) {
				st.setTimestamp(4,
								new java.sql.Timestamp(updatedArtist.getArrivalTime().
					getTime()));
			} else {
				st.setTimestamp(4, null);
			}
			st.setInt(5, updatedArtist.getArrival().getId());
			st.setInt(6, updatedArtist.getHotel().getId());
			if (updatedArtist.getArrivalTime()!=null) {
				st.setTimestamp(7,
								new java.sql.Timestamp(updatedArtist.getArrivalTime().
					getTime()));
			} else {
				st.setTimestamp(7, null);
			}

			st.setInt(8, updatedArtist.getDeparture().getId());
			st.setInt(9, updatedArtist.getNoOfArtists());
			st.setInt(10, updatedArtist.getNoOfCrew());
			st.setInt(11, updatedArtist.getNoOfGuests());
			st.setString(12, updatedArtist.getExtraInfo());
			st.setInt(13, updatedArtist.getId());

			st.executeUpdate();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public void deleteArtist(int id) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"delete from artists where id = ?");
			st.setInt(1, id);

			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public void deleteArtist(Artist a) {
		deleteArtist(a.getId());
	}
}
