package transport.server;

import java.sql.*;
import java.util.*;

import transport.logic.*;

public class TransportWaypointFactory {
	static TransportWaypoint[] getWaypoints(int transportId) throws SQLException {
		ArrayList a=new ArrayList();
		PlaceFactory pf=new PlaceFactory();

		Connection conn=ConnectionFactory.getConnection();

		PreparedStatement ps=conn.prepareStatement(
			"select * from transport_waypoints where transport_id = ?");
		ps.setInt(1, transportId);
		ResultSet rs=ps.executeQuery();

		while (rs.next()) {
			a.add(new TransportWaypoint(pf.getPlace(rs.getInt("place_id")),
rs.getTimestamp("waypoint_time")));
		}
                ConnectionFactory.closeConnection(conn);

		TransportWaypoint[] t=new TransportWaypoint[a.size()];
		a.toArray(t);

		return t;
	}
}
