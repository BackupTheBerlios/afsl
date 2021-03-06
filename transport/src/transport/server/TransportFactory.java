package transport.server;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import transport.logic.*;
import transport.logic.Transport;

/**
 * This factory class produces transport objects.
 * @author Ola Sundell
 */

public class TransportFactory {
  private Logger logger;

  public TransportFactory() {
    logger = Logger.getLogger("transport.server.TransportFactory");
  }

  private void calcDistance(Transport t, Connection conn) {
  }

  private Transport newTransport(ResultSet rs, Connection conn) throws SQLException {
	  return newTransport(rs.getInt(1),
					   rs.getTimestamp(2),
					   rs.getTimestamp(3),
					   rs.getTimestamp(4),
					   rs.getBoolean(5),
					   rs.getString(6),
					   rs.getInt(7),
					   conn);
}

  private Transport newTransport(int id, java.util.Date startTime,
                                 java.util.Date returnTime,
                                 java.util.Date actualReturnTime,
                                 boolean internal,
                                 String miscInfo,
                                 int direction,
                                 Connection conn) throws SQLException {
    Transport t;

    MobilePhoneFactory mpf = new MobilePhoneFactory();

    t = new Transport(id,
                      startTime,
                      returnTime,
                      actualReturnTime,
                      internal,
                      MobilePhoneFactory.getMobilePhonesForTransport(id),
                      TransportWaypointFactory.getWaypoints(id),
                      CarFactory.getCarsForTransport(id),
                      ArtistFactory.getArtistsForTransport(id),
                      FunctionaryFactory.getFunctionariesForTransport(id),
                      0,
                      miscInfo,
                      (new DirectionFactory()).getDirection(direction));

    calcDistance(t, conn);

    return t;
  }

  /**
   * This method gets a transport according to its corresponding id.
   * @param id the id of the transport
   */

  public Transport getTransport(int id) {
    Transport t = null;

    try {
      Connection conn = ConnectionFactory.getConnection();
      PreparedStatement st = conn.prepareStatement(
          "select * from transports where id = ? order by start_time");

      st.setInt(1, id);
      ResultSet rs = st.executeQuery();
      rs.first();

      t = newTransport(rs,
                       conn);

      ConnectionFactory.closeConnection(conn);
    } catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }

    return t;
  }

  /**
   * Gets all transports currently in the database.
   */

  public Transport[] getAllTransports() {
    ArrayList a = new ArrayList();

    try {
      Connection conn = ConnectionFactory.getConnection();
      PreparedStatement st = conn.prepareStatement(
          "select * from transports order by start_time");
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        a.add(newTransport(rs.getInt(1), rs.getTimestamp(2), rs.getTimestamp(3),
                           rs.getTimestamp(4),
                           rs.getBoolean(5), rs.getString(6), rs.getInt(7),
                           conn));
      }
      ConnectionFactory.closeConnection(conn);
    }
    catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }

    Transport[] t = new Transport[a.size()];
    a.toArray(t);

    return t;
  }

  private void insertCars(Transport newTransport, Connection conn) throws
      SQLException {
    Car[] cars = newTransport.getCars();
    PreparedStatement st = conn.prepareStatement(
        "insert into car_transport (car_id, transport_id) values ( ? , ? )");

    for (int i = 0; i < cars.length; i++) {
      st.setInt(1, cars[i].getId());
      st.setInt(2, newTransport.getId());
      st.executeUpdate();
    }
  }

  private void insertArtists(Transport newTransport, Connection conn) throws
      SQLException {
    Artist[] artists = newTransport.getArtists();
    PreparedStatement st = conn.prepareStatement(
        "insert into artist_transport (artist_id, transport_id) values ( ? , ? )");

    for (int i = 0; i < artists.length; i++) {
      st.setInt(1, artists[i].getId());
      st.setInt(2, newTransport.getId());
      st.executeUpdate();
    }
  }

  private void insertFunctionaries(Transport newTransport, Connection conn) throws
      SQLException {
    Functionary[] functionaries = newTransport.getFunctionaries();
    PreparedStatement st = conn.prepareStatement("insert into functionary_transport (functionary_id, transport_id) values ( ? , ? )");

    for (int i = 0; i < functionaries.length; i++) {
      st.setInt(1, functionaries[i].getId());
      st.setInt(2, newTransport.getId());
      st.executeUpdate();
    }
  }

  private void insertTransportWaypoints(Transport newTransport,
                                        Connection conn) throws SQLException {
    TransportWaypoint[] waypoints = newTransport.getWaypoints();
    PreparedStatement st = conn.prepareStatement("insert into transport_waypoints (transport_id, place_id, waypoint_time) values ( ? , ?, ? )");

    for (int i = 0; i < waypoints.length; i++) {
      st.setInt(1, newTransport.getId());
      st.setInt(2, waypoints[i].getPlace().getId());
      st.setTimestamp(3, new java.sql.Timestamp(waypoints[i].getTime().getTime()));
      st.executeUpdate();
    }
  }

  /**
   * insertMobilePhones
   *
   * @param newTransport Transport
   * @param conn Connection
   */
  private void insertMobilePhones(Transport newTransport, Connection conn) throws
      SQLException {
    MobilePhone[] mobilePhones = newTransport.getMobilePhones();
    PreparedStatement st = conn.prepareStatement("insert into mobile_phone_transport (mobile_phone_id, transport_id) values ( ? , ? )");

    for (int i = 0; i < mobilePhones.length; i++) {
      st.setInt(1, mobilePhones[i].getId());
      st.setInt(2, newTransport.getId());
      st.executeUpdate();
    }

  }

  /**
   * Creates a new transport according to Transport object
   * @param newTransport the corresponging transport to create.
   */

  public Transport newTransport(Transport newTransport) {
    try {
      Connection conn = ConnectionFactory.getConnection();
      conn.setAutoCommit(false);

      PreparedStatement st = conn.prepareStatement("insert into transports (start_time, return_time, internal, misc_info, direction ) values ( ? , ? , ? , ? , ?)");

      st.setTimestamp(1, new java.sql.Timestamp(newTransport.getStartTime().getTime()));
      st.setTimestamp(2,
                 new java.sql.Timestamp(newTransport.getReturnTime().getTime()));
      st.setBoolean(3, newTransport.getInternal());
      st.setString(4, newTransport.getMiscInfo());
      st.setInt(5, newTransport.getDirection().getId());

      // FIXME: error checking, damnit!
      st.executeUpdate();

      Statement st2 = conn.createStatement();
      ResultSet rs = st2.executeQuery("select currval('transports_id_seq')");
      rs.next();

      newTransport.setId(rs.getInt(1));

      insertCars(newTransport, conn);
      insertArtists(newTransport, conn);
      insertFunctionaries(newTransport, conn);
      insertTransportWaypoints(newTransport, conn);
      insertMobilePhones(newTransport, conn);

      conn.commit();

      ConnectionFactory.closeConnection(conn);
    }
    catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }

    return newTransport;
  }

//TODO: optimise these method. We are currently fulhacking.

  private void updateCars(Transport updatedTransport, Connection conn) throws
      SQLException {
    PreparedStatement st = conn.prepareStatement(
        "delete from car_transport where transport_id = ?");
    st.setInt(1, updatedTransport.getId());
    st.executeUpdate();

    insertCars(updatedTransport, conn);
  }

  private void updateArtists(Transport updatedTransport, Connection conn) throws
      SQLException {
    PreparedStatement st = conn.prepareStatement(
        "delete from artist_transport where transport_id = ?");
    st.setInt(1, updatedTransport.getId());
    st.executeUpdate();

    insertArtists(updatedTransport, conn);

  }

  private void updateFunctionaries(Transport updatedTransport,
                                   Connection conn) throws SQLException {
    PreparedStatement st = conn.prepareStatement(
        "delete from functionary_transport where transport_id = ?");
    st.setInt(1, updatedTransport.getId());
    st.executeUpdate();

    insertFunctionaries(updatedTransport, conn);
  }

  private void updateTransportWaypoints(Transport updatedTransport,
                                        Connection conn) throws SQLException {

    PreparedStatement st = conn.prepareStatement(
        "delete from transport_waypoints where transport_id = ?");
    st.setInt(1, updatedTransport.getId());
    st.executeUpdate();

    insertTransportWaypoints(updatedTransport, conn);

  }

  /**
   * updateMobilePhones
   *
   * @param updatedTransport Transport
   * @param conn Connection
   */
  private void updateMobilePhones(Transport updatedTransport, Connection conn) throws
      SQLException {
    PreparedStatement st = conn.prepareStatement(
        "delete from mobile_phone_transport where transport_id = ?");
    st.setInt(1, updatedTransport.getId());
    st.executeUpdate();

    insertMobilePhones(updatedTransport, conn);
  }

  public void updateTransport(Transport updatedTransport) {
    try {
      Connection conn = ConnectionFactory.getConnection();

      conn.setAutoCommit(false);

      PreparedStatement st = conn.prepareStatement("update transports set start_time = ? , return_time = ? , internal = ? , misc_info = ?, direction = ? where id = ?");

      st.setTimestamp(1,
                 new java.sql.Timestamp(updatedTransport.getStartTime().getTime()));
      st.setTimestamp(2,
                 new java.sql.Timestamp(updatedTransport.getReturnTime().getTime()));
      st.setBoolean(3, updatedTransport.getInternal());
      st.setString(4, updatedTransport.getMiscInfo());
      st.setInt(5, updatedTransport.getDirection().getId());
      st.setInt(6, updatedTransport.getId());

      st.executeUpdate();

      updateCars(updatedTransport, conn);
      updateArtists(updatedTransport, conn);
      updateFunctionaries(updatedTransport, conn);
      updateTransportWaypoints(updatedTransport, conn);
      updateMobilePhones(updatedTransport, conn);

      conn.commit();

      ConnectionFactory.closeConnection(conn);
    }
    catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }
  }

  public void deleteTransport(int id) {
    try {
      Connection conn = ConnectionFactory.getConnection();
      PreparedStatement st = conn.prepareStatement(
          "delete from transports where id = ?");

      st.setInt(1, id);
      st.executeUpdate();
      ConnectionFactory.closeConnection(conn);
    }
    catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }
  }

  public void deleteTransport(Transport deletedTransport) {
    deleteTransport(deletedTransport.getId());
  }

  public Transport[] getAllTransportsByFunctionaryID(int id) {
    ArrayList a = new ArrayList();

    try {
      Connection conn = ConnectionFactory.getConnection();
      PreparedStatement st = conn.prepareStatement(
          "select * from transports as t, functionary_transport as f where t.id=f.transport_id and f.functionary_id=?");
      st.setInt(1, id);
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        a.add(newTransport(rs,
                           conn));
      }
      ConnectionFactory.closeConnection(conn);
    }
    catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }

    Transport[] t = new Transport[a.size()];
    a.toArray(t);

    return t;
  }

  public Transport[] getAllCurrentTransportsByFunctionaryID(int id) {
    ArrayList a = new ArrayList();

    try {
      Connection conn = ConnectionFactory.getConnection();
      PreparedStatement st = conn.prepareStatement(
          "select * from transports as t, functionary_transport as f where t.id=f.transport_id and f.functionary_id=? and ((t.start_time<now()) and (t.return_time>now()))");

      st.setInt(1, id);
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        a.add(newTransport(rs,
                           conn));
      }
      ConnectionFactory.closeConnection(conn);
    }
    catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }

    Transport[] t = new Transport[a.size()];
    a.toArray(t);

    return t;
  }

  public Transport[] getAllFinishedTransportsByFunctionaryID(int id) {
    ArrayList a = new ArrayList();

    try {
      Connection conn = ConnectionFactory.getConnection();
      PreparedStatement st = conn.prepareStatement(
          "select * from transports as t, functionary_transport as f where t.id=f.transport_id  and f.functionary_id=? and (t.return_time<now())");
      st.setInt(1, id);
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        a.add(newTransport(rs,
                           conn));
      }
      ConnectionFactory.closeConnection(conn);
    }
    catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }

    Transport[] t = new Transport[a.size()];
    a.toArray(t);

    return t;

  }

  public Transport[] getAllFutureTransportsByFunctionaryID(int id) {
    ArrayList a = new ArrayList();

    try {
      Connection conn = ConnectionFactory.getConnection();
      PreparedStatement st = conn.prepareStatement(
          "select * from transports as t, functionary_transport as f where t.id=f.transport_id and f.functionary_id=? and (t.start_time>now())");
      st.setInt(1, id);
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        a.add(newTransport(rs,
                           conn));
      }
      ConnectionFactory.closeConnection(conn);
    }
    catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }

    Transport[] t = new Transport[a.size()];
    a.toArray(t);

    return t;

  }

  public Transport[] getAllTransportsByCarID(int id) {
    ArrayList a = new ArrayList();

    try {
      Connection conn = ConnectionFactory.getConnection();
      PreparedStatement st = conn.prepareStatement(
          "select * from transports as t, car_transport as c where t.id=c.transport_id and c.car_id=?");
      st.setInt(1, id);
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        a.add(newTransport(rs,
                           conn));
      }
      ConnectionFactory.closeConnection(conn);
    }
    catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }

    Transport[] t = new Transport[a.size()];
    a.toArray(t);

    return t;
  }
  public Transport[] getAllCurrentTransportsByCarID(int id) {
    ArrayList a = new ArrayList();

    try {
      Connection conn = ConnectionFactory.getConnection();
      PreparedStatement st = conn.prepareStatement(
          "select * from transports as t, car_transport as c where t.id=c.transport_id and c.car_id=? and ((t.start_time<now()) and (t.return_time>now()))");

      st.setInt(1, id);
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        a.add(newTransport(rs, conn));
      }
      ConnectionFactory.closeConnection(conn);
    }
    catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }

    Transport[] t = new Transport[a.size()];
    a.toArray(t);

    return t;
  }

  public Transport[] getAllFinishedTransportsByCarID(int id) {
    ArrayList a = new ArrayList();

    try {
      Connection conn = ConnectionFactory.getConnection();
      PreparedStatement st = conn.prepareStatement(
          "select * from transports as t, car_transport as c where t.id=c.transport_id and c.car_id=? and (t.return_time<now())");
      st.setInt(1, id);
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        a.add(newTransport(rs,
                           conn));
      }
      ConnectionFactory.closeConnection(conn);
    }
    catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }

    Transport[] t = new Transport[a.size()];
    a.toArray(t);

    return t;

  }

  public Transport[] getAllFutureTransportsByCarID(int id) {
    ArrayList a = new ArrayList();

    try {
      Connection conn = ConnectionFactory.getConnection();
      PreparedStatement st = conn.prepareStatement(
          "select * from transports as t, car_transport as c where t.id=c.transport_id and car_id=? and (t.start_time>now())");
      st.setInt(1, id);
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        a.add(newTransport(rs,
                           conn));
      }
      ConnectionFactory.closeConnection(conn);
    }
    catch (SQLException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
    }

    Transport[] t = new Transport[a.size()];
    a.toArray(t);

    return t;

  }

}
