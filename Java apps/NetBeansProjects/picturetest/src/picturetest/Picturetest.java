package picturetest;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
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
        String text = "no i ja się pytam człowieku dumny ty jesteś z siebie zdajesz sobie sprawę z tego co robisz?masz ty wogóle rozum i godnośc człowieka?ja nie wiem ale żałosny typek z ciebie ,chyba nie pomyślałes nawet co robisz i kogo obrażasz ,możesz sobie obrażac tych co na to zasłużyli sobie ale nie naszego papieża polaka naszego rodaka wielką osobę ,i tak wyjątkowa i ważną bo to nie jest ktoś tam taki sobie że możesz go sobie wyśmiać bo tak ci się podoba nie wiem w jakiej ty się wychowałes rodzinie ale chyba ty nie wiem nie rozumiesz co to jest wiara .jeśli myslisz że jestes wspaniały to jestes zwykłym czubkiem którego ktoś nie odizolował jeszcze od społeczeństwa ,nie wiem co w tym jest takie śmieszne ale czepcie się stalina albo hitlera albo innych zwyrodnialców a nie czepiacie się takiej świętej osoby jak papież jan paweł 2 .jak można wogóle publicznie zamieszczac takie zdięcia na forach internetowych?ja się pytam kto powinien za to odpowiedziec bo chyba widac że do koscioła nie chodzi jak jestes nie wiem ateistą albo wierzysz w jakies sekty czy wogóle jestes może ty sługą szatana a nie będziesz z papieża robił takiego ,to ty chyba jestes jakis nie wiem co sie jarasz pomiotami szatana .wez pomyśl sobie ile papież zrobił ,on był kimś a ty kim jestes żeby z niego sobie robić kpiny co? kto dał ci prawo obrażac wogóle papieża naszego ?pomyślałes wogóle nad tym że to nie jest osoba taka sobie że ją wyśmieje i mnie będa wszyscy chwalic? wez dziecko naprawdę jestes jakis psycholek bo w przeciwieństwie do ciebie to papież jest autorytetem dla mnie a ty to nie wiem czyim możesz być autorytetem chyba takich samych jakiś głupków jak ty którzy nie wiedza co to kosciół i religia ,widac że się nie modlisz i nie chodzisz na religie do szkoły ,widac nie szanujesz religii to nie wiem jak chcesz to sobie wez swoje zdięcie wstaw ciekawe czy byś sie odważył .naprawdę wezta się dzieci zastanówcie co wy roicie bo nie macie widac pojęcia o tym kim był papież jan paweł2 jak nie jestescie w pełni rozwinięte umysłowo to się nie zabierajcie za taką osobę jak ojciec swięty bo to świadczy o tym że nie macie chyba w domu krzyża ani jednego obraza świętego nie chodzi tutaj o kosciół mnie ale wogóle ogólnie o zasady wiary żeby mieć jakąs godnosc bo papież nikogo nie obrażał a ty za co go obrażasz co? no powiedz za co obrażasz taką osobę jak ojciec święty ?brak mnie słów ale jakbyś miał pojęcie chociaz i sięgnął po pismo święte i poczytał sobie to może byś się odmienił .nie wiem idz do kościoła bo widac już dawno szatan jest w tobie człowieku ,nie lubisz kościoła to chociaż siedz cicho i nie obrażaj innych ludzi .";
        String resized_location = "/Users/adrix/Pictures/pictures_test/";
        BufferedImage img_res = ImageIO.read(new File("/Users/adrix/Pictures/pictures_test/luska1.png"));
        
        int counterarr = 0;
        String[] array = null;
        
        if (text.length() > 20){
            array = text.split("(?<=\\G.{20})");

            for (int i = 0; i < array.length; i++){
                if (array[i] != null){
                    counterarr++;
                }
            }
            counterarr--;
        }
       
        BufferedImage a = createResizedCopy(img_res, 200, 200, false);
        ImageIO.write(a, "PNG", new File(resized_location, "resized.png"));     
        
        byte[] b = mergeImageAndText(url, title, text, new Point(45, 170), new Point(45,220));
        
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
        g2.drawString(text2, textPosition2.x, textPosition2.y);
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
    
    public static String getSubnet(String firststring) {
        int firstSeparator = firststring.lastIndexOf("/");
        int lastSeparator = firststring.lastIndexOf(".");
        return firststring.substring(firstSeparator+1, lastSeparator+1);
    }   
}


