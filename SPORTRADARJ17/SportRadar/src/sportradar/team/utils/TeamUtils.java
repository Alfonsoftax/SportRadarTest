package sportradar.team.utils;

import java.util.Scanner;

import sportradar.constants.SportRadarConstants;
import sportradar.team.domain.Team;

public class TeamUtils {

	Scanner entrada = new Scanner(System.in);

	public Team addAwayTeam() {
		System.out.println(SportRadarConstants.NAME_AWAY_TEAM);
		Team team = new Team();
		/**
		 * You have to comment the Line 17 for the test and uncomment 18
		 */
		String awayTeamName = entrada.next();
		// String awayTeamName = "TeamAway1";
		team.setName(awayTeamName);
		team.setType(SportRadarConstants.AWAY_TEAM);
		return team;
	}

	public Team addLocalTeam() {
		System.out.println(SportRadarConstants.NAME_HOME_TEAM);
		Team team = new Team();
		/**
		 * You have to comment the Line 31 for the test and uncomment 30
		 */
		String localTeamName = entrada.next();
		// String localTeamName = "TeamLocal1";
		team.setName(localTeamName);
		team.setType(SportRadarConstants.LOCAL_TEAM);
		return team;
	}
}
