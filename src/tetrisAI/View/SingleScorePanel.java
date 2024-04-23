 package tetrisAI.View;
 
 import java.awt.Color;
 import java.awt.Dimension;
 import java.awt.Font;
 import java.awt.Graphics;
 import javax.swing.JPanel;
 
 
 
 
 
 public class SingleScorePanel
   extends JPanel
 {
   private Integer scorePlayer;
   private Integer level;
   private int precscore;
   private int increasepoints;
   
   public SingleScorePanel() {
     this.scorePlayer = Integer.valueOf(0);
     
     this.level = Integer.valueOf(1);
     
     this.precscore = 0;
     
     this.increasepoints = 10;
     
     setPreferredSize(new Dimension(150, 150));
     setBackground(Color.BLACK);
   }
 
   
   public void setScorePlayer(int points) {
     this.scorePlayer = Integer.valueOf(points);
   }
 
   
   public int getScorePlayer() {
     return this.scorePlayer.intValue();
   }
   
   public int getIncreasePoints() {
     return this.increasepoints;
   }
   
   public void updateIncreasePoints() {
     this.increasepoints *= 3;
   }
   
   public int getPrecScore() {
     return this.precscore;
   }
   
   public void updatePrecScore() {
     this.precscore += 50;
   }
   
   public void increaseLevel() {
     this.level = Integer.valueOf(this.level.intValue() + 1);
   }
 
   
   public synchronized void paintComponent(Graphics g) {
     super.paintComponent(g);
     
     g.setColor(Color.LIGHT_GRAY);
     
     g.setFont(new Font("Arial", 0, 20));
     g.drawString("SCORE:", 5, 30);
     
     String player = this.scorePlayer.toString();
     g.setFont(new Font("Arial", 0, 40));
     g.drawString(player, 65, 70);
     
     g.setFont(new Font("Arial", 0, 20));
     g.drawString("LEVEL:", 5, 95);
     
     String lvl = this.level.toString();
     g.setFont(new Font("Arial", 0, 40));
     g.drawString(lvl, 65, 135);
   }
 }
