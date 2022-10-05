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
        pstmt = conn.prepareStatement("UPDATE " + tType.toString() + " SET " + catColUpdate(tType) + " WHERE " + tType.colNames().get(0) + " = ?");
        for(int i = 0; i < n; i++){
            pstmt.setString(i+1, results[i].toString());
        }
        pstmt.setString(n+1, Integer.toString(id));
        pstmt.executeUpdate();
        close();
    }
    public static void insert(Object[] results, TableType tType) throws SQLException
    {
        conn = getConnection();
        int n = tType.colNames().size();
        String str = "";
        pstmt = conn.prepareStatement("INSERT INTO " + tType.toString() + " (" + catColNames(tType) + ") VALUES (" + catColQ(tType) + ")");
        for(int i = 0; i < n; i++) {
            pstmt.setString(i+1, results[i].toString());
        }
        pstmt.executeUpdate();
        close();
    }
    public static void delete(TableType tType, int id) throws SQLException
    {
        conn = getConnection();
        pstmt = conn.prepareStatement("DELETE FROM " + tType.toString() + " WHERE " + tType.colNames().get(0) + " = ?");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        close();
    }
    public static ResultSet getRow(TableType tType, int id) throws SQLException
    {
        conn = getConnection();
        pstmt = conn.prepareStatement("SELECT * FROM " + tType.toString() + " WHERE " + tType.colNames().get(0) + " = ?");
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        close();
        return rs;
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
    private static void close() throws SQLException
    {
        if(conn != null) conn.close();
        if(pstmt != null) pstmt.close();
        if(rs != null) rs.close();
    }
    private static String catColUpdate(TableType tType)
    {
        String str = tType.colNames().get(0);
        for(int i = 1; i < tType.colNames().size(); i++){
            str += " = ?, " + tType.colNames().get(i);
        }
        str += " = ?";
        return str;
    }
    private static String catColNames(TableType tType)
    {
        String str = tType.colNames().get(0);
        for(int i = 1; i < tType.colNames().size(); i++){
            str += ", " + tType.colNames().get(i);
        }
        return str;
    }
    private static String catColQ(TableType tType)
    {
        String str = "?";
        for(int i = 1; i < tType.colNames().size(); i++){
            str += ", ?";
        }
        return str;
    }
}
