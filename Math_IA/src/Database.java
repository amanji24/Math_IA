

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;  
   
public class Database {  
     /** 
     * Connect to a sample database 
     */  
    public static Connection connect(String databaseName) {  
        Connection conn = null;  
        try {  
            // db parameters  
            String url = "jdbc:sqlite:files/" + databaseName + ".sql";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
              
            System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }  
        return conn;
    }
    
    public static void createNewDatabase(String fileName) {  
    	   
    	String url = "jdbc:sqlite:files/" + fileName + ".sql";  
   
        try {  
            Connection conn = DriverManager.getConnection(url);  
            if (conn != null) {  
                DatabaseMetaData meta = conn.getMetaData();  
                System.out.println("The driver name is " + meta.getDriverName());  
                System.out.println("A new database has been created.");  
            }  
   
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    
    public static void createNewTable(String databaseName) {  
        // SQLite connection string  
    	String url = "jdbc:sqlite:files/" + databaseName + ".sql";  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS employees (\n"  
                + " id integer PRIMARY KEY,\n"  
                + " name text NOT NULL,\n"  
                + " capacity real\n"  
                + ");";  
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    
    public void insert(Connection conne, String table, String[] fields, int[] values) {  
    	
    	String sql = "INSERT INTO " + table + "(";
    	for (int i = 0; i < fields.length; i++) {
    		String str = fields[i];
    		sql += str + ", ";
    	}
    	sql = sql.substring(0, sql.length()-2) + ") VALUES(";
    	for (int i = 0; i < fields.length; i++) {
    		sql += "?,";
    	}
    	sql = sql.substring(0, sql.length()-1) + ")";
   
        try{  
            Connection conn = conne;  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            for (int i = 0; i < values.length; i++) {
            	pstmt.setInt(i+1, values[i]);
            }
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    
    public static void insert(Connection con, String table, String[] fields, String[] values) {  
    	
    	String sql = "INSERT INTO " + table + "(";
    	for (int i = 0; i < fields.length; i++) {
    		String str = fields[i];
    		sql += str + ", ";
    	}
    	sql = sql.substring(0, sql.length()-2) + ") VALUES(";
    	for (int i = 0; i < fields.length; i++) {
    		sql += "?,";
    	}
    	sql = sql.substring(0, sql.length()-1) + ")";
   
        try{  
            Connection conn = con;  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            for (int i = 0; i < values.length; i++) {
            	pstmt.setString(i+1, values[i]);
            }
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    
}
