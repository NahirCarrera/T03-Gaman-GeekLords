package ec.edu.espe.ehamanagement.view;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.controller.Agenda;

/**
 *
 * @author NicolayChillo Gaman GeekLords at DCOO-ESPE
 */
public class PnlAgenda extends javax.swing.JPanel {
    private final MongoCollection ordersCollection;
    /**
     * Creates new form PnlAgendaMenuOption
     */
    public PnlAgenda() {
        initComponents();
        ordersCollection = Agenda.createConnectionToCollection();
        initPnlOrdersTable(ordersCollection);
    }
    private void initPnlOrdersTable(MongoCollection ordersCollection){
        PnlOrdersTable pnlTableAllOrders = new PnlOrdersTable(ordersCollection);
        pnlTableAllOrders.setSize(714,523);
        pnlTableAllOrders.setLocation(0, 0);
        pnlWindow.removeAll();
        pnlWindow.add(pnlTableAllOrders,pnlTableAllOrders);
        pnlWindow.revalidate();
        pnlWindow.repaint();
    }

    private void initPnlNewOrder(){
        PnlAddNewOrder pnlNewOrder = new PnlAddNewOrder();
        pnlNewOrder.setSize(714,523);
        pnlNewOrder.setLocation(0, 0);
        pnlWindow.removeAll();
        pnlWindow.add(pnlNewOrder,pnlNewOrder);
        pnlWindow.revalidate();
        pnlWindow.repaint();
    }
    public void initOrderInformation(){
        PnlOrderInformation pnlOrderInformation = new PnlOrderInformation(ordersCollection);
        pnlOrderInformation.setSize(714,523);
        pnlOrderInformation.setLocation(0,0);
        pnlWindow.removeAll();
        pnlWindow.add(pnlOrderInformation,pnlOrderInformation);
        pnlWindow.revalidate();
        pnlWindow.repaint();

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGrOrderTables = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        BtnAddOrder = new javax.swing.JButton();
        BtnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pnlWindow = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(980, 629));
        setPreferredSize(new java.awt.Dimension(980, 629));
        setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(126, 53, 2));
        jPanel2.setToolTipText("");

        BtnAddOrder.setBackground(new java.awt.Color(183, 96, 9));
        BtnAddOrder.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnAddOrder.setForeground(new java.awt.Color(255, 255, 255));
        BtnAddOrder.setText("Add Order");
        BtnAddOrder.setBorder(null);
        BtnAddOrder.setBorderPainted(false);
        BtnAddOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAddOrderMouseClicked(evt);
            }
        });
        BtnAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddOrderActionPerformed(evt);
            }
        });

        BtnBack.setBackground(new java.awt.Color(183, 96, 9));
        BtnBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnBack.setForeground(new java.awt.Color(255, 255, 255));
        BtnBack.setText("Back");
        BtnBack.setBorder(null);
        BtnBack.setBorderPainted(false);
        BtnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBackMouseClicked(evt);
            }
        });
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BtnAddOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(BtnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(126, 53, 2));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(102, 102, 102))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(126, 53, 2));
        jPanel4.setMaximumSize(new java.awt.Dimension(450, 32767));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlWindow.setBackground(new java.awt.Color(255, 255, 255));
        pnlWindow.setPreferredSize(new java.awt.Dimension(714, 523));

        javax.swing.GroupLayout pnlWindowLayout = new javax.swing.GroupLayout(pnlWindow);
        pnlWindow.setLayout(pnlWindowLayout);
        pnlWindowLayout.setHorizontalGroup(
            pnlWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlWindowLayout.setVerticalGroup(
            pnlWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(844, 844, 844)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        initPnlOrdersTable(ordersCollection);
        
    }//GEN-LAST:event_BtnBackActionPerformed

    private void BtnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBackMouseClicked
       
    }//GEN-LAST:event_BtnBackMouseClicked

    private void BtnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddOrderActionPerformed
        
        initPnlNewOrder();
    }//GEN-LAST:event_BtnAddOrderActionPerformed

    private void BtnAddOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAddOrderMouseClicked
        initPnlNewOrder();
    }//GEN-LAST:event_BtnAddOrderMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddOrder;
    private javax.swing.JButton BtnBack;
    private javax.swing.ButtonGroup BtnGrOrderTables;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel pnlWindow;
    // End of variables declaration//GEN-END:variables
}