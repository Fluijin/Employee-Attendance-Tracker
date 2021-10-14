package DataPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FillHistory {
    private static final String username = "root";
    private static final String password = "admin";
    private static final String conn_string = "jdbc:mysql://localhost/eat_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public void searchHistoryTable(JTable jTableALog, String valueToSearch){
               
        try{
        Connection connect = DriverManager.getConnection(conn_string, username, password);
        String query = "SELECT * FROM management_history "
                + "WHERE CONCAT (RecordCount, EmpID, Lname, Fname, MI, Sex, EmpType, TeamName, "
                + "TeacherClass, Password, Action) LIKE ?"; //For Search
        PreparedStatement ps = connect.prepareStatement(query);
        ps.setString(1, "%"+valueToSearch+"%");
        
        ResultSet rs = ps.executeQuery();
        DefaultTableModel TModel = (DefaultTableModel) jTableALog.getModel(); 
        TModel.setRowCount(0);
           
        while(rs.next())
            {
            Object obj[] = 
            {
            rs.getString("RecordCount"), 
            rs.getString("EmpID"), 
            rs.getString("Lname"), 
            rs.getString("Fname"), 
            rs.getString("MI"), 
            rs.getString("Sex"), 
            rs.getString("EmpType"), 
            rs.getString("TeamName"), 
            rs.getString("TeacherClass"), 
            rs.getString("Password"), 
            rs.getString("Action")
            };
            TModel.addRow(obj);
            }
        }   catch (SQLException ex) {
            
        }
    }      
}
