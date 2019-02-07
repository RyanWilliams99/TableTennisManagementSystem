

    package tabletennismanager;

import java.util.ArrayList;

    public class Match {

    private boolean matchPlayed;
    private Team teamHome;
    private Team teamAway;
    private int scoreHome;
    private int scoreAway;
    private ArrayList<Set> sets[];

    public void Match() {
        // Generate 5 sets
        
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

    public ArrayList<Set>[] getSets() {
        return sets;
    }

    public void setSets(ArrayList<Set>[] sets) {
        this.sets = sets;
    }
    
    

}
