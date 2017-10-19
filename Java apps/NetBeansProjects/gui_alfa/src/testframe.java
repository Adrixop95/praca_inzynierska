/*

Created by Adrian Rupala 2017

*/

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class testframe extends javax.swing.JFrame {

    public static String user_name_global = "";
    public static String user_password_global = "";

    public testframe() {
        setTitle("");
        setResizable(false);
        setUndecorated(true);
        setVisible(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        P1 = new javax.swing.JPanel();
        jP1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPB1 = new javax.swing.JButton();
        jP2 = new javax.swing.JPanel();
        title_jp2 = new javax.swing.JLabel();
        subtitle_jp2 = new javax.swing.JLabel();
        user_name = new javax.swing.JTextField();
        user_password = new javax.swing.JPasswordField();
        user_name_title = new javax.swing.JLabel();
        user_password_title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPB2 = new javax.swing.JButton();
        iPB2_back = new javax.swing.JButton();
        jPB2_add_user = new javax.swing.JButton();
        jP3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        network_name_title = new javax.swing.JLabel();
        network_name = new javax.swing.JComboBox<>();
        network_password_title = new javax.swing.JLabel();
        network_password = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jPB4 = new javax.swing.JButton();
        iPB4_back = new javax.swing.JButton();
        jP4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPB3 = new javax.swing.JButton();
        iPB3_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 450));

        P1.setBackground(new java.awt.Color(38, 38, 38));
        P1.setPreferredSize(new java.awt.Dimension(610, 294));
        P1.setLayout(new java.awt.CardLayout());

        jP1.setBackground(new java.awt.Color(38, 38, 38));
        jP1.setPreferredSize(new java.awt.Dimension(610, 294));

        jLabel1.setBackground(new java.awt.Color(204, 204, 198));
        jLabel1.setFont(new java.awt.Font("SF Pro Display", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 198));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hej!");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("SF Pro Text", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(149, 152, 154));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pierwszy raz uruchomiłeś ten system, skonfiguruj go!");

        jPanel1.setBackground(new java.awt.Color(28, 28, 28));
        jPanel1.setForeground(new java.awt.Color(28, 28, 28));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        jPB1.setText("Dalej");
        jPB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPB1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPB1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jPB1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jP1Layout = new javax.swing.GroupLayout(jP1);
        jP1.setLayout(jP1Layout);
        jP1Layout.setHorizontalGroup(
            jP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jP1Layout.setVerticalGroup(
            jP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        P1.add(jP1, "panelOne");

        jP2.setBackground(new java.awt.Color(38, 38, 38));
        jP2.setPreferredSize(new java.awt.Dimension(610, 294));

        title_jp2.setBackground(new java.awt.Color(204, 204, 198));
        title_jp2.setFont(new java.awt.Font("SF Pro Display", 0, 32)); // NOI18N
        title_jp2.setForeground(new java.awt.Color(204, 204, 198));
        title_jp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_jp2.setText("Przedstaw się.");
        title_jp2.setToolTipText("");

        subtitle_jp2.setFont(new java.awt.Font("SF Pro Text", 0, 20)); // NOI18N
        subtitle_jp2.setForeground(new java.awt.Color(149, 152, 154));
        subtitle_jp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtitle_jp2.setText("Tymi danymi będziesz logował się do systemu.");

        user_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_nameActionPerformed(evt);
            }
        });

        user_name_title.setFont(new java.awt.Font("SF Pro Text", 0, 10)); // NOI18N
        user_name_title.setForeground(new java.awt.Color(149, 152, 154));
        user_name_title.setText("Podaj nazwę użytkownika:");

        user_password_title.setFont(new java.awt.Font("SF Pro Text", 0, 10)); // NOI18N
        user_password_title.setForeground(new java.awt.Color(149, 152, 154));
        user_password_title.setText("Podaj swoje hasło:");

        jPanel2.setBackground(new java.awt.Color(28, 28, 28));
        jPanel2.setForeground(new java.awt.Color(28, 28, 28));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);

        jPB2.setText("Dalej");
        jPB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPB2ActionPerformed(evt);
            }
        });

        iPB2_back.setText("Wstecz");
        iPB2_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iPB2_backActionPerformed(evt);
            }
        });

        jPB2_add_user.setText("Dodaj użytkownika");
        jPB2_add_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPB2_add_userActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iPB2_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPB2_add_user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPB2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPB2)
                    .addComponent(iPB2_back)
                    .addComponent(jPB2_add_user))
                .addContainerGap())
        );

        javax.swing.GroupLayout jP2Layout = new javax.swing.GroupLayout(jP2);
        jP2.setLayout(jP2Layout);
        jP2Layout.setHorizontalGroup(
            jP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jP2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title_jp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subtitle_jp2, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addComponent(user_name)
                    .addComponent(user_password)
                    .addGroup(jP2Layout.createSequentialGroup()
                        .addGroup(jP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(user_password_title)
                            .addComponent(user_name_title))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jP2Layout.setVerticalGroup(
            jP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_jp2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subtitle_jp2)
                .addGap(28, 28, 28)
                .addComponent(user_name_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(user_password_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        P1.add(jP2, "panelTwo");

        jP3.setBackground(new java.awt.Color(38, 38, 38));
        jP3.setPreferredSize(new java.awt.Dimension(610, 294));

        jLabel7.setBackground(new java.awt.Color(204, 204, 198));
        jLabel7.setFont(new java.awt.Font("SF Pro Display", 0, 32)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 198));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Połącz się z siecią");
        jLabel7.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("SF Pro Text", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(149, 152, 154));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Sieć jest wymagana do pełnego działania systemu.");

        network_name_title.setFont(new java.awt.Font("SF Pro Text", 0, 10)); // NOI18N
        network_name_title.setForeground(new java.awt.Color(149, 152, 154));
        network_name_title.setText("Wybierz swoją sieć:");

        network_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wybierz sieć." }));
        network_name.removeAllItems();
        try {
            String[] network_command = {"/home/pi/avilible_networks.sh"};
            Process network_process = Runtime.getRuntime().exec(network_command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(network_process.getInputStream()));
            String read;
            while ((read = reader.readLine()) != null) {
                String [] parts = read.split(": ");
                network_name.addItem(parts[1].trim());
                //String x = String.valueOf(network_name.getSelectedItem());
                //network_name.setSelectedItem();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        network_name.setAutoscrolls(true);
        network_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                network_nameActionPerformed(evt);
            }
        });

        network_password_title.setFont(new java.awt.Font("SF Pro Text", 0, 10)); // NOI18N
        network_password_title.setForeground(new java.awt.Color(149, 152, 154));
        network_password_title.setText("Podaj swoje hasło:");

        jPanel4.setBackground(new java.awt.Color(28, 28, 28));
        jPanel4.setForeground(new java.awt.Color(28, 28, 28));
        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);

        jPB4.setText("Dalej");
        jPB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPB4ActionPerformed(evt);
            }
        });

        iPB4_back.setText("Wstecz");
        iPB4_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iPB4_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iPB4_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPB4)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPB4)
                    .addComponent(iPB4_back))
                .addContainerGap())
        );

        javax.swing.GroupLayout jP3Layout = new javax.swing.GroupLayout(jP3);
        jP3.setLayout(jP3Layout);
        jP3Layout.setHorizontalGroup(
            jP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jP3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addGroup(jP3Layout.createSequentialGroup()
                        .addComponent(network_name_title, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(network_name, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jP3Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addGroup(jP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(network_password)
                        .addGroup(jP3Layout.createSequentialGroup()
                            .addComponent(network_password_title)
                            .addGap(0, 510, Short.MAX_VALUE)))
                    .addGap(6, 6, 6)))
        );
        jP3Layout.setVerticalGroup(
            jP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(25, 25, 25)
                .addComponent(network_name_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(network_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jP3Layout.createSequentialGroup()
                    .addGap(156, 156, 156)
                    .addComponent(network_password_title)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(network_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(93, Short.MAX_VALUE)))
        );

        P1.add(jP3, "panelThree");

        jP4.setBackground(new java.awt.Color(38, 38, 38));
        jP4.setPreferredSize(new java.awt.Dimension(610, 294));

        jLabel5.setBackground(new java.awt.Color(204, 204, 198));
        jLabel5.setFont(new java.awt.Font("SF Pro Display", 0, 32)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 198));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("To tyle.");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("SF Pro Text", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(149, 152, 154));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Miłego korzystania z systemu!");

        jPanel3.setBackground(new java.awt.Color(28, 28, 28));
        jPanel3.setForeground(new java.awt.Color(28, 28, 28));
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);

        jPB3.setText("Zakończ");
        jPB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPB3ActionPerformed(evt);
            }
        });

        iPB3_back.setText("Wstecz");
        iPB3_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iPB3_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iPB3_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPB3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPB3)
                    .addComponent(iPB3_back))
                .addContainerGap())
        );

        javax.swing.GroupLayout jP4Layout = new javax.swing.GroupLayout(jP4);
        jP4.setLayout(jP4Layout);
        jP4Layout.setHorizontalGroup(
            jP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jP4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
                .addContainerGap())
        );
        jP4Layout.setVerticalGroup(
            jP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        P1.add(jP4, "panelFour");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(P1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(P1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPB1ActionPerformed
        CardLayout card = (CardLayout)P1.getLayout();
        card.show(P1, "panelTwo");
    }//GEN-LAST:event_jPB1ActionPerformed

    private void jPB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPB2ActionPerformed
        CardLayout card = (CardLayout)P1.getLayout();
        card.show(P1, "panelThree");
    }//GEN-LAST:event_jPB2ActionPerformed

    private void jPB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPB4ActionPerformed
        CardLayout card = (CardLayout)P1.getLayout();
        card.show(P1, "panelFour");
    }//GEN-LAST:event_jPB4ActionPerformed

    private void jPB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPB3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jPB3ActionPerformed

    private void user_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_nameActionPerformed

    private void iPB2_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iPB2_backActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)P1.getLayout();
        card.show(P1,"panelOne");
    }//GEN-LAST:event_iPB2_backActionPerformed

    private void iPB4_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iPB4_backActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)P1.getLayout();
        card.show(P1,"panelTwo");
    }//GEN-LAST:event_iPB4_backActionPerformed

    private void iPB3_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iPB3_backActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)P1.getLayout();
        card.show(P1,"panelThree");
    }//GEN-LAST:event_iPB3_backActionPerformed

    private void jPB2_add_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPB2_add_userActionPerformed
        // TODO add your handling code here:
        user_name_global = user_name.getText();
        user_password_global = new String(user_password.getPassword());

        try {
            ProcessBuilder pb = new ProcessBuilder("/home/pi/add_user.sh");
            Map<String, String> env = pb.environment();
            env.put("username", user_name_global);
            env.put("password", user_password_global);
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jPB2_add_userActionPerformed
    
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
            java.util.logging.Logger.getLogger(testframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel P1;
    private javax.swing.JButton iPB2_back;
    private javax.swing.JButton iPB3_back;
    private javax.swing.JButton iPB4_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jP1;
    private javax.swing.JPanel jP2;
    private javax.swing.JPanel jP3;
    private javax.swing.JPanel jP4;
    private javax.swing.JButton jPB1;
    private javax.swing.JButton jPB2;
    private javax.swing.JButton jPB2_add_user;
    private javax.swing.JButton jPB3;
    private javax.swing.JButton jPB4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> network_name;
    private javax.swing.JLabel network_name_title;
    private javax.swing.JPasswordField network_password;
    private javax.swing.JLabel network_password_title;
    private javax.swing.JLabel subtitle_jp2;
    private javax.swing.JLabel title_jp2;
    private javax.swing.JTextField user_name;
    private javax.swing.JLabel user_name_title;
    private javax.swing.JPasswordField user_password;
    private javax.swing.JLabel user_password_title;
    // End of variables declaration//GEN-END:variables
}
