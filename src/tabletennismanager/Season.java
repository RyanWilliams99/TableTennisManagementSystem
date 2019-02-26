package tabletennismanager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Season {

    public ArrayList<Match> fixtures;
    private ArrayList<Team> teams;

    public Season(){
        teams = new ArrayList<>(2);
        fixtures = new ArrayList<>(2);
    }

    public ArrayList<Match> getFixtures() {
        return fixtures;
    }

    public void addTeam(Team teamPassed) {
        System.out.println("Adding Team " + teamPassed.getTeamName());
        teams.add(teamPassed);
    }


    public void setFixtures(ArrayList<Match> fixtures) {
        this.fixtures = fixtures;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void addMatch(Match match) {

        fixtures.add(match);
    }

    public void generateFixtures() {
        fixtures.clear();
        for(int x = 0; x < teams.size(); x++)
        {
            for(int y = x + 1; y < teams.size(); y++)
            {
                fixtures.add(new Match(teams.get(x),teams.get(y)));
            }
        }

        for(int x = 0; x < teams.size(); x++)
        {
            for(int y = x + 1; y < teams.size(); y++)
            {
                fixtures.add(new Match(teams.get(y),teams.get(x)));
            }
        }
    }

    public void generateStats() {

        for (int x = 0; x < fixtures.size(); x++)
        {
            fixtures.get(x).getTeamHome().resetStats();
            fixtures.get(x).getTeamAway().resetStats();
        }
        for(int x = 0; x < fixtures.size(); x++) //For every fixture
        {

            if (fixtures.get(x).isMatchPlayed()) //If Match is played
            {
                System.out.println("Generate Stats");
                fixtures.get(x).getTeamHome().setMatchesPlayed(fixtures.get(x).getTeamHome().getMatchesPlayed() + 1);
                fixtures.get(x).getTeamAway().setMatchesPlayed(fixtures.get(x).getTeamAway().getMatchesPlayed() + 1);
                if (fixtures.get(x).getScoreHome() > fixtures.get(x).getScoreAway())
                    fixtures.get(x).getTeamHome().setMatchesWon(fixtures.get(x).getTeamHome().getMatchesWon() + 1);
                else
                    fixtures.get(x).getTeamAway().setMatchesWon(fixtures.get(x).getTeamAway().getMatchesWon() + 1);

                fixtures.get(x).getTeamHome().setSetsPlayed(fixtures.get(x).getTeamHome().getMatchesPlayed() * 5);
                fixtures.get(x).getTeamAway().setSetsPlayed(fixtures.get(x).getTeamAway().getMatchesPlayed() * 5);
                fixtures.get(x).getTeamHome().setSetsWon(fixtures.get(x).getScoreHome());
                fixtures.get(x).getTeamAway().setSetsWon(fixtures.get(x).getScoreAway());

                fixtures.get(x).getTeamHome().setGamesPlayed(fixtures.get(x).getTeamHome().getSetsPlayed() * 3);
                fixtures.get(x).getTeamAway().setGamesPlayed(fixtures.get(x).getTeamAway().getSetsPlayed() * 3);
                for (int y = 0; y < 5; y++) {
                    for (int z = 0; z < 3; z++) {
                        if (fixtures.get(x).sets.get(y).games.get(z).getHomeScore() > fixtures.get(x).sets.get(y).games.get(z).getAwayScore()) {
                            fixtures.get(x).getTeamHome().setGamesWon(fixtures.get(x).getTeamHome().getGamesWon() + 1);
                        } else
                            fixtures.get(x).getTeamAway().setGamesWon(fixtures.get(x).getTeamAway().getGamesWon() + 1);

                    }
                }
                fixtures.get(x).getTeamHome().setLostValues();
                fixtures.get(x).getTeamAway().setLostValues();

            }
        }
    }

    public void displayTeamStats() {
        System.out.println("\n________________DisplayTeamStats________________");
        for (int x = 0; x < teams.size(); x++)
        {
            System.out.println("Team Name: " + teams.get(x).getTeamName());
            System.out.println("Matches Played: " + teams.get(x).getMatchesPlayed() + " Matches Won: " + teams.get(x).getMatchesWon() + " Matches Lost: " + teams.get(x).getMatchesLost());
            System.out.println("Sets Played:    " + teams.get(x).getSetsPlayed() + " Sets Won     " + teams.get(x).getSetsWon() + " Sets Lost     " + teams.get(x).getSetsLost());
            System.out.println("Games Played:   " + teams.get(x).getGamesPlayed() + " Games Won    " + teams.get(x).getGamesWon() + " Games Lost    " + teams.get(x).getGamesLost());
            System.out.println("________________________________________________");
        }
    }
    public void displayLeaderBoard() {
        int tempHighest = 0;
        for (int x = 0; x < teams.size(); x++)
        {
            //if(teams.get(x).getMatchesWon() > tempHighest)

        }
    }

    public void displayAMatch(Match passedMatch) {
        System.out.println(passedMatch.getTeamHome().getTeamName() + " VS " + passedMatch.getTeamAway().getTeamName());
        for (int x = 0; x < passedMatch.getTeamHome().getPlayers().size(); x++)
        {
            System.out.println("Home player " + x + passedMatch.getTeamHome().getPlayers().get(x));
        }
        for (int x = 0; x < passedMatch.getTeamAway().getPlayers().size(); x++)
        {
            System.out.println("Away Player " + x + passedMatch.getTeamAway().getPlayers().get(x));
        }
        System.out.println("Home: " + passedMatch.getTeamHome().getSetsWon() + " Away: " + passedMatch.getTeamAway().getSetsWon());
        // Display match score
    }

    public void displayFixtures() { //Probably doesnt need to display teams and scores like initially thought
        System.out.println("\nFixtures");
        for(int x = 0; x < fixtures.size(); x++)
        {
            System.out.println(fixtures.get(x).getTeamHome().getTeamName() + " VS " + fixtures.get(x).getTeamAway().getTeamName());
        }
        System.out.println("\n");
    }

    public void autoUpdateThread() {
        // Call generate fixtures every 100 seconds
    }


    public void calculateScores()
    {
        for (int x  = 0; x < fixtures.size(); x++)
        {
            fixtures.get(x).resetScores();
            if(fixtures.get(x).isMatchPlayed())
            {
                fixtures.get(x).calculateMatchScores();
            }
        }
    }

    public boolean teamAlreadyExists(String proposedTeamName)
    {
        for(int x = 0; x < this.getTeams().size(); x++)
        {
            if (proposedTeamName.equals(teams.get(x).getTeamName()))
            {
                System.out.println("team already exitsts");
                return true;
            }
        }
        System.out.println("Return false team does not exuits");
        return false;
    }


    public void addTestData()
    {
        fixtures.clear();
        teams.clear();
        Team uwe = new Team("uwe");
        Team page = new Team("page");
        Team filton = new Team("filton");
        Team kcc = new Team("kcc");
        this.addTeam(uwe);
        this.addTeam(page);
        this.addTeam(filton);
        this.addTeam(kcc);
        uwe.addPlayer(new Player("jin"));
        uwe.addPlayer(new Player("julia"));
        uwe.addPlayer(new Player("stewart"));
        page.addPlayer(new Player("peter"));
        page.addPlayer(new Player("phil"));
        filton.addPlayer(new Player("alex"));
        filton.addPlayer(new Player("brian"));
        kcc.addPlayer(new Player("ryan"));
        kcc.addPlayer(new Player("chris"));

        this.generateFixtures();

        for(int x = 0; x < fixtures.size(); x++)
        {
            if (fixtures.get(x).getTeamHome() == filton && fixtures.get(x).getTeamAway() == uwe)
            {
                fixtures.get(x).sets.get(0).addSetScoresAndPlayers(11,2,3,11,11,5);
                fixtures.get(x).sets.get(1).addSetScoresAndPlayers(1,11,5,11,11,6);
                fixtures.get(x).sets.get(2).addSetScoresAndPlayers(11,9,11,1,11,1);
                fixtures.get(x).sets.get(3).addSetScoresAndPlayers(11,2,3,11,11,5);
                fixtures.get(x).sets.get(4).addSetScoresAndPlayers(0,11,1,11,2,11);
                fixtures.get(x).setMatchPlayed(true);
            }

            if (fixtures.get(x).getTeamHome() == uwe && fixtures.get(x).getTeamAway() == page)
            {
                fixtures.get(x).sets.get(0).addSetScoresAndPlayers(11,2,3,11,11,5);
                fixtures.get(x).sets.get(1).addSetScoresAndPlayers(11,1,5,11,11,6);
                fixtures.get(x).sets.get(2).addSetScoresAndPlayers(11,9,11,1,11,1);
                fixtures.get(x).sets.get(3).addSetScoresAndPlayers(11,2,3,11,11,5);
                fixtures.get(x).sets.get(4).addSetScoresAndPlayers(0,11,1,11,2,11);
                fixtures.get(x).setMatchPlayed(true);
            }
        }
    }
}