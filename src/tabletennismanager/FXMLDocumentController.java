package tabletennismanager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLDocumentController {

    @FXML private TextField addTeamTextField;
    @FXML private TextField playerNameTextField;
    @FXML private MenuButton selectTeam;
    @FXML private TableView<FixtureAndResult> viewingTable;
    @FXML private MenuButton homeTeam;
    @FXML private MenuButton awayTeam;
    @FXML private MenuButton awayPlayer0;
    @FXML private MenuButton awayPlayer1;
    @FXML private MenuButton homePlayer1;
    @FXML private MenuButton homePlayer0;
    @FXML private MenuButton set0game0h;
    @FXML private MenuButton set0game0a;
    @FXML private MenuButton set0game1h;
    @FXML private MenuButton set0game1a;
    @FXML private MenuButton set0game2h;
    @FXML private MenuButton set0game2a;
    @FXML private MenuButton set1game0h;
    @FXML private MenuButton set1game0a;
    @FXML private MenuButton set1game1h;
    @FXML private MenuButton set1game1a;
    @FXML private MenuButton set1game2h;
    @FXML private MenuButton set1game2a;
    @FXML private MenuButton set2game0h;
    @FXML private MenuButton set2game0a;
    @FXML private MenuButton set2game1h;
    @FXML private MenuButton set2game1a;
    @FXML private MenuButton set2game2h;
    @FXML private MenuButton set2game2a;
    @FXML private MenuButton set3game0h;
    @FXML private MenuButton set3game0a;
    @FXML private MenuButton set3game1h;
    @FXML private MenuButton set3game1a;
    @FXML private MenuButton set3game2h;
    @FXML private MenuButton set3game2a;
    @FXML private MenuButton set4game0h;
    @FXML private MenuButton set4game0a;
    @FXML private MenuButton set4game1h;
    @FXML private MenuButton set4game1a;
    @FXML private MenuButton set4game2h;
    @FXML private MenuButton set4game2a;
    @FXML private MenuButton selectTeamViewMatch0;
    @FXML private MenuButton selectTeamViewMatch1;

    Season Season = new Season();

    @FXML public void initialize() { //Called as GUI starts
        Season.addTestData();
        updateHomeTeamAwayTeamDropdown();
        updateSelectTeamDropdown();
        menuButtonSetSelected();
        Season.autoUpdateStats();
    }

    public void updateUI() //Used by multiple functions to "refresh gui"
    {
        updateHomeTeamAwayTeamDropdown();
        updateSelectTeamDropdown();
    }

    @FXML void addTestData(ActionEvent event) {
        Season.addTestData();
    }

    public void updateSelectTeamDropdown() //Dynamically changes what teams a user can select once they add a new team
    {
        selectTeam.getItems().clear();
        for (int x = 0; x < Season.getTeams().size(); x++)
        {
            selectTeam.getItems().add(new MenuItem(Season.getTeams().get(x).getTeamName()));
        }
        setDropdownMenus(selectTeam);
        selectTeamViewMatch0.getItems().clear();
        for (int x = 0; x < Season.getTeams().size(); x++)
        {
            selectTeamViewMatch0.getItems().add(new MenuItem(Season.getTeams().get(x).getTeamName()));
        }
        setDropdownMenus(selectTeamViewMatch0);

        selectTeamViewMatch1.getItems().clear();
        for (int x = 0; x < Season.getTeams().size(); x++)
        {
            selectTeamViewMatch1.getItems().add(new MenuItem(Season.getTeams().get(x).getTeamName()));
        }
        setDropdownMenus(selectTeamViewMatch1);
    }

    @FXML void addTeamHandle(ActionEvent event) { //Makes a new team and passes to Season.addTeam
        if (addTeamTextField.getText().isEmpty())
        {
            Alert noNameAlert = new Alert(Alert.AlertType.ERROR, "Must enter Team name",  ButtonType.OK);
            noNameAlert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to add a new team called: " + addTeamTextField.getText(), ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES)
            {
                if (!addTeamTextField.getText().isEmpty() && !Season.teamAlreadyExists(addTeamTextField.getText()))
                {
                    String temp = addTeamTextField.getText();
                    Season.addTeam(new Team(temp));
                    updateSelectTeamDropdown();
                }
            }
        }
    }

    @FXML void generateFixturesHandle(ActionEvent event) { //
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to generate new fixtures, all past match data will be removed", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            Season.generateFixtures();
        }
    }

    @FXML void generateTeamStatsHandle(ActionEvent event) {
        Season.generateStats();
    }

    @FXML void registerPlayerHandle(ActionEvent event) {
        if (selectTeam.getText().equals("Select Team") || playerNameTextField.getText().isEmpty())
        {
            Alert noNameAlert = new Alert(Alert.AlertType.ERROR, "Please Enter a player name and select a team",  ButtonType.OK);
            noNameAlert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to a player: " + playerNameTextField.getText() + " to Team: " + selectTeam.getText(), ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES)
            {
                for(int x = 0; x < Season.getTeams().size(); x++)
                {
                    if (Season.getTeams().get(x).getTeamName().equals(selectTeam.getText()))
                    {
                        Season.getTeams().get(x).addPlayer(new Player(playerNameTextField.getText()));
                    }
                }
            }
        }
        updateUI();
    }

    @FXML void showRankingTableHandle(ActionEvent event) {
        viewingTable.getColumns().clear();
        Season.calculateScores();
        Season.generateStats();

        TableColumn<FixtureAndResult, Integer> position = new TableColumn<>("Position");
        position.setCellValueFactory(new PropertyValueFactory<>("position"));

        TableColumn<FixtureAndResult, String> teamName = new TableColumn<>("Team Name");
        teamName.setCellValueFactory(new PropertyValueFactory<>("teamName"));

        TableColumn<FixtureAndResult, String> matchesPlayed = new TableColumn<>("Played");
        matchesPlayed.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));

        TableColumn<FixtureAndResult, String> matchesWon = new TableColumn<>("Won");
        matchesWon.setCellValueFactory(new PropertyValueFactory<>("matchesWon"));
        matchesWon.setMinWidth(70);
        matchesWon.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn<FixtureAndResult, String> matchesLost = new TableColumn<>("Lost");
        matchesLost.setCellValueFactory(new PropertyValueFactory<>("matchesLost"));

        viewingTable.setItems(getStats());
        viewingTable.getColumns().addAll(position, teamName, matchesPlayed, matchesWon);
        viewingTable.getSortOrder().add(matchesWon);
    }

    @FXML void showStatsHandle(ActionEvent event) {
        viewingTable.getColumns().clear();
        Season.calculateScores();
        Season.generateStats();

        TableColumn<FixtureAndResult, String> teamName = new TableColumn<>("Team Name");
        teamName.setCellValueFactory(new PropertyValueFactory<>("teamName"));

        TableColumn<FixtureAndResult, String> matchesPlayed = new TableColumn<>("Matches Played");
        matchesPlayed.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));

        TableColumn<FixtureAndResult, String> matchesWon = new TableColumn<>("Matches Won");
        matchesWon.setCellValueFactory(new PropertyValueFactory<>("matchesWon"));

        TableColumn<FixtureAndResult, String> setsWon = new TableColumn<>("Sets Won");
        setsWon.setCellValueFactory(new PropertyValueFactory<>("setsWon"));

        viewingTable.setItems(getStats());
        viewingTable.getColumns().addAll(teamName, matchesPlayed, matchesWon, setsWon);
    }

    @FXML void viewFixturesResultsHandle(ActionEvent event) {
        Season.displayFixtures();
        Season.calculateScores();
        viewingTable.getColumns().clear();


        TableColumn<FixtureAndResult, String> homeTeam = new TableColumn<>("Home Team");
        homeTeam.setCellValueFactory(new PropertyValueFactory<>("homeTeam"));

        TableColumn<FixtureAndResult, String> awayTeam = new TableColumn<>("Away Team");
        awayTeam.setCellValueFactory(new PropertyValueFactory<>("awayTeam"));

        TableColumn<FixtureAndResult, String> vs = new TableColumn<>("VS");
        vs.setCellValueFactory(new PropertyValueFactory<>("vs"));


        TableColumn<FixtureAndResult, Integer> homeTeamSets = new TableColumn<>("Home Team Sets");
        homeTeamSets.setCellValueFactory(new PropertyValueFactory<>("homeTeamSets"));

        TableColumn<FixtureAndResult, Integer> awayTeamSets = new TableColumn<>("Away Team Sets");
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
            int y = x + 1;
            fixtureAndResults.add(new FixtureAndResult(y,Season.getTeams().get(x).getTeamName(), Season.getTeams().get(x).getMatchesPlayed(), Season.getTeams().get(x).getMatchesWon(),Season.getTeams().get(x).getMatchesLost(),Season.getTeams().get(x).getSetsPlayed(),Season.getTeams().get(x).getSetsWon(),Season.getTeams().get(x).getSetsLost(),Season.getTeams().get(x).getGamesPlayed(),Season.getTeams().get(x).getGamesWon(),Season.getTeams().get(x).getGamesLost()));
        }

        return fixtureAndResults;
    }

    @FXML void viewMatchScoresHandle(ActionEvent event) {
        boolean foundMatch = false;
        if (selectTeamViewMatch0.getText().equals(selectTeamViewMatch1.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select two different teams",  ButtonType.OK);
            alert.showAndWait();
        }
        else
        {
            for (int y = 0; y < Season.getFixtures().size();y++)
            {
                if (Season.getFixtures().get(y).getTeamHome().getTeamName().equals(selectTeamViewMatch0.getText()) && Season.getFixtures().get(y).getTeamAway().getTeamName().equals(selectTeamViewMatch1.getText()) && Season.fixtures.get(y).isMatchPlayed())
                {
                    foundMatch = true;
                    Alert viewMatch = new Alert(Alert.AlertType.INFORMATION,
                            "Match: " + Season.getFixtures().get(y).getTeamHome().getTeamName()
                            + " vs " + Season.getFixtures().get(y).getTeamAway().getTeamName()
                            +"\nSet: "+ Season.getFixtures().get(y).getTeamHome().getPlayers().get(0).getPlayerName()
                            +" vs "+ Season.getFixtures().get(y).getTeamAway().getPlayers().get(0).getPlayerName()
                            + " " + Season.getFixtures().get(y).sets.get(0).games.get(0).getHomeScore()
                            + ":" + Season.getFixtures().get(y).sets.get(0).games.get(0).getAwayScore()
                            + " " + Season.getFixtures().get(y).sets.get(0).games.get(1).getHomeScore()
                            + ":" + Season.getFixtures().get(y).sets.get(0).games.get(1).getAwayScore()
                            + " " + Season.getFixtures().get(y).sets.get(0).games.get(2).getHomeScore()
                            + ":" + Season.getFixtures().get(y).sets.get(0).games.get(2).getAwayScore()

                                    +"\nSet: "+ Season.getFixtures().get(y).getTeamHome().getPlayers().get(0).getPlayerName()
                                    +" vs "+ Season.getFixtures().get(y).getTeamAway().getPlayers().get(1).getPlayerName()
                                    + " " + Season.getFixtures().get(y).sets.get(1).games.get(0).getHomeScore()
                                    + ":" + Season.getFixtures().get(y).sets.get(1).games.get(0).getAwayScore()
                                    + " " + Season.getFixtures().get(y).sets.get(1).games.get(1).getHomeScore()
                                    + ":" + Season.getFixtures().get(y).sets.get(1).games.get(1).getAwayScore()
                                    + " " + Season.getFixtures().get(y).sets.get(1).games.get(2).getHomeScore()
                                    + ":" + Season.getFixtures().get(y).sets.get(1).games.get(2).getAwayScore()

                                    +"\nSet: "+ Season.getFixtures().get(y).getTeamHome().getPlayers().get(1).getPlayerName()
                                    +" vs "+ Season.getFixtures().get(y).getTeamAway().getPlayers().get(0).getPlayerName()
                                    + " " + Season.getFixtures().get(y).sets.get(2).games.get(0).getHomeScore()
                                    + ":" + Season.getFixtures().get(y).sets.get(2).games.get(0).getAwayScore()
                                    + " " + Season.getFixtures().get(y).sets.get(2).games.get(1).getHomeScore()
                                    + ":" + Season.getFixtures().get(y).sets.get(2).games.get(1).getAwayScore()
                                    + " " + Season.getFixtures().get(y).sets.get(2).games.get(2).getHomeScore()
                                    + ":" + Season.getFixtures().get(y).sets.get(2).games.get(2).getAwayScore()

                                    +"\nSet: "+ Season.getFixtures().get(y).getTeamHome().getPlayers().get(1).getPlayerName()
                                    +" vs "+ Season.getFixtures().get(y).getTeamAway().getPlayers().get(1).getPlayerName()
                                    + " " + Season.getFixtures().get(y).sets.get(3).games.get(0).getHomeScore()
                                    + ":" + Season.getFixtures().get(y).sets.get(3).games.get(0).getAwayScore()
                                    + " " + Season.getFixtures().get(y).sets.get(3).games.get(1).getHomeScore()
                                    + ":" + Season.getFixtures().get(y).sets.get(3).games.get(1).getAwayScore()
                                    + " " + Season.getFixtures().get(y).sets.get(3).games.get(2).getHomeScore()
                                    + ":" + Season.getFixtures().get(y).sets.get(3).games.get(2).getAwayScore()

                                    +"\nSet: NULL vs NULL"
                                    + " " + Season.getFixtures().get(y).sets.get(4).games.get(0).getHomeScore()
                                    + ":" + Season.getFixtures().get(y).sets.get(4).games.get(0).getAwayScore()
                                    + " " + Season.getFixtures().get(y).sets.get(4).games.get(1).getHomeScore()
                                    + ":" + Season.getFixtures().get(y).sets.get(4).games.get(1).getAwayScore()
                                    + " " + Season.getFixtures().get(y).sets.get(4).games.get(2).getHomeScore()
                                    + ":" + Season.getFixtures().get(y).sets.get(4).games.get(2).getAwayScore()


                            ,  ButtonType.OK);
                    viewMatch.setTitle("Match: " + Season.getFixtures().get(y).getTeamHome().getTeamName()
                            + " vs " + Season.getFixtures().get(y).getTeamAway().getTeamName());
                    viewMatch.setHeaderText(null);
                    viewMatch.showAndWait();
                }
            }
        }
        if (!foundMatch)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Match between selected teams is not played", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void updateHomeTeamAwayTeamDropdown()
    {
        homeTeam.getItems().clear();
        awayTeam.getItems().clear();
        for (int x = 0; x < Season.getTeams().size(); x++)
        {
            homeTeam.getItems().add(new MenuItem(Season.getTeams().get(x).getTeamName()));
            awayTeam.getItems().add(new MenuItem(Season.getTeams().get(x).getTeamName()));

        }
        setDropdownMenus(homeTeam);
        setDropdownMenus(awayTeam);
    }

    @FXML void updatePlayersHandle(ActionEvent event) {
        homePlayer0.getItems().clear();
        homePlayer1.getItems().clear();
        awayPlayer0.getItems().clear();
        awayPlayer1.getItems().clear();

        if (homeTeam.getText().equals(awayTeam.getText()))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select two different teams",  ButtonType.OK);
            alert.showAndWait();
        }

        for (int x = 0; x < Season.getTeams().size(); x++)
        {
            if (homeTeam.getText().equals(Season.getTeams().get(x).getTeamName()))
            {
                for (int y = 0; y < Season.getTeams().get(x).getPlayers().size(); y++)
                {
                    homePlayer0.getItems().add(new MenuItem(Season.getTeams().get(x).getPlayers().get(y).getPlayerName()));
                    homePlayer1.getItems().add(new MenuItem(Season.getTeams().get(x).getPlayers().get(y).getPlayerName()));
                }
            }
            if (awayTeam.getText().equals(Season.getTeams().get(x).getTeamName()))
            {
                for (int y = 0; y < Season.getTeams().get(x).getPlayers().size(); y++)
                {
                    awayPlayer0.getItems().add(new MenuItem(Season.getTeams().get(x).getPlayers().get(y).getPlayerName()));
                    awayPlayer1.getItems().add(new MenuItem(Season.getTeams().get(x).getPlayers().get(y).getPlayerName()));
                }
            }
        }
        setDropdownMenus(homePlayer0);
        setDropdownMenus(homePlayer1);
        setDropdownMenus(awayPlayer0);
        setDropdownMenus(awayPlayer1);

    }
    public void setDropdownMenus(MenuButton passedButton)
    {
        for (MenuItem item : passedButton.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent event) {
                    passedButton.setText(MenuItem.getText());
                }}); }
    }

    //Getting the choice for combobox
    private void menuButtonSetSelected()
    {
        setDropdownMenus(set0game0h);
        setDropdownMenus(set0game0a);
        setDropdownMenus(set0game1h);
        setDropdownMenus(set0game1a);
        setDropdownMenus(set0game2h);
        setDropdownMenus(set0game2a);

        setDropdownMenus(set1game0h);
        setDropdownMenus(set1game0a);
        setDropdownMenus(set1game1h);
        setDropdownMenus(set1game1a);
        setDropdownMenus(set1game2h);
        setDropdownMenus(set1game2a);

        setDropdownMenus(set2game0h);
        setDropdownMenus(set2game0a);
        setDropdownMenus(set2game1h);
        setDropdownMenus(set2game1a);
        setDropdownMenus(set2game2h);
        setDropdownMenus(set2game2a);

        setDropdownMenus(set3game0h);
        setDropdownMenus(set3game0a);
        setDropdownMenus(set3game1h);
        setDropdownMenus(set3game1a);
        setDropdownMenus(set3game2h);
        setDropdownMenus(set3game2a);

        setDropdownMenus(set4game0h);
        setDropdownMenus(set4game0a);
        setDropdownMenus(set4game1h);
        setDropdownMenus(set4game1a);
        setDropdownMenus(set4game2h);
        setDropdownMenus(set4game2a);
    }

    //Takes Information from score sheet and updates the set data
    @FXML void calculateAndSubmitScoresHandle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to submit this scoresheet (You can edit it at any time)", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            for (int x = 0; x < Season.getFixtures().size(); x++) {
                if (homeTeam.getText().equals(Season.getFixtures().get(x).getTeamHome().getTeamName()) && awayTeam.getText().equals(Season.getFixtures().get(x).getTeamAway().getTeamName())) {
                    Season.getFixtures().get(x).sets.get(0).addSetScoresAndPlayers(Integer.parseInt(set0game0h.getText()), Integer.parseInt(set0game0a.getText()), Integer.parseInt(set0game1h.getText()), Integer.parseInt(set0game1a.getText()), Integer.parseInt(set0game2h.getText()), Integer.parseInt(set0game2a.getText()));
                    Season.getFixtures().get(x).sets.get(1).addSetScoresAndPlayers(Integer.parseInt(set1game0h.getText()), Integer.parseInt(set1game0a.getText()), Integer.parseInt(set1game1h.getText()), Integer.parseInt(set1game1a.getText()), Integer.parseInt(set1game2h.getText()), Integer.parseInt(set1game2a.getText()));
                    Season.getFixtures().get(x).sets.get(2).addSetScoresAndPlayers(Integer.parseInt(set2game0h.getText()), Integer.parseInt(set2game0a.getText()), Integer.parseInt(set2game1h.getText()), Integer.parseInt(set2game1a.getText()), Integer.parseInt(set2game2h.getText()), Integer.parseInt(set2game2a.getText()));
                    Season.getFixtures().get(x).sets.get(3).addSetScoresAndPlayers(Integer.parseInt(set3game0h.getText()), Integer.parseInt(set3game0a.getText()), Integer.parseInt(set3game1h.getText()), Integer.parseInt(set3game1a.getText()), Integer.parseInt(set3game2h.getText()), Integer.parseInt(set3game2a.getText()));
                    Season.getFixtures().get(x).sets.get(4).addSetScoresAndPlayers(Integer.parseInt(set4game0h.getText()), Integer.parseInt(set4game0a.getText()), Integer.parseInt(set4game1h.getText()), Integer.parseInt(set4game1a.getText()), Integer.parseInt(set4game2h.getText()), Integer.parseInt(set4game2a.getText()));
                    Season.getFixtures().get(x).setMatchPlayed(true);
                    Season.calculateScores();
                }
            }
        }
    }
}