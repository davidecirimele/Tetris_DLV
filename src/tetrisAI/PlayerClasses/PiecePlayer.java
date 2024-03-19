/*    */ package tetrisAI.PlayerClasses;
/*    */ 
/*    */ import java.awt.Image;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PiecePlayer
/*    */ {
/* 19 */   protected CellPlayer[] blocks = new CellPlayer[4];
/* 20 */   protected boolean[] state = new boolean[4]; public PiecePlayer() {
/* 21 */     for (int i = 0; i < 4; i++) {
/* 22 */       this.blocks[i] = new CellPlayer();
/* 23 */       this.state[i] = false;
/*    */     } 
/*    */   }
/*    */   protected Image image;
/*    */   protected int id;
/*    */   protected boolean isMoving;
/*    */   
/*    */   public CellPlayer[] getPiece() {
/* 31 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Image getImage() {
/* 36 */     return this.image;
/*    */   }
/*    */ 
/*    */   
/*    */   public void Rotate(MapPlayer map) {}
/*    */ 
/*    */   
/*    */   public int getId() {
/* 44 */     return this.id;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setId(int id) {
/* 49 */     this.id = id;
/*    */   }
/*    */   
/*    */   public boolean[] getState() {
/* 53 */     return this.state;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setState(boolean state, int i) {
/* 58 */     this.state[i] = state;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isMoving() {
/* 63 */     return this.isMoving;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setMoving(boolean isMoving) {
/* 68 */     this.isMoving = isMoving;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canMoveLeft(MapPlayer map) {
/* 74 */     for (int i = 0; i < 4; i++) {
/* 75 */       if (this.blocks[i].getColumn() == 0)
/* 76 */         return false; 
/* 77 */       CellPlayer adj = map.getMatrix()[this.blocks[i].getRow()][this.blocks[i].getColumn() - 1];
/* 78 */       if (adj.getValue() != 0 && adj.getId() != this.id) {
/* 79 */         return false;
/*    */       }
/*    */     } 
/* 82 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canMoveRight(MapPlayer map) {
/* 89 */     for (int i = 0; i < 4; i++) {
/* 90 */       if (this.blocks[i].getColumn() == 9)
/* 91 */         return false; 
/* 92 */       CellPlayer adj = map.getMatrix()[this.blocks[i].getRow()][this.blocks[i].getColumn() + 1];
/* 93 */       if (adj.getValue() != 0 && adj.getId() != this.id)
/* 94 */         return false; 
/*    */     } 
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/PlayerClasses/PiecePlayer.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */