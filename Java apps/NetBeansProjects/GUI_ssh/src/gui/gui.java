/*

Created by Adrian Rupala 2017

*/

package gui;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;




public class gui extends javax.swing.JPanel {
    
    JFrame newFrame = new JFrame();

    public static String komenda = "";
    public static String USER = "";
    public static String PASS = "";
    public static String host = "";
    public static int port = 0;
     
    public static void main(String[] args) throws InterruptedException {
        gui myscreen = new gui();   
    }
    
    private void updateTextPane(final String text) {
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          Document doc = textPane.getDocument();
          try {
            doc.insertString(doc.getLength(), text, null);
          } catch (BadLocationException e) {
            throw new RuntimeException(e);
          }
          textPane.setCaretPosition(doc.getLength() - 1);
        }
      });
    }


    private void redirectSystemStreams() {
      OutputStream out = new OutputStream() {
        @Override
        public void write(final int b) throws IOException {
          updateTextPane(String.valueOf((char) b));
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
          updateTextPane(new String(b, off, len));
        }

        @Override
        public void write(byte[] b) throws IOException {
          write(b, 0, b.length);
        }
      };

      System.setOut(new PrintStream(out, true));
      System.setErr(new PrintStream(out, true));

    }

    
    public gui() throws InterruptedException {
        initComponents();
        newFrame.getContentPane().add(this, BorderLayout.CENTER);
            newFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                newFrame.pack();
                    newFrame.setVisible(true);
                        newFrame.setTitle("System wyświetlania informacji");                
                        redirectSystemStreams();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(204, 204, 204));

        jTabbedPane2.setBackground(new java.awt.Color(204, 204, 204));

        jPasswordField2.setText("jPasswordField2");
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nazwa użytkownika:");

        jLabel2.setText("Hasło:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField2))
                .addGap(271, 271, 271))
        );

        jTabbedPane2.addTab("Logowanie", jPanel1);

        jLabel5.setText("Adres IP Serwera:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Port Serwera:");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton3.setText("Test połączenia z serwerem");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton2.setText("Restart serwera");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                            .addComponent(jTextField5))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(245, 245, 245))
        );

        jTabbedPane2.addTab("Ustawienia", jPanel3);

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        jButton4.setText("Uruchom system wyświetlania");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton4);

        jButton6.setText("Wyłącz system wyświetlania");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton6);

        jButton5.setText("Pokaż urządzenia w sieci");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton5);

        jButton1.setText("Wyczyść panel");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton1);

        jScrollPane2.setViewportView(textPane);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addComponent(jToolBar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jTabbedPane2.addTab("Wyświetlanie", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2))
        );
    }// </editor-fold>//GEN-END:initComponents
   
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        komenda = "cd ~/ && screen -dm bash -c '/home/pi/Server_wyswietlania/DisplayMode.sh'";        
        
        try
        {
            JSch jsch = new JSch();

            Session session = jsch.getSession(USER, host, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(PASS);
            session.connect();

            String command = komenda;
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            channel.setInputStream(null);

            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();

            channel.connect();
            StringBuilder sb = new StringBuilder();
            byte[] tmp = new byte[1024];
            while (true)
            {
                while (in.available() > 0)
                {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0)
                        break;
                    sb.append(new String(tmp, 0, i));
                }
                if (channel.isClosed())
                {
                    if (in.available() > 0)
                        continue;
                    //System.out.println("exit-status: "
                    //        + channel.getExitStatus());
                    break;
                }
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception ee)
                {
                }
            }
            //disconnecting and closing
            channel.disconnect();

            session.disconnect();
            System.out.println("System został uruchomiony bez błędu.");
            System.out.println(sb.toString());
        }
        catch (Exception e)
        {
             //something should be done here
            e.printStackTrace();

        }
        
    redirectSystemStreams();            
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        komenda = "pkill -f 'SCREEN -dm bash -c' && pkill -f 'java -jar'";
        
        try
        {
            JSch jsch = new JSch();

            Session session = jsch.getSession(USER, host, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(PASS);
            session.connect();

            String command = komenda;
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            channel.setInputStream(null);

            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();

            channel.connect();
            StringBuilder sb = new StringBuilder();
            byte[] tmp = new byte[1024];
            while (true)
            {
                while (in.available() > 0)
                {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0)
                        break;
                    sb.append(new String(tmp, 0, i));
                }
                if (channel.isClosed())
                {
                    if (in.available() > 0)
                        continue;
                    //System.out.println("exit-status: "
                    //        + channel.getExitStatus());
                    break;
                }
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception ee)
                {
                }
            }
            //disconnecting and closing
            channel.disconnect();

            session.disconnect();
            System.out.println("System został wyłączony poprawnie.");
            System.out.println(sb.toString());
        }
        catch (Exception e)
        {
             //something should be done here
            e.printStackTrace();

        }       
        
    redirectSystemStreams();         
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        //USER = jTextField1.getText();
        USER = jTextField1.getText();        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
        //PASS = new String(jPasswordField2.getPassword());
        PASS = new String(jPasswordField2.getPassword());        
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        textPane.selectAll();
        textPane.replaceSelection("");        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
        host = jTextField4.getText();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
        port = Integer.parseInt(jTextField5.getText());
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        komenda = "ping -c 3 google.pl";
        
        try
        {
            JSch jsch = new JSch();

            Session session = jsch.getSession(USER, host, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(PASS);
            session.connect();

            String command = komenda;
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            channel.setInputStream(null);

            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();

            channel.connect();
            StringBuilder sb = new StringBuilder();
            byte[] tmp = new byte[1024];
            while (true)
            {
                while (in.available() > 0)
                {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0)
                        break;
                    sb.append(new String(tmp, 0, i));
                }
                if (channel.isClosed())
                {
                    if (in.available() > 0)
                        continue;
                    break;
                }
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception ee)
                {
                }
            }
            //disconnecting and closing
            channel.disconnect();

            session.disconnect();
            System.out.println("Test połączenia...");
            System.out.println(sb.toString());
            System.out.println("Test powiódł się!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }       
        
    redirectSystemStreams();        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        komenda = "sudo reboot now";
        
        try
        {
            JSch jsch = new JSch();

            Session session = jsch.getSession(USER, host, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(PASS);
            session.connect();

            String command = komenda;
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            channel.setInputStream(null);

            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();

            channel.connect();
            StringBuilder sb = new StringBuilder();
            byte[] tmp = new byte[1024];
            while (true)
            {
                while (in.available() > 0)
                {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0)
                        break;
                    sb.append(new String(tmp, 0, i));
                }
                if (channel.isClosed())
                {
                    if (in.available() > 0)
                        continue;
                    //System.out.println("exit-status: "
                    //        + channel.getExitStatus());
                    break;
                }
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception ee)
                {
                }
            }
            //disconnecting and closing
            channel.disconnect();

            session.disconnect();
            System.out.println("Restart serwera powiódł się.");
            System.out.println(sb.toString());
        }
        catch (Exception e)
        {
             //something should be done here
            e.printStackTrace();
        }       
                
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
    if(System.getProperty("os.name").startsWith("Windows")){
        System.out.println("Wykryty system operacyjny to Windows");
        
    } else if(System.getProperty("os.name").startsWith("Mac")) {
        System.out.println("Wykryty system operacyjny to macOS");

        PrintStream originalStream = System.out;

        PrintStream dummyStream    = new PrintStream(new OutputStream(){
            public void write(int b) {
                //NO-OP
            }
        });           
        
        Runtime rt = Runtime.getRuntime();
        String[] cmd = { "/bin/bash", "-c", "extensions/nmap -sP 192.168.1.1/24" };
        
        Process proc = null;
        try {
            proc = rt.exec(cmd);
        } catch (IOException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader is = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line;
        try {
            while ((line = is.readLine()) != null) {
                System.out.println(line);
                System.setOut(dummyStream);

            }
        
        System.setOut(originalStream);
            
        Runtime rt1 = Runtime.getRuntime();
        System.out.println("Twoje Raspberry PI w sieci: ");
        String[] cmd1 = { "/bin/bash", "-c", "arp -a | grep 'b8:27:eb'" };
        
        Process proc1 = null;
        try {
            proc1 = rt1.exec(cmd1);
        } catch (IOException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader is1 = new BufferedReader(new InputStreamReader(proc1.getInputStream()));
        String line1;
        try {
            while ((line1 = is1.readLine()) != null) {
                System.out.println(line1);
            }
            
              } catch (IOException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }   catch (IOException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else if(System.getProperty("os.name").startsWith("Linux")) {
        System.out.println("Wykryty system operacyjny to GNU/Linux");
        
    }
    
              
    }//GEN-LAST:event_jButton5ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToolBar jToolBar1;
    private static javax.swing.JToolBar jToolBar3;
    private javax.swing.JTextPane textPane;
    // End of variables declaration//GEN-END:variables
    
}
