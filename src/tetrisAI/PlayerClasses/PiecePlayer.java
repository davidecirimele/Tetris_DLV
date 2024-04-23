 package tetrisAI.PlayerClasses;
 
 import java.awt.Image;
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class PiecePlayer
 {
   protected CellPlayer[] blocks = new CellPlayer[4];
   protected boolean[] state = new boolean[4]; public PiecePlayer() {
     for (int i = 0; i < 4; i++) {
       this.blocks[i] = new CellPlayer();
       this.state[i] = false;
     } 
   }
   protected Image image;
   protected int id;
   protected boolean isMoving;
   
   public CellPlayer[] getPiece() {
     return null;
   }
 
   
   public Image getImage() {
     return this.image;
   }
 
   
   public void Rotate(MapPlayer map) {}
 
   
   public int getId() {
     return this.id;
   }
 
   
   public void setId(int id) {
     this.id = id;
   }
   
   public boolean[] getState() {
     return this.state;
   }
 
   
   public void setState(boolean state, int i) {
     this.state[i] = state;
   }
 
   
   public boolean isMoving() {
     return this.isMoving;
   }
 
   
   public void setMoving(boolean isMoving) {
     this.isMoving = isMoving;
   }
 
 
   
   public boolean canMoveLeft(MapPlayer map) {
     for (int i = 0; i < 4; i++) {
       if (this.blocks[i].getColumn() == 0)
         return false; 
       CellPlayer adj = map.getMatrix()[this.blocks[i].getRow()][this.blocks[i].getColumn() - 1];
       if (adj.getValue() != 0 && adj.getId() != this.id) {
         return false;
       }
     } 
     return true;
   }
 
 
 
   
   public boolean canMoveRight(MapPlayer map) {
     for (int i = 0; i < 4; i++) {
       if (this.blocks[i].getColumn() == 9)
         return false; 
       CellPlayer adj = map.getMatrix()[this.blocks[i].getRow()][this.blocks[i].getColumn() + 1];
       if (adj.getValue() != 0 && adj.getId() != this.id)
         return false; 
     } 
     return true;
   }
 }
