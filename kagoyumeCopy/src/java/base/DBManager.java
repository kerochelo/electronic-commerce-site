package base;

/**
 *  DB接続はここで
 * @author takahirokanno
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
    
    public static Connection getConnection(){
        
        final String db = "jdbc:mysql://localhost:3306/kagoyume_db";
        final String user = "kerochelo";
        final String pass = "tkhr8547";
        
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(db, user, pass);
            System.out.println("DBConnected!!");
            return con;
        }
        catch(ClassNotFoundException e){
            throw new IllegalMonitorStateException();
        }
        catch (SQLException e){
            throw new IllegalMonitorStateException();
        }
    }
}
