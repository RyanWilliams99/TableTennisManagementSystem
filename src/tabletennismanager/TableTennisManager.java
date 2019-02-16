package tabletennismanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TableTennisManager extends Application {

    public static void main(String[] args){
        Season testSeason = new Season();
        testSeason.addTestData();


        testSeason.displayFixtures();
        testSeason.calculateScores();
        testSeason.generateStats();
        testSeason.displayTeamStats();
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
