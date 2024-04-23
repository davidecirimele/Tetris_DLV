 package tetrisAI.PlayerClasses;
 
 import java.awt.Image;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 
 
 
 
 
 
 public class EmptyBlockPlayer
   extends CellPlayer
 {
   private int id = 0;
   
   private static Image image;
   
   public EmptyBlockPlayer(int r, int c, int v) {
     super(r, c, v);
     
     try {
       image = ImageIO.read(getClass().getResource("/resources/background.png"));
       Image icon = image.getScaledInstance(30, 30, 4);
       image = icon;
     } catch (IOException e) {
       
       e.printStackTrace();
     } 
   }
 
 
   
   public Image getImage() {
     return image;
   }
 }
