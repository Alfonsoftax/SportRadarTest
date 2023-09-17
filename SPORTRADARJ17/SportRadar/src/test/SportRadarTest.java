package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import sportradar.constants.SportRadarConstants;
import sportradar.match.domain.Match;
import sportradar.match.repository.MatchRepository;
import sportradar.match.repository.impl.MatchRepositoryImpl;
import sportradar.team.domain.Team;
import sportradar.team.utils.TeamUtils;

public class SportRadarTest {
	private TeamUtils teamManager = new TeamUtils();
	MatchRepository matchRepository = new MatchRepositoryImpl();

	@Before
	public void setUp() {
		teamManager = new TeamUtils(); // Crea una instancia de la clase que contiene el método.
		matchRepository = new MatchRepositoryImpl();
	}

	@Test
	public void testAddLocalTeam() {
		// Simula la entrada del nombre del equipo local.

		Team team = teamManager.addLocalTeam();
		// Verifica que el nombre y el tipo del equipo se hayan configurado
		// correctamente.
		assertEquals("TeamLocal1", team.getName());
		assertEquals(SportRadarConstants.LOCAL_TEAM, team.getType());
	}

	@Test
	public void testAddAwayTeam() {
		// Simula la entrada del nombre del equipo local.

		Team team = teamManager.addAwayTeam();
		// Verifica que el nombre y el tipo del equipo se hayan configurado
		// correctamente.
		assertEquals("TeamAway1", team.getName());
		assertEquals(SportRadarConstants.AWAY_TEAM, team.getType());
	}

	@Test
	public void testStartGame() {
		// Configura los datos de prueba
		List<Team> teams = new ArrayList<>();
		Team team1 = new Team("NewTeam1", 0L);
		Team team2 = new Team("NewTeam2", 1L);
		teams.add(team1);
		teams.add(team2);

		Match match = matchRepository.startGame(teams, 0);

		assertEquals(SportRadarConstants.INITIAL, match.getLocalGoals());
		assertEquals(SportRadarConstants.INITIAL, match.getAwayGoals());
		assertEquals(teams, match.getTeams());
		assertNotNull(match);
	}

	@Test
	public void testViewMatches() {
		List<Match> games = this.createGames();

		matchRepository.viewMatches(games);

		assertEquals(2, games.size());
	}

	private List<Match> createGames() {
		List<Match> games = new ArrayList<>();
		List<Team> teams = new ArrayList<>();
		Team team1 = new Team("NewTeam1", 0L);
		Team team2 = new Team("NewTeam2", 1L);
		teams.add(team1);
		teams.add(team2);
		List<Team> teams2 = new ArrayList<>();
		Team team3 = new Team("NewTeam3", 0L);
		Team team4 = new Team("NewTeam4", 1L);
		teams2.add(team3);
		teams2.add(team4);
		Match match = new Match(0L, 0L, teams, 0L, 1);
		Match match2 = new Match(0L, 0L, teams2, 0L, 1);
		games.add(match2);
		games.add(match);
		return games;
	}

	@Test
	public void testAddGoals() {
		List<Match> games = this.createGames();
		Match updatedMatch = matchRepository.addGoals(games.get(0));
		assertEquals(3L, updatedMatch.getLocalGoals());
		assertEquals(4L, updatedMatch.getAwayGoals());
	}

	@Test
	public void testFindMatchAndFinish() {
		List<Match> games = new ArrayList<>();
		List<Team> teams = new ArrayList<>();
		Team team1 = new Team("NewTeam1", 0L);
		Team team2 = new Team("NewTeam2", 1L);
		teams.add(team1);
		teams.add(team2);
		List<Team> teams2 = new ArrayList<>();
		Team team3 = new Team("NewTeam3", 0L);
		Team team4 = new Team("NewTeam4", 1L);
		teams2.add(team3);
		teams2.add(team4);
		Match match = new Match(1L, 0L, 0L, 0L, 1, teams);
		Match match2 = new Match(2L, 0L, 0L, 0L, 1, teams);
		games.add(match2);
		games.add(match);
		Long selected = 1L;

		List<Match> updatedGames = matchRepository.findMatchAndFinish(games, selected);

		assertFalse(updatedGames.contains(match));
		assertTrue(updatedGames.contains(match2));
	}
}
