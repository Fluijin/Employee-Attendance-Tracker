package DataPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FillAttendanceTbl {
    
    private static final String username = "root";
    private static final String password = "admin";
    private static final String conn_string = "jdbc:mysql://localhost/eat_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public void searchAttendanceTable(JTable jTableALog, String valueToSearch){
               
        try{
        Connection connect = DriverManager.getConnection(conn_string, username, password);
        String query = "SELECT * FROM attendance_log_view "
                + "WHERE CONCAT (EmpID, Date, TimeIn, TimeOut) LIKE ?"; //For Search
        PreparedStatement ps = connect.prepareStatement(query);
        ps.setString(1, "%"+valueToSearch+"%");
        
        ResultSet rs = ps.executeQuery();
        DefaultTableModel TModel = (DefaultTableModel) jTableALog.getModel(); 
        TModel.setRowCount(0);
           
        while(rs.next())
            {
            Object obj[] = 
            {
            rs.getString("EmpID"), 
            rs.getString("Date"), 
            rs.getString("TimeIn"), 
            rs.getString("TimeOut")
            };
            TModel.addRow(obj);
            }
        }   catch (SQLException ex) {
            
        }
    }  
   
    public void searchEarlyTable(JTable jTableEarlyIn, String valueToSearch){

    }
    
}
