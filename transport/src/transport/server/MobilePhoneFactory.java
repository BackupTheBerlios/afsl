package transport.server;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import transport.logic.*;

public class MobilePhoneFactory {
	private Logger logger;

	public MobilePhoneFactory() {
		logger=Logger.getLogger("transport.server.MobilePhoneFactory");
	}

	public MobilePhone[] getMobilePhonesFreeBetween(java.util.Date from,
		java.util.Date to) {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			// TODO: fix, cars???
			PreparedStatement st=conn.prepareStatement("select * from cars where cars.id not in (select car_id from car_transport, transports where transports.return_time <= ? and transports.start_time>= ? and car_transport.transport_id=transports.id)");

			java.sql.Timestamp d1=new java.sql.Timestamp(from.getTime());
			java.sql.Timestamp d2=new java.sql.Timestamp(to.getTime());

			st.setTimestamp(1, d1);
			st.setTimestamp(2, d2);

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
			PreparedStatement st=conn.prepareStatement(
				"select * from mobile_phones where id = ?");

			st.setInt(1, id);
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
			PreparedStatement st=conn.prepareStatement(
				"select * from mobile_phones");
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				a.add(new MobilePhone(rs.getInt(1), rs.getString(2)));
			}

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		MobilePhone[] ar=new MobilePhone[a.size()];
		a.toArray(ar);

		return ar;
	}

	public MobilePhone newMobilePhone(MobilePhone newPhone) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"insert into mobile_phones (phone_no) values ( ? )");
			st.setString(1, newPhone.getNumber());
			// FIXME: error checking, damnit!
			st.executeUpdate();

			Statement st2=conn.createStatement();
			ResultSet rs=st2.executeQuery(
				"select currval('mobile_phones_id_seq')");
			rs.next();

			newPhone.setId(rs.getInt(1));

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return newPhone;
	}

	protected static MobilePhone[] getMobilePhonesForTransport(int transportId) throws
		SQLException {

		ArrayList a=new ArrayList();

		Connection conn=ConnectionFactory.getConnection();

		PreparedStatement st=conn.prepareStatement(
			"select * from mobile_phone_transport where transport_id = ?");
		st.setInt(1, transportId);
		ResultSet rs=st.executeQuery();

		// FIXME: poor performance at all factories

		MobilePhoneFactory mpf=new MobilePhoneFactory();
		while (rs.next()) {
			a.add(mpf.getMobilePhone(rs.getInt("mobile_phone_id")));
		}

		conn.close();

		MobilePhone[] ar=new MobilePhone[a.size()];
		a.toArray(ar);

		return ar;
	}

	public void updateMobilePhone(MobilePhone updatedPhone) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"update mobile_phones set phone_no = ? where id = ?");
			st.setString(1, updatedPhone.getNumber());
			st.setInt(2, updatedPhone.getId());

			st.executeUpdate();

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public void deleteMobilePhone(int id) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("delete from mobile_phones where id = ?");
			st.setInt(1,id);

			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	/**
	 * deleteMobilePhone
	 *
	 * @param mobilePhone MobilePhone
	 */
	public void deleteMobilePhone(MobilePhone mobilePhone) {
		deleteMobilePhone(mobilePhone.getId());
	}
}
