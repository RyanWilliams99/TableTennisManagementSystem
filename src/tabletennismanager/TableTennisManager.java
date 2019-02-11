package tabletennismanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;

public class TableTennisManager extends Application {

    public static void main(String[] args) throws IOException {
        Season testSeason = new Season();
        //testSeason.loadTestData();

        Team A = new Team();
        Team B = new Team();
        Team C = new Team();

        A.setTeamName("A");
        B.setTeamName("B");
        C.setTeamName("C");

        testSeason.addTeam(A);
        testSeason.addTeam(B);
        testSeason.addTeam(C);

        testSeason.generateFixtures();
        testSeason.displayFixtures();
        testSeason.generateStats();
        testSeason.displayTeamStats();
        testSeason.displayAMatch(testSeason.fixtures.get(0));
        //launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
