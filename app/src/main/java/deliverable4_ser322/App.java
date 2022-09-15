
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

    static{ 
        testDatabaseConnection();
    }

    @Override
    public void start(Stage stage) throws SQLException
    {
        ObservableList<Athlete> data = getAllFromTable("athlete");
        Table<Athlete> table = new Table(data, "Statistics", vbox,TableType.ATHLETE);

        Scene scene = new Scene(new Group());
        scene.getStylesheets().add("ContextMenu.css");

        stage.setTitle("Table View Sample");
        stage.setWidth(550);
        stage.setHeight(550);
        
        vbox.prefWidthProperty().bind(stage.widthProperty().multiply(0.96));
        vbox.autosize();

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();
    }

    public static Athlete mapFromResultSet(ResultSet rs)
    {
        Athlete nAthlete  = null;
        try
        {
            String id = rs.getString("athleteID");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String skill = rs.getString("skill");
            String orgID = rs.getString("organizationID");

            nAthlete = new Athlete(id, name, email, skill, orgID);

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return nAthlete;
    }

    public static ObservableList<Athlete> getAllFromTable(String tableName) throws SQLException
    {
        String Query = "select * " + "from " + tableName;

        return GenericRM.getAttributesFromQuery(Query, rs -> mapFromResultSet(rs));
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
