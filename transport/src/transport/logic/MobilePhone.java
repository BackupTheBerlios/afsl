package transport.logic;

public class MobilePhone extends LogicItem {
	int id;
	String number;

	public MobilePhone(int id, String number) {
		this.id=id;
		this.number=number;
	}

	public String toString() {
		return number;
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
		this.number=number;
	}

	/**
	 * MobilePhone
	 */
	public MobilePhone() {
		this.id= -1;
	}

        public String toHTML() {
          String html;
          html = "\n<b>Mobile Phone:</b>" + getNumber() + "(id:" + getId() +
              ")<br>\n";
          return html;
        }
}
