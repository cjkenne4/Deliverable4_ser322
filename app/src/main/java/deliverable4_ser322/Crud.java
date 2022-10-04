package deliverable4_ser322;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud {

    static volatile Connection conn;
    static PreparedStatement pstmt;
    static ResultSet rs;
    
    public static void update(int id, Object[] results, TableType tType) throws SQLException 
    {
        conn = getConnection();
        int n = tType.colNames().size();
        pstmt = conn.prepareStatement("UPDATE " + tType.toString() + " SET " + catCol(tType) + " WHERE " + tType.colNames().get(0) + " = ?");
        for(int i = 0; i < n; i++){
            pstmt.setString(i+1, results[i].toString());
        }
        pstmt.setString(n+1, Integer.toString(id));
        pstmt.executeUpdate();
    }
    private static Connection getConnection() throws SQLException 
    {
        String url = "jdbc:mysql://ser322.mysql.database.azure.com:3306/league?useSSL=true";
        String username = "group_admin";
        String password = "1goodPassword";

        System.out.println("Connecting database...");

        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    private static String catCol(TableType tType)
    {
        String str = tType.colNames().get(0);
        for(int i = 1; i < tType.colNames().size(); i++){
            str += " = ?, " + tType.colNames().get(i);
        }
        str += " = ?";
        return str;
    }
}
