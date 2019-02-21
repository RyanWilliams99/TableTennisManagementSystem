package tabletennismanager;

public class FixtureAndResult {
    private String homeTeam;
    private String awayTeam;
    private int homeTeamSets;
    private int awayTeamSets;

    public FixtureAndResult(String homeTeam, String awayTeam, int homeTeamSets, int awayTeamSets) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamSets = homeTeamSets;
        this.awayTeamSets = awayTeamSets;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

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
}
