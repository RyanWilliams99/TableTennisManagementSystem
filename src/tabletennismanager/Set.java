package tabletennismanager;

import java.util.ArrayList;

public class Set {

    private int playerHome;
    private int playerAway;
    private int scoreHome;
    private int scoreAway;
    private ArrayList<Game> games;

    public Set() {

       games = new ArrayList<>(2);

        for(int x  = 0; x < 3; x++) //Generate 3 Game objects
        {
            games.add(new Game());
        }
    }

    public void calculateSetScores() {
        //Should check to see if 3 game objects contain score yet or not
        for (int x = 0; x < 3; x++)
        {
            if(games.get(x).getHomeScore() > games.get(x).getAwayScore())
                this.setScoreHome(this.getScoreHome() + 1);
            else
                this.setScoreAway(this.getScoreAway() + 1);

        }

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
