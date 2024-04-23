 package tetrisAI.AIClasses;
 
 import it.unical.mat.embasp.languages.Id;
 import it.unical.mat.embasp.languages.Param;
 import java.awt.Image;
 import tetrisAI.PlayerClasses.CellPlayer;
 import tetrisAI.PlayerClasses.PiecePlayer;
 
 
 
 
 
 
 
 
 
 
 
 
 
 @Id("piece")
 public class Piece
   extends PiecePlayer
 {
   @Param(0)
   protected Cell[] blocks = new Cell[4]; @Param(1)
   protected boolean[] state = new boolean[4]; public Piece() {
     for (int i = 0; i < 4; i++) {
       this.blocks[i] = new Cell();
       this.state[i] = false;
     } 
   }
   protected Image image;
   protected int id;
   public boolean isMoving;
   
   public Cell[] getPiece() {
     return null;
   }
 
   
   public Image getImage() {
     return this.image;
   }
 
 
   
   public void Rotate(Map map) {}
 
   
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
 
 
   
   public boolean canMoveLeft(Map map) {
     for (int i = 0; i < 4; i++) {
       if (this.blocks[i].getColumn() == 0)
         return false; 
       Cell adj = map.getMatrix()[this.blocks[i].getRow()][this.blocks[i].getColumn() - 1];
       if (adj.getValue() != 0 && adj.getId() != this.id) {
         return false;
       }
     } 
     return true;
   }
 
 
 
   
   public boolean canMoveRight(Map map) {
     for (int i = 0; i < 4; i++) {
       if (this.blocks[i].getColumn() == 9)
         return false; 
       Cell adj = map.getMatrix()[this.blocks[i].getRow()][this.blocks[i].getColumn() + 1];
       if (adj.getValue() != 0 && adj.getId() != this.id)
         return false; 
     } 
     return true;
   }
 }

