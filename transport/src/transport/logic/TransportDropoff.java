package transport.logic;

import java.util.Date;

public class TransportDropoff {
	Place place;
	Date time;

	public TransportDropoff (Place place, Date time) {
		this.place=place;
		this.time=time;
	}

	public String toString() {
		return new String(time + ", " + place);
	}
	
	/**
	 * Get place.
	 *
	 * @return place as Place.
	 */
	public Place getPlace() {
		return place;
	}
	
	/**
	 * Set place.
	 *
	 * @param place the value to set.
	 */
	public void setPlace(Place place) {
		this.place = place;
	}
	
	/**
	 * Get time.
	 *
	 * @return time as Date.
	 */
	public Date getTime() {
		return time;
	}
	
	/**
	 * Set time.
	 *
	 * @param time the value to set.
	 */
	public void setTime(Date time) {
		this.time = time;
	}
}

