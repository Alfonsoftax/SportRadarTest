package sportradar.match.resource;

import java.util.List;
import java.util.Scanner;

import sportradar.constants.SportRadarConstants;
import sportradar.match.domain.Match;
import sportradar.match.repository.MatchRepository;
import sportradar.match.repository.impl.MatchRepositoryImpl;
import sportradar.match.utils.MatchUtils;
import sportradar.team.domain.Team;
import sportradar.team.repository.TeamRepository;
import sportradar.team.repository.impl.TeamRepositoryImpl;

public class MatchResource {

	MatchRepository matchRepository = new MatchRepositoryImpl();
	TeamRepository teamRepository = new TeamRepositoryImpl();
	MatchUtils matchUtils = new MatchUtils();
	Scanner entrada = new Scanner(System.in);

	public void addMatch(List<Match> matchs) {
		// add Teams for the match
		List<Team> teams = teamRepository.addTeam();
		// Calculate the entry position of the match in the system.
		Integer position = matchUtils.calculatePosition(matchs);
		// Start match
		Match match = matchRepository.startGame(teams, position);
		// Add match in the list on the first position
		matchs.add(SportRadarConstants.FIRST_POSITION, match);
		// Assingn unique ID for the match
		matchUtils.assignID(matchs);
		// Build phrase
		matchUtils.buildPhraseMatch(match);
	}

	public void watchAllGames(List<Match> games) {
		// We check if there are more than 0 matches; if not, we display a warning.
		if (games.size() > SportRadarConstants.ZERO) {
			matchRepository.viewMatches(games);
		} else {
			System.out.println(SportRadarConstants.NOT_AVAILABLE);
			System.out.println(SportRadarConstants.SEPARATE);
		}
	}

	public void scoredGoals(List<Match> games) {
		// We check if there are more than 0 matches; if not, we display a warning.
		if (games.size() > SportRadarConstants.ZERO) {
			matchRepository.viewMatches(games);
			// We check if there are more than 1 matches; if not, we add goals directly.
			if (games.size() > SportRadarConstants.ONE) {
				System.out.println(SportRadarConstants.SELECT_MATCH);
				Long selected = entrada.nextLong();
				// We find the match as we want to score goal
				Match match = matchRepository.findMatch(games, selected);
				// We add the goals
				matchRepository.addGoals(match);
			} else if (!games.isEmpty()) {
				matchRepository.addGoals(games.get(SportRadarConstants.ZERO));
			}

			System.out.println(SportRadarConstants.SEPARATE);
			// We will see the updated matches
			matchRepository.viewMatches(games);
		} else {
			System.out.println(SportRadarConstants.NOT_AVAILABLE);
			System.out.println(SportRadarConstants.SEPARATE);
		}
	}

	public void endGames(List<Match> games) {
		// We check if there are more than 0 matches; if not, we display a warning.
		if (games.size() > SportRadarConstants.ZERO) {
			matchRepository.viewMatches(games);
			System.out.println(SportRadarConstants.END_GAME);
			Long selected = entrada.nextLong();
			// We find the selected match
			games = matchRepository.findMatchAndFinish(games, selected);
			matchRepository.viewMatches(games);
		} else {
			System.out.println(SportRadarConstants.NOT_AVAILABLE);
			System.out.println(SportRadarConstants.SEPARATE);
		}

	}
}
