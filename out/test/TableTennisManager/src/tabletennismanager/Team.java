package tabletennismanager;

import java.util.ArrayList;

    public class Team {

        private String teamName;
        private int matchesPlayed;
        private int matchesWon;
        private int matchesLost;
        private int setsPlayed;
        private int setsWon;
        private int setsLost;
        private int gamesPlayed;
        private int gamesWon;
        private int gamesLost;

        private ArrayList<Player> players; // Should be ArrayList

        public Team(String teamName) {
            this.setTeamName(teamName);
            players = new ArrayList<Player>(2);
        }

        public void addPlayer(Player player) {
            System.out.println("Adding Player " + player.getPlayerName() + " to Team " + this.getTeamName());
            players.add(player);
        }

        public void setLostValues()
        {
            this.setMatchesLost(this.getMatchesPlayed() - this.getMatchesWon());
            this.setSetsLost(this.getSetsPlayed() - this.getSetsWon());
            this.setGamesLost(this.getGamesPlayed() - this.getGamesWon());
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public void setMatchesPlayed(int matchesPlayed) {
            this.matchesPlayed = matchesPlayed;
        }

        public int getMatchesWon() {
            return matchesWon;
        }

        public void setMatchesWon(int matchesWon) {
            this.matchesWon = matchesWon;
        }

        public int getMatchesLost() {
            return matchesLost;
        }

        public void setMatchesLost(int matchesLost) {
            this.matchesLost = matchesLost;
        }

        public int getSetsPlayed() {
            return setsPlayed;
        }

        public void setSetsPlayed(int setsPlayed) {
            this.setsPlayed = setsPlayed;
        }

        public int getSetsWon() {
            return setsWon;
        }

        public void setSetsWon(int setsWon) {
            this.setsWon = setsWon;
        }

        public int getSetsLost() {
            return setsLost;
        }

        public void setSetsLost(int setsLost) {
            this.setsLost = setsLost;
        }

        public int getGamesPlayed() {
            return gamesPlayed;
        }

        public void setGamesPlayed(int gamesPlayed) {
            this.gamesPlayed = gamesPlayed;
        }

        public int getGamesWon() {
            return gamesWon;
        }

        public void setGamesWon(int gamesWon) {
            this.gamesWon = gamesWon;
        }

        public int getGamesLost() {
            return gamesLost;
        }

        public void setGamesLost(int gamesLost) {
            this.gamesLost = gamesLost;
        }

        public ArrayList<Player> getPlayers() {
            return players;
        }

        public void setPlayers(ArrayList<Player> players) {
            this.players = players;
        }
    }