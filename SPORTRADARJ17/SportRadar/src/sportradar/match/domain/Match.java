package sportradar.match.domain;

import java.util.List;

import sportradar.team.domain.Team;

public class Match {

	public Match(Long id, Long awayGoals, Long localGoals, Long totalScores, Integer position, List<Team> teams) {
		super();
		this.id = id;
		this.awayGoals = awayGoals;
		this.localGoals = localGoals;
		this.totalScores = totalScores;
		this.position = position;
		this.teams = teams;
	}

	public Match(Long awayGoals, Long localGoals, List<Team> teams, Long totalScores, Integer position) {
		super();
		this.awayGoals = Long.valueOf(0);
		this.localGoals = Long.valueOf(0);
		this.teams = teams;
		this.setPosition(position);
		this.setTotalScores(totalScores);
	}

	private Long id;
	private Long awayGoals;
	private Long localGoals;
	private Long totalScores;
	private Integer position;
	private List<Team> teams;

	public Long getAwayGoals() {
		return awayGoals;
	}

	public void setAwayGoals(Long awayGoals) {
		this.awayGoals = awayGoals;
	}

	public Long getLocalGoals() {
		return localGoals;
	}

	public void setLocalGoals(Long localGoals) {
		this.localGoals = localGoals;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotalScores() {
		return totalScores;
	}

	public void setTotalScores(Long totalScores) {
		this.totalScores = totalScores;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}
