package deliverable4_ser322;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import javax.lang.model.util.ElementScanner14;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Table<T> extends TableView {

    private TableView<T> table = new TableView<>();

    public Table(ObservableList<T> data, String tableName, VBox vbox, TableType tableType){

        final Label label = new Label(tableName);
        label.setFont(new Font("Arial", 16));

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        TextField textField = new TextField();
        FilteredList<T> flAthlete = new FilteredList<>(data, p -> true);

        table.setItems(flAthlete);
        addColumns(table, tableType);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.prefWidthProperty().bind(vbox.widthProperty().multiply(0.96));
        table.prefHeightProperty().bind(vbox.heightProperty().multiply(0.86));
        table.setEditable(true);
        
        createSearchBar(textField, choiceBox, flAthlete, tableType);
        HBox hBox = new HBox(choiceBox, textField);
        hBox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hBox);
    }

    private void createSearchBar(TextField textField, ChoiceBox<String> choiceBox, FilteredList<T> flAthlete, TableType tType){

        choiceBox.getItems().addAll(tType.colNames());
        choiceBox.setValue(tType.colNames().get(0));
        textField.setPromptText("Search...");
        textField.textProperty().addListener((obs, oldValue, newValue) -> {
            String cbv = choiceBox.getValue();
            String methodName = "get" + cbv.substring(0,1).toUpperCase() + cbv.substring(1);

            flAthlete.setPredicate(p -> {
                try {
                    Method method = tType.objClass().getMethod(methodName);
                    if(method.invoke(p).getClass().equals(String.class));
                        return (method.invoke(p).toString()).toLowerCase().contains(newValue.toLowerCase().trim());
                    
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                return false;
            });
        });
    
        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)
                -> {
            if (newVal != null) {
                textField.setText("");
            }
        });
    }

    private void addColumns(TableView<T> tableView, TableType tType){

        for(String str: tType.colNames()){
            tableView.getColumns().add(setColumn(str, str, 100));
        }
    }

    private TableColumn<T, String> setColumn(String colName, String colValue, int minWidth){

        TableColumn<T, String> tableColumn = new TableColumn<>(colName);
        tableColumn.setMinWidth(minWidth);
        tableColumn.setCellValueFactory(new PropertyValueFactory<T, String>(colValue));
            
        return tableColumn;
    } 
}
