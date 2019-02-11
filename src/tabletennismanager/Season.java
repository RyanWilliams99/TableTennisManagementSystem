package tabletennismanager;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
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

        for(int x = 0; x < fixtures.size(); x++) //For every fixture
        {
            if (fixtures.get(x).isMatchPlayed())
            {
                fixtures.get(x).getTeamHome().setSetsWon(fixtures.get(x).getScoreHome());
                fixtures.get(x).getTeamAway().setSetsWon(fixtures.get(x).getScoreAway());
                for(int y = 0; y < 5; y ++)
                {
                    for(int z = 0; z < 3; z++)
                    {
                        fixtures.get(x).getTeamHome().setGamesWon(fixtures.get(x).sets.get(y).games.get(z).getHomeScore());
                        fixtures.get(x).getTeamAway().setGamesWon(fixtures.get(x).sets.get(y).games.get(z).getAwayScore());

                    }

                }
            }
            else
                System.out.println("is match played bool not true");
        }
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
        System.out.println(passedMatch.getTeamHome().getTeamName() + " VS " + passedMatch.getTeamAway().getTeamName());
        for (int x = 0; x < passedMatch.getTeamHome().getPlayers().size(); x++)
        {
            System.out.println("Home player " + x + passedMatch.getTeamHome().getPlayers().get(x));
        }
        for (int x = 0; x < passedMatch.getTeamAway().getPlayers().size(); x++)
        {
            System.out.println("Away Player" + x + passedMatch.getTeamAway().getPlayers().get(x));
        }
        System.out.println("Home: " + passedMatch.getTeamHome().getSetsWon() + " Away: " + passedMatch.getTeamAway().getSetsWon());
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

    public void loadTestData() throws IOException {
        // pass the path to the file as a parameter
        ArrayList<Integer> ints = new ArrayList<Integer>();
        System.out.println("test");
        try {
            File file = new File("C:\\Projects\\OneDrive - UWE Bristol (Students)\\Work\\2\\OOSD\\Group Assignment\\UFCFB6-30-2-TableTennisManagementSystem\\TableTennisManager\\testScores.txt");
            Scanner sc = new Scanner(file);

            while(sc.hasNext())
            {
                sc.useDelimiter(":");
                System.out.println(sc.next());

                //ints.add(Integer.parseInt(sc.next()));
            }
        } catch(IOException sc) {
            sc.printStackTrace();
        }

       // System.out.println(ints);
    }

}