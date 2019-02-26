package tabletennismanager;

import java.util.ArrayList;

    public class Match {

    private boolean matchPlayed;
    private Team teamHome;
    private Team teamAway;
    private int scoreHome;
    private int scoreAway;
    public ArrayList<Set> sets;


        public Match(Team teamHome, Team teamAway) { //When creating new match 2 MUST pass two Team objects
            this.teamHome = teamHome;
            this.teamAway = teamAway;

            sets = new ArrayList<>(5);
            for(int x  = 0; x < 5; x++) //Generate 5 set objects and add to sets arraylist
            {
                sets.add(new Set());
            }
        }


        public void calculateMatchScores() {
            System.out.println("Calculating match scores for " + this.getTeamHome().getTeamName() + " VS " + this.getTeamAway().getTeamName());
            for (int x  = 0; x < 5; x++) //For every Set see who had most games
            {
                sets.get(x).calculateSetScores();
                System.out.println("About to compare home team SETS vs away team SETS " + sets.get(x).getScoreHome()  + " : " +  sets.get(x).getScoreAway());
                if (sets.get(x).getScoreHome() > sets.get(x).getScoreAway()) //Who ever has more sets increment sets won
                {
                    this.setScoreHome(this.getScoreHome() + 1);
                }
                else
                {
                    this.setScoreAway(this.getScoreAway() + 1);
                }

            }
            System.out.println("HOME SETS WON: " + this.getScoreHome() + " AWAY SETS WON: " + this.getScoreAway());
        }

        public void resetScores() //Used To reset values so they are not wrong if user presses more than once
        {
            this.setScoreHome(0);
            this.setScoreAway(0);
            for (int x = 0; x < 5; x++)
            {
                sets.get(x).setScoreHome(0);
                sets.get(x).setScoreAway(0);
            }
        }

        public boolean isMatchPlayed() { return matchPlayed; }

        public void setMatchPlayed(boolean matchPlayed) {
            this.matchPlayed = matchPlayed;
        }

        public Team getTeamHome() {
            return teamHome;
        }

        public Team getTeamAway() {
            return teamAway;
        }

        public int getScoreHome() {
            return scoreHome;
        }

        public void setScoreHome(int scoreHome) {
            this.scoreHome = scoreHome;
        }

        public int getScoreAway() {
            return scoreAway;
        }

        public void setScoreAway(int scoreAway) {
            this.scoreAway = scoreAway;
        }
    }