
package Forms;

import geniusapp.Constants;
import geniusapp.Security;
import geniusapp.SqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Administrator
 */
public class Homepage1 extends javax.swing.JFrame  {

    
    public Homepage1() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        validateroles();
    }
 static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Constants=new Constants();
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SplitPanel = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        UsersMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EmployeeMenuPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ReportspanelMenu = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SecuritypanelMenu = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemPO = new javax.swing.JMenuItem();
        jMenuItemInvoiceMatching = new javax.swing.JMenuItem();
        jMenuItemInventoryReceipts = new javax.swing.JMenuItem();
        jMenuItemSuppPayments = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemOpeningStock = new javax.swing.JMenuItem();
        jMenuItemInvAdjustments = new javax.swing.JMenuItem();
        jMenuItemInvIssuing = new javax.swing.JMenuItem();
        jMenuItemInvTransfers = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuSalesOrder = new javax.swing.JMenuItem();
        jMenuItemCustPayments = new javax.swing.JMenuItem();
        jMenu6Users = new javax.swing.JMenu();
        jMSuppliers = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuSuppCreditNote = new javax.swing.JMenuItem();
        jMenuItemCustomers = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItemRoles = new javax.swing.JMenuItem();
        menuUserGroups = new javax.swing.JMenuItem();
        MenuRoles = new javax.swing.JMenuItem();
        Users_Groups = new javax.swing.JMenuItem();
        jMenuUsers = new javax.swing.JMenuItem();
        jMenuItemCompany = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KOSACHEI HARDWARE");

        SplitPanel.setBackground(new java.awt.Color(153, 255, 204));
        SplitPanel.setDividerLocation(200);
        SplitPanel.setDividerSize(0);

        jPanel1.setBackground(new java.awt.Color(89, 82, 82));

        UsersMenu.setBackground(new java.awt.Color(89, 82, 82));
        UsersMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UsersMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UsersMenuMouseExited(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("System Users");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/user.png"))); // NOI18N

        javax.swing.GroupLayout UsersMenuLayout = new javax.swing.GroupLayout(UsersMenu);
        UsersMenu.setLayout(UsersMenuLayout);
        UsersMenuLayout.setHorizontalGroup(
            UsersMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UsersMenuLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        UsersMenuLayout.setVerticalGroup(
            UsersMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        EmployeeMenuPanel.setBackground(new java.awt.Color(89, 82, 82));
        EmployeeMenuPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeMenuPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EmployeeMenuPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EmployeeMenuPanelMouseExited(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Employees");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/Employee.png"))); // NOI18N

        javax.swing.GroupLayout EmployeeMenuPanelLayout = new javax.swing.GroupLayout(EmployeeMenuPanel);
        EmployeeMenuPanel.setLayout(EmployeeMenuPanelLayout);
        EmployeeMenuPanelLayout.setHorizontalGroup(
            EmployeeMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeeMenuPanelLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        EmployeeMenuPanelLayout.setVerticalGroup(
            EmployeeMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ReportspanelMenu.setBackground(new java.awt.Color(89, 82, 82));
        ReportspanelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReportspanelMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReportspanelMenuMouseExited(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Reports");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/reports-icon.png"))); // NOI18N

        javax.swing.GroupLayout ReportspanelMenuLayout = new javax.swing.GroupLayout(ReportspanelMenu);
        ReportspanelMenu.setLayout(ReportspanelMenuLayout);
        ReportspanelMenuLayout.setHorizontalGroup(
            ReportspanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReportspanelMenuLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ReportspanelMenuLayout.setVerticalGroup(
            ReportspanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/Applications-icon.png"))); // NOI18N

        SecuritypanelMenu.setBackground(new java.awt.Color(89, 82, 82));
        SecuritypanelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SecuritypanelMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SecuritypanelMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SecuritypanelMenuMouseExited(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Security");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/PadLock-icon.png"))); // NOI18N

        javax.swing.GroupLayout SecuritypanelMenuLayout = new javax.swing.GroupLayout(SecuritypanelMenu);
        SecuritypanelMenu.setLayout(SecuritypanelMenuLayout);
        SecuritypanelMenuLayout.setHorizontalGroup(
            SecuritypanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecuritypanelMenuLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        SecuritypanelMenuLayout.setVerticalGroup(
            SecuritypanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EmployeeMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReportspanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SecuritypanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(UsersMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UsersMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmployeeMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SecuritypanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReportspanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(401, Short.MAX_VALUE))
        );

        SplitPanel.setLeftComponent(jPanel1);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/Big1.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        SplitPanel.setRightComponent(jPanel2);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Home_40px.png"))); // NOI18N
        jMenu1.setText("Home           ");
        jMenuBar1.add(jMenu1);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Add_Tag_40px.png"))); // NOI18N
        jMenu4.setText("Procurement              ");

        jMenuItemPO.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemPO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Purchase_Order_20px.png"))); // NOI18N
        jMenuItemPO.setText("Purchase Orders");
        jMenuItemPO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPOActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemPO);

        jMenuItemInvoiceMatching.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemInvoiceMatching.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Invoice_20px.png"))); // NOI18N
        jMenuItemInvoiceMatching.setText("Invoice Matching");
        jMenuItemInvoiceMatching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInvoiceMatchingActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemInvoiceMatching);

        jMenuItemInventoryReceipts.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemInventoryReceipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Waiter_20px.png"))); // NOI18N
        jMenuItemInventoryReceipts.setText("Inventory Receipts");
        jMenuItemInventoryReceipts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInventoryReceiptsActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemInventoryReceipts);

        jMenuItemSuppPayments.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemSuppPayments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Coins_20px_1.png"))); // NOI18N
        jMenuItemSuppPayments.setText("Supplier Payments");
        jMenuItemSuppPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSuppPaymentsActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemSuppPayments);

        jMenuBar1.add(jMenu4);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Downloads_Folder_40px.png"))); // NOI18N
        jMenu2.setText("Invenoty Management               ");

        jMenuItemOpeningStock.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemOpeningStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Open_Sign_40px.png"))); // NOI18N
        jMenuItemOpeningStock.setText("Opening Stock");
        jMenuItemOpeningStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpeningStockActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemOpeningStock);

        jMenuItemInvAdjustments.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemInvAdjustments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Drag_Reorder_30px.png"))); // NOI18N
        jMenuItemInvAdjustments.setText("Inventory Adjustments");
        jMenuItemInvAdjustments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInvAdjustmentsActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemInvAdjustments);

        jMenuItemInvIssuing.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemInvIssuing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Sell_40px_1.png"))); // NOI18N
        jMenuItemInvIssuing.setText("Inventory Issuing");
        jMenuItemInvIssuing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInvIssuingActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemInvIssuing);

        jMenuItemInvTransfers.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemInvTransfers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Exchange_40px.png"))); // NOI18N
        jMenuItemInvTransfers.setText("Inventory Transfers");
        jMenu2.add(jMenuItemInvTransfers);

        jMenuBar1.add(jMenu2);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Trolley_40px.png"))); // NOI18N
        jMenu5.setText("Sales         ");

        menuSalesOrder.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        menuSalesOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Sale_20px_1.png"))); // NOI18N
        menuSalesOrder.setText("SalesOrder");
        menuSalesOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalesOrderActionPerformed(evt);
            }
        });
        jMenu5.add(menuSalesOrder);

        jMenuItemCustPayments.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemCustPayments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Cash_in_Hand_20px.png"))); // NOI18N
        jMenuItemCustPayments.setText("Customer Payments");
        jMenuItemCustPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCustPaymentsActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemCustPayments);

        jMenuBar1.add(jMenu5);

        jMenu6Users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Settings_40px.png"))); // NOI18N
        jMenu6Users.setText("Setups           ");

        jMSuppliers.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMSuppliers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Supplier_40px.png"))); // NOI18N
        jMSuppliers.setText("Suppliers");
        jMSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSuppliersActionPerformed(evt);
            }
        });
        jMenu6Users.add(jMSuppliers);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Add_Shopping_Cart_40px.png"))); // NOI18N
        jMenuItem1.setText("New Item");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6Users.add(jMenuItem1);

        jMenuSuppCreditNote.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuSuppCreditNote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Money_Pound_40px.png"))); // NOI18N
        jMenuSuppCreditNote.setText("Supplier CreditNote");
        jMenuSuppCreditNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSuppCreditNoteActionPerformed(evt);
            }
        });
        jMenu6Users.add(jMenuSuppCreditNote);

        jMenuItemCustomers.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Customer_Support_20px.png"))); // NOI18N
        jMenuItemCustomers.setText("Customers");
        jMenuItemCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCustomersActionPerformed(evt);
            }
        });
        jMenu6Users.add(jMenuItemCustomers);

        jMenuBar1.add(jMenu6Users);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Edit_Property_40px.png"))); // NOI18N
        jMenu7.setText("Reports and Inquiries");
        jMenuBar1.add(jMenu7);

        jMenu6.setText("System Administration");

        jMenuItemRoles.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemRoles.setText("Security Roles");
        jMenuItemRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRolesActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemRoles);

        menuUserGroups.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        menuUserGroups.setText("Access Groups");
        menuUserGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUserGroupsActionPerformed(evt);
            }
        });
        jMenu6.add(menuUserGroups);

        MenuRoles.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        MenuRoles.setText("Map User Roles");
        MenuRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRolesActionPerformed(evt);
            }
        });
        jMenu6.add(MenuRoles);

        Users_Groups.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Users_Groups.setText("User Groups");
        Users_Groups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Users_GroupsActionPerformed(evt);
            }
        });
        jMenu6.add(Users_Groups);

        jMenuUsers.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_User_40px.png"))); // NOI18N
        jMenuUsers.setText("System Users");
        jMenuUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsersActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuUsers);

        jMenuItemCompany.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemCompany.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_New_Company_20px.png"))); // NOI18N
        jMenuItemCompany.setText("Company");
        jMenuItemCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCompanyActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemCompany);

        jMenuBar1.add(jMenu6);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_ShutDown_40px.png"))); // NOI18N
        jMenu3.setText("Sign Out");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SplitPanel))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SplitPanel)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
        Login _log=new Login();
        _log.setVisible(true);
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenu3ActionPerformed

    public void validateroles(){
         if(!ValidateUserRole("Purchase Orders") ){
              jMenuItemPO.setEnabled(false);
         }
         if(!ValidateUserRole("Supplier Invoice Matching") ){
              jMenuItemInvoiceMatching.setEnabled(false);
         }
          if(!ValidateUserRole("Inventory Receipts") ){
               jMenuItemInventoryReceipts.setEnabled(false);
         }
         if(!ValidateUserRole("Supplier Payments") ){
               jMenuItemSuppPayments.setEnabled(false);
         }
         if(!ValidateUserRole("Opening Stock") ){
               jMenuItemOpeningStock.setEnabled(false);
         }
         if(!ValidateUserRole("Inventory Adjustments") ){
               jMenuItemInvAdjustments.setEnabled(false);
         }
          if(!ValidateUserRole("Inventory Issuing") ){
               jMenuItemInvIssuing.setEnabled(false);
         }
           if(!ValidateUserRole("Inventory Transfers") ){
               jMenuItemInvTransfers.setEnabled(false);
         }
             if(!ValidateUserRole("Sales Orders") ){
               menuSalesOrder.setEnabled(false);
         }
         if(!ValidateUserRole("Customer Payments") ){
               jMenuItemCustPayments.setEnabled(false);
         }
         if(!ValidateUserRole("New Suppliers") ){
               jMSuppliers.setEnabled(false);
         }
          if(!ValidateUserRole("New Item") ){
               jMenuItem1.setEnabled(false);
         }
           if(!ValidateUserRole("Supplier Credit Notes") ){
               jMenuSuppCreditNote.setEnabled(false);
         }
         if(!ValidateUserRole("New Customers") ){
               jMenuItemCustomers.setEnabled(false);
         }
         if(!ValidateUserRole("UserSecurityRoles") ){
               jMenuItemRoles.setEnabled(false);
         }
         if(!ValidateUserRole("User Groups") ){
               menuUserGroups.setEnabled(false);
         }
         if(!ValidateUserRole("Map Security Roles") ){
               MenuRoles.setEnabled(false);
         }
         if(!ValidateUserRole("Add New user") ){
               jMenuUsers.setEnabled(false);
         }
         if(!ValidateUserRole("Add New Company") ){
               jMenuItemCompany.setEnabled(false);
         }
    }
    public Boolean ValidateUserRole(String Role){
        try {
            Boolean re=false;
          PreparedStatement pstmt = con.prepareStatement("{call sp_ValidatePrivilege(?,?)}");
                pstmt.setString(1, Role);
                pstmt.setString(2, _Constants.getUserId());
            ResultSet rs=pstmt.executeQuery();
      
         
                while(rs.next()){
                  Boolean Nm= rs.getBoolean("View");// getNString("VATInclusive"); 
                  if(Nm){
                      re= true;   
                  }else{
                      re= false;   
                  }
                            
            } 
          
           
            rs.close();
            pstmt.close();
             return re;
      
        } catch (Exception e) {
              Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Loading Items to jtable");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
            return false;
             
        }
    }
    private void EmployeeMenuPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeMenuPanelMouseClicked
        // TODO add your handling code here:
         SplitPanel.setRightComponent( new EmployeePanel());
    }//GEN-LAST:event_EmployeeMenuPanelMouseClicked

    private void EmployeeMenuPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeMenuPanelMouseEntered
        // TODO add your handling code here:
         EmployeeMenuPanel.setBackground(new java.awt.Color(153,102,255));
    }//GEN-LAST:event_EmployeeMenuPanelMouseEntered

    private void EmployeeMenuPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeMenuPanelMouseExited
        // TODO add your handling code here:
         EmployeeMenuPanel.setBackground(new java.awt.Color(89, 82, 82));
       
    }//GEN-LAST:event_EmployeeMenuPanelMouseExited

    private void SecuritypanelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SecuritypanelMenuMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SecuritypanelMenuMouseClicked

    private void SecuritypanelMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SecuritypanelMenuMouseEntered
        // TODO add your handling code here:
         SecuritypanelMenu.setBackground(new java.awt.Color(153,102,255));
    }//GEN-LAST:event_SecuritypanelMenuMouseEntered

    private void SecuritypanelMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SecuritypanelMenuMouseExited
        // TODO add your handling code here:
         SecuritypanelMenu.setBackground(new java.awt.Color(89, 82, 82));
    }//GEN-LAST:event_SecuritypanelMenuMouseExited

    private void UsersMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersMenuMouseEntered
        // TODO add your handling code here:
         UsersMenu.setBackground(new java.awt.Color(153,102,255));
    }//GEN-LAST:event_UsersMenuMouseEntered

    private void UsersMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersMenuMouseExited
        // TODO add your handling code here:
         UsersMenu.setBackground(new java.awt.Color(89, 82, 82));
    }//GEN-LAST:event_UsersMenuMouseExited

    private void ReportspanelMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportspanelMenuMouseEntered
        // TODO add your handling code here:
         ReportspanelMenu.setBackground(new java.awt.Color(153,102,255));
    }//GEN-LAST:event_ReportspanelMenuMouseEntered

    private void ReportspanelMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportspanelMenuMouseExited
        // TODO add your handling code here:
          ReportspanelMenu.setBackground(new java.awt.Color(89, 82, 82));
    }//GEN-LAST:event_ReportspanelMenuMouseExited

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        ItemMaster _Master=new ItemMaster();
        _Master.setVisible(true);
       

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemPOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPOActionPerformed
        // TODO add your handling code here:
        PurchaseOrders po = new PurchaseOrders(); 
        po.setVisible(true);
    }//GEN-LAST:event_jMenuItemPOActionPerformed

    private void jMSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSuppliersActionPerformed
        // TODO add your handling code here:
        sUppliers _supp=new sUppliers();
        _supp.setVisible(true);
    }//GEN-LAST:event_jMSuppliersActionPerformed

    private void jMenuItemInventoryReceiptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInventoryReceiptsActionPerformed
        InventoryReceipts _InventoryReceipts=new InventoryReceipts();
        _InventoryReceipts.setVisible(true);
    }//GEN-LAST:event_jMenuItemInventoryReceiptsActionPerformed

    private void jMenuUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsersActionPerformed
        // TODO add your handling code here:
        Users _users=new Users();
        _users.setVisible(true);
    }//GEN-LAST:event_jMenuUsersActionPerformed

    private void jMenuItemInvoiceMatchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInvoiceMatchingActionPerformed
        InvoiceMatching _InvoiceMatching=new InvoiceMatching();
        _InvoiceMatching.setVisible(true);
    }//GEN-LAST:event_jMenuItemInvoiceMatchingActionPerformed

    private void jMenuItemSuppPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSuppPaymentsActionPerformed
        SupplierPayments _SupplierPayments =new SupplierPayments();
        _SupplierPayments.setVisible(true);
    }//GEN-LAST:event_jMenuItemSuppPaymentsActionPerformed

    private void jMenuSuppCreditNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSuppCreditNoteActionPerformed
      CreditNotes _notes=new CreditNotes();
      _notes.setVisible(true);
    }//GEN-LAST:event_jMenuSuppCreditNoteActionPerformed

    private void jMenuItemOpeningStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpeningStockActionPerformed
        OpeningStock _OpeningStock=new OpeningStock();
        _OpeningStock.setVisible(true);
    }//GEN-LAST:event_jMenuItemOpeningStockActionPerformed

    private void jMenuItemInvAdjustmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInvAdjustmentsActionPerformed
        InventoryAdjustment _InventoryAdjustment=new InventoryAdjustment();
        _InventoryAdjustment.setVisible(true);
    }//GEN-LAST:event_jMenuItemInvAdjustmentsActionPerformed

    private void jMenuItemInvIssuingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInvIssuingActionPerformed
        Inventoryisuing _Inventoryisuing=new Inventoryisuing();
        _Inventoryisuing.setVisible(true);
    }//GEN-LAST:event_jMenuItemInvIssuingActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        Login _log=new Login();
        _log.setVisible(true);
        dispose();
        //System.exit(0);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenuItemCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCompanyActionPerformed
        Company _Company=new Company();
        _Company.setVisible(true);
    }//GEN-LAST:event_jMenuItemCompanyActionPerformed

    private void jMenuItemCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCustomersActionPerformed
       Customers _Customers=new Customers();
       _Customers.setVisible(true);
    }//GEN-LAST:event_jMenuItemCustomersActionPerformed

    private void menuSalesOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalesOrderActionPerformed
       SalesOrders _SalesOrders=new SalesOrders();
       _SalesOrders.setVisible(true);
    }//GEN-LAST:event_menuSalesOrderActionPerformed

    private void jMenuItemCustPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCustPaymentsActionPerformed
       CustomerPayments _CustomerPayments=new CustomerPayments();
       _CustomerPayments.setVisible(true);
    }//GEN-LAST:event_jMenuItemCustPaymentsActionPerformed

    private void jMenuItemRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRolesActionPerformed
        Roles _Roles=new Roles();
        _Roles.setVisible(true);
    }//GEN-LAST:event_jMenuItemRolesActionPerformed

    private void menuUserGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUserGroupsActionPerformed
       UserGroups _UserGroups=new UserGroups();
       _UserGroups.setVisible(true);
    }//GEN-LAST:event_menuUserGroupsActionPerformed

    private void MenuRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRolesActionPerformed
       UserRoles _UserRoles=new UserRoles();
       _UserRoles.setVisible(true);
    }//GEN-LAST:event_MenuRolesActionPerformed

    private void Users_GroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Users_GroupsActionPerformed
        User_Groups _User_Groups=new User_Groups();
        _User_Groups.setVisible(true);
    }//GEN-LAST:event_Users_GroupsActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Homepage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EmployeeMenuPanel;
    private javax.swing.JMenuItem MenuRoles;
    private javax.swing.JPanel ReportspanelMenu;
    private javax.swing.JPanel SecuritypanelMenu;
    public static javax.swing.JSplitPane SplitPanel;
    private javax.swing.JPanel UsersMenu;
    private javax.swing.JMenuItem Users_Groups;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMSuppliers;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu6Users;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemCompany;
    private javax.swing.JMenuItem jMenuItemCustPayments;
    private javax.swing.JMenuItem jMenuItemCustomers;
    private javax.swing.JMenuItem jMenuItemInvAdjustments;
    private javax.swing.JMenuItem jMenuItemInvIssuing;
    private javax.swing.JMenuItem jMenuItemInvTransfers;
    private javax.swing.JMenuItem jMenuItemInventoryReceipts;
    private javax.swing.JMenuItem jMenuItemInvoiceMatching;
    private javax.swing.JMenuItem jMenuItemOpeningStock;
    private javax.swing.JMenuItem jMenuItemPO;
    private javax.swing.JMenuItem jMenuItemRoles;
    private javax.swing.JMenuItem jMenuItemSuppPayments;
    private javax.swing.JMenuItem jMenuSuppCreditNote;
    private javax.swing.JMenuItem jMenuUsers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem menuSalesOrder;
    private javax.swing.JMenuItem menuUserGroups;
    // End of variables declaration//GEN-END:variables
}
