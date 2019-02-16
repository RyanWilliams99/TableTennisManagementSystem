package tabletennismanager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Season {

    public ArrayList<Match> fixtures;
    private ArrayList<Team> teams;


    public Season(){
        teams = new ArrayList<>(2);
        fixtures = new ArrayList<>(2);
    }

    public void addTeam(Team teamPassed) {
        System.out.println("Adding Team " + teamPassed.getTeamName());
        teams.add(teamPassed);
    }

    public void addMatch(Match match) {

        fixtures.add(match);
    }

    public void generateFixtures() {
        for(int x = 0; x < teams.size(); x++)
        {
            for(int y = x + 1; y < teams.size(); y++)
            {
                //System.out.println("Generating fixtures for the added team");
                fixtures.add(new Match(teams.get(x),teams.get(y)));
            }
        }

        for(int x = 0; x < teams.size(); x++)
        {
            for(int y = x + 1; y < teams.size(); y++)
            {
                //System.out.println("Generating fixtures for the added team");
                fixtures.add(new Match(teams.get(y),teams.get(x)));
            }
        }
    }

    public void generateStats() {

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
        // Generate stats
        // Display team stats in order of matches won
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
            if(fixtures.get(x).isMatchPlayed())
                fixtures.get(x).calculateMatchScores();
        }
    }

    public void addTestData()
    {
        Team uwe = new Team();
        Team page = new Team();
        Team filton = new Team();
        Team kcc = new Team();
        uwe.setTeamName("uwe");
        page.setTeamName("page");
        filton.setTeamName("filton");
        kcc.setTeamName("kcc");
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
                System.out.println("Filton vs uwe setting scores manually");
                fixtures.get(x).sets.get(0).addSetScoresAndPlayers(11,2,3,11,11,5);
                fixtures.get(x).sets.get(1).addSetScoresAndPlayers(1,11,5,11,11,6);
                fixtures.get(x).sets.get(2).addSetScoresAndPlayers(11,9,11,1,11,1);
                fixtures.get(x).sets.get(3).addSetScoresAndPlayers(11,2,3,11,11,5);
                fixtures.get(x).sets.get(4).addSetScoresAndPlayers(0,11,1,11,2,11);
                fixtures.get(x).setMatchPlayed(true);
            }

            if (fixtures.get(x).getTeamHome() == uwe && fixtures.get(x).getTeamAway() == page)
            {
                System.out.println("Filton vs uwe setting scores manually");
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