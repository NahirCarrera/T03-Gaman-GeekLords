package ec.edu.espe.ehamanagement.view;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.controller.MaterialsOrganizer;
import ec.edu.espe.ehamanagement.model.Material;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.CostsCalculator;

/**
 *
 * @author Jairo Bonilla & Nahir Carrera, Gaman GeekLords, DCCO-ESPE
 */
public class PnlOrganizerAddNewMaterial extends javax.swing.JPanel {
    private final MongoCollection materialsCollection;
    /**
     * Creates new form PnlAddProductInventor
     * @param collection
     */
    public PnlOrganizerAddNewMaterial(MongoCollection collection) {
        materialsCollection = collection;
        initComponents();
        validateFields();
        
    }

    private boolean addMaterial(){
        Material materialToAdd = createMaterialToAdd();
        return MaterialsOrganizer.insertMaterial(materialsCollection,materialToAdd);
    }
    
    private Material createMaterialToAdd(){
        String name = txtMaterialName.getText();
        float generalCost = Float.valueOf(String.valueOf(txtGeneralCost.getText()));
        float generalQuantity = Float.valueOf(String.valueOf(spnrQuantity.getValue()));
        Material materialToAdd;
        materialToAdd = new Material(0, name, generalQuantity, generalCost,0.0F );
        CostsCalculator calculator = new CostsCalculator();
        float cost = calculator.computeMaterialUnitCost(materialToAdd);
        materialToAdd.setUnitCost(cost);
        return materialToAdd;
    }

     
     
    public void validateFields() {
        if (txtMaterialName.getText().isEmpty()|| txtMaterialName.getText().equals("Material Name")) {
            lblTextWarning.setText("This fields is required");
            pictureWarningProduct();
        } else {
            lblTextWarning.setText("");
            pictureWhiteProduct();
        }
        if (txtGeneralCost.getText().isEmpty()|| txtGeneralCost.getText().equals("0.00")) {
            lblTextGeneralCost.setText("This fields is required");
            pictureWarningGeneralCost();
        } else {
            lblTextGeneralCost.setText("");
            pictureWhiteGeneralCost();
        }
        if(txtMaterialName.getText().isEmpty()|| txtMaterialName.getText().equals("Material Name")||txtGeneralCost.getText().isEmpty()|| txtGeneralCost.getText().equals("0.00"))
        {
            btnSave.setEnabled(false);
        }
        else
        {
            btnSave.setEnabled(true);
        }
    }
    
    private void cleanFields(){
        txtMaterialName.setText("");
        spnrQuantity.setValue(0.1);
        txtGeneralCost.setText("");
    }
    
    public void pictureWarningProduct() {
        lblPictureWarning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/alert.png")));

        lblPictureWarning.setText("");

    }
     private void pictureWarningGeneralCost() {
        lblPicturGeneralCost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/alert.png"))); // NOI18N
        lblPictureWarning.setText("");
    }

    private void pictureWhiteGeneralCost() {
        lblPicturGeneralCost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/whiteSeen.png"))); // NOI18N
        lblPictureWarning.setText("");
    }

    public void pictureWhiteProduct() {
        lblPictureWarning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/whiteSeen.png"))); // NOI18N
        lblPictureWarning.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spnrQuantity = new javax.swing.JSpinner();
        txtMaterialName = new javax.swing.JTextField();
        lblPictureWarning = new javax.swing.JLabel();
        lblTextWarning = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtGeneralCost = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblPicturGeneralCost = new javax.swing.JLabel();
        lblTextGeneralCost = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel3.setText("Quantity");

        spnrQuantity.setModel(new javax.swing.SpinnerNumberModel(0.1f, 0.1f, null, 0.1f));
        spnrQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtMaterialName.setBackground(new java.awt.Color(255, 255, 255));
        txtMaterialName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaterialName.setText("Material Name");
        txtMaterialName.setBorder(null);
        txtMaterialName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMaterialNameMousePressed(evt);
            }
        });
        txtMaterialName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaterialNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaterialNameKeyTyped(evt);
            }
        });

        lblTextWarning.setForeground(new java.awt.Color(255, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setText("General Cost");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel6.setText("$");

        txtGeneralCost.setBackground(new java.awt.Color(255, 255, 255));
        txtGeneralCost.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtGeneralCost.setText("0.00");
        txtGeneralCost.setBorder(null);
        txtGeneralCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtGeneralCostMousePressed(evt);
            }
        });
        txtGeneralCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGeneralCostKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGeneralCostKeyTyped(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        lblTextGeneralCost.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(110, 110, 110))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(spnrQuantity)
                            .addGap(96, 96, 96)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMaterialName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPictureWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblTextWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGeneralCost, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblPicturGeneralCost, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTextGeneralCost, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaterialName, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(lblPictureWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTextWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnrQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtGeneralCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPicturGeneralCost, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTextGeneralCost, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(131, 131, 131))
        );

        jPanel2.setBackground(new java.awt.Color(52, 122, 52));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("New Material");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/materials.png"))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(52, 122, 52));

        btnSave.setBackground(new java.awt.Color(112, 172, 61));
        btnSave.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setBorder(null);
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaterialNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaterialNameMousePressed
        if(txtMaterialName.getText().equals("Material Name"))
        {
           txtMaterialName.setText(""); 
        }
        if(txtGeneralCost.getText().isEmpty())
        {
                txtGeneralCost.setText("0.00");
        } 
    }//GEN-LAST:event_txtMaterialNameMousePressed

    private void txtMaterialNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaterialNameKeyReleased

    }//GEN-LAST:event_txtMaterialNameKeyReleased

    private void txtMaterialNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaterialNameKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE)) {
            //getToolkit().beep();
            evt.consume();
            pictureWarningProduct();
            lblTextWarning.setText(c + " is not accepted here!");

        } else {
            lblTextWarning.setText("");
            pictureWhiteProduct();
        }
        
    }//GEN-LAST:event_txtMaterialNameKeyTyped

    private void txtGeneralCostMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGeneralCostMousePressed
        if(txtGeneralCost.getText().equals("0.00"))
        {
            txtGeneralCost.setText("");
        }
            
           if(txtMaterialName.getText().isEmpty())
            {
                txtMaterialName.setText("Material Name");
            } 
           validateFields();
    }//GEN-LAST:event_txtGeneralCostMousePressed

    private void txtGeneralCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGeneralCostKeyTyped
        char character = evt.getKeyChar();
        if (!Character.isDigit(character) && (character != KeyEvent.VK_BACK_SPACE) &&(character != KeyEvent.VK_PERIOD)) {
            evt.consume();
            pictureWarningGeneralCost();
            lblTextGeneralCost.setText(character + " is not accepted here!");
        } else {

            lblTextGeneralCost.setText("");
            pictureWhiteGeneralCost();
        }
    }//GEN-LAST:event_txtGeneralCostKeyTyped

    private void txtGeneralCostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGeneralCostKeyReleased
        validateFields();
    }//GEN-LAST:event_txtGeneralCostKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int decision = JOptionPane.showConfirmDialog(this,"Are you sure you want to save thismaterial?", "Add Material", JOptionPane.YES_NO_OPTION);
            switch(decision){
                case 0 -> {
            try {
                if(addMaterial()){
                    btnSave.setEnabled(false);
                    JOptionPane.showMessageDialog(this, "Your material has been successfully saved!", "Added successfully to your Organizer", JOptionPane.INFORMATION_MESSAGE);
                    cleanFields();
                } else{
                    JOptionPane.showMessageDialog(this, "Something went wrong. Failed to save this material", "Saved failed", JOptionPane.ERROR_MESSAGE);        
                }
            } catch (ParseException ex) {
                Logger.getLogger(PnlOrganizerAddNewMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
                }

            }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked

    }//GEN-LAST:event_btnSaveMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblPicturGeneralCost;
    private javax.swing.JLabel lblPictureWarning;
    private javax.swing.JLabel lblTextGeneralCost;
    private javax.swing.JLabel lblTextWarning;
    private javax.swing.JSpinner spnrQuantity;
    private javax.swing.JTextField txtGeneralCost;
    private javax.swing.JTextField txtMaterialName;
    // End of variables declaration//GEN-END:variables
}
