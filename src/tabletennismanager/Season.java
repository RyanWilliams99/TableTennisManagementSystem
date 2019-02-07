package tabletennismanager;

import java.util.ArrayList;

public class Season {

    private ArrayList<Match> fixtures;
    private ArrayList<Team> teams;
    
    public Season(){
        fixtures = new ArrayList<Match>();
        teams = new ArrayList<Team>();
    }

    public void addTeam(Team team) {

        teams.add(team);
    }

    public void addMatch(Match match) {

        fixtures.add(match);
    }

    public void generateFixtures() {
       
    }
    public void generateStats() {
        // for all fixtures
        // calculate total sets won
        // calculate total matches won
        // calculate total matches played
    }
    public void displayTeamStats() {
        // for each team
        // Display matches played
        // display sets won
        // display matches won
    }
    public void displayLeaderBoard() {
        // Generate stats
        // Display team stats in order of matches won
    }
    public void displayAMatch() {
        // Display Teams
        // Display players
        // Display Sets scores
        // Display match score
    }
    public void displayFixtures() {
        // For each fixture
        // Display the teams
        // Display the scores
    }
    public void autoUpdateThread() {
        // Call generate fixtures every 100 seconds
    }

}
