package JavaDB_001;

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


public class Pokaz extends JFrame{
    JLabel pic;
    Timer tm;
    int x = 0;
    public static String path_to_files = "/Users/adrix/Pictures/pics_test";
    public static int y = 0;
    
    public static ArrayList<String> list = new ArrayList<String>();
    
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    
    public Pokaz(){
        super("Pokaz_SMCEBI");
        
        System.out.println("Wykryta rozdzielczosc to: "+width+"x"+height);
        
        pic = new JLabel();
        pic.setBounds(0, 0, width, height);

        //Call The Function SetImageSize
        SetImageSize(y);
        
       //set a timer
        tm = new Timer(1500,new ActionListener() {

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
    //create a function to resize the image 
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list.get(i));
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

    public static void main(String[] args) throws FileNotFoundException{ 
        
    File path = new File(path_to_files);
    
    File [] files = path.listFiles();
    
        for (int i = 0; i < files.length; i++){
            if (files[i].isFile()){ //this line weeds out other directories/folders
                System.out.println(files[i]);
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
