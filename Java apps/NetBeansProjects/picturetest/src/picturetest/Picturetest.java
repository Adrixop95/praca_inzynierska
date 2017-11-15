package picturetest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import javax.imageio.ImageIO;


public class Picturetest {

    
    
    public static void main(String[] args) throws IOException {
        
        String filename;
        int countedimage = 0;
        
        File folder = new File("/Users/adrix/Pictures/pictures_test/output");
        File[] filelist = folder.listFiles();
        
        for (int i = 0; i < filelist.length; i++){
            countedimage += 1;
        }
        
        String url = "file:///Users/adrix/Pictures/pictures_test/smcebi.png";
        String title = "Zażółć gęślą jaźń.";
        String text = "123qweqweqwewqeqewqeqweqeqweqweqwewq";
        byte[] b = mergeImageAndText(url, title, text, new Point(45, 170), new Point(200,200));

        filename = "/Users/adrix/Pictures/pictures_test/output/obraz"+countedimage+".png";
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(b);
        fos.close();
        
    }

    public static byte[] mergeImageAndText(String imageFilePath,
            String text, String text2, Point textPosition, Point textPosition2) throws IOException {
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
        g2.drawString(text2, textPosition2.x, textPosition2.y);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(im, "png", baos);
        return baos.toByteArray();
    }
}
