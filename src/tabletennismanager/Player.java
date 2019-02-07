package tabletennismanager;

    public class Player {

    private String playerName;
    
    // Constructor
    public Player(String name){
        playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}