package transport.logic;

import java.util.Date;

public class Functionary {
	private int id;
	private String name;
	private Date beginsWork;
	private Date stopsWork;
	private Role role;

	public Functionary(int id, String name, Date beginsWork, 
					   Date stopsWork, Role role) {
		this.id=id;
		this.name=name;
		this.beginsWork=beginsWork;
		this.stopsWork=stopsWork;
		this.role=role;
	}

	public Functionary() {
		id=-1;
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
	 * Get beginsWork.
	 *
	 * @return beginsWork as Date.
	 */
	public Date getBeginsWork() {
		return beginsWork;
	}
	
	/**
	 * Set beginsWork.
	 *
	 * @param beginsWork the value to set.
	 */
	public void setBeginsWork(Date beginsWork) {
		this.beginsWork = beginsWork;
	}
	
	/**
	 * Get stopsWork.
	 *
	 * @return stopsWork as Date.
	 */
	public Date getStopsWork() {
		return stopsWork;
	}
	
	/**
	 * Set stopsWork.
	 *
	 * @param stopsWork the value to set.
	 */
	public void setStopsWork(Date stopsWork) {
		this.stopsWork = stopsWork;
	}
	
	/**
	 * Get role.
	 *
	 * @return role as Role.
	 */
	public Role getRole() {
		return role;
	}
	
	/**
	 * Set role.
	 *
	 * @param role the value to set.
	 */
	public void setRole(Role role) {
		this.role = role;
	}
}

