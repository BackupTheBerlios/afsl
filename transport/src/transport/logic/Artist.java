package transport.logic;

import java.util.Date;

public class Artist {
	private int id;
	private String name;
	private String contactName;
	private String telephoneNo;
	private Date arrivalTime;
	private Place arrival;
	private Place hotel;
	private Date departureTime;
	private Place departure;
	private int noOfArtists;
	private int noOfCrew;
	private int noOfGuests;
	private String extraInfo;

	public Artist(int id, 
				  String name, 
				  String contactName, 
				  String telephoneNo, 
				  Date arrivalTime, 
				  Place arrival, 
				  Place hotel, 
				  Date departureTime,
				  Place departure, 
				  int noOfArtists, 
				  int noOfCrew, 
				  int noOfGuests,
				  String extraInfo) {
		this.id=id;
		this.name=name;
		this.contactName=contactName;
		this.telephoneNo=telephoneNo;
		this.arrivalTime=arrivalTime;
		this.arrival=arrival;
		this.hotel=hotel;
		this.departure=departure;
		this.noOfArtists=noOfArtists;
		this.noOfCrew=noOfCrew;
		this.noOfGuests=noOfGuests;
		this.extraInfo=extraInfo;
		this.departureTime=departureTime;
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
		this.id = id;
	}
	
	/**
	 * Get name.
	 *
	 * @return name as String.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set name.
	 *
	 * @param name the value to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get contactName.
	 *
	 * @return contactName as String.
	 */
	public String getContactName() {
		return contactName;
	}
	
	/**
	 * Set contactName.
	 *
	 * @param contactName the value to set.
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	/**
	 * Get telephoneNo.
	 *
	 * @return telephoneNo as String.
	 */
	public String getTelephoneNo() {
		return telephoneNo;
	}
	
	/**
	 * Set telephoneNo.
	 *
	 * @param telephoneNo the value to set.
	 */
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	
	/**
	 * Get arrivalTime.
	 *
	 * @return arrivalTime as Date.
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}
	
	/**
	 * Set arrivalTime.
	 *
	 * @param arrivalTime the value to set.
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	/**
	 * Get arrival.
	 *
	 * @return arrival as Place.
	 */
	public Place getArrival() {
		return arrival;
	}
	
	/**
	 * Set arrival.
	 *
	 * @param arrival the value to set.
	 */
	public void setArrival(Place arrival) {
		this.arrival = arrival;
	}
	
	/**
	 * Get hotel.
	 *
	 * @return hotel as Place.
	 */
	public Place getHotel() {
		return hotel;
	}
	
	/**
	 * Set hotel.
	 *
	 * @param hotel the value to set.
	 */
	public void setHotel(Place hotel) {
		this.hotel = hotel;
	}
	
	/**
	 * Get departure.
	 *
	 * @return departure as Place.
	 */
	public Place getDeparture() {
		return departure;
	}
	
	/**
	 * Set departure.
	 *
	 * @param departure the value to set.
	 */
	public void setDeparture(Place departure) {
		this.departure = departure;
	}
	
	/**
	 * Get noOfArtists.
	 *
	 * @return noOfArtists as int.
	 */
	public int getNoOfArtists() {
		return noOfArtists;
	}
	
	/**
	 * Set noOfArtists.
	 *
	 * @param noOfArtists the value to set.
	 */
	public void setNoOfArtists(int noOfArtists) {
		this.noOfArtists = noOfArtists;
	}
	
	/**
	 * Get noOfCrew.
	 *
	 * @return noOfCrew as int.
	 */
	public int getNoOfCrew() {
		return noOfCrew;
	}
	
	/**
	 * Set noOfCrew.
	 *
	 * @param noOfCrew the value to set.
	 */
	public void setNoOfCrew(int noOfCrew) {
		this.noOfCrew = noOfCrew;
	}
	
	/**
	 * Get noOfGuests.
	 *
	 * @return noOfGuests as int.
	 */
	public int getNoOfGuests() {
		return noOfGuests;
	}
	
	/**
	 * Set noOfGuests.
	 *
	 * @param noOfGuests the value to set.
	 */
	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}
	
	/**
	 * Get extraInfo.
	 *
	 * @return extraInfo as String.
	 */
	public String getExtraInfo() {
		return extraInfo;
	}
	
	/**
	 * Set extraInfo.
	 *
	 * @param extraInfo the value to set.
	 */
	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	
	/**
	 * Get departureTime.
	 *
	 * @return departureTime as Date.
	 */
	public Date getDepartureTime() {
		return departureTime;
	}
	
	/**
	 * Set departureTime.
	 *
	 * @param departureTime the value to set.
	 */
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
}

