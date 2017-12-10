/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_arp_win;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adria
 */
public class Test_arp_win {
    
    public static String[] cmd_arp  = new String[3];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runtime rt_arp = Runtime.getRuntime();
        //String[] cmd_arp = { "/bin/bash", "-c", "arp -an | grep 'b8:27:eb'" };
        
        if(System.getProperty("os.name").startsWith("Windows")){
            cmd_arp[0] = "cmd";
            cmd_arp[1] = "/c";
            cmd_arp[2] = "arp -a | findstr \"b8-27-eb\"";
        } else {
            cmd_arp[0] = "/bin/bash";
            cmd_arp[1] = "-c";
            cmd_arp[2] = "arp -an | grep 'b8:27:eb'";
        }   
                
        Process proc_arp = null;
        try {
            proc_arp = rt_arp.exec(cmd_arp);
        } catch (IOException ex) {
        }
        
        BufferedReader is_arp = new BufferedReader(new InputStreamReader(proc_arp.getInputStream()));
        
        String line_arp;
        try {
            while ((line_arp = is_arp.readLine()) != null) {
                if(System.getProperty("os.name").startsWith("Windows")){
                    String[] parts = line_arp.split(" ");
                    System.out.println("Adress ip: " + parts[2] + ", adress mac: "+ parts[12]);
                } else {
                    String[] parts = line_arp.split(" ");
                    System.out.println("Nazwa urządzenia: " + parts[0] + ", adress ip: " + parts[1].substring(1, parts[1].length()-1) + ", adress mac: "+ parts[3]);
                }   
            }
              } catch (IOException ex) {
            Logger.getLogger(appframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
