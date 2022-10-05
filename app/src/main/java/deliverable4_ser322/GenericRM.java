package deliverable4_ser322;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GenericRM<T> {

    static final String url = "jdbc:mysql://ser322.mysql.database.azure.com:3306/league?useSSL=true";
    static final String username = "group_admin";
    static final String password = "1goodPassword";
    static volatile Connection conn;
    
    public static <T> ObservableList<T> getAttributesFromQuery(String query, RSConvertable<T> convert)
    {
        ObservableList<T> data = FXCollections.observableArrayList();
        try
        {
            conn = connectToDB(url, username, password);
            Statement st = conn.createStatement();
            for (ResultSet rs = st.executeQuery(query); rs.next();)
            {
                data.add((T) convert.fromDB(rs));
            }
        }
        catch (SQLException e)
        {
            e.getMessage();
        }

        return data;
    }
    public static Object mapFromResultSet(ResultSet rs, TableType tType)
    {   
        Object nObj = null;
        try {
            nObj = tType.newDbObject(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nObj;
    }

    public static ObservableList<Object> getAllFromTable(String tableName, TableType tType) throws SQLException
    {
        String Query = "select * " + "from " + tableName;

        return getAttributesFromQuery(Query, rs -> mapFromResultSet(rs, tType));
    }
    static Connection connectToDB(String url, String username, String password) throws SQLException{
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

}

