package DataPackage;

import java.awt.geom.RoundRectangle2D;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DataManagement extends javax.swing.JFrame {

    // Database connection establishment
    private static final String username = "root";
    private static final String password = "admin";
    private static final String conn_string = "jdbc:mysql://localhost/eat_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";    

    String sex;
    FillDataManagementTbl dataLog = new FillDataManagementTbl();
    
    public DataManagement() {
        initComponents();
        
        // Center the form once opened
        // Note: Set the property first from "undecorated" to TRUE para mawala yung nasa taas na bar and mag-apply ang rounded corner        
        this.setLocationRelativeTo(null);
        
        // Transparency range: 0.0 - 1.0 float value
        // SetOpacity(0.7f); //30% transparent
        // For rounded corner        
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 60, 50));
        setFocusable(true);
        
        // Tooltip/reminder for birthdate textfield
        jTextFieldBirthdate.setToolTipText("YYYY-MM-DD");
        
        // Set table design
        dataLog.searchDataManagementTable(jTableData, "");
        jTableData.setRowHeight(30);    
        jTableData.setShowGrid(true);
    }
    
        // Groups the buttons so that you can only choose one
        private void buttonGroup1(){
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(jRadioButtonMale);
        bg1.add(jRadioButtonFemale);
    }  
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanelEditPane = new javax.swing.JPanel();
        jLabelINickname = new javax.swing.JLabel();
        jTextFieldMI = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldBirthdate = new javax.swing.JTextField();
        jTextFieldContact = new javax.swing.JTextField();
        jLabelClass = new javax.swing.JLabel();
        jLabelBirthdate = new javax.swing.JLabel();
        jLabelSex = new javax.swing.JLabel();
        jComboBoxEmpType = new javax.swing.JComboBox<>();
        jLabelIMI = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jLabelIAge = new javax.swing.JLabel();
        jRadioButtonFemale = new javax.swing.JRadioButton();
        jTextFieldNickname = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelIFname = new javax.swing.JLabel();
        jTextFieldLname = new javax.swing.JTextField();
        jComboBoxTeam = new javax.swing.JComboBox<>();
        jTextFieldFname = new javax.swing.JTextField();
        jLabelILname = new javax.swing.JLabel();
        jLabelTeam = new javax.swing.JLabel();
        jLabelContact = new javax.swing.JLabel();
        jLabelAddress = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jRadioButtonMale = new javax.swing.JRadioButton();
        jTextFieldAge = new javax.swing.JTextField();
        jComboBoxClass = new javax.swing.JComboBox<>();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jButtonView = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        jButtonHistory = new javax.swing.JButton();
        jTextFieldAddress = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldPassword = new javax.swing.JTextField();
        jPanelMinimize = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelMinimize = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1100, 550));

        jPanel2.setBackground(new java.awt.Color(53, 19, 39));

        jPanelEditPane.setBackground(new java.awt.Color(53, 19, 39));

        jLabelINickname.setForeground(new java.awt.Color(255, 255, 255));
        jLabelINickname.setText("Nickname:");

        jTextFieldMI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMIKeyTyped(evt);
            }
        });

        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("Email:");

        jTextFieldBirthdate.setText("YYYY-MM-DD");
        jTextFieldBirthdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldBirthdateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldBirthdateFocusLost(evt);
            }
        });
        jTextFieldBirthdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBirthdateKeyTyped(evt);
            }
        });

        jTextFieldContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldContactKeyTyped(evt);
            }
        });

        jLabelClass.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClass.setText("Class:");

        jLabelBirthdate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBirthdate.setText("Birthdate:");

        jLabelSex.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSex.setText("Sex:");

        jComboBoxEmpType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "Provisional", "Part-timer", "Regular", "Staff" }));

        jLabelIMI.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIMI.setText("M.I.:");

        jLabelType.setForeground(new java.awt.Color(255, 255, 255));
        jLabelType.setText("Emp Type:");

        jLabelIAge.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIAge.setText("Age:");

        buttonGroup1.add(jRadioButtonFemale);
        jRadioButtonFemale.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonFemale.setText("Female");
        jRadioButtonFemale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonFemaleMouseClicked(evt);
            }
        });

        jTextFieldNickname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNicknameKeyTyped(evt);
            }
        });

        jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEmailKeyTyped(evt);
            }
        });

        jLabelIFname.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIFname.setText("Last Name:");

        jTextFieldLname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLnameKeyTyped(evt);
            }
        });

        jComboBoxTeam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "Sanji", "Nico Robin", "Nami", "Luffy", "Zoro" }));

        jTextFieldFname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFnameKeyTyped(evt);
            }
        });

        jLabelILname.setForeground(new java.awt.Color(255, 255, 255));
        jLabelILname.setText("First Name:");

        jLabelTeam.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTeam.setText("Team:");

        jLabelContact.setForeground(new java.awt.Color(255, 255, 255));
        jLabelContact.setText("Contact No.:");

        jLabelAddress.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAddress.setText("Address:");

        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("Employee ID:");

        buttonGroup1.add(jRadioButtonMale);
        jRadioButtonMale.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonMale.setText("Male");
        jRadioButtonMale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonMaleMouseClicked(evt);
            }
        });

        jTextFieldAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAgeKeyTyped(evt);
            }
        });

        jComboBoxClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "Class C - 120/hr", "Class B - 140/hr", "Class A - 160/hr" }));

        jTextFieldID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIDKeyTyped(evt);
            }
        });

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        jTableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Lname", "Fname", "MI", "Age", "Nickname", "Address", "Sex", "Birthdate", "Email", "Contact", "Team", "Type", "Class", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableData.getTableHeader().setReorderingAllowed(false);
        jTableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDataMouseClicked(evt);
            }
        });
        jTableData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableDataKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableData);

        jButtonView.setBackground(new java.awt.Color(177, 57, 16));
        jButtonView.setText("View Log");
        jButtonView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonViewMouseClicked(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(238, 169, 13));
        jButtonUpdate.setText("Update");
        jButtonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonUpdateMouseClicked(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(238, 169, 13));
        jButtonAdd.setText("Add");
        jButtonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddMouseClicked(evt);
            }
        });

        jButtonRemove.setBackground(new java.awt.Color(238, 169, 13));
        jButtonRemove.setText("Remove");
        jButtonRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRemoveMouseClicked(evt);
            }
        });

        jButtonClear.setBackground(new java.awt.Color(177, 57, 16));
        jButtonClear.setText("Clear");
        jButtonClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonClearMouseClicked(evt);
            }
        });

        jButtonCancel.setBackground(new java.awt.Color(177, 57, 16));
        jButtonCancel.setText("Cancel");
        jButtonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelMouseClicked(evt);
            }
        });

        jLabelSearch.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSearch.setText("Search:");

        jButtonHistory.setBackground(new java.awt.Color(177, 57, 16));
        jButtonHistory.setText("History");
        jButtonHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonHistoryMouseClicked(evt);
            }
        });

        jTextFieldAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAddressKeyTyped(evt);
            }
        });

        jLabelPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setText("Password:");

        jTextFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPasswordKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelEditPaneLayout = new javax.swing.GroupLayout(jPanelEditPane);
        jPanelEditPane.setLayout(jPanelEditPaneLayout);
        jPanelEditPaneLayout.setHorizontalGroup(
            jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                        .addComponent(jLabelIFname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldLname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                        .addComponent(jLabelILname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldFname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                        .addComponent(jLabelEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                        .addComponent(jLabelContact)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldContact, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                        .addComponent(jLabelType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxEmpType, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTeam)
                            .addComponent(jLabelClass))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTeam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxClass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                        .addComponent(jLabelID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditPaneLayout.createSequentialGroup()
                        .addComponent(jLabelBirthdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                        .addComponent(jLabelAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                        .addComponent(jLabelPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditPaneLayout.createSequentialGroup()
                        .addComponent(jLabelSex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButtonMale)
                        .addGap(32, 32, 32)
                        .addComponent(jRadioButtonFemale))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditPaneLayout.createSequentialGroup()
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelINickname)
                            .addComponent(jLabelIMI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                                .addComponent(jTextFieldMI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelIAge)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                        .addComponent(jButtonView, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                            .addComponent(jLabelSearch)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9))
        );
        jPanelEditPaneLayout.setVerticalGroup(
            jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditPaneLayout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelID)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelIFname)
                            .addComponent(jTextFieldLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelILname)
                            .addComponent(jTextFieldFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelIMI)
                            .addComponent(jTextFieldMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIAge)
                            .addComponent(jTextFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelINickname)
                            .addComponent(jTextFieldNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSex)
                            .addComponent(jRadioButtonMale)
                            .addComponent(jRadioButtonFemale))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelBirthdate)
                            .addComponent(jTextFieldBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEmail)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelContact)
                            .addComponent(jTextFieldContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelType)
                            .addComponent(jComboBoxEmpType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTeam)
                            .addComponent(jComboBoxTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelClass))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEditPaneLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditPaneLayout.createSequentialGroup()
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonView, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelEditPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEditPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEditPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanelMinimize.setBackground(new java.awt.Color(246, 138, 13));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Management");

        jLabelMinimize.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinimize.setText("-");
        jLabelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseClicked(evt);
            }
        });

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(53, 19, 39));
        jLabelClose.setText("x");
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelMinimizeLayout = new javax.swing.GroupLayout(jPanelMinimize);
        jPanelMinimize.setLayout(jPanelMinimizeLayout);
        jPanelMinimizeLayout.setHorizontalGroup(
            jPanelMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMinimizeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMinimize)
                .addGap(26, 26, 26)
                .addComponent(jLabelClose)
                .addGap(24, 24, 24))
        );
        jPanelMinimizeLayout.setVerticalGroup(
            jPanelMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMinimizeLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanelMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelMinimize)
                    .addComponent(jLabelClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizeMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jButtonCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelMouseClicked

        this.dispose();
        EmployeeLog lg = new EmployeeLog();
        lg.setVisible(true);
    }//GEN-LAST:event_jButtonCancelMouseClicked

    private void jButtonClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClearMouseClicked
        
        jTextFieldID.setText("");
        jTextFieldLname.setText("");
        jTextFieldFname.setText("");
        jTextFieldMI.setText("");
        jTextFieldAge.setText("");
        jTextFieldNickname.setText("");
        jTextFieldEmail.setText("");
        jTextFieldContact.setText("");
        jTextFieldPassword.setText("");
        jTextFieldBirthdate.setText("YYYY-MM-DD");
        // jTextFieldSearch.setText(""); Di pwede i-clear kasi mawawala ang table
    }//GEN-LAST:event_jButtonClearMouseClicked

    // Delete Record from employee_tbl
    public void DeleteRecord (){
        
        try {
            Connection connect = DriverManager.getConnection(conn_string, username, password);
            
            int rowIndex = jTableData.getSelectedRow();
            String selected = jTableData.getValueAt(rowIndex, 0).toString();
            String query = "DELETE FROM employee_tbl WHERE EmpID = '"+selected+"'";
            
            PreparedStatement ps = connect.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Record Deleted");
            
        } catch (SQLException ex) {
            System.out.print(ex);
            JOptionPane.showMessageDialog(null, "Record has attendance data!", "Warning!", 2);
        }
            
    }    
    
    private void jButtonRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRemoveMouseClicked
        
        DeleteRecord();
    }//GEN-LAST:event_jButtonRemoveMouseClicked

    // Not Future birthdate checker
    public boolean checkDate(){
        
        Date date = new Date();
        int year = date.getYear() + 1900;
        String dateInput = jTextFieldBirthdate.getText();
        
        if(Integer.parseInt(dateInput.split("-", 3)[0]) < year){
            return false;
        }
        return true;
    }
    
    private void jButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddMouseClicked

        try{
            // Empty fields checker
            if(jTextFieldID.getText().equals("") ||
               jTextFieldLname.getText().equals("") ||
               jTextFieldFname.getText().equals("") ||
               jTextFieldMI.getText().equals("") ||
               jTextFieldAge.getText().equals("") ||
               jTextFieldEmail.getText().equals("") ||
               jTextFieldContact.getText().equals("") ||
               jTextFieldAddress.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Incomplete Fields!", "Warning!", 2);
            } 
            else if (jTextFieldBirthdate.getText().equals("YYYY-MM-DD") || jTextFieldBirthdate.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Birthdate Missing", "Warning!", 2);
            }
            else if(checkDate() == true)
            {
                JOptionPane.showMessageDialog(null, "Invalid Year!", "Warning!", 2);
            }
            else{
            String sex = "M";
            if(jRadioButtonFemale.isSelected()){
                sex = "F";
            }
            String empType;
            empType = jComboBoxEmpType.getSelectedItem().toString();
            String team;
            team = jComboBoxTeam.getSelectedItem().toString();
            String tClass;
            tClass = jComboBoxClass.getSelectedItem().toString();

            Connection connect = DriverManager.getConnection(conn_string, username, password);
            CallableStatement cstmt;
            String addEmployee = "{CALL add_employee (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

                cstmt = connect.prepareCall(addEmployee);
                cstmt.setString(1, jTextFieldID.getText());
                cstmt.setString(2, jTextFieldLname.getText());
                cstmt.setString(3, jTextFieldFname.getText());
                cstmt.setString(4, jTextFieldMI.getText());
                cstmt.setString(5, jTextFieldNickname.getText());
                cstmt.setString(6, sex);
                cstmt.setString(7, jTextFieldBirthdate.getText());
                cstmt.setString(8, jTextFieldAge.getText());
                cstmt.setString(9, jTextFieldAddress.getText());
                cstmt.setString(10, jTextFieldEmail.getText());
                cstmt.setString(11, jTextFieldContact.getText());
                cstmt.setString(12, empType);
                cstmt.setString(13, team);
                cstmt.setString(14, tClass);
                cstmt.setString(15, jTextFieldPassword.getText());
                cstmt.execute();
                cstmt.close();

            JOptionPane.showMessageDialog(null,"Added Successfully!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Duplicate Data!", "Change ID", 2);
        }
    }//GEN-LAST:event_jButtonAddMouseClicked

    public void UpdateRecord(){
        
        try{
            // Empty fields checker
            if(jTextFieldID.getText().equals("") ||
               jTextFieldLname.getText().equals("") ||
               jTextFieldFname.getText().equals("") ||
               jTextFieldMI.getText().equals("") ||
               jTextFieldAge.getText().equals("") ||
               jTextFieldEmail.getText().equals("") ||
               jTextFieldContact.getText().equals("") ||
               jTextFieldAddress.getText().equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Incomplete Fields!", "Warning!", 2);
            } 
            else if (jTextFieldBirthdate.getText().equals("YYYY-MM-DD") || jTextFieldBirthdate.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Birthdate Missing", "Warning!", 2);
            }
            else if(checkDate() == true)
            {
                JOptionPane.showMessageDialog(null, "Invalid Year!", "Warning!", 2);
            }
            else {
            
            Connection connect = DriverManager.getConnection(conn_string, username, password);
            
            String Lname = jTextFieldLname.getText();
            String Fname = jTextFieldFname.getText();
            String MI = jTextFieldMI.getText();
            String Age = jTextFieldAge.getText();
            String Sex = "M";
                if(jRadioButtonFemale.isSelected()){
                    sex = "F";
                }
            String Nickname = jTextFieldNickname.getText();
            String Birthdate = jTextFieldBirthdate.getText();    
            String Email = jTextFieldEmail.getText();
            String ContactNo = jTextFieldContact.getText();
            String EmpType = (String) jComboBoxEmpType.getSelectedItem();
            String TeamName = (String) jComboBoxTeam.getSelectedItem();
            String TeacherClass = (String) jComboBoxClass.getSelectedItem();
            String Address = jTextFieldAddress.getText();
            String Password = jTextFieldPassword.getText();
            
            // EmpID cannot be updated: "SQLIntegrityConstraintViolationException: Cannot delete or update a parent row: a foreign key constraint fails"
            // Di pwedeng mag-update ng EmpID since based ang UPDATE sa selected row sa table
            // If we change e.g. EmpID: JA-150 -> JA-200, nothing will happen since JA-200 doesn't exist in the first place.
            // Resolution: Be careful/create new data
            // This is probably because of the nature of the program? EmpID was a reference of many data, so if it changes, program may not work anymore.
            
            String query = "UPDATE employee_tbl SET Lname = '"+Lname+"',  "
                + "Fname = '"+Fname+"', MI = '"+MI+"', Nickname = '"+Nickname+"', Sex = '"+Sex+"', "
                + "Birthdate = '"+Birthdate+"', Age = '"+Age+"' , Address = '"+Address+"' , "
                + "Email = '"+Email+"', ContactNo  = '"+ContactNo+"', EmpType = '"+EmpType+"', "
                + "TeamName = '"+TeamName+"', TeacherClass = '"+TeacherClass+"', Password  = '"+Password+"'"
                + "WHERE EmpID = ?";
            
            // WHERE should be EmpID = ? to be able to change the rest of the data + ps.setString(1, jTextFieldID.getText());
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setString(1, jTextFieldID.getText());
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Record Updated");
            }
            } catch (SQLException ex) {
                // ex.printStackTrace();
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Please Check Inputs!", "Warning!", 2);
            }
    }
    
    private void jButtonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUpdateMouseClicked
           
        UpdateRecord();
    }//GEN-LAST:event_jButtonUpdateMouseClicked

    private void jButtonViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonViewMouseClicked
        
        // Exits the current window then will go to Attendance Log Form
        AttendanceLog attlog = new AttendanceLog();
        attlog.setVisible(true);
        attlog.pack();
        attlog.setLocationRelativeTo(null);
        attlog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButtonViewMouseClicked

    private void jRadioButtonMaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonMaleMouseClicked
        sex = "Male";
    }//GEN-LAST:event_jRadioButtonMaleMouseClicked

    private void jRadioButtonFemaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonFemaleMouseClicked
        sex = "Female";
    }//GEN-LAST:event_jRadioButtonFemaleMouseClicked

    private void jTextFieldBirthdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldBirthdateFocusLost
        if(jTextFieldBirthdate.getText().equals("")){
            jTextFieldBirthdate.setText("YYYY-MM-DD");
        }
    }//GEN-LAST:event_jTextFieldBirthdateFocusLost

    private void jTextFieldBirthdateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldBirthdateFocusGained
        if(jTextFieldBirthdate.getText().equals("YYYY-MM-DD")){
            jTextFieldBirthdate.setText("");
        }
    }//GEN-LAST:event_jTextFieldBirthdateFocusGained

    private void jTextFieldAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAgeKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
        evt.consume();
        }
        
        if(jTextFieldAge.getText().length() >= 2) {  
        evt.consume();
        }
    }//GEN-LAST:event_jTextFieldAgeKeyTyped

    private void jTextFieldContactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldContactKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
        evt.consume();
        }
        
        if(jTextFieldContact.getText().length() >= 11) {  
        evt.consume();
        }
    }//GEN-LAST:event_jTextFieldContactKeyTyped

    private void jTextFieldIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIDKeyTyped
        if(jTextFieldID.getText().length() >= 6) {  
        evt.consume();
        }
    }//GEN-LAST:event_jTextFieldIDKeyTyped

    private void jTextFieldLnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLnameKeyTyped
        if(jTextFieldLname.getText().length() >= 30) {  
        evt.consume();
        }
    }//GEN-LAST:event_jTextFieldLnameKeyTyped

    private void jTextFieldFnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFnameKeyTyped
        if(jTextFieldFname.getText().length() >= 30) {  
        evt.consume();
        }
    }//GEN-LAST:event_jTextFieldFnameKeyTyped

    private void jTextFieldMIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMIKeyTyped
        if(jTextFieldMI.getText().length() >= 10) {  
        evt.consume();
        }
    }//GEN-LAST:event_jTextFieldMIKeyTyped

    private void jTextFieldNicknameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNicknameKeyTyped
        if(jTextFieldNickname.getText().length() >= 15) {  
        evt.consume();
        }
    }//GEN-LAST:event_jTextFieldNicknameKeyTyped

    private void jTextFieldBirthdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBirthdateKeyTyped
        if(jTextFieldBirthdate.getText().length() >= 10) {  
        evt.consume();
        }
    }//GEN-LAST:event_jTextFieldBirthdateKeyTyped

    private void jTextFieldEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyTyped
        if(jTextFieldEmail.getText().length() >= 40) {  
        evt.consume();
        }
    }//GEN-LAST:event_jTextFieldEmailKeyTyped

    private void jTableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDataMouseClicked
        
        // Set the textfields accoring to its corresponding row selected (through mouse click) on the table
        int rowIndex = jTableData.getSelectedRow();
        DefaultTableModel TModel = (DefaultTableModel) jTableData.getModel(); 
        
        jTextFieldID.setText(TModel.getValueAt(rowIndex, 0).toString());
        jTextFieldLname.setText(TModel.getValueAt(rowIndex, 1).toString());
        jTextFieldFname.setText(TModel.getValueAt(rowIndex, 2).toString());
        jTextFieldMI.setText(TModel.getValueAt(rowIndex, 3).toString());
        jTextFieldAge.setText(TModel.getValueAt(rowIndex, 4).toString());
        jTextFieldNickname.setText(TModel.getValueAt(rowIndex, 5).toString());
        
        if(TModel.getValueAt(rowIndex, 7).toString().equals("M"))
        {
            jRadioButtonMale.setSelected(true);
            jRadioButtonFemale.setSelected(false);
        } else {
            jRadioButtonFemale.setSelected(true);
            jRadioButtonMale.setSelected(false);
        }
        
        jTextFieldBirthdate.setText(TModel.getValueAt(rowIndex, 8).toString());
        jTextFieldEmail.setText(TModel.getValueAt(rowIndex, 9).toString());
        jTextFieldContact.setText(TModel.getValueAt(rowIndex, 10).toString());
        jTextFieldAddress.setText(TModel.getValueAt(rowIndex, 6).toString());
        jTextFieldPassword.setText(TModel.getValueAt(rowIndex, 14).toString());
        
    }//GEN-LAST:event_jTableDataMouseClicked

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        
        // For search. See FillDataManagementTbl.java
        jTableData.setModel(new DefaultTableModel(null, new Object [] {"ID", "Lname", "Fname", "MI", "Age", "Nickname", "Address", "Sex", "Birthdate", "Email", "Contact", "Team", "Type", "Class", "Password"}));
        dataLog.searchDataManagementTable(jTableData, jTextFieldSearch.getText());
        jTableData.setDefaultEditor(Object.class, null);
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jTableDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableDataKeyReleased
        
        // Set the textfields accoring to its corresponding row selected (through key press) on the table
        int rowIndex = jTableData.getSelectedRow();
        DefaultTableModel TModel = (DefaultTableModel) jTableData.getModel();

        jTextFieldID.setText(TModel.getValueAt(rowIndex, 0).toString());
        jTextFieldLname.setText(TModel.getValueAt(rowIndex, 1).toString());
        jTextFieldFname.setText(TModel.getValueAt(rowIndex, 2).toString());
        jTextFieldMI.setText(TModel.getValueAt(rowIndex, 3).toString());
        jTextFieldAge.setText(TModel.getValueAt(rowIndex, 4).toString());
        jTextFieldNickname.setText(TModel.getValueAt(rowIndex, 5).toString());
        
        if(TModel.getValueAt(rowIndex, 7).toString().equals("M"))
        {
            jRadioButtonMale.setSelected(true);
            jRadioButtonFemale.setSelected(false);
        } else {
            jRadioButtonFemale.setSelected(true);
            jRadioButtonMale.setSelected(false);
        }
        
        jTextFieldBirthdate.setText(TModel.getValueAt(rowIndex, 8).toString());
        jTextFieldEmail.setText(TModel.getValueAt(rowIndex, 9).toString());
        jTextFieldContact.setText(TModel.getValueAt(rowIndex, 10).toString());
        jTextFieldAddress.setText(TModel.getValueAt(rowIndex, 6).toString());
        jTextFieldPassword.setText(TModel.getValueAt(rowIndex, 14).toString());
        
        
    }//GEN-LAST:event_jTableDataKeyReleased

    private void jButtonHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonHistoryMouseClicked
        
        // Exits the current window then will go to History Form
        History histo = new History();
        histo.setVisible(true);
        histo.pack();
        histo.setLocationRelativeTo(null);
        histo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButtonHistoryMouseClicked

    private void jTextFieldAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAddressKeyTyped
        if(jTextFieldAddress.getText().length() >= 50) {  
        evt.consume();
        }
    }//GEN-LAST:event_jTextFieldAddressKeyTyped

    private void jTextFieldPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPasswordKeyTyped
        if(jTextFieldPassword.getText().length() >= 30) {  
        evt.consume();
        }
    }//GEN-LAST:event_jTextFieldPasswordKeyTyped

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonHistory;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonView;
    private javax.swing.JComboBox<String> jComboBoxClass;
    private javax.swing.JComboBox<String> jComboBoxEmpType;
    private javax.swing.JComboBox<String> jComboBoxTeam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelBirthdate;
    private javax.swing.JLabel jLabelClass;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelContact;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelIAge;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelIFname;
    private javax.swing.JLabel jLabelILname;
    private javax.swing.JLabel jLabelIMI;
    private javax.swing.JLabel jLabelINickname;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelSex;
    private javax.swing.JLabel jLabelTeam;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelEditPane;
    private javax.swing.JPanel jPanelMinimize;
    private javax.swing.JRadioButton jRadioButtonFemale;
    private javax.swing.JRadioButton jRadioButtonMale;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableData;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldAge;
    private javax.swing.JTextField jTextFieldBirthdate;
    private javax.swing.JTextField jTextFieldContact;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFname;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLname;
    private javax.swing.JTextField jTextFieldMI;
    private javax.swing.JTextField jTextFieldNickname;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
