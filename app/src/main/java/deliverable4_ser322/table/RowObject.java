package deliverable4_ser322.table;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.beans.property.SimpleObjectProperty;

/**
 * Create a RowObject using ResultSetMetaData
 * <P>
 * Column names are determined at runtime.
 * For use with join tables and sql aggregate queries.
 * Any potential property value must be predefined.
 * The relevant properties are set using reflection.
 */
public class RowObject {
    //Add any potential properties here. The name must match the name from ResultSetMetaData.
    private final SimpleObjectProperty<Object> name = new SimpleObjectProperty<>();
    private final SimpleObjectProperty<Object> count = new SimpleObjectProperty<>();
    private final SimpleObjectProperty<Object> placement = new SimpleObjectProperty<>();
    private final SimpleObjectProperty<Object> winningStatistics = new SimpleObjectProperty<>();

    public static ArrayList<String> colNames = new ArrayList<String>();
    int size;
    /**
     * Creates a new RowObject from the given ResultSet using
     * the ResultSetMetaData to get the column names.
     * ObjectProperty values are set dynamically by only invoking the
     * methods matching the ResultSet column names.
     * @param rs
     * @throws SQLException
     */
    public RowObject(ResultSet rs) throws SQLException{
        setMetaData(rs);
        for(int i = 0; i < size; i++){
            Object obj = rs.getObject(colNames.get(i));
            Method method;
            try {
                method = getSetMethod(colNames.get(i));
                method.invoke(this, obj);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        
    }
    public RowObject(){};

    public Object getName(){
        return name.get();
    }
    public void setName(Object value){
        name.set(value);
    }
    public Object getCount(){
        return count.get();
    }
    public void setCount(Object value){
        count.set(value);
    }
    public Object getPlacement(){
        return placement.get();
    }
    public void setPlacement(Object value){
        placement.set(value);
    }
    public Object getWinningStatistics(){
        return winningStatistics.get();
    }
    public void setWinningStatistics(Object value){
        winningStatistics.set(value);
    }
    /**
     * Set the size and column names using the ResultSetMetaData
     * @param rs
     * @throws SQLException
     */
    public void setMetaData(ResultSet rs) throws SQLException
    {
        ResultSetMetaData rsmd = rs.getMetaData();
        size = rsmd.getColumnCount();
        colNames = new ArrayList<String>();
        int i = 1;
        while(i <= size){
            colNames.add(rsmd.getColumnName(i++));
        }
    }
    /**
     * Update the RowObject values
     * @param values
     */
    public void setValues(Object[] values){
        for(int i = 0; i < values.length; i++){
            Method method;
            try {
                method = getSetMethod(colNames.get(i));
                method.invoke(this, values[i]);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Get the set method with the given name
     * @param name
     * @return
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    public Method getSetMethod(String name) throws NoSuchMethodException, SecurityException{
        String methodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1);
        Method method = this.getClass().getMethod(methodName, Object.class);
        return method;
    }
    public ArrayList<String> getColumnNames(){
        return colNames;
    }
}
