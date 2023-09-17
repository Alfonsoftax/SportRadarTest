package sportradar.team.repository.impl;

import java.util.ArrayList;
import java.util.List;

import sportradar.team.domain.Team;
import sportradar.team.repository.TeamRepository;
import sportradar.team.utils.TeamUtils;

public class TeamRepositoryImpl implements TeamRepository {

	TeamUtils teamUtils = new TeamUtils();

	@Override
	public List<Team> addTeam() {
		List<Team> teams = new ArrayList<>();
		Team localTeam = teamUtils.addLocalTeam();
		Team awayTeam = teamUtils.addAwayTeam();
		teams.add(awayTeam);
		teams.add(localTeam);
		return teams;
	}

}
