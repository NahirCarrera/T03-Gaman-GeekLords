package ec.edu.espe.ehamanagement.view;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.controller.AgendaReportGenerator;
import ec.edu.espe.ehamanagement.controller.Inventory;
import ec.edu.espe.ehamanagement.controller.InventoryReportGenerator;
import ec.edu.espe.ehamanagement.model.InventoryReport;
import ec.edu.espe.ehamanagement.model.Product;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author NicolayChillo Gaman GeekLords at DCOO-ESPE
 */
public class FrmPrintShortageProductReport extends javax.swing.JFrame {
    private final MongoCollection productsCollection;
    private final MongoCollection reportsCollection;
    private final  ArrayList <Product> readedProducts ;
    /**
     * Creates new form FrmPrintShortageProductReport
     */
    public FrmPrintShortageProductReport() {
        initComponents();
        productsCollection = Inventory.createConnectionToCollection();
        reportsCollection = AgendaReportGenerator.createConnectionToCollection();
        readedProducts = Inventory.readInventory(productsCollection);
    }
private void insertReport(){
        ArrayList <Product> stockProducts = InventoryReportGenerator.filterProducts(readedProducts, "stock");
        ArrayList <Product> sortageProducts = InventoryReportGenerator.filterProducts(readedProducts, "shortage");
        ArrayList <Integer> stockProductsIds = new ArrayList();
        ArrayList <Integer> shortageProductsIds = new ArrayList();
        for(Product product: stockProducts){
            stockProductsIds.add(product.getId());
        }
        for (Product product:sortageProducts){
            shortageProductsIds.add(product.getId());
        }
        
        InventoryReport newReport = new InventoryReport( stockProductsIds, shortageProductsIds);
        newReport.setType("Shortage Products");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        newReport.setDate(String.valueOf(dateFormat.format(date)));
        InventoryReportGenerator.insertReport(reportsCollection, newReport);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrintShortageProductReport1 = new ec.edu.espe.EHAManagement.view.PnlPrintShortageProductReport();
        jPanel1 = new javax.swing.JPanel();
        BtnBack = new javax.swing.JButton();
        BtnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnBack.setText("Back");
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });

        BtnPrint.setText("Print");
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(BtnBack)
                .addGap(133, 133, 133)
                .addComponent(BtnPrint)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBack)
                    .addComponent(BtnPrint))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrintShortageProductReport1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlPrintShortageProductReport1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        insertReport();
        PrinterJob job = PrinterJob.getPrinterJob();

        job.setPrintable(pnlPrintShortageProductReport1);

        if(job.printDialog()){
            try{
                job.print();
            }catch (PrinterException ex){
            }
        }else{
            JOptionPane.showMessageDialog(this, "The print was canceled");
        }
    }//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        FrmPrincipalMenuBar open = new FrmPrincipalMenuBar();
        open.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrintShortageProductReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnPrint;
    private javax.swing.JPanel jPanel1;
    private ec.edu.espe.EHAManagement.view.PnlPrintShortageProductReport pnlPrintShortageProductReport1;
    // End of variables declaration//GEN-END:variables
}