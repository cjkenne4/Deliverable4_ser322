
package deliverable4_ser322;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** 
 * Application main class for launching the application
*/
public class App extends Application
{
    VBox vbox = new VBox();
    static TabView tabs;
    static Stage stage;
    static Queries qbox;

    static{ 
        testDatabaseConnection();
    }

    @Override
    public void start(Stage stage) throws SQLException
    {
        App.stage = stage;
        tabs = new TabView();
        qbox = new Queries();
        Scene scene = new Scene(new Group());
        scene.getStylesheets().add("ContextMenu.css");

        stage.setTitle("Table View Sample");
        stage.setWidth(700);
        stage.setHeight(750);

        qbox.addQueries();

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
