package JavaDB_001;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.File;
import java.util.ArrayList;




public class Pokaz extends JFrame{
    JLabel pic;
    Timer tm;
    int x = 0;
    public static int y = 0;
    
    //Images Path In Array
    /*String[] list = {
                      "/Users/adrix/Desktop/pics/1.jpg",//0
                      "/Users/adrix/Desktop/pics/2.jpg",//1
                      "/Users/adrix/Desktop/pics/3.mp4",
                    };
    */
    
    ArrayList<String> list = new ArrayList<String>(){{
        add("/Users/adrix/Desktop/pics/1.jpg");
        add("/Users/adrix/Desktop/pics/2.jpg");
    }};
    
    public Pokaz(){
        super("Pokaz SMCEBI");
        pic = new JLabel();
        pic.setBounds(0, 0, 1366, 768);

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
        setSize(1366, 768);
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

    public static void main(String[] args){ 
        
    File path = new File("/Users/adrix/Desktop/pics/");

    File [] files = path.listFiles();
    for (int i = 0; i < files.length; i++){
        if (files[i].isFile()){ //this line weeds out other directories/folders
            System.out.println(files[i]);
            y = y+1-1;
        }
    }
      
        new Pokaz();
    }
}
