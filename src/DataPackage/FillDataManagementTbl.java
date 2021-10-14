package DataPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FillDataManagementTbl {

    private static final String username = "root";
    private static final String password = "admin";
    private static final String conn_string = "jdbc:mysql://localhost/eat_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";    

    public void searchDataManagementTable(JTable jTableData, String valueToSearch){
           
        try{
        Connection connect = DriverManager.getConnection(conn_string, username, password);
        String query = "SELECT * FROM employee_tbl WHERE CONCAT (EmpID, Lname, Fname, MI, Age, "
                + "Nickname, Address,Sex, Birthdate, Email, ContactNo, TeamName, "
                + "EmpType, TeacherClass, Password) LIKE ?";
        PreparedStatement ps = connect.prepareStatement(query);
        ps.setString(1, "%"+valueToSearch+"%");
           
        ResultSet rs = ps.executeQuery();
        DefaultTableModel TModel = (DefaultTableModel) jTableData.getModel(); 
        TModel.setRowCount(0);
           
        while(rs.next())
        {
            Object obj[] = 
            {
            rs.getString("EmpID"), 
            rs.getString("LName"), 
            rs.getString("FName"), 
            rs.getString("MI"),
            rs.getString("Age"), 
            rs.getString("Nickname"), 
            rs.getString("Address"), 
            rs.getString("Sex"),
            rs.getString("Birthdate"), 
            rs.getString("Email"), 
            rs.getString("ContactNo"), 
            rs.getString("TeamName"),
            rs.getString("EmpType"), 
            rs.getString("TeacherClass"),
            rs.getString("Password")};
            TModel.addRow(obj);
           }
        }   catch (SQLException ex) {
            
        }
    }
}
