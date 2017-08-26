import javax.swing.*;
import java.awt.*;
import java.awt.Image;

public class Pokaz extends JFrame{
    JLabel pic;
    Timer tm;
    int x = 0;
    String[] list = {
        
    };
    
    public Pokaz(){
        
    }
    
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
    }
    
    public static void main(String[] args){
        
        new Pokaz();
        
    }
}