package tabletennismanager;

public class FixtureAndResult {
    private String homeTeam;
    private String awayTeam;
    private String vs = "VS";
    private int homeTeamSets;
    private int awayTeamSets;

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
    private int position;


    public FixtureAndResult(int x, String teamName, int matchesPlayed, int matchesWon, int matchesLost, int setsPlayed, int setsWon, int setsLost, int gamesPlayed, int gamesWon, int gamesLost) {
        this.position = x;
        this.teamName = teamName;
        this.matchesPlayed = matchesPlayed;
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
        this.setsPlayed = setsPlayed;
        this.setsWon = setsWon;
        this.setsLost = setsLost;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
    }

    public FixtureAndResult(String homeTeam, String awayTeam, int homeTeamSets, int awayTeamSets) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamSets = homeTeamSets;
        this.awayTeamSets = awayTeamSets;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) { this.position = position; }

    public String getHomeTeam() { return homeTeam; }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeamSets() {
        return homeTeamSets;
    }

    public void setHomeTeamSets(int homeTeamSets) {
        this.homeTeamSets = homeTeamSets;
    }

    public int getAwayTeamSets() {
        return awayTeamSets;
    }

    public void setAwayTeamSets(int awayTeamSets) {
        this.awayTeamSets = awayTeamSets;
    }

    public String getVs() {
        return vs;
    }

    public void setVs(String vs) {
        this.vs = vs;
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
}
