package transport.logic;

import java.util.*;
import java.text.DateFormat;

public class Artist extends LogicItem {
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
        private String arrivalFlightNo;
        private String departureFlightNo;
        private String stage;
        private String bookedBy;

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
				  String extraInfo,
                                  String departureFlightNo,
                                  String arrivalFlightNo,
                                  String stage,
                                  String bookedBy) {
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
                this.arrivalFlightNo = arrivalFlightNo;
                this.departureFlightNo = departureFlightNo;
                this.stage = stage;
                this.bookedBy=bookedBy;
	}

	public String toString() {
		return name;
	}

	public Artist() {
		this.id= -1;
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
		this.name=name;
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
		this.contactName=contactName;
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
		this.telephoneNo=telephoneNo;
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
		this.arrivalTime=arrivalTime;
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
		this.arrival=arrival;
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
		this.hotel=hotel;
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
		this.departure=departure;
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
		this.noOfArtists=noOfArtists;
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
		this.noOfCrew=noOfCrew;
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
		this.noOfGuests=noOfGuests;
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
		this.extraInfo=extraInfo;
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
		this.departureTime=departureTime;
	}

        /**
         * Get arrivalFlightNo.
         *
         * @return arrivalFlightNo as String.
         */
        public String getArrivalFlightNo() {
                return arrivalFlightNo;
        }

        /**
         * Set arrivalFlightNo.
         *
         * @param arrivalFlightNo the value to set.
         */
        public void setArrivalFlightNo(String arrivalFlightNo) {
                this.arrivalFlightNo=arrivalFlightNo;
        }
        /**
         * Get departureFlightNo.
         *
         * @return departureFlightNo as String.
         */
        public String getDepartureFlightNo() {
                return departureFlightNo;
        }

        /**
         * Set departureFlightNo.
         *
         * @param departureFlightNo the value to set.
         */
        public void setDepartureFlightNo(String departureFlightNo) {
                this.departureFlightNo=departureFlightNo;
        }
        /**
         * Get stage.
         *
         * @return stage as String.
         */
        public String getStage() {
                return stage;
        }

        /**
         * Set stage.
         *
         * @param stage the value to set.
         */
        public void setStage(String stage) {
                this.stage=stage;
        }

        /**
         * Get bookedBy.
         *
         * @return bookedBy as String.
         */
        public String getBookedBy() {
                return bookedBy;
        }

        /**
         * Set bookedBy.
         *
         * @param bookedBy the value to set.
         */
        public void setBookedBy(String bookedBy) {
                this.bookedBy=bookedBy;
        }



        public String toHTML() {
         String html;
         DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, new Locale("sv"));
         String ArrivalTime = "N/A";
         if (getArrivalTime() != null) {
           ArrivalTime = df.format(getArrivalTime());
         }
         String DepartureTime = "N/A";
         if (getDepartureTime() != null) {
           DepartureTime = df.format(getDepartureTime());
         }
         String name ="N/A";
         if (getName()!=null){
           name=getName();
         }
         String ContactName ="N/A";
         if (getContactName()!=null){
           ContactName=getContactName();
         }
         String TelephoneNo = "N/A";
         if (getTelephoneNo() != null) {
           TelephoneNo = getTelephoneNo();
         }
         String booked ="N/A";
         if (getBookedBy()!=null){
           booked=getBookedBy();
         }
         String scen = "N/A";
         if (getStage() != null) {
           scen = getStage();
         }

         html = "<TABLE BORDER=1>\n";
         html = html + "<TR><TD><b>Name:</b></TD><TD><b>" + name+"</b></TD></TR>\n";
         html = html + "<TR><TD><b>Contact Name:</b></TD><TD>" + ContactName+"</TD></TR>\n";
         html = html + "<TR><TD><b>Telephone Number:</b></TD><TD>" + TelephoneNo+"</TD></TR>\n";
         html = html + "<TR><TD><b>Arrival:</b></TD><TD>" + getArrival().toHTML()+"</TD></TR>\n";
         html = html + "<TR><TD><b>Arrival Time:</b></TD><TD>" +  ArrivalTime +"</TD></TR>\n";
         html = html + "<TR><TD><b>Arrival Flight No:</b></TD><TD>" +  getArrivalFlightNo() +"</TD></TR>\n";
         html = html + "<TR><TD><b>Hotel:</b></TD><TD>" + getHotel().toHTML()+"</TD></TR>\n";
         html = html + "<TR><TD><b>Departure:</b></TD><TD>" +getDeparture().toHTML() +"</TD></TR>\n";
         html = html + "<TR><TD><b>Departure Time:</b></TD><TD>" +DepartureTime+"</TD></TR>\n";
         html = html + "<TR><TD><b>Departure Flight No:</b></TD><TD>" +getDepartureFlightNo()+"</TD></TR>\n";
         html = html + "<TR><TD><b>Stage:</b></TD><TD>" +scen+"</TD></TR>\n";
         html = html + "<TR><TD><b>No of Artists:</b></TD><TD>" +getNoOfArtists() +"</TD></TR>\n";
         html = html + "<TR><TD><b>No of Crew:</b></TD><TD>" + getNoOfCrew()+"</TD></TR>\n";
         html = html + "<TR><TD><b>No of Guests:</b></TD><TD>" +getNoOfGuests() +"</TD></TR>\n";
         html = html + "<TR><TD><b>Booked By:</b></TD><TD>" +booked +"</TD></TR>\n";
         html = html + "</TABLE>\n";

         return html;
       }

}
