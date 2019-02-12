package tabletennismanager;

import java.util.ArrayList;

    public class Match {

    private boolean matchPlayed;
    private Team teamHome;
    private Team teamAway;
    private int scoreHome;
    private int scoreAway;
    public ArrayList<Set> sets;


        public Match(Team teamHome, Team teamAway) { //When creating new match 2 Must pass two Team objects
            this.teamHome = teamHome;
            this.teamAway = teamAway;

            sets = new ArrayList<>(2);
            System.out.println("Creating five new set objects");
            for(int x  = 0;x < 5; x++) //Generate 5 set objects
            {
                sets.add(new Set());
            }
        }

        public void calculateMatchScores() {
            for (int x  = 0; x < 5; x++) //For every Set see who had most games
            {
                sets.get(x).calculateSetScores();
                if (sets.get(x).getScoreHome() > sets.get(x).getScoreAway())
                    this.setScoreHome(this.getScoreHome() + 1);
                else
                    this.setScoreAway(this.getScoreAway() + 1);

            }
        }

        public boolean isMatchPlayed() {

            return matchPlayed;
        }

        public void setMatchPlayed(boolean matchPlayed) {
            this.matchPlayed = matchPlayed;
        }

        public Team getTeamHome() {
            return teamHome;
        }

        public void setTeamHome(Team teamHome) {
            this.teamHome = teamHome;
        }

        public Team getTeamAway() {
            return teamAway;
        }

        public void setTeamAway(Team teamAway) {
            this.teamAway = teamAway;
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