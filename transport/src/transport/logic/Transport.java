package transport.logic;

import java.util.*;

public class Transport {
	private int id;
	private Date startTime;
	private Date returnTime;
	private Date actualReturnTime;
	private boolean internal;
	private MobilePhone mobile;
	private TransportDropoff[] dropoffs;
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
					 MobilePhone mobile,
					 TransportDropoff[] dropoffs,
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
		this.mobile=mobile;
		this.dropoffs=dropoffs;
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
	 * Get mobile.
	 *
	 * @return mobile as MobilePhone.
	 */
	public MobilePhone getMobile() {
		return mobile;
	}

	/**
	 * Set mobile.
	 *
	 * @param mobile the value to set.
	 */
	public void setMobile(MobilePhone mobile) {
		this.mobile=mobile;
	}

	/**
	 * Get dropoffs.
	 *
	 * @return dropoffs as TransportDropoff[].
	 */
	public TransportDropoff[] getDropoffs() {
		return dropoffs;
	}

	/**
	 * Get dropoffs element at specified index.
	 *
	 * @param index the index.
	 * @return dropoffs at index as TransportDropoff.
	 */
	public TransportDropoff getDropoffs(int index) {
		return dropoffs[index];
	}

	/**
	 * Set dropoffs.
	 *
	 * @param dropoffs the value to set.
	 */
	public void setDropoffs(TransportDropoff[] dropoffs) {
		this.dropoffs=dropoffs;
	}

	/**
	 * Set dropoffs at the specified index.
	 *
	 * @param dropoffs the value to set.
	 * @param index the index.
	 */
	public void setDropoffs(TransportDropoff dropoffs, int index) {
		this.dropoffs[index]=dropoffs;
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

	/**
	 * Set miscInfo.
	 *
	 * @param miscInfo the value to set.
	 */
	public void setMiscInfo(String miscInfo) {
		this.miscInfo=miscInfo;
	}
}
