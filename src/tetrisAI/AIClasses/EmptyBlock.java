 package tetrisAI.AIClasses;
 
 import it.unical.mat.embasp.languages.Id;
 import it.unical.mat.embasp.languages.Param;
 import java.awt.Image;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 
 
 @Id("emptyBlock")
 public class EmptyBlock
   extends Cell
 {
   @Param(1)
   private int id = 0;
   
   private static Image image;
   
   public EmptyBlock(int r, int c, int v) {
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

