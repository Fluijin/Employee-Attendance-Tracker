package DataPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FillEarlyIns {
    
    private static final String username = "root";
    private static final String password = "admin";
    private static final String conn_string = "jdbc:mysql://localhost/eat_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";    
       
    public void EarlyIns (JTable jTableEarlyIn, String valueToSearch){
               
        try{
        Connection connect = DriverManager.getConnection(conn_string, username, password);
        String query = "SELECT EmpId, Month, MAX(MaxIn) AS  \"Early Ins Count\"" +
                " FROM (SELECT et.EmpID, MONTHNAME(Date) AS Month, COUNT(at.TimeIn) AS MaxIn" +
                " FROM employee_tbl et JOIN attendancelog_tbl at" +
                " ON et.EmpID = at.EmpID" +
                " WHERE at.TimeIn < \"8:00\"" +
                " GROUP BY et.EmpID, MONTH(Date)" +
                " ORDER BY COUNT(at.TimeIn) DESC) AS sub" +
                " GROUP BY Month";
        PreparedStatement ps = connect.prepareStatement(query);
        
        ResultSet rs = ps.executeQuery();
        DefaultTableModel TModel = (DefaultTableModel) jTableEarlyIn.getModel(); 
        TModel.setRowCount(0);
           
        while(rs.next())
            {
            Object obj[] = 
            {
            rs.getString("EmpID"), 
            rs.getString("Month"), 
            rs.getString("Early Ins Count")
            };
            TModel.addRow(obj);
            }
        }   catch (Exception ex) {
            ex.printStackTrace();
        }
    } 
}
    

