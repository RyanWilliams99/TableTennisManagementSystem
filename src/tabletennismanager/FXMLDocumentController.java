package tabletennismanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
    void addTeamHandle(ActionEvent event) {
        System.out.println("AddTeamPressed");
        String temp = addTeamTextField.getText();
        new Team(temp);
    }

    @FXML
    void selectTeamHandle(ActionEvent event) {
        new MenuItem();
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

    }

    @FXML
    void viewFixturesResultsHandle(ActionEvent event) {

    }

    @FXML
    void viewMatchScoresHandle(ActionEvent event) {

    }

}