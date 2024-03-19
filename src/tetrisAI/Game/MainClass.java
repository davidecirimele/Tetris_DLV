/*    */ package tetrisAI.Game;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import javax.swing.JFrame;
/*    */ import tetrisAI.View.GamePanel;
/*    */ import tetrisAI.View.StartPanel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MainClass
/*    */   implements Runnable
/*    */ {
/*    */   private GamePanel g;
/*    */   
/*    */   public static void main(String[] args) {
/* 38 */     JFrame f = new JFrame();
/*    */ 
/*    */     
/* 41 */     StartPanel s = new StartPanel();
/*    */     
/* 43 */     f.add((Component)s, "Center");
/* 44 */     f.setVisible(true);
/*    */     
/* 46 */     f.setTitle("TETRIS");
/* 47 */     f.setSize(300, 600);
/* 48 */     f.setResizable(false);
/* 49 */     f.setDefaultCloseOperation(3);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/*    */     while (true)
/* 56 */       this.g.repaint(); 
/*    */   }
/*    */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/Game/MainClass.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */