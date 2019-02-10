package tabletennismanager;

import java.util.ArrayList;

public class Season {

    private ArrayList<Match> fixtures;
    private ArrayList<Team> teams;
    
    public Season(){
        teams = new ArrayList<>(2);
        fixtures = new ArrayList<>(2);
    }

    public void addTeam(Team teamPassed) {
        System.out.println("In Add team" + teamPassed.getTeamName());
        teams.add(teamPassed);
        System.out.println(teams.size());
    }

    public void addMatch(Match match) {

        fixtures.add(match);
    }

    public void generateFixtures() {
        for(int x = 0; x < teams.size(); x++)
        {
            for(int y = x + 1; y < teams.size(); y++)
            {
                System.out.println("Generating fixtures for the added team");
                fixtures.add(new Match(teams.get(x),teams.get(y)));
            }
        }

        for(int x = 0; x < teams.size(); x++)
        {
            for(int y = x + 1; y < teams.size(); y++)
            {
                System.out.println("Generating fixtures for the added team");
                fixtures.add(new Match(teams.get(y),teams.get(x)));
            }
        }
    }
    public void generateStats() {

        String teamName;
        int gamesPlayed;
        int gamesWon;
        int gamesLost;

        for(int x = 0; x < teams.size(); x++)
        {
            teamName = teams.get(x).getTeamName();
            gamesPlayed = teams.get(x).getMatchesPlayed();
            gamesWon = teams.get(x).getGamesWon();
            gamesLost = gamesPlayed - gamesWon;
            System.out.println("__________________________________________________________________\n" +
                    teamName + " Team Stats\nMatches Played: " + gamesPlayed + " Matches Won: " + gamesWon + " Matches Lost: " + gamesLost);
        }

        // for all fixtures
        // calculate total sets won
        // calculate total matches won
        // calculate total matches played
    }
    public void displayTeamStats() {
        System.out.println("\ndisplayTeamStats");
        for (int x = 0; x < teams.size(); x++)
        {
            System.out.println("Team Name: " + teams.get(x).getTeamName());
            System.out.println("Matches played: " + teams.get(x).getMatchesPlayed() + " Matches Won: " + teams.get(x).getMatchesWon() + " Matches Lost: " + (teams.get(x).getMatchesPlayed() - teams.get(x).getMatchesWon()));
        }
        // for each team
        // Display matches played
        // display sets won
        // display matches won
    }
    public void displayLeaderBoard() {
        // Generate stats
        // Display team stats in order of matches won
    }
    public void displayAMatch(Match passedMatch) {
        System.out.println(passedMatch.getTeamHome().getTeamName() + "VS" + passedMatch.getTeamAway().getTeamName());
        for (int x = 0; x < passedMatch.getTeamHome().getPlayers().size(); x++)
        {
            System.out.println("Home player " + x + passedMatch.getTeamHome().getPlayers().get(x));
        }
        for (int x = 0; x < passedMatch.getTeamAway().getPlayers().size(); x++)
        {
            System.out.println("Away Player" + x + passedMatch.getTeamAway().getPlayers().get(x));
        }

        // Display Teams
        // Display players
        // Display Sets scores
        // Display match score
    }
    public void displayFixtures() { //Probably doesnt need to display teams and scores like initially thought
        for(int x = 0; x < fixtures.size(); x++)
        {
            System.out.println(fixtures.get(x).getTeamHome().getTeamName() + " VS " + fixtures.get(x).getTeamAway().getTeamName());
        }
    }
    public void autoUpdateThread() {
        // Call generate fixtures every 100 seconds
    }
}