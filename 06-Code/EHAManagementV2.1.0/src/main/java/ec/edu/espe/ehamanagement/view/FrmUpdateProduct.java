package ec.edu.espe.ehamanagement.view;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.controller.Inventory;
import ec.edu.espe.ehamanagement.model.Product;
import ec.edu.espe.mongodbmanager.MongoDbManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.CostCalculator;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class FrmUpdateProduct extends javax.swing.JFrame {
    DefaultTableModel model;
    int idToUpdate;
    MongoCollection productsCollection;
    MongoCollection materialsCollection;
    /**
     * Creates new form frmProduct
     */
    public FrmUpdateProduct() {
        initComponents();
        String uri = "mongodb+srv://oop:oop@cluster0.og4urrq.mongodb.net/?retryWrites=true&w=majority";
        String dataBase = "ManagementSoftware";
        String pCollection = "Products";
        String mCollection = "Materials";
        productsCollection = MongoDbManager.connectToCollection(uri, dataBase, pCollection);
        materialsCollection = MongoDbManager.connectToCollection(uri, dataBase, mCollection);
        
        model =  new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Material");
        model.addColumn("Quantity");
        this.tblMaterials.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        pnlInput = new javax.swing.JPanel();
        lblProduct = new javax.swing.JLabel();
        lblText = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        spnrQuantity = new javax.swing.JSpinner();
        lblDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtADescription = new javax.swing.JTextArea();
        lblHours = new javax.swing.JLabel();
        lblMaterials = new javax.swing.JLabel();
        cmbMaterials = new javax.swing.JComboBox<>();
        spnrMaterial = new javax.swing.JSpinner();
        btnAddMaterial = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        btnDeleteMaterial = new javax.swing.JButton();
        lblUnits = new javax.swing.JLabel();
        spnrWorkingTime = new javax.swing.JSpinner();
        lblWorkingTime1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMaterials = new javax.swing.JTable();
        pnlButtons = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        pnlInput.setBackground(new java.awt.Color(255, 255, 255));
        pnlInput.setForeground(new java.awt.Color(0, 0, 0));
        pnlInput.setToolTipText("");

        lblProduct.setBackground(new java.awt.Color(246, 211, 227));
        lblProduct.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        lblProduct.setForeground(new java.awt.Color(232, 123, 167));
        lblProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProduct.setText("New Product");
        lblProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(232, 123, 167), 2, true));

        lblText.setBackground(new java.awt.Color(199, 206, 234));
        lblText.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblText.setForeground(new java.awt.Color(237, 136, 177));
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setLabelFor(txtName);
        lblText.setText("Name");
        lblText.setToolTipText("");
        lblText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(244, 152, 194), 2, true));
        lblText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblQuantity.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(131, 217, 220));
        lblQuantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuantity.setText("Quantity");
        lblQuantity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(131, 217, 220), 2, true));

        spnrQuantity.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        spnrQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        spnrQuantity.setBorder(null);
        spnrQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblDescription.setBackground(new java.awt.Color(255, 255, 255));
        lblDescription.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(201, 151, 198));
        lblDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescription.setText("Description");
        lblDescription.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 151, 198), 2, true));

        txtADescription.setBackground(new java.awt.Color(219, 193, 218));
        txtADescription.setColumns(20);
        txtADescription.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        txtADescription.setForeground(new java.awt.Color(255, 255, 255));
        txtADescription.setRows(5);
        txtADescription.setBorder(null);
        jScrollPane1.setViewportView(txtADescription);

        lblHours.setBackground(new java.awt.Color(255, 255, 255));
        lblHours.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblHours.setForeground(new java.awt.Color(186, 219, 158));
        lblHours.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHours.setText("Hours");

        lblMaterials.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblMaterials.setForeground(new java.awt.Color(169, 188, 229));
        lblMaterials.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaterials.setText("Used Materials");
        lblMaterials.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 188, 229), 2, true));

        cmbMaterials.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Material 1", "Material 2", "Material 3" }));

        spnrMaterial.setModel(new javax.swing.SpinnerNumberModel(0.1f, 0.1f, null, 0.1f));
        spnrMaterial.setBorder(null);

        btnAddMaterial.setBackground(new java.awt.Color(143, 163, 212));
        btnAddMaterial.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnAddMaterial.setForeground(new java.awt.Color(255, 255, 255));
        btnAddMaterial.setText("Add +");
        btnAddMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMaterialActionPerformed(evt);
            }
        });

        txtName.setBackground(new java.awt.Color(246, 211, 227));
        txtName.setForeground(new java.awt.Color(0, 0, 0));

        btnDeleteMaterial.setBackground(new java.awt.Color(143, 163, 212));
        btnDeleteMaterial.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnDeleteMaterial.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteMaterial.setText("Delete -");
        btnDeleteMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMaterialActionPerformed(evt);
            }
        });

        lblUnits.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblUnits.setForeground(new java.awt.Color(131, 217, 220));
        lblUnits.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUnits.setText("Units");

        spnrWorkingTime.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        spnrWorkingTime.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        spnrWorkingTime.setBorder(null);
        spnrWorkingTime.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblWorkingTime1.setBackground(new java.awt.Color(255, 255, 255));
        lblWorkingTime1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblWorkingTime1.setForeground(new java.awt.Color(186, 219, 158));
        lblWorkingTime1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWorkingTime1.setText("Working Time");
        lblWorkingTime1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 219, 158), 2, true));

        tblMaterials.setBackground(new java.awt.Color(188, 233, 234));
        tblMaterials.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        tblMaterials.setForeground(new java.awt.Color(131, 217, 220));
        tblMaterials.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane3.setViewportView(tblMaterials);

        javax.swing.GroupLayout pnlInputLayout = new javax.swing.GroupLayout(pnlInput);
        pnlInput.setLayout(pnlInputLayout);
        pnlInputLayout.setHorizontalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInputLayout.createSequentialGroup()
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlInputLayout.createSequentialGroup()
                                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlInputLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lblQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createSequentialGroup()
                                        .addComponent(spnrQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblUnits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlInputLayout.createSequentialGroup()
                                .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlInputLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblWorkingTime1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnrWorkingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblHours)))
                        .addGap(33, 33, 33)
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlInputLayout.createSequentialGroup()
                                .addComponent(btnAddMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeleteMaterial))
                            .addGroup(pnlInputLayout.createSequentialGroup()
                                .addComponent(cmbMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnrMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblMaterials, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblProduct)
                .addGap(17, 17, 17)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMaterials, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnrQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblQuantity)
                        .addComponent(lblUnits))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spnrMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescription)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHours, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnrWorkingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWorkingTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddMaterial)
                            .addComponent(btnDeleteMaterial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlButtons.setBackground(new java.awt.Color(255, 255, 255));

        btnUpdate.setBackground(new java.awt.Color(246, 211, 227));
        btnUpdate.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(246, 211, 227));
        btnCancel.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(244, 152, 194));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        if(validateTxt(name) && !name.equals("") ){
            Product productToAdd;  
            productToAdd = collectInformation();
            Inventory.updateProduct(productToAdd, idToUpdate);
            CostCalculator.calculateTotalProductProductionCost(productToAdd);
            JOptionPane.showMessageDialog(this,"Product added successfully :)", "Saved", JOptionPane.PLAIN_MESSAGE);
            cleanFields();
        }else{
            JOptionPane.showMessageDialog(this,"Empty name field, you must enter at least the name of the product to continue", "Warning", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMaterialActionPerformed
        // TODO add your handling code here:
        String material = String.valueOf(cmbMaterials.getSelectedItem());
        float quantity = (float)(spnrMaterial.getValue());
        int id = findMaterialId(material);
        String[] information = new String[3];
        information[0] = String.valueOf(id);
        information[1] = material;
        information[2] = String.valueOf(quantity);
        model.addRow(information);
    }//GEN-LAST:event_btnAddMaterialActionPerformed

    private void btnDeleteMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMaterialActionPerformed

        int row = tblMaterials.getSelectedRow();
        if (row >=0){
            model.removeRow(row);
        }else{
            JOptionPane.showMessageDialog(this, "Select row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteMaterialActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        new FrmUpdateProduct().setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed
    
    private void cleanFields(){
        txtName.setText("");
        txtADescription.setText("");
        spnrQuantity.setValue(0);
        spnrWorkingTime.setValue(0);
        spnrMaterial.setValue(0.1);
        cleanTableInfo();
        
    }
    
    public void setIdToUpdate(int id){
        idToUpdate = id;
    } 
    private Product collectInformation(){
        int id = 0;
        String name = txtName.getText();
        float productionCost = 0.0F;
        String description = txtADescription.getText();
        int workingTime = (int) spnrWorkingTime.getValue();
        int quantity = (int) spnrQuantity.getValue();
        ArrayList <Integer> materialsIds = getTableInfo("id", 0);
        ArrayList <Float> materialsQuantities = getTableInfo("quantity", 2);
        Product productToAdd;
        productToAdd = new Product(id, name, productionCost, description,materialsIds, materialsQuantities, workingTime, quantity);
        float cost = CostCalculator.calculateTotalProductProductionCost(productToAdd);
        productToAdd.setProductionCost(cost);
        return productToAdd;
    }
    
    private int findMaterialId(String material){
        int id  = Integer.parseInt(MongoDbManager.findValue(materialsCollection,"name", material, "id"));
        return id;
    }
    
    private ArrayList getTableInfo(String title, int column){
        int row = tblMaterials.getRowCount();
        ArrayList columnValues = new ArrayList();
        switch (title) {
            case "id" -> {
                for (int i = 0; i < row; i++) {
                    int value = Integer.parseInt(tblMaterials.getValueAt(i, column).toString());
                    columnValues.add(value);
                }
                return columnValues;
            }
            case "quantity" -> {
                for (int i = 0; i < row; i++) {
                    float value = Float.parseFloat(tblMaterials.getValueAt(i, column).toString());
                    columnValues.add(value);
                }
                return columnValues;
            }
            default -> {
                return columnValues;
            }
        }
    }
    
    private void cleanTableInfo(){
        int row =  tblMaterials.getRowCount();
        for(int i = row - 1; i >=0 ; i--){
            model.removeRow(i);
        }
    }
    private boolean validateTxt(String text){
        boolean isInvalidCharacter = false;
        ArrayList invalidCharacters = new ArrayList();
        for (int i = 0; i < text.length(); i++){
            char character = text.charAt(i);
            if(!Character.isAlphabetic(character)&& !(character == ' ')){
                isInvalidCharacter = true;
                invalidCharacters.add(character);
            }
        }
        if (isInvalidCharacter){
            JOptionPane.showMessageDialog(this," Invalid characters for Names: " + invalidCharacters , "Warning on input data", JOptionPane.WARNING_MESSAGE);
            return false;
        }else{
            return true;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();
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
                new FrmUpdateProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMaterial;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteMaterial;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbMaterials;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblHours;
    private javax.swing.JLabel lblMaterials;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblText;
    private javax.swing.JLabel lblUnits;
    private javax.swing.JLabel lblWorkingTime1;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JSpinner spnrMaterial;
    private javax.swing.JSpinner spnrQuantity;
    private javax.swing.JSpinner spnrWorkingTime;
    private javax.swing.JTable tblMaterials;
    private javax.swing.JTextArea txtADescription;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
