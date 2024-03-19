/*    */ package tetrisAI.PlayerClasses;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmptyBlockPlayer
/*    */   extends CellPlayer
/*    */ {
/* 15 */   private int id = 0;
/*    */   
/*    */   private static Image image;
/*    */   
/*    */   public EmptyBlockPlayer(int r, int c, int v) {
/* 20 */     super(r, c, v);
/*    */     
/*    */     try {
/* 23 */       image = ImageIO.read(getClass().getResource("/resources/background.png"));
/* 24 */       Image icon = image.getScaledInstance(30, 30, 4);
/* 25 */       image = icon;
/* 26 */     } catch (IOException e) {
/*    */       
/* 28 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Image getImage() {
/* 35 */     return image;
/*    */   }
/*    */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/PlayerClasses/EmptyBlockPlayer.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */