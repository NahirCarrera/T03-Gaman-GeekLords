/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ec.edu.espe.ehamanagement.view;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.controller.Registration;
import ec.edu.espe.ehamanagement.model.User;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Jairo Bonilla, Gaman GeekLords, DCCO-ESPE
 */
public class PnlUpdateUser extends javax.swing.JPanel {

     MongoCollection userCollection;
    /**
     * Creates new form PnlUpdate
     */
    public PnlUpdateUser() {
        initComponents();
        btnSave.setEnabled(false);
        pflPassword.setEnabled(false);
        userCollection = Registration.createConnectionToCollection();
    }

    private void validateFields(){
        if (txtUserName.getText().equals("UserName"))
        {
            lbWarningUser.setText("this area is required");
            pictureWarningUser();
        }
        else 
        {
            lbWarningUser.setText("");
            pictureWhitePassword();
        }
        if (txtEmail.getText().equals("name@gmail.com"))
        {
            lbWarningEmail.setText("this area is required");
            pictureWarningEmail();
        } 
        else 
        {
            if (txtEmail.getText().equals("")) 
            {
                pictureWhiteEmail();
                lbWarningEmail.setText("");

            } 
            else 
            {

                if (!txtEmail.getText().contains("@") || !txtEmail.getText().contains("."))
                {
                    lbWarningEmail.setText("enter a valid email");
                    pictureWarningEmail();
                } else
                {
                    lbWarningEmail.setText("");
                    pictureWhiteEmail();
                }
            }

        }
        if (pflOldPassword.getText().equals("***************"))
        {
            lbWarningPass.setText("this area is required");
            pictureWarningPassword();
        }
        else 
        {
            lbWarningPass.setText("");
            pictureWhitePassword();
        }
        
        
        if (txtCurrentSalary.getText().equals("$00.00") || pflOldPassword.getText().equals("***************") || lbWarningEmail.getText().equals("enter a valid email")
            || txtEmail.getText().equals("name@gmail.com") || txtUserName.getText().equals("UserName") || txtUserName.getText().isEmpty() || pflOldPassword.getText().isEmpty() || txtEmail.getText().isEmpty()
             || txtCurrentSalary.getText().isEmpty() || pflPassword.getText().equals("***************")|| pflPassword.getText().isEmpty()) {
         btnSave.setEnabled(false);
        }

    }
    private void writeFields(){
        if (txtUserName.getText().isEmpty()) {
            txtUserName.setText("UserName");
            txtUserName.setForeground(Color.gray);
        }
        if (txtEmail.getText().isEmpty()) {
            txtEmail.setText("name@gmail.com");
            txtEmail.setForeground(Color.gray);
        }
        if (txtCurrentSalary.getText().isEmpty()) {
            txtCurrentSalary.setText("$00.00");
            txtCurrentSalary.setForeground(Color.gray);

        }
        if (String.valueOf(pflOldPassword.getPassword()).isEmpty()) {
            pflOldPassword.setText("***************");
            pflOldPassword.setForeground(Color.gray);
        }
        if(String.valueOf(pflPassword.getPassword()).isEmpty())
        {
            pflPassword.setText("***************");
            pflPassword.setForeground(Color.gray);
        }
    }
    private void pictureSeenGreenUser() {
        lblSeenGreenP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/seenGreen.png"))); // NOI18N
        lblSeenGreenP.setText("");
        lbWriteGreen.setText("Enter new password");
    }
    private void pictureWiteNewPassword()
    {
        lblSeenGreenP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/whiteSeen.png")));
        lbWriteGreen.setText("");
    }

    private void pictureWarningUser() {
        lbValidateUserPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/alert.png"))); // NOI18N
        lbValidateUserPicture.setText("");
    }

    private void pictureWhiteUser() {
        lbValidateUserPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/picture1.png"))); // NOI18N
        lbValidateUserPicture.setText("");
    }

    private void pictureWarningPassword() {
        lbValidatePassPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/alert.png"))); // NOI18N
        lbValidatePassPicture.setText("");
    }

    private void pictureWhitePassword() {
        lbValidatePassPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/picture1.png"))); // NOI18N
        lbValidatePassPicture.setText("");
    }

    private void pictureWarningEmail() {
        lbValidateEmailPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/alert.png"))); // NOI18N
        lbValidateEmailPicture.setText("");
    }

    private void pictureWhiteEmail() {
        lbValidateEmailPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/picture1.png"))); // NOI18N
        lbValidateEmailPicture.setText("");
    }

    private void pictureWarningSalary() {
        lbValidateCurrentSPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/alert.png"))); // NOI18N
        lbValidateCurrentSPicture.setText("");
    }

    private void pictureWhiteSalary() {
        lbValidateCurrentSPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec.edu.espe.ehamanagement.picture/picture1.png"))); // NOI18N
        lbValidateCurrentSPicture.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lbValidatePassPicture = new javax.swing.JLabel();
        lbValidateUserPicture = new javax.swing.JLabel();
        lbValidateEmailPicture = new javax.swing.JLabel();
        lbValidateCurrentSPicture = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtCurrentSalary = new javax.swing.JTextField();
        lbWarningCurrentS = new javax.swing.JLabel();
        lbWarningPass = new javax.swing.JLabel();
        lbWarningEmail = new javax.swing.JLabel();
        lbWarningUser = new javax.swing.JLabel();
        pflOldPassword = new javax.swing.JPasswordField();
        txtUserName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        pflPassword = new javax.swing.JPasswordField();
        btnConfirmPassword = new javax.swing.JButton();
        lblSeenGreenP = new javax.swing.JLabel();
        lbWriteGreen = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("User");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Email");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Current Salary");

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("New Password");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(153, 153, 153));
        txtEmail.setText("name@gmail.com");
        txtEmail.setBorder(null);
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        txtCurrentSalary.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCurrentSalary.setForeground(new java.awt.Color(153, 153, 153));
        txtCurrentSalary.setText("$00.00");
        txtCurrentSalary.setBorder(null);
        txtCurrentSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCurrentSalaryMousePressed(evt);
            }
        });
        txtCurrentSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurrentSalaryActionPerformed(evt);
            }
        });
        txtCurrentSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCurrentSalaryKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCurrentSalaryKeyTyped(evt);
            }
        });

        lbWarningCurrentS.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lbWarningCurrentS.setForeground(new java.awt.Color(204, 0, 0));
        lbWarningCurrentS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbWarningPass.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lbWarningPass.setForeground(new java.awt.Color(204, 0, 0));
        lbWarningPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbWarningEmail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lbWarningEmail.setForeground(new java.awt.Color(204, 0, 0));
        lbWarningEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbWarningUser.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lbWarningUser.setForeground(new java.awt.Color(204, 0, 0));

        pflOldPassword.setForeground(new java.awt.Color(153, 153, 153));
        pflOldPassword.setText("***************");
        pflOldPassword.setBorder(null);
        pflOldPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pflOldPasswordMousePressed(evt);
            }
        });
        pflOldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pflOldPasswordActionPerformed(evt);
            }
        });
        pflOldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pflOldPasswordKeyReleased(evt);
            }
        });

        txtUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(153, 153, 153));
        txtUserName.setText("UserName");
        txtUserName.setBorder(null);
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUserNameMousePressed(evt);
            }
        });
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserNameKeyTyped(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 105, 125));
        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Current password");

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        pflPassword.setForeground(new java.awt.Color(153, 153, 153));
        pflPassword.setText("***************");
        pflPassword.setBorder(null);
        pflPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pflPasswordMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pflPasswordMousePressed(evt);
            }
        });
        pflPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pflPasswordActionPerformed(evt);
            }
        });
        pflPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pflPasswordKeyReleased(evt);
            }
        });

        btnConfirmPassword.setBackground(new java.awt.Color(0, 105, 125));
        btnConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnConfirmPassword.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmPassword.setText("confirm");
        btnConfirmPassword.setToolTipText("You have to confirm your old password to save changes, also to change you current password");
        btnConfirmPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmPasswordActionPerformed(evt);
            }
        });

        lbWriteGreen.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lbWriteGreen.setForeground(new java.awt.Color(51, 204, 0));
        lbWriteGreen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pflPassword)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator1)
                    .addComponent(txtUserName)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCurrentSalary))
                    .addComponent(pflOldPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbValidateEmailPicture, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValidateCurrentSPicture, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValidatePassPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(lbValidateUserPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSeenGreenP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbWarningCurrentS, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addComponent(lbWarningEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addComponent(lbWarningPass, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addComponent(lbWarningUser, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addComponent(lbWriteGreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbValidateUserPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbWarningUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValidateEmailPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbWarningEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValidateCurrentSPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCurrentSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbWarningCurrentS, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbValidatePassPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbWarningPass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(btnConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(pflOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pflPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSeenGreenP)
                    .addComponent(lbWriteGreen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCurrentSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurrentSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurrentSalaryActionPerformed

    private void txtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMousePressed
        writeFields();
        if (txtEmail.getText().equals("name@gmail.com")) {
            txtEmail.setText("");
            txtEmail.setForeground(Color.black);

        }
        validateFields();
    }//GEN-LAST:event_txtEmailMousePressed

    private void txtCurrentSalaryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCurrentSalaryMousePressed
        writeFields();
        if (txtCurrentSalary.getText().equals("$00.00")) {
            txtCurrentSalary.setText("");
            txtCurrentSalary.setForeground(Color.black);
        }
        validateFields();
    }//GEN-LAST:event_txtCurrentSalaryMousePressed

    private void pflOldPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pflOldPasswordMousePressed
        writeFields();
        if (String.valueOf(pflOldPassword.getPassword()).equals("***************")) {
            pflOldPassword.setText("");
            pflOldPassword.setForeground(Color.black);

        }
        validateFields();
    }//GEN-LAST:event_pflOldPasswordMousePressed

    private void txtUserNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMousePressed
        writeFields();
        if (txtUserName.getText().equals("UserName")) {
            txtUserName.setText("");

            txtUserName.setForeground(Color.black);

        }
        validateFields();
        
    }//GEN-LAST:event_txtUserNameMousePressed

    private void txtUserNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyTyped
        char c = evt.getKeyChar();
            if (!Character.isLetter(c) && (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE)) {
                getToolkit().beep();
                evt.consume();
                pictureWarningUser();
                lbWarningUser.setText(c + " is not accepted here!");

            } else {
                lbWarningUser.setText("");
                pictureWhiteUser();
            }
    }//GEN-LAST:event_txtUserNameKeyTyped

    private void txtUserNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyReleased
        validateFields();
        if (txtCurrentSalary.getText().equals("$00.00")) {
            lbWarningCurrentS.setText("this area is required");
            pictureWarningSalary();
        } else {
            lbValidateCurrentSPicture.setText("");
            pictureWhiteSalary();
        }
    }//GEN-LAST:event_txtUserNameKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        if (txtUserName.getText().equals("UserName")) {
            lbWarningUser.setText("this area is required ");
            pictureWarningUser();
        } else {
            lbWarningUser.setText("");
            pictureWhiteUser();
        }
        if (txtCurrentSalary.getText().equals("$00.00")) {
            lbWarningCurrentS.setText("this area is required");
            pictureWarningSalary();
        } else {
            lbWarningCurrentS.setText("");
            pictureWhiteSalary();
        }
        validateFields();
    }//GEN-LAST:event_txtEmailKeyReleased

    private void pflOldPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pflOldPasswordKeyReleased
        if (txtUserName.getText().equals("UserName")) {
            lbWarningUser.setText("this area is required");
            pictureWarningUser();
        } else {
            lbWarningUser.setText("");
            pictureWhiteUser();
        }
        validateFields();
    }//GEN-LAST:event_pflOldPasswordKeyReleased

    private void txtCurrentSalaryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurrentSalaryKeyReleased
        if (txtUserName.getText().equals("UserName")) {
            lbWarningUser.setText("this area is required");
            pictureWarningUser();
        } else {
            lbWarningUser.setText("");
            pictureWhiteUser();
        }
        validateFields();
    }//GEN-LAST:event_txtCurrentSalaryKeyReleased

    private void txtCurrentSalaryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurrentSalaryKeyTyped
        char c = evt.getKeyChar();

        if (txtCurrentSalary.getText().equals("$00.00")) {
            lbWarningCurrentS.setText("this area is required");
            pictureWarningSalary();
        } else {
            if (!Character.isDigit(c) && (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_PERIOD)) {
                //getToolkit().beep();
                evt.consume();
                pictureWarningSalary();
                lbWarningCurrentS.setText(c + " is not accepted here");
            } else {
                lbWarningCurrentS.setText("");
                pictureWhiteSalary();
            }

        }
    }//GEN-LAST:event_txtCurrentSalaryKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
     int option = JOptionPane.showConfirmDialog(this, "Do you want to update ?");      
     if (option == 0){
         String userName = txtUserName.getText();
         String email = txtEmail.getText();
         float currentSalary = Float.parseFloat(txtCurrentSalary.getText());
         String password = pflPassword.getText();
         User user = new User(1, userName, email, password, currentSalary);
         if(Registration.updateUser(user)){
             JOptionPane.showMessageDialog(this,"Your changes  have been successfully saved!", "Updated successfully", JOptionPane.INFORMATION_MESSAGE);
         }else{
             JOptionPane.showMessageDialog(this,"An error occured updating your changes", "Updated failed", JOptionPane.ERROR_MESSAGE);
         }
     }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void pflPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pflPasswordMousePressed
         if (String.valueOf(pflPassword.getPassword()).equals("***************")) {
            pflPassword.setText("");
            pflPassword.setForeground(Color.black);

        }
        if (txtUserName.getText().isEmpty()) {
            txtUserName.setText("UserName");
            txtUserName.setForeground(Color.gray);
        }
        if (txtEmail.getText().isEmpty()) {
            txtEmail.setText("name@gmail.com");
            txtEmail.setForeground(Color.gray);
        }
        if (txtCurrentSalary.getText().isEmpty()) {
            txtCurrentSalary.setText("$00.00");
            txtCurrentSalary.setForeground(Color.gray);

        }
    }//GEN-LAST:event_pflPasswordMousePressed

    private void pflPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pflPasswordKeyReleased
        if (txtUserName.getText().equals("UserName")) {
            lbWarningUser.setText("this area is required");
            pictureWarningUser();
        } else {
            lbWarningUser.setText("");
            pictureWhiteUser();
        }
        if (txtCurrentSalary.getText().equals("$00.00")) {
            lbWarningCurrentS.setText("this area is required");
            pictureWarningSalary();
        } else {
            lbWarningCurrentS.setText("");
            pictureWhiteSalary();
        }
        validateFields();
       
    }//GEN-LAST:event_pflPasswordKeyReleased

    private void btnConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmPasswordActionPerformed
        String correctPassword = Registration.findValue(userCollection, 1, "password");
        String password = pflOldPassword.getText();
         if ( password.equals(correctPassword))
         {
            btnSave.setEnabled(true);
            pictureSeenGreenUser();
            pflPassword.setEnabled(true);
            pflOldPassword.setEnabled(false);
            btnConfirmPassword.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(this,"The  password is incorrect, please try again", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmPasswordActionPerformed

    private void pflPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pflPasswordActionPerformed
       
        if(pflPassword.getText().isEmpty())
        {
            pictureSeenGreenUser();
        }
        
    }//GEN-LAST:event_pflPasswordActionPerformed

    private void pflPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pflPasswordMouseClicked
        
    }//GEN-LAST:event_pflPasswordMouseClicked

    private void pflOldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pflOldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pflOldPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmPassword;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbValidateCurrentSPicture;
    private javax.swing.JLabel lbValidateEmailPicture;
    private javax.swing.JLabel lbValidatePassPicture;
    private javax.swing.JLabel lbValidateUserPicture;
    private javax.swing.JLabel lbWarningCurrentS;
    private javax.swing.JLabel lbWarningEmail;
    private javax.swing.JLabel lbWarningPass;
    private javax.swing.JLabel lbWarningUser;
    private javax.swing.JLabel lbWriteGreen;
    private javax.swing.JLabel lblSeenGreenP;
    private javax.swing.JPasswordField pflOldPassword;
    public javax.swing.JPasswordField pflPassword;
    public javax.swing.JTextField txtCurrentSalary;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
