 package tetrisAI.PlayerBlocks;
 
 import java.awt.Image;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 import tetrisAI.PlayerClasses.CellPlayer;
 import tetrisAI.PlayerClasses.MapPlayer;
 import tetrisAI.PlayerClasses.PiecePlayer;
 
 
 
 
 
 public class zBlockPlayer
   extends PiecePlayer
 {
   private int id = 7;
   
   private int value = 7;
 
 
   
   public zBlockPlayer() {
     this.blocks[0].setRow(0);
     this.blocks[0].setColumn(4);
     this.blocks[0].setValue(7);
     this.blocks[1].setRow(0);
     this.blocks[1].setColumn(5);
     this.blocks[1].setValue(7);
     this.blocks[2].setRow(1);
     this.blocks[2].setColumn(5);
     this.blocks[2].setValue(7);
     this.blocks[3].setRow(1);
     this.blocks[3].setColumn(6);
     this.blocks[3].setValue(7);
     setState(true, 0);
     
     try {
       this.image = ImageIO.read(getClass().getResource("/resources/redsquare.png"));
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
   
   public void Rotate(MapPlayer map) {
     boolean restoreLeft = false;
     boolean restoreRight = false;
     
     if (!canMoveLeft(map)) {
       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
       restoreLeft = true;
     
     }
     else if (!canMoveRight(map)) {
       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
       restoreRight = true;
     } 
     
     if (this.state[0]) {
       
       this.blocks[0].setRow(this.blocks[0].getRow() + 1);
       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
       
       this.blocks[2].setRow(this.blocks[2].getRow() - 1);
       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
       
       this.blocks[3].setRow(this.blocks[3].getRow() - 2);
       this.blocks[3].setColumn(this.blocks[3].getColumn());
       
       this.state[0] = false;
       this.state[1] = true;
 
 
     
     }
     else if (this.state[1]) {
       this.blocks[0].setRow(this.blocks[0].getRow() - 1);
       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
       
       this.blocks[2].setRow(this.blocks[2].getRow() + 1);
       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
       
       this.blocks[3].setRow(this.blocks[3].getRow() + 2);
       this.blocks[3].setColumn(this.blocks[3].getColumn());
       
       this.state[0] = true;
       this.state[1] = false;
     } 
 
     
     if (canMoveLeft(map) && restoreLeft) {
       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
       restoreLeft = false;
     } 
     
     if (canMoveRight(map) && restoreRight) {
       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
       restoreRight = false;
     } 
   }
 }
