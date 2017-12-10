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
import java.util.List;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class Picturetest {
   
    public static void main(String[] args) throws IOException {
        
        String filename;
        int countedimage = 0;
        
        File folder = new File("C:/Users/adria/Pictures/pictures_test/output/");
        File[] filelist = folder.listFiles();
        
        for (int i = 0; i < filelist.length; i++){
            countedimage += 1;
        }
        
        String url = "file:///C:/Users/adria/Pictures/pictures_test/smcebi.png";
        String title = "Zażółć gęślą jaźń.";
        String text = "Lorem ipsum dolor sit amet, conse????ctetur? adipiscing elielitelittelitelitelit . In elementum, libero? sed dignissim ultrices, ante ligula ultricies dui, blandit vestibulum mi diam sed lorem. Maecenas pellentesque tellus vel feugiat posuere. Vestibulum efficitur id mauris in mattis. Sed et ipsum pharetra, semper urna in, condimentum magna. Sed tellus mi, gravida ut viverra vel, mollis id enim. Cras egestas dolor sapien, a sollicitudin libero iaculis vitae. Praesent volutpat non felis ac iaculis. Vestibulum luctus, quam quis viverra euismod, purus elit fermentum leo, eu vehicula lacus felis in nibh.";
        String resized_location = "C:/Users/adria/Pictures/pictures_test/resized/";
        BufferedImage img_res = ImageIO.read(new File("C:/Users/adria/Pictures/rory-hennessey-345299.jpg"));
                     
        BufferedImage a = createResizedCopy(img_res, 610, 480, false);
        ImageIO.write(a, "PNG", new File(resized_location, "resized.png"));     
        
        byte[] b = mergeImageAndText(url, title, text, new Point(37, 170), new Point(37,240));
        
        filename = "C:/Users/adria/Pictures/pictures_test/resized/"+countedimage+".png";
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(b);
        fos.close();
        
        BufferedImage img_text = ImageIO.read(new File("C:/Users/adria/Pictures/pictures_test/resized/resized.png")); 
        BufferedImage img_back = ImageIO.read(new File (filename));
        
        int w = Math.max(img_text.getWidth(), img_back.getWidth());
        int h = Math.max(img_text.getHeight(), img_back.getHeight());
        BufferedImage combined = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB);
        
        Graphics g = combined.getGraphics();
        g.drawImage(img_back, 0, 0, null);
        g.drawImage(img_text, 630, 120, null);
        
        String picname = "polaczone"+countedimage+".png";
        ImageIO.write(combined, "PNG", new File(resized_location, picname));
        
        //File del1 = new File("/Users/adrix/Pictures/pictures_test/resized.png");
        //File del2 = new File(filename);
        //File del_text = new File("/Users/adrix/Pictures/pictures_test/text.txt");
        //del1.delete();
        //del2.delete();
        //del_text.delete();
        
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
    
    public static void drawStringMultiLine(Graphics2D g, String text, int lineWidth, int x, int y) throws FileNotFoundException, IOException {
        FontMetrics m = g.getFontMetrics();
        if(m.stringWidth(text) < lineWidth) {
            g.drawString(text, x, y);
        } else {
            StringBuilder justifiedText = new StringBuilder();
            StringBuilder justifiedLine = new StringBuilder();
            String[] words_spl = text.split(" ");
            for (int i = 0; i < words_spl.length; i++) {
                justifiedLine.append(words_spl[i]).append(" ");
                if (i+1 == words_spl.length || justifiedLine.length() + words_spl[i+1].length() > 56) {
                    justifiedLine.deleteCharAt(justifiedLine.length() - 1);
                    justifiedText.append(justifiedLine.toString()).append(System.lineSeparator());
                    justifiedLine = new StringBuilder();
                }
            }
            String words_text = justifiedText.toString();
            
            System.out.print(words_text);
            try(  PrintWriter out = new PrintWriter("C:/Users/adria/Pictures/pictures_test/resized/text.txt")){
                out.println( words_text );
            }

            String[] words = null;
            
            List<String> items = new ArrayList<String>();
            try 
            { 
                FileInputStream fstream_school = new FileInputStream("C:/Users/adria/Pictures/pictures_test/resized/text.txt"); 
                DataInputStream data_input = new DataInputStream(fstream_school); 
                BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input)); 
                String str_line; 

                while ((str_line = buffer.readLine()) != null) 
                { 
                    str_line = str_line.trim(); 
                    if ((str_line.length()!=0))  
                    { 
                        items.add(str_line);
                    } 
                }

                words = (String[])items.toArray(new String[items.size()]);
            } catch(SocketException e) { }

            
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
}