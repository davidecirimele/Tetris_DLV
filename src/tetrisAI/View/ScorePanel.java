 package tetrisAI.View;
 
 import java.awt.Color;
 import java.awt.Dimension;
 import java.awt.Font;
 import java.awt.Graphics;
 import javax.swing.JPanel;
 
 
 
 public class ScorePanel
   extends JPanel
 {
   private Integer scoreAI;
   private Integer scorePlayer;
   
   public ScorePanel() {
     this.scoreAI = Integer.valueOf(0);
     this.scorePlayer = Integer.valueOf(0);
     
     setPreferredSize(new Dimension(200, 200));
     setBackground(Color.BLACK);
   }
 
   
   public void setScoreAI(int points) {
     this.scoreAI = Integer.valueOf(points);
   }
   
   public void setScorePlayer(int points) {
     this.scorePlayer = Integer.valueOf(points);
   }
   
   public int getScoreAI() {
     return this.scoreAI.intValue();
   }
   
   public int getScorePlayer() {
     return this.scorePlayer.intValue();
   }
 
   
   public synchronized void paintComponent(Graphics g) {
     super.paintComponent(g);
     
     g.setColor(Color.LIGHT_GRAY);
 
     
     g.setFont(new Font("Arial", 0, 20));
     g.drawString("SCORE AI:", 15, 20);
     
     String AI = this.scoreAI.toString();
     g.setFont(new Font("Arial", 0, 40));
     g.drawString(AI, 100, 70);
     
     g.setFont(new Font("Arial", 0, 20));
     g.drawString("SCORE PLAYER:", 15, 120);
     
     String player = this.scorePlayer.toString();
     g.setFont(new Font("Arial", 0, 40));
     g.drawString(player, 100, 170);
   }
 }

