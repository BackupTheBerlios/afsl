package transport.server;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import transport.logic.*;

public class CarFactory {
	private Logger logger;

	public CarFactory() {
		logger=Logger.getLogger("transport.server.CarFactory");
	}

	protected static Car[] getCarsForTransport(int transportId) throws
		SQLException {
		ArrayList a=new ArrayList();

		Connection conn=ConnectionFactory.getConnection();

		PreparedStatement st=conn.prepareStatement(
			"select * from car_transport where transport_id = ?");
		st.setInt(1, transportId);
		ResultSet rs=st.executeQuery();

		// FIXME: poor performance at all factories

		while (rs.next()) {
			a.add(new CarFactory().getCar(rs.getInt("car_id")));
		}

		Car[] c=new Car[a.size()];
		a.toArray(c);

		return c;
	}

	public Car[] getCarsFreeBetween(java.util.Date from, java.util.Date to) {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from cars where cars.id not in (select car_id from car_transport, transports where transports.return_time <= ? and transports.start_time>= ? and car_transport.transport_id=transports.id)");

			java.sql.Date d1=new java.sql.Date(from.getTime());
			java.sql.Date d2=new java.sql.Date(to.getTime());

			st.setDate(1, d1);
			st.setDate(2, d2);

			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				a.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3),
							  rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return (Car[])a.toArray();
	}

	public Car getCar(int id) {
		Car c=null;

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"select * from cars where id = ?");

			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			rs.first();
			c=new Car(id, rs.getString(2), rs.getString(3), rs.getInt(4),
					  rs.getString(5));
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return c;
	}

	public Car[] getAllCars() {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from cars");
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				a.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3),
							  rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		Car[] r=new Car[a.size()];
		a.toArray(r);

		return r;
	}

	public Car newCar(Car newCar) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("insert into cars (reg_no, car_type, no_of_seats, misc_info ) values ( ? , ? , ? , ? )");
			st.setString(1, newCar.getRegNo());
			st.setString(2, newCar.getCarType());
			st.setInt(3, newCar.getNumberOfSeats());
			st.setString(4, newCar.getMiscInfo());

			// FIXME: error checking, damnit!
			st.executeUpdate();

			Statement st2=conn.createStatement();
			ResultSet rs=st2.executeQuery("select currval('cars_id_seq')");
			rs.next();

			newCar.setId(rs.getInt(1));

			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return newCar;
	}

	public void updateCars(Car[] cars, Connection conn) throws SQLException {
		for (int i=0; i < cars.length; i++) {
			updateCar(cars[i], conn);
		}
	}

	public void updateCar(Car updatedCar, Connection conn) throws SQLException {
		PreparedStatement st=conn.prepareStatement("update cars set reg_no = ?, car_type = ?, no_of_seast = ?, misc_info = ? where id = ?");
		st.setString(1, updatedCar.getRegNo());
		st.setString(2, updatedCar.getCarType());
		st.setInt(3, updatedCar.getNumberOfSeats());
		st.setString(4, updatedCar.getMiscInfo());
		st.setInt(5, updatedCar.getId());
		if (conn.getAutoCommit()) {
			conn.close();
		}
	}

	public void updateCar(Car updatedCar) {
		try {
			Connection conn=ConnectionFactory.getConnection();

			updateCar(updatedCar, conn);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public void deleteCar(int id) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement(
				"delete from cars where id = ?");

			st.setInt(1, id);
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public void deleteCar(Car deletedCar) {
		deleteCar(deletedCar.getId());
	}
}
