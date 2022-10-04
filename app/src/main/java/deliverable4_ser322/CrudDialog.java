package deliverable4_ser322;

import java.sql.SQLException;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class CrudDialog {

    static Alert alert;
    static Dialog<Result> updateDialog;

    public static void displayDelete(Object selectedRow, TableType tType, TableView table){
        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete");
        Object[] currentVals = tType.getValues(selectedRow);
        String txt = "";
        for(Object o : currentVals) txt += o.toString() + "\n";
        alert.setHeaderText("Are you sure you want to delete this row?");
        alert.setContentText(txt);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            table.getItems().remove(selectedRow);
        } else {
            alert.close();
        }
    }
    public static void displayUpdate(TableType tType, Object selectedRow)
    {
        updateDialog = new Dialog<Result>();
        updateDialog.setTitle("Update");
        updateDialog.setHeaderText("Enter values to update");
        DialogPane dialogPane = updateDialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        VBox vbox = new VBox(8);
        TextField[] textField = new TextField[tType.colNames().size()];
        Object[] currentVals = tType.getValues(selectedRow);
        int id = (int)currentVals[0];

        for(int i = 0; i < tType.colNames().size(); i++){
            textField[i] = new TextField(currentVals[i].toString());
            vbox.getChildren().add(textField[i]);
        }
        dialogPane.setContent(vbox);
        updateDialog.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                Object[] values = new Object[tType.colNames().size()];
                for(int i = 0; i < tType.colNames().size(); i++){
                    values[i] = textField[i].getText();
                }
                return new Result(values);
            }
            return null;
        });
        Optional<Result> optionalResult = updateDialog.showAndWait();
        optionalResult.ifPresent((Result results) -> {
            try {
                Crud.update(id, results.values, tType);
                tType.setRowObject(selectedRow, results.values);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for(Object o : results.values){
                
                System.out.println(o);
            }
        });

    }

    private static class Result{
        Object[] values;

        Result(Object...vals){
            values = new Object[vals.length];
            for(int i = 0; i < values.length; i++){
                values[i] = vals[i];
            }
        }
    }
}
