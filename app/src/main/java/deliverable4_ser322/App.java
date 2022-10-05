
package deliverable4_ser322;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application
{
    VBox vbox = new VBox();
    static TabView tabs = new TabView();
    static Stage stage;
    static Queries qbox = new Queries();

    static{ 
        testDatabaseConnection();
    }

    @Override
    public void start(Stage stage) throws SQLException
    {
        App.stage = stage;
        Scene scene = new Scene(new Group());
        scene.getStylesheets().add("ContextMenu.css");

        stage.setTitle("Table View Sample");
        stage.setWidth(700);
        stage.setHeight(750);

        qbox.addQueries();
       
        /*ObservableList<Object> athleteData = GenericRM.getAllFromTable("athlete", TableType.ATHLETE);
        ObservableList<Object> compData = GenericRM.getAllFromTable("competition", TableType.COMPETITION);
        ObservableList<Object> orgData = GenericRM.getAllFromTable("organization", TableType.ORGANIZATION);
        ObservableList<Object> sponsorData = GenericRM.getAllFromTable("sponsor", TableType.SPONSOR);
        ObservableList<Object> compSponsorData = GenericRM.getAllFromTable("competitions_sponsored", TableType.COMPETITIONS_SPONSORED);
        ObservableList<Object> athStatData = GenericRM.getAllFromTable("athlete_stats", TableType.ATHLETE_STATS);
        tabs.addTableTab("Athlete", athleteData, TableType.ATHLETE, stage);
        tabs.addTableTab("Competition", compData, TableType.COMPETITION, stage);
        tabs.addTableTab("Organization", orgData, TableType.ORGANIZATION, stage);
        tabs.addTableTab("Sponsor", sponsorData, TableType.SPONSOR, stage);
        tabs.addTableTab("Competitions_Sponsored", compSponsorData, TableType.COMPETITIONS_SPONSORED, stage);
        tabs.addTableTab("Athlete_Stats", athStatData, TableType.ATHLETE_STATS, stage);*/

        vbox.getChildren().add(tabs.createContent());
        vbox.getChildren().add(qbox.getQbox());
        vbox.prefWidthProperty().bind(stage.widthProperty().multiply(0.96));
        vbox.autosize();
        
        ((Group) scene.getRoot()).getChildren().add(vbox);
        stage.setScene(scene);
        stage.show();
    }

    private static void testDatabaseConnection(){

        String url = "jdbc:mysql://ser322.mysql.database.azure.com:3306/league?useSSL=true";
        String username = "group_admin";
        String password = "1goodPassword";

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Connection failed!", e);
        }
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
