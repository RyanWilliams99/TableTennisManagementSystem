package tabletennismanager;

import java.util.ArrayList;

public class Set {

    private int playerHome;
    private int playerAway;
    private int scoreHome;
    private int scoreAway;
    private ArrayList<Game> games;

    public void Set() {
        // generate 3 games
    }

    public void calculateSetScores() {
        // if teamHome.calculateGames > teamAway.calculateGames()
        // return teamHome
        // else team away
    }

    public int getPlayerHome()
    {
        return playerHome;
    }

    public void setPlayerHome(int playerHome) {
        this.playerHome = playerHome;
    }

    public int getPlayerAway() {
        return playerAway;
    }

    public void setPlayerAway(int playerAway) {
        this.playerAway = playerAway;
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

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

}
