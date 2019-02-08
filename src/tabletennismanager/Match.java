package tabletennismanager;

import java.util.ArrayList;

    public class Match {

    private boolean matchPlayed;
    private Team teamHome;
    private Team teamAway;
    private int scoreHome;
    private int scoreAway;
    private ArrayList<Set> sets;

        public Match(Team teamHome, Team teamAway) {
            this.teamHome = teamHome;
            this.teamAway = teamAway;
        }

        public void calculateMatchScores() {
            // if teamHome.calculate sets > teamAway.calculateSets()
            // return teamHome
            // else team away
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

