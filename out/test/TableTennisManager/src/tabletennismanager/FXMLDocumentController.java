package tabletennismanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class FXMLDocumentController {

    Season Season = new Season();

    @FXML
    private TextField addTeamTextField;

    @FXML
    private Button addTeam;

    @FXML
    private TextField playerNameTextField;

    @FXML
    private MenuButton selectTeam;

    @FXML
    private Button registerPlayer;

    @FXML
    private Button generateFixtures;

    @FXML
    private Button generateTeamStats;

    @FXML
    private Button viewFixturesResults;

    @FXML
    private Button showStats;

    @FXML
    private Button showRankingTable;

    @FXML
    private Button viewMatchScores;

    @FXML
    private Button modifyScoresheet;

    @FXML
    private MenuButton homeTeam;

    @FXML
    private TableView<FixtureAndResult> viewingTable;

    @FXML
    private AnchorPane viewerPage;

    @FXML
    public void initialize() {

        Season.addTestData();

        updateSelectTeamDropdown();
    }

    public void updateSelectTeamDropdown()
    {
        selectTeam.getItems().clear();
        for (int x = 0; x < Season.getTeams().size(); x++)
        {
            selectTeam.getItems().add(new MenuItem(Season.getTeams().get(x).getTeamName()));

        }
    }

    @FXML
    void addTeamHandle(ActionEvent event) {

        if (!addTeamTextField.getText().isEmpty() && !Season.teamAlreadyExists(addTeamTextField.getText()))
        {

            String temp = addTeamTextField.getText();
            Season.addTeam(new Team(temp));
            updateSelectTeamDropdown();
        }

    }

    @FXML
    void selectTeamHandle(ActionEvent event) {
        System.out.println("Select team pressed");
        selectTeam.show();
        //selectTeam.getItems().

    }

    @FXML
    void generateFixturesHandle(ActionEvent event) {
        Season.generateFixtures();

    }

    @FXML
    void generateTeamStatsHandle(ActionEvent event) {
        Season.generateStats();

    }

    @FXML
    void modifyScoresheetHandle(ActionEvent event) {

    }

    @FXML
    void registerPlayerHandle(ActionEvent event) {

    }

    @FXML
    void showRankingTableHandle(ActionEvent event) {

    }

    @FXML
    void showStatsHandle(ActionEvent event) {
        Season.displayTeamStats();
        Season.displayFixtures();
        viewingTable.getColumns().clear();


        TableColumn<FixtureAndResult, String> teamName = new TableColumn<>("Team Name");
        teamName.setCellValueFactory(new PropertyValueFactory<>("teamName"));

        viewingTable.setItems(getStats());
        viewingTable.getColumns().addAll(teamName);
    }

    @FXML
    void viewFixturesResultsHandle(ActionEvent event) {
        Season.displayFixtures();
        viewingTable.getColumns().clear();


        TableColumn<FixtureAndResult, String> homeTeam = new TableColumn<>("Home Team");
        //homeTeam.setMinWidth(100);
        homeTeam.setCellValueFactory(new PropertyValueFactory<>("homeTeam"));

        TableColumn<FixtureAndResult, String> awayTeam = new TableColumn<>("Away Team");
        //awayTeam.setMinWidth(100);
        awayTeam.setCellValueFactory(new PropertyValueFactory<>("awayTeam"));

        TableColumn<FixtureAndResult, String> vs = new TableColumn<>("VS");
        //vs.setMinWidth(25);
        vs.setCellValueFactory(new PropertyValueFactory<>("vs"));


        TableColumn<FixtureAndResult, Integer> homeTeamSets = new TableColumn<>("Home Team Sets");
        //homeTeamSets.setMinWidth(100);
        homeTeamSets.setCellValueFactory(new PropertyValueFactory<>("homeTeamSets"));

        TableColumn<FixtureAndResult, Integer> awayTeamSets = new TableColumn<>("Away Team Sets");
        //awayTeamSets.setMinWidth(100);
        awayTeamSets.setCellValueFactory(new PropertyValueFactory<>("awayTeamSets"));

        viewingTable.setItems(getFixtures());
        viewingTable.getColumns().addAll(homeTeam, vs, awayTeam, homeTeamSets, awayTeamSets);

    }

    public ObservableList<FixtureAndResult> getFixtures(){
        ObservableList<FixtureAndResult> fixtureAndResults = FXCollections.observableArrayList();
        for (int x = 0; x < Season.getFixtures().size(); x++)
        {
            fixtureAndResults.add(new FixtureAndResult(Season.getFixtures().get(x).getTeamHome().getTeamName(), Season.getFixtures().get(x).getTeamAway().getTeamName(), Season.getFixtures().get(x).getScoreHome(), Season.getFixtures().get(x).getScoreAway()));
        }

        return fixtureAndResults;
    }

    public ObservableList<FixtureAndResult> getStats(){
        ObservableList<FixtureAndResult> fixtureAndResults = FXCollections.observableArrayList();
        for (int x = 0; x < Season.getTeams().size(); x++)
        {
            fixtureAndResults.add(new FixtureAndResult(Season.getTeams().get(x).getTeamName(), Season.getTeams().get(x).getMatchesPlayed(), Season.getTeams().get(x).getMatchesWon(),Season.getTeams().get(x).getMatchesLost(),Season.getTeams().get(x).getSetsPlayed(),Season.getTeams().get(x).getSetsWon(),Season.getTeams().get(x).getSetsLost(),Season.getTeams().get(x).getGamesPlayed(),Season.getTeams().get(x).getGamesWon(),Season.getTeams().get(x).getGamesLost()));
        }

        return fixtureAndResults;
    }



    @FXML
    void viewMatchScoresHandle(ActionEvent event) {

    }

}



