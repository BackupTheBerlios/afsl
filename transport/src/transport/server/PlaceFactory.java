package transport.server;

import java.sql.*;
import java.util.ArrayList;
import transport.logic.*;

public class PlaceFactory {
	public Place getPlace(int id) {
		Place p=null;
		
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from places where id = ?");

			st.setInt(1,id);
			ResultSet rs=st.executeQuery();
			rs.first();
			p=new Place(id, rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public Place[] getAllPlaces() {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from places");
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				a.add(new Place(rs.getInt(1), rs.getString(2)));
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (Place[])a.toArray();
	}

	public void newPlace(Place newPlace) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("insert into places (name) values ( ? )");
			st.setString(1,newPlace.getName());
			// FIXME: error checking, damnit!
			st.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePlace(Place updatedPlace) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("update places set name = ? where id = ?");
			st.setString(1,updatedPlace.getName());
			st.setInt(2,updatedPlace.getId());

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

