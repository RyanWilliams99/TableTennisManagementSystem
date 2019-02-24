package tabletennismanager;

import java.util.ArrayList;

public class Set {

    private Player playerHome;
    private Player playerAway;
    private int scoreHome;
    private int scoreAway;
    public ArrayList<Game> games;

    public Set() {

       games = new ArrayList<>(2);

        for(int x  = 0; x < 3; x++) //Generate 3 Game objects
        {
            games.add(new Game());
        }
    }

    public void addSetScoresAndPlayers(int game0h, int game0a ,int game1h, int game1a, int game2h, int game2a) {
        games.get(0).setHomeScore(game0h);
        games.get(0).setAwayScore(game0a);
        games.get(1).setHomeScore(game1h);
        games.get(1).setAwayScore(game1a);
        games.get(2).setHomeScore(game2h);
        games.get(2).setAwayScore(game2a);

    }

    public void calculateSetScores() {
        System.out.println("Calculating who won this set between ");
        //Should check to see if 3 game objects contain score yet or not
        for (int x = 0; x < 3; x++)
        {
            System.out.println("About to compare home team vs away team score GAMES " + games.get(x).getHomeScore() + " : " + games.get(x).getAwayScore());
            if(games.get(x).getHomeScore() > games.get(x).getAwayScore())
            {
                //System.out.println("Before Home Score " + this.getScoreHome());
                this.setScoreHome(this.getScoreHome() + 1);
                //System.out.println("After Home Score " + this.getScoreHome());
            }
            else
            {
                //System.out.println("Before Away Score " + this.getScoreAway());
                this.setScoreAway(this.getScoreAway() + 1);
                //System.out.println("After Away Score " + this.getScoreAway());
            }

        }

    }

    public Player getPlayerHome() {
        return playerHome;
    }

    public void setPlayerHome(Player playerHome) {
        this.playerHome = playerHome;
    }

    public Player getPlayerAway() {
        return playerAway;
    }

    public void setPlayerAway(Player playerAway) {
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
