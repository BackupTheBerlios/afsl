package transport.logic;

import java.util.*;

public class Car {
	private int id;
	private String regNo;
	private String carType;
	private int numberOfSeats;
	private String miscInfo;

	public Car() {
		id=-1;
	}
	
	public Car(int id, String regNo, String carType, 
			   int numberOfSeats, String miscInfo) {
		this.id=id;
		this.regNo=regNo;
		this.carType=carType;
		this.numberOfSeats=numberOfSeats;
		this.miscInfo=miscInfo;
	}

	public String toString() {
		return new String(regNo + ", "+carType);
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
	 * Get regNo.
	 *
	 * @return regNo as String.
	 */
	public String getRegNo() {
		return regNo;
	}
	
	/**
	 * Set regNo.
	 *
	 * @param regNo the value to set.
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	/**
	 * Get carType.
	 *
	 * @return carType as String.
	 */
	public String getCarType() {
		return carType;
	}
	
	/**
	 * Set carType.
	 *
	 * @param carType the value to set.
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	/**
	 * Get numberOfSeats.
	 *
	 * @return numberOfSeats as int.
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	
	/**
	 * Set numberOfSeats.
	 *
	 * @param numberOfSeats the value to set.
	 */
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
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
		this.miscInfo = miscInfo;
	}
}

