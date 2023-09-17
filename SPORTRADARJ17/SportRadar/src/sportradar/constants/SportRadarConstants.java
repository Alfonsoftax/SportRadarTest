package sportradar.constants;

public class SportRadarConstants extends Exception {

	private static final long serialVersionUID = 1L;
	public static final Long LOCAL_TEAM = Long.valueOf(0);
	public static final Long AWAY_TEAM = Long.valueOf(1);

	public static final Long INITIAL = Long.valueOf(0);
	public static final int ADD_MATCH = 1;
	public static final int WATCH_ALL_MATCH = 2;
	public static final int SCORED_GOALS = 3;
	public static final int END_MATCH = 4;
	public static final int CERRAR_APLICACION = 5;

	public static final String WELCOME = "Welcome to the SportRadar website. \r\n"
			+ "Here you can follow live and register all the day's matches: \r\n"
			+ "Select an option: \r\n" + "1-  AddMatch \r\n" + "2 - Watch all games \r\n" + "3 - Scored Goals\r\n"
			+ "4 - End Games\r\n";
	public static final String NOT_AVAILABLE = "There are no matches available. \r\n";
	public static final String SELECT_MATCH = "Select the match ID you want to update the goals for \r\n";
	public static final String END_GAME = "Select the ID of the finished match. \r\n";
	public static final String START_GAME = "The match has started. \r\n";
	public static final String LIST_MATCHES = "List of matches ";
	public static final String LOCAL_SCORED = "How many goals has the home team scored?";
	public static final String AWAY_SCORED = "How many goals has the away team scored?";
	public static final String FINISH_MATCH = "The match has ended with the following result: \r\n";
	public static final String NAME_AWAY_TEAM = "Select the name of the away team.";
	public static final String NAME_HOME_TEAM = "Select the name of the home team.";

	public static final String WHITE = " ";
	public static final String BLANK = "";
	public static final String HYPHENS = " ---- ";
	public static final String HYPHEN = " - ";
	public static final String SEPARATE = "______________________________ \r\n";
	public static final String GOODBYE = "Hasta la proxima!";
	public static final Integer FIRST_POSITION = 0;
	public static final Integer ZERO = 0;
	public static final Integer ONE = 1;

}
