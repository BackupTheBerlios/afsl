package transport.logic;

import java.util.*;
import java.text.DateFormat;

public class Transport extends LogicItem {
	private int id;
	private Date startTime;
	private Date returnTime;
	private Date actualReturnTime;
	private boolean internal;
	private MobilePhone[] mobilePhones;
	private TransportWaypoint[] waypoints;
	private Car[] cars;
	private Artist[] artists;
	private Functionary[] functionaries;
	private int distance;
	private String miscInfo;

	public Transport(int id,
					 Date startTime,
					 Date returnTime,
					 Date actualReturnTime,
					 boolean internal,
					 MobilePhone[] mobilePhones,
					 TransportWaypoint[] waypoints,
					 Car[] cars,
					 Artist[] artists,
					 Functionary[] functionaries,
					 int distance,
					 String miscInfo) {
		this.id=id;
		this.startTime=startTime;
		this.returnTime=returnTime;
		this.actualReturnTime=actualReturnTime;
		this.internal=internal;
		this.mobilePhones=mobilePhones;
		this.waypoints=waypoints;
		this.cars=cars;
		this.artists=artists;
		this.functionaries=functionaries;
		this.distance=distance;
		this.miscInfo=miscInfo;
	}

	public Transport() {
		id= -1;
	}

	/**
	 * Get id.
	 *
	 * @return id as int.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set id.
	 *
	 * @param id the value to set.
	 */
	public void setId(int id) {
		this.id=id;
	}

	/**
	 * Get startTime.
	 *
	 * @return startTime as Date.
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * Set startTime.
	 *
	 * @param startTime the value to set.
	 */
	public void setStartTime(Date startTime) {
		this.startTime=startTime;
	}

	/**
	 * Get returnTime.
	 *
	 * @return returnTime as Date.
	 */
	public Date getReturnTime() {
		return returnTime;
	}

	/**
	 * Set returnTime.
	 *
	 * @param returnTime the value to set.
	 */
	public void setReturnTime(Date returnTime) {
		this.returnTime=returnTime;
	}

	/**
	 * Get actualReturnTime.
	 *
	 * @return actualReturnTime as Date.
	 */
	public Date getActualReturnTime() {
		return actualReturnTime;
	}

	/**
	 * Set actualReturnTime.
	 *
	 * @param actualReturnTime the value to set.
	 */
	public void setActualReturnTime(Date actualReturnTime) {
		this.actualReturnTime=actualReturnTime;
	}

	/**
	 * Get internal.
	 *
	 * @return internal as boolean.
	 */
	public boolean getInternal() {
		return internal;
	}

	/**
	 * Set internal.
	 *
	 * @param internal the value to set.
	 */
	public void setInternal(boolean internal) {
		this.internal=internal;
	}

	/**
	 * Get dropoffs.
	 *
	 * @return dropoffs as TransportDropoff[].
	 */
	public TransportWaypoint[] getWaypoints() {
		return waypoints;
	}

	/**
	 * Get dropoffs element at specified index.
	 *
	 * @param index the index.
	 * @return dropoffs at index as TransportDropoff.
	 */
	public TransportWaypoint getWaypoints(int index) {
		return waypoints[index];
	}

	/**
	 * Set dropoffs.
	 *
	 * @param dropoffs the value to set.
	 */
	public void setWaypoints(TransportWaypoint[] waypoints) {
		this.waypoints=waypoints;
	}

	/**
	 * Set dropoffs at the specified index.
	 *
	 * @param dropoffs the value to set.
	 * @param index the index.
	 */
	public void setWaypoints(TransportWaypoint waypoints, int index) {
		this.waypoints[index]=waypoints;
	}

	/**
	 * Get cars.
	 *
	 * @return cars as Car[].
	 */
	public Car[] getCars() {
		return cars;
	}

	/**
	 * Get cars element at specified index.
	 *
	 * @param index the index.
	 * @return cars at index as Car.
	 */
	public Car getCars(int index) {
		return cars[index];
	}

	/**
	 * Set cars.
	 *
	 * @param cars the value to set.
	 */
	public void setCars(Car[] cars) {
		this.cars=cars;
	}

	/**
	 * Set cars at the specified index.
	 *
	 * @param cars the value to set.
	 * @param index the index.
	 */
	public void setCars(Car cars, int index) {
		this.cars[index]=cars;
	}

	/**
	 * Get artists.
	 *
	 * @return artists as Artist[].
	 */
	public Artist[] getArtists() {
		return artists;
	}

	/**
	 * Get artists element at specified index.
	 *
	 * @param index the index.
	 * @return artists at index as Artist.
	 */
	public Artist getArtists(int index) {
		return artists[index];
	}

	/**
	 * Set artists.
	 *
	 * @param artists the value to set.
	 */
	public void setArtists(Artist[] artists) {
		this.artists=artists;
	}

	/**
	 * Set artists at the specified index.
	 *
	 * @param artists the value to set.
	 * @param index the index.
	 */
	public void setArtists(Artist artists, int index) {
		this.artists[index]=artists;
	}

	/**
	 * Get functionaries.
	 *
	 * @return functionaries as Functionary[].
	 */
	public Functionary[] getFunctionaries() {
		return functionaries;
	}

	/**
	 * Get functionaries element at specified index.
	 *
	 * @param index the index.
	 * @return functionaries at index as Functionary.
	 */
	public Functionary getFunctionaries(int index) {
		return functionaries[index];
	}

	/**
	 * Set functionaries.
	 *
	 * @param functionaries the value to set.
	 */
	public void setFunctionaries(Functionary[] functionaries) {
		this.functionaries=functionaries;
	}

	/**
	 * Set functionaries at the specified index.
	 *
	 * @param functionaries the value to set.
	 * @param index the index.
	 */
	public void setFunctionaries(Functionary functionaries, int index) {
		this.functionaries[index]=functionaries;
	}

	/**
	 * Get distance.
	 *
	 * @return distance as int.
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Set distance.
	 *
	 * @param distance the value to set.
	 */
	public void setDistance(int distance) {
		this.distance=distance;
	}

	/**
	 * Get miscInfo.
	 *
	 * @return miscInfo as String.
	 */
	public String getMiscInfo() {
		return miscInfo;
	}

	public MobilePhone[] getMobilePhones() {
		return mobilePhones;
	}

	/**
	 * Set miscInfo.
	 *
	 * @param miscInfo the value to set.
	 */
	public void setMiscInfo(String miscInfo) {
		this.miscInfo=miscInfo;
	}

	public void setMobilePhones(MobilePhone[] mobilePhones) {
		this.mobilePhones=mobilePhones;
	}

        public String toHTML() {
         String html="<html><body>\n";
         DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("sv"));
         if (getInternal()){
           html = html+ "\n<b>INTERNAL TRANSPORT: </b>" +"(id:" + getId() +
             ")<br>\n";
         }
         else{
           html = html+"\n<b>TRANSPORT: </b>" +"(id:" + getId() +
             ")<br>\n";
         }
         String ActualReturnTime = "N/A";
         String StartTime = "N/A";
         String ReturnTime = "N/A";
         if (getActualReturnTime() != null) {
           ActualReturnTime = df.format(getActualReturnTime());
         }
         if (getReturnTime() != null) {
           ReturnTime = df.format(getReturnTime());
         }
         if (getStartTime() != null) {
           StartTime = df.format(getStartTime());
         }

         html = html +"<TABLE BORDER=0>\n";
         html = html +"<TR><TD><b>Artists:</b></TD><TD>"+  getHTMLArtists()+"</TD></TR>\n";
         html = html +"<TR><TD><b>Cars:</b></TD><TD>"+ getHTMLCars()+"</TD></TR>\n";
         html = html +"<TR><TD><b>Functionaries:</b></TD><TD>"+ getHTMLFunctionaries()+"</TD></TR>\n";
         html = html +"<TR><TD><b>Waypoints:</b></TD><TD>"+ getHTMLWaypoints()+"</TD></TR>\n";
         html = html +"<TR><TD><b>Mobile Phones:</b></TD><TD>"+ getHTMLMobilePhones() +"</TD></TR>\n";
         html = html +"<TR><TD><b>Start Time:</b></TD><TD>"+ StartTime+"</TD></TR>\n";
         html = html +"<TR><TD><b>Return Time:</b></TD><TD>"+ ReturnTime+"</TD></TR>\n";
         html = html +"<TR><TD><b>Distance:</b></TD><TD>"+ getDistance()+"</TD></TR>\n";

         html = html +"<TR><TD><b>Actual Return Time:</b></TD><TD>"+ActualReturnTime +"</TD></TR>\n";
         html = html +"<TR><TD><b>Misc Info:</b></TD><TD>"+ getMiscInfo()+"</TD></TR>\n";
         html = html +"</TABLE>\n";

         html = html + "</body></html>";
         return html;
       }

       public String getHTMLFunctionaries(){
         String html="";
         Functionary[] allFunctionaries=getFunctionaries();
        for (int i = 0; i < allFunctionaries.length; i++) {
          html=html+"\n<br>"+allFunctionaries[i].toHTML();
        }
        return html;
       }
       public String getHTMLCars(){
        String html="";
        Car[] allCars=getCars();
       for (int i = 0; i < allCars.length; i++) {
         html=html+"\n<br>"+allCars[i].toHTML();
       }
       return html;
      }

      public String getHTMLArtists() {
        String html = "";
        Artist[] allArtists = getArtists();
        for (int i = 0; i < allArtists.length; i++) {
          html = html+ "\n<br>"+ allArtists[i].toHTML();
        }
        return html;
      }

      public String getHTMLWaypoints() {
        String html = "";
        TransportWaypoint[] allWaypoints = getWaypoints();
        for (int i = 0; i < allWaypoints.length; i++) {
          html = html + "\n<br>" + allWaypoints[i].toHTML();
        }
        return html;
      }

      public String getHTMLMobilePhones() {
        String html = "";
        MobilePhone[] allPhones =  getMobilePhones();
        for (int i = 0; i < allPhones.length; i++) {
          html = html + "\n<br>" + allPhones[i].toHTML();
        }
        return html;
      }


}
