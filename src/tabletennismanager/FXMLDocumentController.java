package tabletennismanager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

import java.util.ArrayList;


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
    private TableView<FixtureAndResult> viewingTable;

    @FXML
    private AnchorPane viewerPage;

    @FXML
    private AnchorPane scoresheet;

    @FXML
    private MenuButton homeTeam;

    @FXML
    private MenuButton awayTeam;

    @FXML
    private MenuButton awayPlayer0;

    @FXML
    private MenuButton awayPlayer1;

    @FXML
    private MenuButton homePlayer1;

    @FXML
    private MenuButton homePlayer0;

    @FXML
    private Button calculateAndSubmitScores;

    @FXML
    private MenuButton set0game0h;

    @FXML
    private MenuButton set0game0a;

    @FXML
    private MenuButton set0game1h;

    @FXML
    private MenuButton set0game1a;

    @FXML
    private MenuButton set0game2h;

    @FXML
    private MenuButton set0game2a;

    @FXML
    private MenuButton set1game0h;

    @FXML
    private MenuButton set1game0a;

    @FXML
    private MenuButton set1game1h;

    @FXML
    private MenuButton set1game1a;

    @FXML
    private MenuButton set1game2h;

    @FXML
    private MenuButton set1game2a;

    @FXML
    private MenuButton set2game0h;

    @FXML
    private MenuButton set2game0a;

    @FXML
    private MenuButton set2game1h;

    @FXML
    private MenuButton set2game1a;

    @FXML
    private MenuButton set2game2h;

    @FXML
    private MenuButton set2game2a;

    @FXML
    private MenuButton set3game0h;

    @FXML
    private MenuButton set3game0a;

    @FXML
    private MenuButton set3game1h;

    @FXML
    private MenuButton set3game1a;

    @FXML
    private MenuButton set3game2h;

    @FXML
    private MenuButton set3game2a;

    @FXML
    private MenuButton set4game0h;

    @FXML
    private MenuButton set4game0a;

    @FXML
    private MenuButton set4game1h;

    @FXML
    private MenuButton set4game1a;

    @FXML
    private MenuButton set4game2h;

    @FXML
    private MenuButton set4game2a;

    @FXML
    private Button updatePlayers;

    @FXML
    public void initialize() {

        Season.addTestData();
        updateHomeTeamAwayTeamDropdown();
        updateSelectTeamDropdown();
        setSelectedScore();
        
    }

    public void updateUI()
    {
        updateHomeTeamAwayTeamDropdown();
        updateSelectTeamDropdown();
    }

    public void updateSelectTeamDropdown()
    {
        selectTeam.getItems().clear();
        for (int x = 0; x < Season.getTeams().size(); x++)
        {
            selectTeam.getItems().add(new MenuItem(Season.getTeams().get(x).getTeamName()));

        }
        for(MenuItem item : selectTeam.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    selectTeam.setText(MenuItem.getText());
                }
            });
        }
    }

    @FXML
    void addTeamHandle(ActionEvent event) {

        if (addTeamTextField.getText().isEmpty())
        {
            Alert noNameAlert = new Alert(Alert.AlertType.ERROR, "Must enter Team name",  ButtonType.OK);
            noNameAlert.showAndWait();
        }
        else
        {
            if (!addTeamTextField.getText().isEmpty() && !Season.teamAlreadyExists(addTeamTextField.getText()))
            {
                String temp = addTeamTextField.getText();
                Season.addTeam(new Team(temp));
                updateSelectTeamDropdown();
            }
        }
    }

    @FXML
    void selectTeamHandle(ActionEvent event) {
        System.out.println("Select team pressed");

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
        System.out.println("Register player");
        System.out.println("Adding player " + playerNameTextField.getText() + " to team:" + selectTeam.getText());
        if(!playerNameTextField.getText().isEmpty() && !selectTeam.getText().equals("Select Team"))
        {
            for(int x = 0; x < Season.getTeams().size(); x++)
            {
                if (Season.getTeams().get(x).getTeamName().equals(selectTeam.getText()))
                {
                    System.out.println("Adding player");
                    Season.getTeams().get(x).addPlayer(new Player(playerNameTextField.getText()));
                }
            }
        }
        updateUI();
    }

    @FXML
    void showRankingTableHandle(ActionEvent event) {

        viewingTable.getColumns().clear();

        TableColumn<FixtureAndResult, String> teamName = new TableColumn<>("Team Name");
        teamName.setCellValueFactory(new PropertyValueFactory<>("teamName"));

        TableColumn<FixtureAndResult, String> matchesPlayed = new TableColumn<>("Played");
        matchesPlayed.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));

        TableColumn<FixtureAndResult, String> matchesWon = new TableColumn<>("Won");
        matchesWon.setCellValueFactory(new PropertyValueFactory<>("matchesWon"));
        matchesWon.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn<FixtureAndResult, String> matchesLost = new TableColumn<>("Lost");
        matchesLost.setCellValueFactory(new PropertyValueFactory<>("matchesLost"));


        viewingTable.setItems(getStats());
        viewingTable.getColumns().addAll(teamName, matchesPlayed, matchesWon);
        viewingTable.getSortOrder().add(matchesWon);
    }

    @FXML
    void showStatsHandle(ActionEvent event) {
        viewingTable.getColumns().clear();
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



    public void updateHomeTeamAwayTeamDropdown()
    {
        homeTeam.getItems().clear();
        awayTeam.getItems().clear();
        for (int x = 0; x < Season.getTeams().size(); x++)
        {
            homeTeam.getItems().add(new MenuItem(Season.getTeams().get(x).getTeamName()));
            awayTeam.getItems().add(new MenuItem(Season.getTeams().get(x).getTeamName()));

        }
        for(MenuItem item : homeTeam.getItems())
        {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event) {
                    homeTeam.setText(MenuItem.getText());
                }
            });
        }
        for(MenuItem item : awayTeam.getItems())
        {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event) {
                    awayTeam.setText(MenuItem.getText());
                }
            });
        }
    }


    @FXML
    void updatePlayersHandle(ActionEvent event) {
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
        for(MenuItem item : homePlayer0.getItems())
        {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event) {
                    homePlayer0.setText(MenuItem.getText());
                }
            });
        }
        for(MenuItem item : homePlayer1.getItems())
        {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event) {
                    homePlayer1.setText(MenuItem.getText());
                }
            });
        }
        for(MenuItem item : awayPlayer0.getItems())
        {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event) {
                    awayPlayer0.setText(MenuItem.getText());
                }
            });
        }
        for(MenuItem item : awayPlayer1.getItems())
        {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event) {
                    awayPlayer1.setText(MenuItem.getText());
                }
            });
        }

    }

    void setSelectedScore()
    {
        for (MenuItem item : set0game0h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set0game0h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set0game0a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set0game0a.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set0game1h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set0game1h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set0game1a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set0game1a.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set0game2h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set0game2h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set0game2a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set0game2a.setText(MenuItem.getText());
                }}); }






        for (MenuItem item : set1game0h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set1game0h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set1game0a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set1game0a.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set1game1h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set1game1h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set1game1a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set1game1a.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set1game2h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set1game2h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set1game2a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set1game2a.setText(MenuItem.getText());
                }}); }




        for (MenuItem item : set2game0h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set2game0h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set2game0a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set2game0a.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set2game1h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set2game1h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set2game1a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set2game1a.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set2game2h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set2game2h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set2game2a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set2game2a.setText(MenuItem.getText());
                }}); }



        for (MenuItem item : set3game0h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set3game0h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set3game0a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set3game0a.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set3game1h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set3game1h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set3game1a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set3game1a.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set3game2h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set3game2h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set3game2a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set3game2a.setText(MenuItem.getText());
                }}); }




        for (MenuItem item : set4game0h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set4game0h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set4game0a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set4game0a.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set4game1h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set4game1h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set4game1a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set4game1a.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set4game2h.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set4game2h.setText(MenuItem.getText());
                }}); }
        for (MenuItem item : set4game2a.getItems()) {
            MenuItem MenuItem = (MenuItem) item;
            MenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    set4game2a.setText(MenuItem.getText());
                }}); }

    }

    @FXML
    void calculateAndSubmitScoresHandle(ActionEvent event) {

        for (int x = 0; x < Season.getTeams().size(); x++)
        {
            if (homeTeam.getText().equals(Season.getTeams().get(x).getTeamName()))
            {
                Season.getFixtures().get(x).sets.get(0).addSetScoresAndPlayers(Integer.parseInt(set0game0h.getText()),Integer.parseInt(set0game0a.getText()), Integer.parseInt(set0game1h.getText()), Integer.parseInt(set0game1a.getText()), Integer.parseInt(set0game2h.getText()), Integer.parseInt(set0game2a.getText()));
                Season.getFixtures().get(x).sets.get(1).addSetScoresAndPlayers(Integer.parseInt(set1game0h.getText()),Integer.parseInt(set1game0a.getText()), Integer.parseInt(set1game1h.getText()), Integer.parseInt(set1game1a.getText()), Integer.parseInt(set1game2h.getText()), Integer.parseInt(set1game2a.getText()));
                Season.getFixtures().get(x).sets.get(2).addSetScoresAndPlayers(Integer.parseInt(set2game0h.getText()),Integer.parseInt(set2game0a.getText()), Integer.parseInt(set2game1h.getText()), Integer.parseInt(set2game1a.getText()), Integer.parseInt(set2game2h.getText()), Integer.parseInt(set2game2a.getText()));
                Season.getFixtures().get(x).sets.get(3).addSetScoresAndPlayers(Integer.parseInt(set3game0h.getText()),Integer.parseInt(set3game0a.getText()), Integer.parseInt(set3game1h.getText()), Integer.parseInt(set3game1a.getText()), Integer.parseInt(set3game2h.getText()), Integer.parseInt(set3game2a.getText()));
                Season.getFixtures().get(x).sets.get(4).addSetScoresAndPlayers(Integer.parseInt(set4game0h.getText()),Integer.parseInt(set4game0a.getText()), Integer.parseInt(set4game1h.getText()), Integer.parseInt(set4game1a.getText()), Integer.parseInt(set4game2h.getText()), Integer.parseInt(set4game2a.getText()));
                Season.getFixtures().get(x).setMatchPlayed(true);

            }
        }
    }
}