package transport.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import transport.logic.*;

public class TransportDropoffFactory {
	static TransportDropoff[] getDropoffs(int transportId) throws SQLException {
		ArrayList a=new ArrayList();
		PlaceFactory pf=new PlaceFactory();

		Connection conn=ConnectionFactory.getConnection();

		PreparedStatement ps=conn.prepareStatement("select * from transport_dropoffs where transport_id = ?");
		ps.setInt(1,transportId);
		ResultSet rs=ps.executeQuery();

	 	while (rs.next()) {
			a.add(new TransportDropoff(pf.getPlace(rs.getInt("place_id")),rs.getDate("dropoff_time")));
		}

		return (TransportDropoff[])a.toArray();
	}
}

