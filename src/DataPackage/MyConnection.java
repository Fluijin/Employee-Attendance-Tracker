package DataPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    
    // General connection between Java (Netbeans in my case) and MySql
    public static Connection getConnection(){
        Connection connect = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/eat_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
            // For 'Malay Peninsula Standard Time' error, add the code ^
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return connect;
    }
    
    public static void main (String []args){
        
        
    }
}
