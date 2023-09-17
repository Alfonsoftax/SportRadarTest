package sportradar.match.utils;

import java.util.List;

import sportradar.constants.SportRadarConstants;
import sportradar.match.domain.Match;
import sportradar.team.domain.Team;

public class MatchUtils {

	public void buildPhraseMatch(Match match) {
		String localTeam = this.findLocalTeam(match.getTeams());
		String awayTeam = this.findAwayTeam(match.getTeams());
		System.out.println(match.getId() + SportRadarConstants.HYPHENS + localTeam + SportRadarConstants.WHITE
				+ match.getLocalGoals() + SportRadarConstants.HYPHEN + awayTeam + SportRadarConstants.WHITE
				+ match.getAwayGoals());
		System.out.println(SportRadarConstants.SEPARATE);
	}

	private String findAwayTeam(List<Team> list) {
		return list.stream().filter(team -> team.getType().equals(SportRadarConstants.AWAY_TEAM)).map(Team::getName)
				.findFirst().orElse(SportRadarConstants.BLANK);
	}

	private String findLocalTeam(List<Team> list) {
		return list.stream().filter(team -> team.getType().equals(SportRadarConstants.LOCAL_TEAM)).map(Team::getName)
				.findFirst().orElse(SportRadarConstants.BLANK);
	}

	public void assignID(List<Match> matchs) {
		Integer id = 1;
		if (matchs.size() > SportRadarConstants.ZERO) {
			for (Match match : matchs) {
				id = matchs.indexOf(match) + SportRadarConstants.ONE;
				match.setId(Long.valueOf(id));
			}
		}
	}

	public Integer calculatePosition(List<Match> matchs) {
		Integer id = matchs.size();
		for (Match match : matchs) {
			if (match.getId().equals(Long.valueOf(id))) {
				id++;
			}
		}
		return id > 0 ? id : SportRadarConstants.ONE;
	}
}
