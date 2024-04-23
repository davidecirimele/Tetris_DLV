 package tetrisAI.PlayerBlocks;
 
 import java.awt.Image;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 import tetrisAI.PlayerClasses.CellPlayer;
 import tetrisAI.PlayerClasses.MapPlayer;
 import tetrisAI.PlayerClasses.PiecePlayer;
 
 
 
 
 
 
 
 public class iBlockPlayer
   extends PiecePlayer
 {
   private int id = 1;
 
   
   private int X1;
   
   private int Y1;
   
   private int X2;
   
   private int Y2;
   
   private int X3;
   
   private int Y3;
   
   private int X4;
   
   private int Y4;
   
   private int value = 1;
 
 
 
 
 
   
   public iBlockPlayer() {
     this.blocks[0].setRow(0);
     this.blocks[0].setColumn(4);
     this.blocks[0].setValue(1);
     this.blocks[1].setRow(0);
     this.blocks[1].setColumn(5);
     this.blocks[1].setValue(1);
     this.blocks[2].setRow(0);
     this.blocks[2].setColumn(6);
     this.blocks[2].setValue(1);
     this.blocks[3].setRow(0);
     this.blocks[3].setColumn(7);
     this.blocks[3].setValue(1);
     setState(true, 0);
     
     this.X1 = this.blocks[0].getRow();
     this.Y1 = this.blocks[0].getColumn();
     
     this.X2 = this.blocks[1].getRow();
     this.Y2 = this.blocks[1].getColumn();
     
     this.X3 = this.blocks[2].getRow();
     this.Y3 = this.blocks[2].getColumn();
     
     this.X4 = this.blocks[3].getRow();
     this.Y4 = this.blocks[3].getColumn();
     
     try {
       this.image = ImageIO.read(getClass().getResource("/resources/cyan.png"));
       Image icon = this.image.getScaledInstance(30, 30, 4);
       this.image = icon;
     } catch (IOException e) {
       
       e.printStackTrace();
     } 
   }
 
 
 
   
   public iBlockPlayer(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int v) {
     this.X1 = x1;
     this.X2 = x2;
     this.X3 = x3;
     this.X4 = x4;
     this.Y1 = y1;
     this.Y2 = y2;
     this.Y3 = y3;
     this.Y4 = y4;
     this.value = v;
   }
   
   public int getX1() {
     return this.X1;
   }
   
   public void setX1(int x1) {
     this.X1 = x1;
   }
   
   public int getY1() {
     return this.Y1;
   }
   
   public void setY1(int y1) {
     this.Y1 = y1;
   }
   
   public int getX2() {
     return this.X2;
   }
   
   public void setX2(int x2) {
     this.X2 = x2;
   }
   
   public int getY2() {
     return this.Y2;
   }
   
   public void setY2(int y2) {
     this.Y2 = y2;
   }
   
   public int getX3() {
     return this.X3;
   }
   
   public void setX3(int x3) {
     this.X3 = x3;
   }
   
   public int getY3() {
     return this.Y3;
   }
   
   public void setY3(int y3) {
     this.Y3 = y3;
   }
   
   public int getX4() {
     return this.X4;
   }
   
   public void setX4(int x4) {
     this.X4 = x4;
   }
   
   public int getY4() {
     return this.Y4;
   }
   
   public void setY4(int y4) {
     this.Y4 = y4;
   }
   
   public int getValue() {
     return this.value;
   }
   
   public void setValue(int value) {
     this.value = value;
   }
   
   public iBlockPlayer getType() {
     return this;
   }
   
   public CellPlayer[] getPiece() {
     return this.blocks;
   }
 
   
   public void Rotate(MapPlayer map) {
     boolean restoreLeft = false;
     boolean restoreRight = false;
     
     if (!canMoveLeft(map)) {
       this.blocks[0].setColumn(this.blocks[0].getColumn() + 2);
       this.blocks[1].setColumn(this.blocks[1].getColumn() + 2);
       this.blocks[2].setColumn(this.blocks[2].getColumn() + 2);
       this.blocks[3].setColumn(this.blocks[3].getColumn() + 2);
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
       this.blocks[0].setColumn(this.blocks[0].getColumn() + 2);
       
       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
       
       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
       
       this.state[0] = false;
       this.state[1] = true;
 
     
     }
     else if (this.state[1]) {
       this.blocks[0].setRow(this.blocks[0].getRow() - 2);
       this.blocks[0].setColumn(this.blocks[0].getColumn() - 2);
       
       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
       
       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
       
       this.state[0] = true;
       this.state[1] = false;
     } 
 
     
     if (canMoveLeft(map) && restoreLeft) {
       this.blocks[0].setColumn(this.blocks[0].getColumn() - 2);
       this.blocks[1].setColumn(this.blocks[1].getColumn() - 2);
       this.blocks[2].setColumn(this.blocks[2].getColumn() - 2);
       this.blocks[3].setColumn(this.blocks[3].getColumn() - 2);
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
