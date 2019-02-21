package tabletennismanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

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

        System.out.println("AddTeamPressed");
        String temp = addTeamTextField.getText();
        Season.addTeam(new Team(temp));
        updateSelectTeamDropdown();
    }

    @FXML
    void selectTeamHandle(ActionEvent event) {


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

    }

    @FXML
    void viewFixturesResultsHandle(ActionEvent event) {
        Season.displayFixtures();
        viewingTable.getColumns().clear();


        TableColumn<FixtureAndResult, String> homeTeam = new TableColumn<>("Home Team");
        homeTeam.setMinWidth(200);
        homeTeam.setCellValueFactory(new PropertyValueFactory<>("homeTeam"));

        TableColumn<FixtureAndResult, String> awayTeam = new TableColumn<>("Away Team");
        awayTeam.setMinWidth(200);
        awayTeam.setCellValueFactory(new PropertyValueFactory<>("awayTeam"));

        //Price column
        TableColumn<FixtureAndResult, Integer> homeTeamSets = new TableColumn<>("Home Team Sets");
        homeTeamSets.setMinWidth(100);
        homeTeamSets.setCellValueFactory(new PropertyValueFactory<>("homeTeamSets"));

        //Quantity column
        TableColumn<FixtureAndResult, Integer> awayTeamSets = new TableColumn<>("Away Team Sets");
        awayTeamSets.setMinWidth(100);
        awayTeamSets.setCellValueFactory(new PropertyValueFactory<>("awayTeamSets"));

        viewingTable.setItems(getProduct());
        viewingTable.getColumns().addAll(homeTeam, awayTeam, homeTeamSets, awayTeamSets);

    }

    //Get all of the products
    public ObservableList<FixtureAndResult> getProduct(){
        ObservableList<FixtureAndResult> fixtureAndResults = FXCollections.observableArrayList();
        for (int x = 0; x < Season.getFixtures().size(); x++)
        {
            fixtureAndResults.add(new FixtureAndResult(Season.getFixtures().get(x).getTeamHome().getTeamName(), Season.getFixtures().get(x).getTeamAway().getTeamName(), Season.getFixtures().get(x).getScoreHome(), Season.getFixtures().get(x).getScoreAway()));
        }

        return fixtureAndResults;
    }

    @FXML
    void viewMatchScoresHandle(ActionEvent event) {

    }

}