package sportradar.match.repository;

import java.util.List;

import sportradar.match.domain.Match;
import sportradar.team.domain.Team;

public interface MatchRepository {

	public Match startGame(List<Team> teams, Integer position);

	public void viewMatches(List<Match> matchs);

	public Match addGoals(Match game);

	public Match findMatch(List<Match> games, Long selected);

	public List<Match> findMatchAndFinish(List<Match> games, Long selected);
}
