package transport.logic;

public class MobilePhone {
	int id;
	String number;

	MobilePhone(int id, String number) {
		this.id=id;
		this.number=number;
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
	 * Get number.
	 *
	 * @return number as String.
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Set number.
	 *
	 * @param number the value to set.
	 */
	public void setNumber(String number) {
		this.number = number;
	}
}

