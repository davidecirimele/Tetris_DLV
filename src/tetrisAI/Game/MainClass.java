 package tetrisAI.Game;
 
 import java.awt.Component;
 import javax.swing.JFrame;
 import tetrisAI.View.GamePanel;
 import tetrisAI.View.StartPanel;
 
 
 public class MainClass implements Runnable
 {
   private GamePanel g;
   
   public static void main(String[] args) {
     JFrame f = new JFrame();
 
     
     StartPanel s = new StartPanel();
     
     f.add((Component)s, "Center");
     f.setVisible(true);
     
     f.setTitle("TETRIS");
     f.setSize(300, 600);
     f.setResizable(false);
     f.setDefaultCloseOperation(3);
   }
 
 
   
   public void run() {
     while (true)
       this.g.repaint(); 
   }
 }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/Game/MainClass.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */