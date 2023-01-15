package ec.edu.espe.ehamanagement.view;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NicolayChillo Gaman GeekLords at DCOO-ESPE
 */
public class PnlOrdersTable extends javax.swing.JPanel {

    DefaultTableModel model;

    /**
     * Creates new form PnlTableAllOrders
     */
    public PnlOrdersTable() {
        initComponents();

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Client Name");
        model.addColumn("Delivery Date");
        model.addColumn("Delivered");
        this.tblAllOrders.setModel(model);
        refreshInfo();
        txtSearch.setEnabled(true);
        btnSearch.setEnabled(false);
    }

    public void validateDates() {

        if (!txtSearch.getText().isEmpty() && !txtSearch.getText().equals("Search...")) {
            btnSearch.setEnabled(true);
        } else {
            btnSearch.setEnabled(false);
        }
    }

    private void pictureWarningSearch() {
        lblPictureWarning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/alert.png"))); // NOI18N
        lblPictureWarning.setText("");
    }

    public void pictureWhiteSearch() {
        lblPictureWarning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/picture1.png"))); // NOI18N
        lblPictureWarning.setText("");
    }

    private void cleanTable() {
        int row = tblAllOrders.getRowCount();
        for (int i = row - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void initPnlOrderInformation() {
        PnlOrderInformation pnlOrderInformation = new PnlOrderInformation();
        pnlOrderInformation.setSize(714, 523);
        pnlOrderInformation.setLocation(0, 0);
        pnlTable.removeAll();
        pnlTable.add(pnlOrderInformation, pnlOrderInformation);
        pnlTable.revalidate();
        pnlTable.repaint();
    }

    private void refreshInfo() {
        String[] information1 = new String[4];
        information1[0] = "1";
        information1[1] = "Client 1 Name";
        information1[2] = "12/02/23";
        information1[3] = "No";
        String[] information2 = new String[4];
        information2[0] = "2";
        information2[1] = "Client 2 Name";
        information2[2] = "13/03/23";
        information2[3] = "Yes";
        if (rbtnAllOrders.isSelected()) {
            cleanTable();
            lblTableTitle.setText("All Orders");
            model.addRow(information1);
            model.addRow(information2);
        } else if (rbtnDeliveredOrders.isSelected()) {
            lblTableTitle.setText("Delivered Orders");
            cleanTable();
            model.addRow(information2);
        } else if (rbtnPendingOrders.isSelected()) {
            lblTableTitle.setText("Pending Orders");
            cleanTable();
            model.addRow(information1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        PnlWindow = new javax.swing.JPanel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnlTable = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllOrders = new javax.swing.JTable();
        lblTableTitle = new javax.swing.JLabel();
        rbtnAllOrders = new javax.swing.JRadioButton();
        rbtnPendingOrders = new javax.swing.JRadioButton();
        rbtnDeliveredOrders = new javax.swing.JRadioButton();
        btnRefresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rbtnByID = new javax.swing.JRadioButton();
        rbtnByName = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        lblPictureWarning = new javax.swing.JLabel();
        lblTextWarning = new javax.swing.JLabel();

        PnlWindow.setBackground(new java.awt.Color(255, 255, 255));
        PnlWindow.setPreferredSize(new java.awt.Dimension(450, 650));

        javax.swing.GroupLayout PnlWindowLayout = new javax.swing.GroupLayout(PnlWindow);
        PnlWindow.setLayout(PnlWindowLayout);
        PnlWindowLayout.setHorizontalGroup(
            PnlWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PnlWindowLayout.setVerticalGroup(
            PnlWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));
        pnlTable.setPreferredSize(new java.awt.Dimension(900, 500));

        tblAllOrders.setBackground(new java.awt.Color(255, 215, 95));
        tblAllOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblAllOrders);

        lblTableTitle.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblTableTitle.setText("All Orders");

        rbtnAllOrders.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnAllOrders);
        rbtnAllOrders.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbtnAllOrders.setSelected(true);
        rbtnAllOrders.setText("All Orders");

        rbtnPendingOrders.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnPendingOrders);
        rbtnPendingOrders.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbtnPendingOrders.setText("Pending Orders");

        rbtnDeliveredOrders.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnDeliveredOrders);
        rbtnDeliveredOrders.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbtnDeliveredOrders.setText("Delivered Orders");

        btnRefresh.setBackground(new java.awt.Color(252, 154, 11));
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Search Order");

        rbtnByID.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rbtnByID);
        rbtnByID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnByID.setSelected(true);
        rbtnByID.setText("By ID");
        rbtnByID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnByIDMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnByIDMousePressed(evt);
            }
        });
        rbtnByID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rbtnByIDKeyReleased(evt);
            }
        });

        rbtnByName.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rbtnByName);
        rbtnByName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnByName.setText("ByName");
        rbtnByName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnByNameMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnByNameMousePressed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnSearch.setBackground(new java.awt.Color(252, 154, 11));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.setText("Search...");
        txtSearch.setBorder(null);
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtSearchMousePressed(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(rbtnAllOrders)
                        .addGap(28, 28, 28)
                        .addComponent(rbtnPendingOrders)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnDeliveredOrders)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(lblTableTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnByID)
                            .addComponent(rbtnByName))
                        .addGap(39, 39, 39)
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPictureWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTextWarning, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTableTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnAllOrders)
                    .addComponent(rbtnPendingOrders)
                    .addComponent(rbtnDeliveredOrders)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGap(17, 17, Short.MAX_VALUE)
                        .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlTableLayout.createSequentialGroup()
                                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlTableLayout.createSequentialGroup()
                                        .addComponent(rbtnByID)
                                        .addGap(17, 17, 17)
                                        .addComponent(rbtnByName))
                                    .addGroup(pnlTableLayout.createSequentialGroup()
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)))
                                .addGap(0, 36, Short.MAX_VALUE))
                            .addGroup(pnlTableLayout.createSequentialGroup()
                                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPictureWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTextWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshInfo();

    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (rbtnByID.isSelected() && txtSearch.getText().equals("1")) {
            initPnlOrderInformation();
        } else if (rbtnByName.isSelected() && txtSearch.getText().equals("order 1")) {
            initPnlOrderInformation();
        } else {
            JOptionPane.showMessageDialog(this, "Order not found", "Search failed", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMousePressed
        if (txtSearch.getText().equals("Search...")) {
            txtSearch.setText("");
        }


    }//GEN-LAST:event_txtSearchMousePressed

    private void rbtnByIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnByIDMousePressed
        txtSearch.setText("Search...");
        if (txtSearch.getText().isEmpty()) {
            txtSearch.setText("Search...");
        }
    }//GEN-LAST:event_rbtnByIDMousePressed

    private void rbtnByNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnByNameMousePressed
        txtSearch.setText("Search...");
        if (txtSearch.getText().isEmpty()) {
            txtSearch.setText("Search...");
        }
    }//GEN-LAST:event_rbtnByNameMousePressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        validateDates();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked

    }//GEN-LAST:event_btnSearchMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        char character = evt.getKeyChar();
        if (txtSearch.getText().equals("Search...")) {
            lblTextWarning.setText(" requiered to search");
            pictureWarningSearch();
        }else{
            if (rbtnByName.isSelected() && !Character.isLetter(character) && (character != KeyEvent.VK_BACK_SPACE && character != KeyEvent.VK_SPACE)) 
            {
                evt.consume();
                pictureWarningSearch();
                lblTextWarning.setText(character + " is not accepted here!");
            }else{
                if (rbtnByID.isSelected() && !Character.isDigit(character) && (character != KeyEvent.VK_BACK_SPACE )) {
                    evt.consume();
                    pictureWarningSearch();
                    lblTextWarning.setText(character + " is not accepted here!");
                }else{

                    lblTextWarning.setText("");
                    pictureWhiteSearch();

                }
            }
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void rbtnByIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbtnByIDKeyReleased

    }//GEN-LAST:event_rbtnByIDKeyReleased

    private void rbtnByIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnByIDMouseClicked
        txtSearch.setText("Search...");
        if (txtSearch.getText().equals("Search...")||txtSearch.getText().equals("")) {
            lblTextWarning.setText(" requiered to search");
            pictureWarningSearch();
        } else {
            lblTextWarning.setText("");
        }
    }//GEN-LAST:event_rbtnByIDMouseClicked

    private void rbtnByNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnByNameMouseClicked
        txtSearch.setText("Search...");
        if (txtSearch.getText().equals("Search...")) {
            lblTextWarning.setText(" requiered to search");
            pictureWarningSearch();
        } else {
            lblTextWarning.setText("");
        }
    }//GEN-LAST:event_rbtnByNameMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlWindow;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblPictureWarning;
    private javax.swing.JLabel lblTableTitle;
    private javax.swing.JLabel lblTextWarning;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JRadioButton rbtnAllOrders;
    private javax.swing.JRadioButton rbtnByID;
    private javax.swing.JRadioButton rbtnByName;
    private javax.swing.JRadioButton rbtnDeliveredOrders;
    private javax.swing.JRadioButton rbtnPendingOrders;
    private javax.swing.JTable tblAllOrders;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
