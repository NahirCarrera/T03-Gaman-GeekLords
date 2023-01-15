package ec.edu.espe.ehamanagement.view;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.controller.Agenda;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import ec.edu.espe.ehamanagement.model.Order;
/**
 *
 * @author NicolayChillo Gaman GeekLords at DCOO-ESPE
 */
public class PnlAddNewOrder extends javax.swing.JPanel {
    private MongoCollection ordersCollection;
    /**
     * Creates new form PnlNewOrder
     */
    public PnlAddNewOrder() {
        ordersCollection = Agenda.createConnectionToCollection();
        initComponents();
        btnSave.setEnabled(false);
        txtADescription.setLineWrap(true);
        txtADescription.setWrapStyleWord(true);
        
    }
    private void validateFields(){
        if(txtClientName.getText().equals("client's  name"))
        {
            lblTextWarningClient.setText("this area is required");
            pictureWarningClient();
        }else{
            pictureWhiteClient();
            lblTextWarningClient.setText("");
        }
        if(txtDeliveryPlace.getText().equals("216 Newbury Street"))
        {
            lblTextWarningPlace.setText("this area is required");
            pictureWarningPlace();
        }else{
            pictureWhitePlace();
            lblTextWarningPlace.setText("");
        }
        
        if(txtADescription.getText().equals("Product's description"))
        {
            lblTextWarningDes.setText("this area is required");
            pictureWarningDescription();
        }else{
            pictureWhiteDescription();
            lblTextWarningDes.setText("");
        }
        
        if(txtDeliveryPlace.getText().equals("216 Newbury Street")|| txtADescription.getText().equals("Product's description")|| txtADescription.getText().isEmpty()||txtClientName.getText().equals("client's  name")
            || txtDeliveryPlace.getText().isEmpty()|| txtClientName.getText().isEmpty())
        {
            btnSave.setEnabled(false);
        }
        else
        {
            btnSave.setEnabled(true);
        }
    }
    
    private void writeFields(){
        if(txtClientName.getText().isEmpty()){
                txtClientName.setText("client's  name");
                txtClientName.setForeground(Color.gray);
            }
        if(txtDeliveryPlace.getText().isEmpty()){
                txtDeliveryPlace.setText("216 Newbury Street");
                txtDeliveryPlace.setForeground(Color.gray);
               
            }
        if(txtADescription.getText().isEmpty()){
                txtADescription.setText("Product's description");
                txtADescription.setForeground(Color.gray);
                
            }
    }
    
    private void cleanFields(){
        txtClientName.setText("");
        txtDeliveryPlace.setText("");
        txtADescription.setText("");
    }
    
    private void pictureWarningDescription() {
        lblPictureWarningDes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/alert.png"))); // NOI18N
        lblPictureWarningDes.setText("");
    }

    private void pictureWhiteDescription() {
        lblPictureWarningDes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/whiteSeen.png"))); // NOI18N
        lblPictureWarningDes.setText("");
    }
    private void pictureWarningClient() {
        lblPictureWarningClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/alert.png"))); // NOI18N
        lblPictureWarningClient.setText("");
    }

    private void pictureWhiteClient() {
        lblPictureWarningClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/whiteSeen.png"))); // NOI18N
        lblPictureWarningClient.setText("");
    }
    private void pictureWarningPlace() {
        lblPictureWarningPlace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/alert.png"))); // NOI18N
        lblPictureWarningPlace.setText("");
    }

    private void pictureWhitePlace() {
        lblPictureWarningPlace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/whiteSeen.png"))); // NOI18N
        lblPictureWarningPlace.setText("");
    }
    private Order collectInformation(){
        String clientName = txtClientName.getText();
        String deliveryPlace = txtDeliveryPlace.getText();
        String deliveryDate = cbxMonthDelivery.getSelectedItem() + "/" + cbxDayDelivery.getSelectedItem() + "/" + cbxYearDelivery.getSelectedItem();
        String description = txtADescription.getText();
        boolean isDelivered = false;
        Order newOrder =  new Order(0, clientName,  deliveryPlace, deliveryDate, description, isDelivered);
        return newOrder;
    }
    private boolean insertOrder(){
        Order newOrder = collectInformation();
        return Agenda.insertOrder(ordersCollection, newOrder);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtClientName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDeliveryPlace = new javax.swing.JTextField();
        cbxMonthDelivery = new javax.swing.JComboBox<>();
        cbxDayDelivery = new javax.swing.JComboBox<>();
        cbxYearDelivery = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        lblPictureWarningClient = new javax.swing.JLabel();
        lblTextWarningClient = new javax.swing.JLabel();
        lblPictureWarningPlace = new javax.swing.JLabel();
        lblTextWarningPlace = new javax.swing.JLabel();
        lblPictureWarningDes = new javax.swing.JLabel();
        lblTextWarningDes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtADescription = new javax.swing.JTextArea();

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setEnabled(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 410));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setText("New Order");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Client Name");

        txtClientName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtClientName.setText("client's  name");
        txtClientName.setBorder(null);
        txtClientName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtClientNameMousePressed(evt);
            }
        });
        txtClientName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClientNameKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Delivery Place");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Delivery Date");

        txtDeliveryPlace.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDeliveryPlace.setText("216 Newbury Street");
        txtDeliveryPlace.setBorder(null);
        txtDeliveryPlace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDeliveryPlaceMousePressed(evt);
            }
        });
        txtDeliveryPlace.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDeliveryPlaceKeyReleased(evt);
            }
        });

        cbxMonthDelivery.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMonthDelivery.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "Dicember" }));
        cbxMonthDelivery.setBorder(null);
        cbxMonthDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMonthDeliveryActionPerformed(evt);
            }
        });

        cbxDayDelivery.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxDayDelivery.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbxDayDelivery.setBorder(null);

        cbxYearDelivery.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxYearDelivery.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        cbxYearDelivery.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Description:");

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(126, 53, 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/Agenda.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(126, 53, 2));

        btnSave.setBackground(new java.awt.Color(252, 154, 11));
        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        lblTextWarningPlace.setForeground(new java.awt.Color(255, 0, 0));

        lblTextWarningDes.setForeground(new java.awt.Color(255, 0, 0));

        txtADescription.setBackground(new java.awt.Color(255, 255, 255));
        txtADescription.setColumns(20);
        txtADescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtADescription.setRows(5);
        txtADescription.setTabSize(1);
        txtADescription.setText("Product's description");
        txtADescription.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(126, 53, 2), 2, true));
        txtADescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtADescriptionMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtADescription);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtDeliveryPlace)
                                .addComponent(txtClientName)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jSeparator3)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(cbxMonthDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(43, 43, 43)
                                    .addComponent(cbxDayDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxYearDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(77, 77, 77)
                                    .addComponent(jLabel2))
                                .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPictureWarningDes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTextWarningDes, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblPictureWarningClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTextWarningClient, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblPictureWarningPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(lblTextWarningPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTextWarningClient, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(lblPictureWarningClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDeliveryPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPictureWarningPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(lblTextWarningPlace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxMonthDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDayDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxYearDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPictureWarningDes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTextWarningDes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int decision = JOptionPane.showConfirmDialog(this,"Are you sure you want to save this order?", "Save Order", JOptionPane.YES_NO_OPTION);
        switch(decision){
            case 0 -> {
                if(insertOrder()){
                    JOptionPane.showMessageDialog(this,"Your order  has been successfully saved!", "Saved successfully", JOptionPane.INFORMATION_MESSAGE);
                    btnSave.setEnabled(false);
                    cleanFields();
                    writeFields();
                }else{
                    JOptionPane.showMessageDialog(this,"Something went wrong. Failed to save this order", "Saved failed", JOptionPane.ERROR_MESSAGE);
            }  
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtClientNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClientNameKeyTyped
        char character = evt.getKeyChar();
          if (!Character.isLetter(character) && (character != KeyEvent.VK_BACK_SPACE && character != KeyEvent.VK_SPACE)) {
               evt.consume();
                pictureWarningClient();
                lblTextWarningClient.setText(character + " is not accepted here!");

            } else {
                lblTextWarningClient.setText("");
                pictureWhiteClient();
            }
    }//GEN-LAST:event_txtClientNameKeyTyped

    private void txtDeliveryPlaceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDeliveryPlaceKeyReleased
    if (txtClientName.getText().isEmpty()) {
            lblTextWarningClient.setText("this area is required");
            pictureWarningClient();
        } 
        validateFields();
    }//GEN-LAST:event_txtDeliveryPlaceKeyReleased

    private void txtClientNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClientNameMousePressed
        writeFields();
        if(txtClientName.getText().equals("client's  name"))
        {
            txtClientName.setText("");
            txtClientName.setForeground(Color.black);

        }
        
        validateFields();
    }//GEN-LAST:event_txtClientNameMousePressed

    private void txtDeliveryPlaceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDeliveryPlaceMousePressed
        writeFields();
        if(txtDeliveryPlace.getText().equals("216 Newbury Street"))
        {
            txtDeliveryPlace.setText("");
            txtDeliveryPlace.setForeground(Color.black);

        }
        
        validateFields();
    }//GEN-LAST:event_txtDeliveryPlaceMousePressed

    private void txtADescriptionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtADescriptionMousePressed
        writeFields();
        if(txtADescription.getText().equals("Product's description"))
        {
            txtADescription.setText("");
            txtADescription.setForeground(Color.black);

        }  
        
        validateFields();
    }//GEN-LAST:event_txtADescriptionMousePressed

    private void cbxMonthDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMonthDeliveryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMonthDeliveryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbxDayDelivery;
    private javax.swing.JComboBox<String> cbxMonthDelivery;
    private javax.swing.JComboBox<String> cbxYearDelivery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblPictureWarningClient;
    private javax.swing.JLabel lblPictureWarningDes;
    private javax.swing.JLabel lblPictureWarningPlace;
    private javax.swing.JLabel lblTextWarningClient;
    private javax.swing.JLabel lblTextWarningDes;
    private javax.swing.JLabel lblTextWarningPlace;
    private javax.swing.JTextArea txtADescription;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JTextField txtDeliveryPlace;
    // End of variables declaration//GEN-END:variables
}
