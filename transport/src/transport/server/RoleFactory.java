package transport.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import transport.logic.*;

public class RoleFactory {
	public Role getRole(int id) {
		Role c=null;
		
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from mobile_phones where id = ?");

			st.setInt(1,id);
			ResultSet rs=st.executeQuery();
			rs.first();
			c=new Role(id, rs.getString(2), rs.getString(3));

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public Role[] getAllRoles() {
		ArrayList a=new ArrayList();

		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("select * from mobile_phones");
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				a.add(new Role(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (Role[])a.toArray();
	}

	public void newRole(Role newRole) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("insert into roles (short_descr, long_descr) values ( ? , ? )");
			st.setString(1,newRole.getShortDescr());
			st.setString(2,newRole.getLongDescr());
			// FIXME: error checking, damnit!
			st.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateRole(Role updatedRole) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement st=conn.prepareStatement("update roles set short_descr = ? , long_descr = ?  where id = ?");
			st.setString(1,updatedRole.getShortDescr());
			st.setString(2,updatedRole.getLongDescr());
			st.setInt(3,updatedRole.getId());

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


