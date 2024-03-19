/*    */ package tetrisAI.View;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ScorePanel
/*    */   extends JPanel
/*    */ {
/*    */   private Integer scoreAI;
/*    */   private Integer scorePlayer;
/*    */   
/*    */   public ScorePanel() {
/* 18 */     this.scoreAI = Integer.valueOf(0);
/* 19 */     this.scorePlayer = Integer.valueOf(0);
/*    */     
/* 21 */     setPreferredSize(new Dimension(200, 200));
/* 22 */     setBackground(Color.BLACK);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setScoreAI(int points) {
/* 27 */     this.scoreAI = Integer.valueOf(points);
/*    */   }
/*    */   
/*    */   public void setScorePlayer(int points) {
/* 31 */     this.scorePlayer = Integer.valueOf(points);
/*    */   }
/*    */   
/*    */   public int getScoreAI() {
/* 35 */     return this.scoreAI.intValue();
/*    */   }
/*    */   
/*    */   public int getScorePlayer() {
/* 39 */     return this.scorePlayer.intValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void paintComponent(Graphics g) {
/* 44 */     super.paintComponent(g);
/*    */     
/* 46 */     g.setColor(Color.LIGHT_GRAY);
/*    */ 
/*    */     
/* 49 */     g.setFont(new Font("Arial", 0, 20));
/* 50 */     g.drawString("SCORE AI:", 15, 20);
/*    */     
/* 52 */     String AI = this.scoreAI.toString();
/* 53 */     g.setFont(new Font("Arial", 0, 40));
/* 54 */     g.drawString(AI, 100, 70);
/*    */     
/* 56 */     g.setFont(new Font("Arial", 0, 20));
/* 57 */     g.drawString("SCORE PLAYER:", 15, 120);
/*    */     
/* 59 */     String player = this.scorePlayer.toString();
/* 60 */     g.setFont(new Font("Arial", 0, 40));
/* 61 */     g.drawString(player, 100, 170);
/*    */   }
/*    */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/View/ScorePanel.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */