 package tetrisAI.AIBlocks;
 
 import java.awt.Image;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 import tetrisAI.AIClasses.Cell;
 import tetrisAI.AIClasses.Map;
 import tetrisAI.AIClasses.Piece;
 import tetrisAI.PlayerClasses.CellPlayer;
 
 
 
 
 public class jBlock
   extends Piece
 {
   private int id = 2;
   
   private int value = 2;
 
 
 
 
   
   public jBlock() {
     this.blocks[0].setRow(0);
     this.blocks[0].setColumn(4);
     this.blocks[0].setValue(2);
     this.blocks[1].setRow(1);
     this.blocks[1].setColumn(4);
     this.blocks[1].setValue(2);
     this.blocks[2].setRow(1);
     this.blocks[2].setColumn(5);
     this.blocks[2].setValue(2);
     this.blocks[3].setRow(1);
     this.blocks[3].setColumn(6);
     this.blocks[3].setValue(2);
     setState(true, 0);
 
     
     try {
       this.image = ImageIO.read(getClass().getResource("/resources/blue.png"));
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
       
       this.blocks[0].setRow(this.blocks[0].getRow() + 2);
       this.blocks[0].setColumn(this.blocks[0].getColumn());
       
       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
       
       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
       
       this.state[0] = false;
       this.state[1] = true;
 
 
     
     }
     else if (this.state[1]) {
       this.blocks[0].setRow(this.blocks[0].getRow());
       this.blocks[0].setColumn(this.blocks[0].getColumn() + 2);
       
       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
       
       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
       
       this.state[2] = true;
       this.state[1] = false;
 
     
     }
     else if (this.state[2]) {
       this.blocks[0].setRow(this.blocks[0].getRow() - 2);
       this.blocks[0].setColumn(this.blocks[0].getColumn());
       
       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
       
       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
       
       this.state[3] = true;
       this.state[2] = false;
 
     
     }
     else if (this.state[3]) {
       
       this.blocks[0].setRow(this.blocks[0].getRow());
       this.blocks[0].setColumn(this.blocks[0].getColumn() - 2);
       
       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
       
       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
       
       this.state[0] = true;
       this.state[3] = false;
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

