package transport.logic;

public class Place {
	int id;
	String name;

	public Place(int id, String name) {
		this.id=id;
		this.name=name;
	}

	public String toString() {
		return name;
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
	 * Place
	 */
	public Place() {
		this.id= -1;
	}
}
