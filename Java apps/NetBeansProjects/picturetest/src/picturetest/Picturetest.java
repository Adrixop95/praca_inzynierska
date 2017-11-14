package picturetest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;


public class Picturetest {

    public static void main(String[] args) throws IOException {
        String url = "file:///Users/adrix/smcebi.png";
        String text = "Zażółć gęślą jaźń.";
        byte[] b = mergeImageAndText(url, text, new Point(45, 170));
        FileOutputStream fos = new FileOutputStream("pic1.png");
        fos.write(b);
        fos.close();
        
    }

    public static byte[] mergeImageAndText(String imageFilePath,
            String text, Point textPosition) throws IOException {
        BufferedImage im = ImageIO.read(new URL(imageFilePath));
        Graphics2D g2 = im.createGraphics();
        g2.setColor(Color.black);
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setFont(new Font("Arial", Font.BOLD, 20)); 
        g2.drawString(text, textPosition.x, textPosition.y);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(im, "png", baos);
        return baos.toByteArray();
    }
    
    
}
