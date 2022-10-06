package deliverable4_ser322;

import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Create Tabs for each TableView
 */
public class TabView {
    
    TabPane root = new TabPane();
    /**
     * Create a new Tab for the given data and TableType
     * @param tableName
     * @param data
     * @param tType
     * @param stage
     */
    public void addTableTab(String tableName, ObservableList<Object> data, TableType tType, Stage stage)
    {
        Tab tableTab = new Tab(tableName);
        VBox vbox = new VBox();
        Table<Object> table = new Table(data, tableName, vbox, tType);
        tableTab.setContent(vbox);
        root.getTabs().add(tableTab);
        vbox.prefWidthProperty().bind(stage.widthProperty().multiply(0.96));
        vbox.prefHeightProperty().bind(stage.heightProperty().multiply(.80));
        vbox.autosize();
    }
    /**
     * Return the root TabPane that contains all the tabs
     * @return
     */
    public TabPane createContent()
    {
        return root;
    }
}
