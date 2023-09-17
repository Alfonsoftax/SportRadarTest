package sportradar.match.repository.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import sportradar.constants.SportRadarConstants;
import sportradar.match.domain.Match;
import sportradar.match.repository.MatchRepository;
import sportradar.match.utils.MatchUtils;
import sportradar.team.domain.Team;

public class MatchRepositoryImpl implements MatchRepository {

	MatchUtils matchUtils = new MatchUtils();
	Scanner entrada = new Scanner(System.in);

	@Override
	public Match startGame(List<Team> teams, Integer position) {
		// Initialize the constructor.
		Match match = new Match(SportRadarConstants.INITIAL, SportRadarConstants.INITIAL, teams,
				SportRadarConstants.INITIAL, position);
		System.out.print(SportRadarConstants.START_GAME);
		return match;
	}

	@Override
	public void viewMatches(List<Match> games) {
		System.out.println(SportRadarConstants.LIST_MATCHES);
		// For the order in which they are displayed, 
		// we compare the total goals; if they are equal, we compare the entry in the system.
		Collections.sort(games,
				Comparator.comparing(Match::getTotalScores).thenComparing(Match::getPosition).reversed());
		// We assign the IDs again in case there have been modifications to the list. 
		// Since we are not using typical sequences, we will calculate the IDs for the matches
		matchUtils.assignID(games);
		games.forEach(match -> {
			// We iterate through the list and display it on the screen
			matchUtils.buildPhraseMatch(match);
		});
	}

	@Override
	public Match addGoals(Match matchChange) {
		System.out.println(SportRadarConstants.LOCAL_SCORED);
		/**
		 * You have to comment the Line 50 for the test and uncomment 51
		 */
		Long localGoals = entrada.nextLong();
		// Long localGoals = 3L;
		System.out.println(SportRadarConstants.AWAY_SCORED);
		/**
		 * You have to comment the Line 56 for the test and uncomment 57
		 */
		Long awayGoals = entrada.nextLong();
		// Long awayGoals = 4L;

		// We add the goals to the scoreboard.
		matchChange.setLocalGoals(matchChange.getLocalGoals() + localGoals);
		matchChange.setAwayGoals(matchChange.getAwayGoals() + awayGoals);
		matchChange.setTotalScores(matchChange.getLocalGoals() + matchChange.getAwayGoals());
		return matchChange;
	}

	@Override
	public List<Match> findMatchAndFinish(List<Match> games, Long selected) {
		// We find and remove for the list
		Match endMatch = this.findMatch(games, selected);
		games.remove(endMatch);
		System.out.print(SportRadarConstants.FINISH_MATCH);
		matchUtils.buildPhraseMatch(endMatch);
		return games;
	}

	@Override
	public Match findMatch(List<Match> games, Long selected) {
		return games.stream().filter(match -> match.getId().equals(selected)).findFirst().orElse(null);
	}

}
