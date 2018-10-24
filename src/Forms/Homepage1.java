
package Forms;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Homepage1 extends javax.swing.JFrame  {

    
    public Homepage1() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        
    }

  
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
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6Users = new javax.swing.JMenu();
        jMenuUsers = new javax.swing.JMenuItem();
        jMSuppliers = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
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

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Purchase_Order_20px.png"))); // NOI18N
        jMenuItem3.setText("Purchase Orders");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Invoice_20px.png"))); // NOI18N
        jMenuItem6.setText("Invoice Matching");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Waiter_20px.png"))); // NOI18N
        jMenuItem5.setText("Inventory Receipts");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Coins_20px_1.png"))); // NOI18N
        jMenuItem7.setText("Supplier Payments");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Downloads_Folder_40px.png"))); // NOI18N
        jMenu2.setText("Invenoty Management               ");

        jMenuItem10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Open_Sign_40px.png"))); // NOI18N
        jMenuItem10.setText("Opening Stock");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Drag_Reorder_30px.png"))); // NOI18N
        jMenuItem2.setText("Inventory Adjustments");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Sell_40px_1.png"))); // NOI18N
        jMenuItem8.setText("Inventory Issuing");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Exchange_40px.png"))); // NOI18N
        jMenuItem9.setText("Inventory Transfers");
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Trolley_40px.png"))); // NOI18N
        jMenu5.setText("Sales         ");
        jMenuBar1.add(jMenu5);

        jMenu6Users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Settings_40px.png"))); // NOI18N
        jMenu6Users.setText("Setups           ");

        jMenuUsers.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_User_40px.png"))); // NOI18N
        jMenuUsers.setText("Users");
        jMenuUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsersActionPerformed(evt);
            }
        });
        jMenu6Users.add(jMenuUsers);

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

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Money_Pound_40px.png"))); // NOI18N
        jMenuItem4.setText("Supplier CreditNote");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6Users.add(jMenuItem4);

        jMenuItem11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem11.setText("Company");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6Users.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem12.setText("Customers");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6Users.add(jMenuItem12);

        jMenuBar1.add(jMenu6Users);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Edit_Property_40px.png"))); // NOI18N
        jMenu7.setText("Reports and Inquiries");
        jMenuBar1.add(jMenu7);

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
        _Master.show();
       

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        PurchaseOrders po = new PurchaseOrders(); 
        po.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSuppliersActionPerformed
        // TODO add your handling code here:
        sUppliers _supp=new sUppliers();
        _supp.show();
    }//GEN-LAST:event_jMSuppliersActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        InventoryReceipts _InventoryReceipts=new InventoryReceipts();
        _InventoryReceipts.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsersActionPerformed
        // TODO add your handling code here:
        Users _users=new Users();
        _users.show();
    }//GEN-LAST:event_jMenuUsersActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        InvoiceMatching _InvoiceMatching=new InvoiceMatching();
        _InvoiceMatching.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        SupplierPayments _SupplierPayments =new SupplierPayments();
        _SupplierPayments.show();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
      CreditNotes _notes=new CreditNotes();
      _notes.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        OpeningStock _OpeningStock=new OpeningStock();
        _OpeningStock.show();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        InventoryAdjustment _InventoryAdjustment=new InventoryAdjustment();
        _InventoryAdjustment.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Inventoryisuing _Inventoryisuing=new Inventoryisuing();
        _Inventoryisuing.show();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        Login _log=new Login();
        _log.setVisible(true);
        dispose();
        //System.exit(0);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Company _Company=new Company();
        _Company.show();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
       Customers _Customers=new Customers();
       _Customers.show();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

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
    private javax.swing.JPanel ReportspanelMenu;
    private javax.swing.JPanel SecuritypanelMenu;
    public static javax.swing.JSplitPane SplitPanel;
    private javax.swing.JPanel UsersMenu;
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
    private javax.swing.JMenu jMenu6Users;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuUsers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
