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
/*    */ 
/*    */ 
/*    */ public class SingleScorePanel
/*    */   extends JPanel
/*    */ {
/*    */   private Integer scorePlayer;
/*    */   private Integer level;
/*    */   private int precscore;
/*    */   private int increasepoints;
/*    */   
/*    */   public SingleScorePanel() {
/* 22 */     this.scorePlayer = Integer.valueOf(0);
/*    */     
/* 24 */     this.level = Integer.valueOf(1);
/*    */     
/* 26 */     this.precscore = 0;
/*    */     
/* 28 */     this.increasepoints = 10;
/*    */     
/* 30 */     setPreferredSize(new Dimension(150, 150));
/* 31 */     setBackground(Color.BLACK);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setScorePlayer(int points) {
/* 36 */     this.scorePlayer = Integer.valueOf(points);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getScorePlayer() {
/* 41 */     return this.scorePlayer.intValue();
/*    */   }
/*    */   
/*    */   public int getIncreasePoints() {
/* 45 */     return this.increasepoints;
/*    */   }
/*    */   
/*    */   public void updateIncreasePoints() {
/* 49 */     this.increasepoints *= 3;
/*    */   }
/*    */   
/*    */   public int getPrecScore() {
/* 53 */     return this.precscore;
/*    */   }
/*    */   
/*    */   public void updatePrecScore() {
/* 57 */     this.precscore += 50;
/*    */   }
/*    */   
/*    */   public void increaseLevel() {
/* 61 */     this.level = Integer.valueOf(this.level.intValue() + 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void paintComponent(Graphics g) {
/* 66 */     super.paintComponent(g);
/*    */     
/* 68 */     g.setColor(Color.LIGHT_GRAY);
/*    */     
/* 70 */     g.setFont(new Font("Arial", 0, 20));
/* 71 */     g.drawString("SCORE:", 5, 30);
/*    */     
/* 73 */     String player = this.scorePlayer.toString();
/* 74 */     g.setFont(new Font("Arial", 0, 40));
/* 75 */     g.drawString(player, 65, 70);
/*    */     
/* 77 */     g.setFont(new Font("Arial", 0, 20));
/* 78 */     g.drawString("LEVEL:", 5, 95);
/*    */     
/* 80 */     String lvl = this.level.toString();
/* 81 */     g.setFont(new Font("Arial", 0, 40));
/* 82 */     g.drawString(lvl, 65, 135);
/*    */   }
/*    */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/View/SingleScorePanel.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */