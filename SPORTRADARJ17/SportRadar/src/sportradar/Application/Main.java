package sportradar.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sportradar.constants.SportRadarConstants;
import sportradar.match.domain.Match;
import sportradar.match.resource.MatchResource;

public class Main {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int opcion;
		MatchResource matchResource = new MatchResource();
		List<Match> games = new ArrayList<>();
		do {
			System.out.println(SportRadarConstants.WELCOME);
			opcion = entrada.nextInt();
			switch (opcion) {
			case SportRadarConstants.ADD_MATCH:
				// Option 1: Register match
				matchResource.addMatch(games);
				break;
			case SportRadarConstants.WATCH_ALL_MATCH:
				// Option 2: Watch all the games
				matchResource.watchAllGames(games);
				break;
			case SportRadarConstants.SCORED_GOALS:
				// Option 3.1: Add goals
				matchResource.scoredGoals(games);
				break;
			case SportRadarConstants.END_MATCH:
				// Option 3.2: End Match
				matchResource.endGames(games);
				break;
			default:
				System.out.println(SportRadarConstants.GOODBYE);
			}
		} while (opcion != 5);

	}

}
