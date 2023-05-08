package Bank;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Transfer_Money extends javax.swing.JInternalFrame {

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String p4, p2, p3, p1;

    int i_no = 0;

    public Transfer_Money() {
        initComponents();

        try {

            conn = DatabaseConnection.connectToDb();
            st = (Statement) conn.createStatement();
            UpdateCombo();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void clearFields() {

        txt_SenderName.setText("");
        txt_SenderBalance.setText("");
        txt_AmountToTransfer.setText("");
        txt_SenderNewBalance.setText("");
        txt_ReceiverName.setText("");
        txt_ReceiverBalance.setText("");
        txt_ReceiverNewBalance.setText("");
    }

    private void UpdateCombo() {
        try {
            String sql = "SELECT * FROM bank";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                cmb_bankcode.addItem(rs.getString("code"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Branch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void UpdateBranchNoCombo() {
        cmb_branchNo.removeAllItems();
        cmb_branchNo.addItem("~Select Branch No~");
        try {
            String sql = "SELECT branch_no FROM bank_branch where code='" + cmb_bankcode.getSelectedItem() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                cmb_branchNo.addItem(rs.getString("branch_no"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void UpdateAccNoCombo() {
        cmb_ReceiverAccount.removeAllItems();
        cmb_ReceiverAccount.addItem("~Select Account No~");
        cmb_AccTransferFrom.removeAllItems();
        cmb_AccTransferFrom.addItem("~Select Account No~");
        try {
            String sql = "SELECT acc_no FROM account where branch_no='" + cmb_branchNo.getSelectedItem() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                cmb_AccTransferFrom.addItem(rs.getString("acc_no"));
                cmb_ReceiverAccount.addItem(rs.getString("acc_no"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void UpdateAccountName() {

        try {
            String sql = "SELECT a.balance,b.name  FROM account as a JOIN Customer as b ON a.cus_ssn=b.ssn where acc_no='" + cmb_AccTransferFrom.getSelectedItem() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                txt_SenderName.setText(rs.getString("b.name"));
                txt_SenderBalance.setText(rs.getString("a.balance"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void UpdateAccountNameReceiver() {

        try {
            String sql = "SELECT a.balance,b.name  FROM account as a JOIN Customer as b ON a.cus_ssn=b.ssn where acc_no='" + cmb_ReceiverAccount.getSelectedItem() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                txt_ReceiverName.setText(rs.getString("b.name"));
                txt_ReceiverBalance.setText(rs.getString("a.balance"));

                int bal = Integer.parseInt(rs.getString("a.balance"));
                int AmountReceived = Integer.parseInt(txt_AmountToTransfer.getText());

                bal += AmountReceived;
                txt_ReceiverNewBalance.setText("" + bal);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Reg_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        cmb_bankcode = new javax.swing.JComboBox<>();
        cmb_branchNo = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cmb_ReceiverAccount = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txt_ReceiverName = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_ReceiverBalance = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_ReceiverNewBalance = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        cmb_AccTransferFrom = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txt_SenderName = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_SenderBalance = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_AmountToTransfer = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_SenderNewBalance = new javax.swing.JTextField();
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

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TRANSFER MONEY");
        jLabel10.setName("jLabel10"); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setName("jPanel5"); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Bank Code:");
        jLabel15.setName("jLabel15"); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Branch No.:");
        jLabel16.setName("jLabel16"); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setName("jPanel1"); // NOI18N

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("TRANSFER");
        btnSave.setName("btnSave"); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
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
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        cmb_bankcode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Select Bank Code~" }));
        cmb_bankcode.setName("cmb_bankcode"); // NOI18N
        cmb_bankcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_bankcodeActionPerformed(evt);
            }
        });

        cmb_branchNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Select Branch No~" }));
        cmb_branchNo.setName("cmb_branchNo"); // NOI18N
        cmb_branchNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_branchNoActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sender Account", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel7.setName("jPanel7"); // NOI18N

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Account No. to Transfer To:");
        jLabel17.setName("jLabel17"); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        cmb_ReceiverAccount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Select Account No.~" }));
        cmb_ReceiverAccount.setName("cmb_ReceiverAccount"); // NOI18N
        cmb_ReceiverAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_ReceiverAccountActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Account Name:");
        jLabel18.setName("jLabel18"); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        txt_ReceiverName.setEditable(false);
        txt_ReceiverName.setName("txt_ReceiverName"); // NOI18N
        txt_ReceiverName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ReceiverNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ReceiverNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ReceiverNameKeyTyped(evt);
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

        txt_ReceiverBalance.setEditable(false);
        txt_ReceiverBalance.setName("txt_ReceiverBalance"); // NOI18N
        txt_ReceiverBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ReceiverBalanceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ReceiverBalanceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ReceiverBalanceKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setText("New Balance:");
        jLabel21.setName("jLabel21"); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        txt_ReceiverNewBalance.setEditable(false);
        txt_ReceiverNewBalance.setName("txt_ReceiverNewBalance"); // NOI18N
        txt_ReceiverNewBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ReceiverNewBalanceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ReceiverNewBalanceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ReceiverNewBalanceKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ReceiverNewBalance)
                    .addComponent(txt_ReceiverBalance)
                    .addComponent(txt_ReceiverName)
                    .addComponent(cmb_ReceiverAccount, 0, 198, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cmb_ReceiverAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_ReceiverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_ReceiverBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_ReceiverNewBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sender Account", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel8.setName("jPanel8"); // NOI18N

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setText("Account No. to Transfer From:");
        jLabel22.setName("jLabel22"); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        cmb_AccTransferFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "~Select Account No.~" }));
        cmb_AccTransferFrom.setName("cmb_AccTransferFrom"); // NOI18N
        cmb_AccTransferFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_AccTransferFromActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setText("Account Name:");
        jLabel23.setName("jLabel23"); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        txt_SenderName.setEditable(false);
        txt_SenderName.setName("txt_SenderName"); // NOI18N
        txt_SenderName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_SenderNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SenderNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SenderNameKeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setText("Balance:");
        jLabel24.setName("jLabel24"); // NOI18N
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        txt_SenderBalance.setEditable(false);
        txt_SenderBalance.setName("txt_SenderBalance"); // NOI18N
        txt_SenderBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SenderBalanceActionPerformed(evt);
            }
        });
        txt_SenderBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_SenderBalanceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SenderBalanceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SenderBalanceKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setText("Amount to Transfer:");
        jLabel25.setName("jLabel25"); // NOI18N
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        txt_AmountToTransfer.setName("txt_AmountToTransfer"); // NOI18N
        txt_AmountToTransfer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_AmountToTransferKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_AmountToTransferKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_AmountToTransferKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setText("New Balance:");
        jLabel26.setName("jLabel26"); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        txt_SenderNewBalance.setEditable(false);
        txt_SenderNewBalance.setName("txt_SenderNewBalance"); // NOI18N
        txt_SenderNewBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_SenderNewBalanceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SenderNewBalanceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SenderNewBalanceKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_AccTransferFrom, 0, 198, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(154, 154, 154)
                        .addComponent(txt_SenderBalance))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_AmountToTransfer)
                            .addComponent(txt_SenderNewBalance))))
                .addGap(12, 12, 12))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addGap(113, 113, 113)
                .addComponent(txt_SenderName)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cmb_AccTransferFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txt_SenderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txt_SenderBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txt_AmountToTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txt_SenderNewBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGap(134, 134, 134)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_bankcode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_branchNo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cmb_bankcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cmb_branchNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(120, 120, 120))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cash-logo.png"))); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int bal = Integer.parseInt(txt_SenderBalance.getText());
        int AmountTransf = Integer.parseInt(txt_AmountToTransfer.getText());

        if (txt_ReceiverNewBalance.getText().toUpperCase().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Make sure every data is entered!");
        } else if (AmountTransf>bal) {
            JOptionPane.showMessageDialog(null, "Sorry You have Insuffiecient Balance To Transfer!");
        } else {
            int del = JOptionPane.showConfirmDialog(null, "Are you sure to TRANSFER?", "TRANSFER MONEY?", JOptionPane.YES_NO_OPTION);
            if (del == 0) {
                try {
                    String sql = "UPDATE account SET balance='" + txt_SenderNewBalance.getText() + "' where acc_no='" + cmb_AccTransferFrom.getSelectedItem() + "'";
                    pst = conn.prepareStatement(sql);
                    pst.executeUpdate();
                    String sql1 = "UPDATE account SET balance='" + txt_ReceiverNewBalance.getText() + "' where acc_no='" + cmb_ReceiverAccount.getSelectedItem() + "'";
                    pst = conn.prepareStatement(sql1);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Transferred");
                    clearFields();
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
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();

    }//GEN-LAST:event_btnClearActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void txt_ReceiverBalanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ReceiverBalanceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ReceiverBalanceKeyPressed

    private void txt_ReceiverBalanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ReceiverBalanceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ReceiverBalanceKeyReleased

    private void txt_ReceiverBalanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ReceiverBalanceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ReceiverBalanceKeyTyped

    private void txt_ReceiverNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ReceiverNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ReceiverNameKeyPressed

    private void txt_ReceiverNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ReceiverNameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ReceiverNameKeyReleased

    private void txt_ReceiverNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ReceiverNameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ReceiverNameKeyTyped

    private void txt_ReceiverNewBalanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ReceiverNewBalanceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ReceiverNewBalanceKeyPressed

    private void txt_ReceiverNewBalanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ReceiverNewBalanceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ReceiverNewBalanceKeyReleased

    private void txt_ReceiverNewBalanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ReceiverNewBalanceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ReceiverNewBalanceKeyTyped

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void txt_SenderNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SenderNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SenderNameKeyPressed

    private void txt_SenderNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SenderNameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SenderNameKeyReleased

    private void txt_SenderNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SenderNameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SenderNameKeyTyped

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void txt_SenderBalanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SenderBalanceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SenderBalanceKeyPressed

    private void txt_SenderBalanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SenderBalanceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SenderBalanceKeyReleased

    private void txt_SenderBalanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SenderBalanceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SenderBalanceKeyTyped

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void txt_AmountToTransferKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AmountToTransferKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AmountToTransferKeyPressed

    private void txt_AmountToTransferKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AmountToTransferKeyReleased
        int bal = Integer.parseInt(txt_SenderBalance.getText());
        int AmountTrans = Integer.parseInt(txt_AmountToTransfer.getText());

        bal -= AmountTrans;
        txt_SenderNewBalance.setText("" + bal);


    }//GEN-LAST:event_txt_AmountToTransferKeyReleased

    private void txt_AmountToTransferKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AmountToTransferKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AmountToTransferKeyTyped

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void txt_SenderNewBalanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SenderNewBalanceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SenderNewBalanceKeyPressed

    private void txt_SenderNewBalanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SenderNewBalanceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SenderNewBalanceKeyReleased

    private void txt_SenderNewBalanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SenderNewBalanceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SenderNewBalanceKeyTyped

    private void cmb_bankcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_bankcodeActionPerformed
        UpdateBranchNoCombo();
    }//GEN-LAST:event_cmb_bankcodeActionPerformed

    private void cmb_branchNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_branchNoActionPerformed
        UpdateAccNoCombo();
    }//GEN-LAST:event_cmb_branchNoActionPerformed

    private void txt_SenderBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SenderBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SenderBalanceActionPerformed

    private void cmb_AccTransferFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_AccTransferFromActionPerformed
        UpdateAccountName();
    }//GEN-LAST:event_cmb_AccTransferFromActionPerformed

    private void cmb_ReceiverAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_ReceiverAccountActionPerformed
        UpdateAccountNameReceiver();
    }//GEN-LAST:event_cmb_ReceiverAccountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmb_AccTransferFrom;
    private javax.swing.JComboBox<String> cmb_ReceiverAccount;
    private javax.swing.JComboBox<String> cmb_bankcode;
    private javax.swing.JComboBox<String> cmb_branchNo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField txt_AmountToTransfer;
    private javax.swing.JTextField txt_ReceiverBalance;
    private javax.swing.JTextField txt_ReceiverName;
    private javax.swing.JTextField txt_ReceiverNewBalance;
    private javax.swing.JTextField txt_SenderBalance;
    private javax.swing.JTextField txt_SenderName;
    private javax.swing.JTextField txt_SenderNewBalance;
    // End of variables declaration//GEN-END:variables

}
