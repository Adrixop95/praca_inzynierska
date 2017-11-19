/*

Created by Adrian Rupala 2017

*/

package picturetest;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In elementum, libero sed dignissim ultrices, ante ligula ultricies dui, blandit vestibulum mi diam sed lorem. Maecenas pellentesque tellus vel feugiat posuere. Vestibulum efficitur id mauris in mattis. Sed et ipsum pharetra, semper urna in, condimentum magna. Sed tellus mi, gravida ut viverra vel, mollis id enim. Cras egestas dolor sapien, a sollicitudin libero iaculis vitae. Praesent volutpat non felis ac iaculis. Vestibulum luctus, quam quis viverra euismod, purus elit fermentum leo, eu vehicula lacus felis in nibh.";
        String resized_location = "/Users/adrix/Pictures/pictures_test/";
        BufferedImage img_res = ImageIO.read(new File("/Users/adrix/Pictures/pictures_test/luska1.png"));
                     
        BufferedImage a = createResizedCopy(img_res, 200, 200, false);
        ImageIO.write(a, "PNG", new File(resized_location, "resized.png"));     
        
        byte[] b = mergeImageAndText(url, title, text, new Point(45, 170), new Point(45,240));
        
        filename = "/Users/adrix/Pictures/pictures_test/obraz"+countedimage+".png";
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(b);
        fos.close();
        
        BufferedImage img_text = ImageIO.read(new File("/Users/adrix/Pictures/pictures_test/resized.png")); 
        BufferedImage img_back = ImageIO.read(new File (filename));
        
        int w = Math.max(img_text.getWidth(), img_back.getWidth());
        int h = Math.max(img_text.getHeight(), img_back.getHeight());
        BufferedImage combined = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB);
        
        Graphics g = combined.getGraphics();
        g.drawImage(img_back, 0, 0, null);
        g.drawImage(img_text, 630, 130, null);
        
        String picname = "polaczone"+countedimage+".png";
        ImageIO.write(combined, "PNG", new File(resized_location+"/output", picname));
        
        File del1 = new File("/Users/adrix/Pictures/pictures_test/resized.png");
        File del2 = new File(filename);
        del1.delete();
        del2.delete();
    }
    
    public static byte[] mergeImageAndText(String imageFilePath,
            String text, String text2, 
            Point textPosition, Point textPosition2) throws IOException {
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
        drawStringMultiLine(g2, text2, 30, textPosition2.x, textPosition2.y);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(im, "png", baos);
        return baos.toByteArray();
    }
      
    
    public static BufferedImage createResizedCopy(Image originalImage, 
        int scaledWidth, int scaledHeight, 
            boolean preserveAlpha){
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
        g.dispose();
        return scaledBI;
    } 
    
    public static void drawStringMultiLine(Graphics2D g, String text, int lineWidth, int x, int y) {
        FontMetrics m = g.getFontMetrics();
        if(m.stringWidth(text) < lineWidth) {
            g.drawString(text, x, y);
        } else {
            //String[] words = text.split(" ");
            String[] words = text.split("(?<=\\G.{55})");
            String currentLine = words[0];
            for(int i = 1; i < words.length; i++) {
                if(m.stringWidth(currentLine+words[i]) < lineWidth) {
                    currentLine += " "+words[i];
                } else {
                    g.drawString(currentLine, x, y);
                    y += m.getHeight();
                    currentLine = words[i];
                }
            }
            if(currentLine.trim().length() > 0) {
                g.drawString(currentLine, x, y);
            }
        }
    }

    
    public static String getSubnet(String firststring) {
        int firstSeparator = firststring.lastIndexOf("/");
        int lastSeparator = firststring.lastIndexOf(".");
        return firststring.substring(firstSeparator+1, lastSeparator+1);
    }   
}


