


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sourav
 */
public class DBConnection {
    
    static Connection con=null;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3308/cms","root","sr121"); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return con;
    }
        
}
