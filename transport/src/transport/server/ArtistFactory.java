package transport.server;

import java.sql.*;
import java.util.ArrayList;
import transport.logic.*;

public class ArtistFactory {
	PlaceFactory pf;
	
	public ArtistFactory() {
		pf=new PlaceFactory();
	}

	protected static Artist[] getArtistsForTransport(int transportId) throws SQLException {
		ArrayList a=new ArrayList();

		Connection conn=ConnectionFactory.getConnection();

		PreparedStatement st=conn.prepareStatement("select * from artist_transport where transport_id = ?");
		st.setInt(1,transportId);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			a.add(new ArtistFactory().getArtist(rs.getInt(1)));
		}

		return (Artist[])a.toArray();
	}

	private Artist createArtist(ResultSet rs) throws SQLException {
		Artist a=new Artist(rs.getInt(1), 
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getDate(5),
					pf.getPlace(rs.getInt(6)),
					pf.getPlace(rs.getInt(7)),
					rs.getDate(8),
					pf.getPlace(rs.getInt(9)),
					rs.getInt(10),
					rs.getInt(11),
					rs.getInt(12),
					rs.getString(13));

		return a;
	}

	public Artist getArtist(int id) {
		Artist a=null;
		
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from artists where id = ?");

			st.setInt(1,id);
			ResultSet rs=st.executeQuery();
			rs.first();
			a=createArtist(rs);

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

	public Artist[] getAllArtists() {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from artists");
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				a.add(createArtist(rs));
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (Artist[])a.toArray();
	}

	public void newArtist(Artist newArtist) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"insert into artists (name, contact_name, phone_no," +
				"arrival_time, arrival_place_id, hotel_id," +
				"departure_place_id, no_of_artists, no_of_crew," +
				"no_of_guests, extra_info) values " +
				"( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )");

			st.setString(1,newArtist.getName());
			st.setString(2,newArtist.getContactName());
			st.setString(3,newArtist.getTelephoneNo());
			st.setDate(4,new java.sql.Date(newArtist.getArrivalTime().getTime()));
			st.setInt(5,newArtist.getArrival().getId());
			st.setInt(6,newArtist.getHotel().getId());
			st.setDate(7,new java.sql.Date(newArtist.getDepartureTime().getTime()));
			st.setInt(8,newArtist.getDeparture().getId());
			st.setInt(9,newArtist.getNoOfArtists());
			st.setInt(10,newArtist.getNoOfCrew());
			st.setInt(11,newArtist.getNoOfGuests());
			st.setString(12,newArtist.getExtraInfo());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateArtist(Artist updatedArtist) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"update artists set name = ?, contact_name = ?, phone_no = ?," +
				"arrival_time = ?, arrival_place_id = ?, hotel_id = ?," +
				"departure_place_id = ?, no_of_artists = ?, no_of_crew = ?," +
				"no_of_guests = ?, extra_info = ? where id = ?");

			st.setString(1,updatedArtist.getName());
			st.setString(2,updatedArtist.getContactName());
			st.setString(3,updatedArtist.getTelephoneNo());
			st.setDate(4,new java.sql.Date(updatedArtist.getArrivalTime().getTime()));
			st.setInt(5,updatedArtist.getArrival().getId());
			st.setInt(6,updatedArtist.getHotel().getId());
			st.setDate(7,new java.sql.Date(updatedArtist.getDepartureTime().getTime()));
			st.setInt(8,updatedArtist.getDeparture().getId());
			st.setInt(9,updatedArtist.getNoOfArtists());
			st.setInt(10,updatedArtist.getNoOfCrew());
			st.setInt(11,updatedArtist.getNoOfGuests());
			st.setString(12,updatedArtist.getExtraInfo());
			st.setInt(13,updatedArtist.getId());

			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

