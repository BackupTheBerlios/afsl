package transport.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.*;
import transport.logic.*;

public class MobilePhoneFactory {
	private Logger logger;

	public MobilePhoneFactory() {
		logger=Logger.getLogger("transport.server.MobilePhoneFactory");
	}

	public MobilePhone[] getMobilePhonesFreeBetween(java.util.Date from, java.util.Date to) {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from cars where cars.id not in (select car_id from car_transport, transports where transports.return_time <= ? and transports.start_time>= ? and car_transport.transport_id=transports.id)");

			java.sql.Date d1=new java.sql.Date(from.getTime());
			java.sql.Date d2=new java.sql.Date(to.getTime());

			st.setDate(1,d1);
			st.setDate(2,d2);

			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				a.add(new MobilePhone(rs.getInt(1), rs.getString(2)));
			}

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return (MobilePhone[])a.toArray();
	}
	
	public MobilePhone getMobilePhone(int id) {
		MobilePhone c=null;
		
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from mobile_phones where id = ?");

			st.setInt(1,id);
			ResultSet rs=st.executeQuery();
			rs.first();
			c=new MobilePhone(id, rs.getString(2));

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return c;
	}

	public MobilePhone[] getAllMobilePhones() {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from mobile_phones");
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				a.add(new MobilePhone(rs.getInt(1), rs.getString(2)));
			}

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return (MobilePhone[])a.toArray();
	}

	public void newMobilePhone(MobilePhone newPhone) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("insert into mobile_phones (phone_no) values ( ? )");
			st.setString(1,newPhone.getNumber());
			// FIXME: error checking, damnit!
			st.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public void updateMobilePhone(MobilePhone updatedPhone) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("update mobile_phones set phone_no = ? where id = ?");
			st.setString(1,updatedPhone.getNumber());
			st.setInt(2,updatedPhone.getId());

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}

