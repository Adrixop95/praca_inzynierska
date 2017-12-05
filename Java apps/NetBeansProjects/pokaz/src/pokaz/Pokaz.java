/*

Created by Adrian Rupala 2017

*/

package pokaz;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner; 


public class Pokaz extends JFrame{
    JLabel pic;
    Timer tm;
    int x = 0;
    public static String path_to_files;
    private static String OS = System.getProperty("os.name").toLowerCase();
    public static int y = 0;
    public static ArrayList<String> list = new ArrayList<String>();
    
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    
    public Pokaz(){
        super("PokazSMCEBI");
                
        pic = new JLabel();
        pic.setBounds(0, 0, width, height);

        SetImageSize(y);
        
        tm = new Timer(50000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.size() )
                    x = 0; 
            }
        });
        add(pic);
        tm.start();
        setLayout(null);
        setSize(width, height);
        getContentPane().setBackground(Color.decode("#808080"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true);
    }
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list.get(i));
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

    public static void main(String[] args) throws FileNotFoundException{ 
    
    if(System.getProperty("os.name").startsWith("Linux")){
        System.out.println("Wykryty system operacyjny to GNU/Linux.");
        path_to_files = "/mnt/gdrivefs/display_pictures";
    } else {
        System.out.println("Nie wykryto systemu operacyjnego, podaj sciezke recznie: ");
        Scanner diff_path = new Scanner(System.in);
        path_to_files = diff_path.next();
    }   
    File path = new File(path_to_files);
    File [] files = path.listFiles();
    
        for (int i = 0; i < files.length; i++){
            if (files[i].isFile() | !files[i].isHidden()){
                y = y+1-1;
                ByteArrayOutputStream test = new ByteArrayOutputStream();
                PrintStream PS = new PrintStream(test);
                PrintStream old = System.out;
                System.setOut(PS);
                list.add(files[i].toString());
            }
        }
        new Pokaz();
    }
}
