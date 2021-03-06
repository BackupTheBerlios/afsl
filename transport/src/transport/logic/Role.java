package transport.logic;

public class Role extends LogicItem {
	private int id;
	private String shortDescr;
	private String longDescr;
        private String initial;
	public Role(int id, String shortDescr, String longDescr, String initial) {
		this.id=id;
		this.shortDescr=shortDescr;
		this.longDescr=longDescr;
                this.initial=initial;
	}

	public String toString() {
		return shortDescr;
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
	 * Get shortDescr.
	 *
	 * @return shortDescr as String.
	 */
	public String getShortDescr() {
		return shortDescr;
	}

	/**
	 * Set shortDescr.
	 *
	 * @param shortDescr the value to set.
	 */
	public void setShortDescr(String shortDescr) {
		this.shortDescr=shortDescr;
	}

	/**
	 * Get longDescr.
	 *
	 * @return longDescr as String.
	 */
	public String getLongDescr() {
		return longDescr;
	}

	/**
	 * Set longDescr.
	 *
	 * @param longDescr the value to set.
	 */
	public void setLongDescr(String longDescr) {
		this.longDescr=longDescr;
	}
        /**
         * Get initial.
         *
         * @return initial as String.
         */
        public String getInitial() {
                return initial;
        }

        /**
         * Set initial.
         *
         * @param initial the value to set.
         */
        public void setInitial(String initial) {
                this.initial=initial;
        }

	/**
	 * Role
	 */
	public Role() {
		this.id= -1;
	}

        public String toHTML() {
          String html;
          html = "<i>" + getShortDescr() +"</i>\n";
          return html;
        }

}
