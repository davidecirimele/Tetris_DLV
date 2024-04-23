 package tetrisAI.AIBlocks;
 
 import java.awt.Image;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 import tetrisAI.AIClasses.Cell;
 import tetrisAI.AIClasses.Map;
 import tetrisAI.AIClasses.Piece;
 import tetrisAI.PlayerClasses.CellPlayer;
 
 
 
 
 public class sBlock
   extends Piece
 {
   private int id = 5;
   
   private int value = 5;
 
 
   
   public sBlock() {
     this.blocks[0].setRow(0);
     this.blocks[0].setColumn(5);
     this.blocks[0].setValue(5);
     this.blocks[1].setRow(0);
     this.blocks[1].setColumn(6);
     this.blocks[1].setValue(5);
     this.blocks[2].setRow(1);
     this.blocks[2].setColumn(4);
     this.blocks[2].setValue(5);
     this.blocks[3].setRow(1);
     this.blocks[3].setColumn(5);
     this.blocks[3].setValue(5);
     setState(true, 0);
     try {
       this.image = ImageIO.read(getClass().getResource("/resources/green.png"));
       Image icon = this.image.getScaledInstance(30, 30, 4);
       this.image = icon;
     } catch (IOException e) {
       
       e.printStackTrace();
     } 
   }
 
 
   
   public Cell[] getPiece() {
     return this.blocks;
   }
 
 
   
   public int getValue() {
     return this.value;
   }
   
   public void setValue(int value) {
     this.value = value;
   }
   
   public void Rotate(Map map) {
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
 
       
       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
       
       this.blocks[2].setRow(this.blocks[2].getRow());
       this.blocks[2].setColumn(this.blocks[2].getColumn() + 2);
       
       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
       
       this.state[0] = false;
       this.state[1] = true;
 
 
     
     }
     else if (this.state[1]) {
       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
       
       this.blocks[2].setRow(this.blocks[2].getRow());
       this.blocks[2].setColumn(this.blocks[2].getColumn() - 2);
       
       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
       
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
