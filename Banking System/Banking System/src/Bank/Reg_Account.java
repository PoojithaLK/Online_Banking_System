package Bank;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Reg_Account extends javax.swing.JInternalFrame {
    
    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String p4, p2, p3, p1;
    
    int i_no = 0;
    
    public Reg_Account() {
        initComponents();
        
        try {
            
            conn = DatabaseConnection.connectToDb();
            st = (Statement) conn.createStatement();
            UpdateTable();
            GenAccNo();
            nonRUD();
            UpdateCombo();
            UpdateCustomerSSNCombo();
            cmb_branchNo.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    private void clearFields() {
        txt_IntRate.setText("");
        txt_Balance.setText("");
        txt_IntRate.setText("");
        cmb_bankCode.setSelectedIndex(0);
        cmb_branchNo.setSelectedIndex(0);
        cmb_customerSsn.setSelectedIndex(0);
        cmb_type.setSelectedIndex(0);
        GenAccNo();
        nonRUD();
    }
    
    private void UpdateTable() {
        try {
            String sql = "SELECT * FROM account";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            branch_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void UpdateCombo() {
        try {
            String sql = "SELECT * FROM bank";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                cmb_bankCode.addItem(rs.getString("code"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void UpdateBranchNoCombo() {
        cmb_branchNo.removeAllItems();
        cmb_branchNo.addItem("~Select Branch No~");
        try {
            String sql = "SELECT branch_no FROM bank_branch where code='" + cmb_bankCode.getSelectedItem() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                
                cmb_branchNo.addItem(rs.getString("branch_no"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void UpdateCustomerSSNCombo() {
        try {
            String sql = "SELECT ssn FROM customer";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                cmb_customerSsn.addItem(rs.getString("ssn"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void GenAccNo() {
        int num1;
        String q1;
        num1 = 1111 + (int) (Math.random() * 5000);
        q1 = "01110" + num1;
        txt_AccNo.setText(q1);
        txt_AccNo.setEditable(false);
    }
    
    private void RUD() {
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnClear.setEnabled(true);
        btnDelete.setEnabled(true);
        btnView.setEnabled(true);
        cmb_branchNo.setEnabled(false);
    }
    
    private void nonRUD() {
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnClear.setEnabled(false);
        btnDelete.setEnabled(false);
        btnView.setEnabled(false);
        cmb_branchNo.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        branch_table = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txt_IntRate = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_AccNo = new javax.swing.JTextField();
        cmb_bankCode = new javax.swing.JComboBox<>();
        txt_Balance = new javax.swing.JTextField();
        cmb_type = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cmb_branchNo = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cmb_customerSsn = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");
        jButton1.setName("jButton1"); // NOI18N

        setBackground(new java.awt.Color(0, 0, 0));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setName("jPanel3"); // NOI18N

        jPanel4.setBackground(new java.awt.Color(188, 155, 122));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        jPanel4.setName("jPanel4"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        jPanel2.setName("jPanel2"); // NOI18N

        scrollPane1.setName("scrollPane1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        branch_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        branch_table.setName("branch_table"); // NOI18N
        branch_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                branch_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(branch_table);

        scrollPane1.add(jScrollPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ACCOUNT DETAILS");
        jLabel10.setName("jLabel10"); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setName("jPanel5"); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Account No.:");
        jLabel15.setName("jLabel15"); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        txt_IntRate.setName("txt_IntRate"); // NOI18N
        txt_IntRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_IntRateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_IntRateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_IntRateKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Interest Rate:");
        jLabel16.setName("jLabel16"); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Type:");
        jLabel17.setName("jLabel17"); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setName("jPanel1"); // NOI18N

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.setName("btnSave"); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setName("btnUpdate"); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnView.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnView.setText("VIEW");
        btnView.setName("btnView"); // NOI18N
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setText("Clear Field");
        btnClear.setName("btnClear"); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnView)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Bank Code:");
        jLabel18.setName("jLabel18"); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Balance:");
        jLabel19.setName("jLabel19"); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        txt_AccNo.setName("txt_AccNo"); // NOI18N
        txt_AccNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_AccNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_AccNoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_AccNoKeyTyped(evt);
            }
        });

        cmb_bankCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Select Bank Code~" }));
        cmb_bankCode.setName("cmb_bankCode"); // NOI18N
        cmb_bankCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_bankCodeActionPerformed(evt);
            }
        });

        txt_Balance.setName("txt_Balance"); // NOI18N
        txt_Balance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BalanceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BalanceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_BalanceKeyTyped(evt);
            }
        });

        cmb_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Select Type~", "Savings", "Brokerage", "Salary", "Money Market", "Other" }));
        cmb_type.setName("cmb_type"); // NOI18N

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setText("Branch No.:");
        jLabel20.setName("jLabel20"); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        cmb_branchNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Select Branch No~" }));
        cmb_branchNo.setName("cmb_branchNo"); // NOI18N

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setText("Customer SSN.:");
        jLabel21.setName("jLabel21"); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        cmb_customerSsn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Select Customer SSN.:~" }));
        cmb_customerSsn.setName("cmb_customerSsn"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_IntRate)
                    .addComponent(txt_AccNo)
                    .addComponent(cmb_bankCode, 0, 256, Short.MAX_VALUE)
                    .addComponent(txt_Balance)
                    .addComponent(cmb_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_branchNo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_customerSsn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_AccNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txt_Balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txt_IntRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cmb_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(cmb_bankCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cmb_branchNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(cmb_customerSsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(138, 138, 138))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/account-log.png"))); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 345, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void txt_IntRateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IntRateKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IntRateKeyPressed

    private void txt_IntRateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IntRateKeyReleased

    }//GEN-LAST:event_txt_IntRateKeyReleased

    private void txt_IntRateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IntRateKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IntRateKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txt_AccNo.getText().toUpperCase().isEmpty() == true | cmb_bankCode.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Ensure all data is entered!");
        } else {
            try {
                String sql1 = "select * from account where acc_no='" + txt_AccNo.getText().toUpperCase() + "' ";
                pst = conn.prepareStatement(sql1);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Branch Already Registered ");
                } else {
                    String sql2 = "insert into account(acc_no,balance,int_rate,type,b_code,branch_no,cus_ssn)VALUES (?,?,?,?,?,?,?)";
                    pst = conn.prepareStatement(sql2);
                    
                    pst.setString(1, txt_AccNo.getText().toUpperCase());
                    pst.setString(2, txt_Balance.getText().toUpperCase());
                    pst.setString(3, txt_IntRate.getText().toUpperCase());
                    pst.setString(4, cmb_type.getSelectedItem().toString());
                    pst.setString(5, cmb_bankCode.getSelectedItem().toString());
                    pst.setString(6, cmb_branchNo.getSelectedItem().toString());
                    pst.setString(7, cmb_customerSsn.getSelectedItem().toString());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Account Successfully Registered");
                    UpdateTable();
                    clearFields();
                    GenAccNo();
                    RUD();
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
        GenAccNo();
        //RUD();
    }//GEN-LAST:event_btnClearActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int del = JOptionPane.showConfirmDialog(null, "Are you sure to UPDATE?", "Update Account?", JOptionPane.YES_NO_OPTION);
        if (del == 0) {
            
            if (cmb_branchNo.getSelectedIndex() == 0) {
                
            } else {
                try {
                    String sql = "UPDATE account SET acc_no='" + txt_AccNo.getText() + "',balance='" + txt_Balance.getText() + "',int_rate='" + txt_IntRate.getText() + "',type='" + cmb_type.getSelectedItem() + "',b_code='" + cmb_bankCode.getSelectedItem() + "',branch_no='" + cmb_branchNo.getSelectedItem() + "',cus_ssn='" + cmb_customerSsn.getSelectedItem() + "' where acc_no='" + txt_AccNo.getText() + "'";
                    pst = conn.prepareStatement(sql);
                    pst.executeUpdate();
                    UpdateTable();
                    JOptionPane.showMessageDialog(null, "Updated");
                    clearFields();
                    nonRUD();
                } catch (Exception e) {
                } finally {
                    try {
                        pst.close();
                        rs.close();
                    } catch (Exception e) {
                    }
                }
            }
            
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int del = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Delete Bank?", JOptionPane.YES_NO_OPTION);
        if (del == 0) {
            try {
                String sql = "delete from account where branch_no='" + txt_AccNo.getText() + "'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                UpdateTable();
                JOptionPane.showMessageDialog(null, "Deleted");
                clearFields();
                nonRUD();
            } catch (Exception e) {
            } finally {
                try {
                    pst.close();
                    rs.close();
                } catch (Exception e) {
                }
            }
            
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        try {
            String sql = "SELECT * FROM account WHERE acc_no='" + txt_AccNo.getText() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            branch_table.setModel(DbUtils.resultSetToTableModel(rs));
            nonRUD();
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void branch_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_branch_tableMouseClicked
        try {
            int r = branch_table.getSelectedRow();
            int c = branch_table.getSelectedColumn();
            Object s = branch_table.getValueAt(r, 0);
            String NameVal = s.toString();
            String sql = "select * from account where acc_no='" + NameVal + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            txt_Balance.setText(rs.getString("balance"));
            txt_AccNo.setText(rs.getString("acc_no"));
            txt_IntRate.setText(rs.getString("int_rate"));
            cmb_type.setSelectedItem(rs.getString("type"));
            cmb_customerSsn.setSelectedItem(rs.getString("cus_ssn"));
            cmb_bankCode.setSelectedItem(rs.getString("b_code"));  
            RUD();
              
            cmb_branchNo.setEnabled(true);
            cmb_branchNo.setSelectedItem(rs.getString("branch_no"));
            
          
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_branch_tableMouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void txt_AccNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AccNoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AccNoKeyPressed

    private void txt_AccNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AccNoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AccNoKeyReleased

    private void txt_AccNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AccNoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AccNoKeyTyped

    private void txt_BalanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BalanceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BalanceKeyPressed

    private void txt_BalanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BalanceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BalanceKeyReleased

    private void txt_BalanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BalanceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BalanceKeyTyped

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void cmb_bankCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_bankCodeActionPerformed
        UpdateBranchNoCombo();
        cmb_branchNo.setEnabled(true);
    }//GEN-LAST:event_cmb_bankCodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable branch_table;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmb_bankCode;
    private javax.swing.JComboBox<String> cmb_branchNo;
    private javax.swing.JComboBox<String> cmb_customerSsn;
    private javax.swing.JComboBox<String> cmb_type;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTextField txt_AccNo;
    private javax.swing.JTextField txt_Balance;
    private javax.swing.JTextField txt_IntRate;
    // End of variables declaration//GEN-END:variables

}
