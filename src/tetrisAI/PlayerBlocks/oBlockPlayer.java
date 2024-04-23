 package tetrisAI.PlayerBlocks;
 
 import java.awt.Image;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 import tetrisAI.PlayerClasses.CellPlayer;
 import tetrisAI.PlayerClasses.PiecePlayer;
 
 
 
 
 
 
 public class oBlockPlayer
   extends PiecePlayer
 {
   private int id = 4;
   
   private int value = 4;
 
 
   
   public oBlockPlayer() {
     this.blocks[0].setRow(0);
     this.blocks[0].setColumn(4);
     this.blocks[0].setValue(4);
     this.blocks[1].setRow(0);
     this.blocks[1].setColumn(5);
     this.blocks[1].setValue(4);
     this.blocks[2].setRow(1);
     this.blocks[2].setColumn(4);
     this.blocks[2].setValue(4);
     this.blocks[3].setRow(1);
     this.blocks[3].setColumn(5);
     this.blocks[3].setValue(4);
     setState(true, 0);
     
     try {
       this.image = ImageIO.read(getClass().getResource("/resources/yellow.png"));
       Image icon = this.image.getScaledInstance(30, 30, 4);
       this.image = icon;
     } catch (IOException e) {
       
       e.printStackTrace();
     } 
   }
 
   
   public CellPlayer[] getPiece() {
     return this.blocks;
   }
 
 
   
   public int getValue() {
     return this.value;
   }
   
   public void setValue(int value) {
     this.value = value;
   }
   
   public void Rotate() {}
 }
