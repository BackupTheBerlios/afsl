package transport.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import transport.logic.*;

public class PlaceFactory {
	private Logger logger;

	public PlaceFactory() {
		logger=Logger.getLogger("transport.server.PlaceFactory");
	}

	public Place getPlace(int id) {
		Place p=null;
		logger.entering("PlaceFactory","getPlace("+id+")");
		
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from places where id = ?");

			st.setInt(1,id);
			ResultSet rs=st.executeQuery();
			
			if (!rs.next()) {
				logger.log(Level.WARNING,"No rows returned for getPlace("+id+"), returning null.");
				return null;
			}
			
			p=new Place(id, rs.getString(2));
			
			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
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
			logger.log(Level.SEVERE, e.getMessage(), e);
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
			logger.log(Level.SEVERE, e.getMessage(), e);
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
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}

