package sportradar.team.domain;

// TODO: Auto-generated Javadoc
/**
 * The Class Team.
 */
public class Team {

	/**
	 * Instantiates a new team.
	 *
	 * @param name the name
	 * @param type the type
	 */
	public Team(String name, Long type) {
		super();
		this.name = name;
		this.type = type;
	}

	/**
	 * Instantiates a new team.
	 */
	public Team() {
		super();
	}

	/** The name. */
	private String name;
	
	/** The type. */
	// 0 if it`s localTeam 1 if it`s awayTeam
	private Long type;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Long getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(Long type) {
		this.type = type;
	}
}
