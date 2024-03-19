/*    */ package tetrisAI.PlayerClasses;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CellPlayer
/*    */ {
/*    */   private int row;
/*    */   private int column;
/*    */   private int value;
/*    */   private int id;
/*    */   
/*    */   public int getId() {
/* 18 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 22 */     this.id = id;
/*    */   }
/*    */   
/*    */   public CellPlayer(int r, int c, int v) {
/* 26 */     this.row = r;
/* 27 */     this.column = c;
/* 28 */     this.value = v;
/*    */   }
/*    */ 
/*    */   
/*    */   public CellPlayer() {}
/*    */   
/*    */   public int getRow() {
/* 35 */     return this.row;
/*    */   }
/*    */   
/*    */   public void setRow(int row) {
/* 39 */     this.row = row;
/*    */   }
/*    */   
/*    */   public int getColumn() {
/* 43 */     return this.column;
/*    */   }
/*    */   
/*    */   public void setColumn(int column) {
/* 47 */     this.column = column;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 51 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(int value) {
/* 55 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/PlayerClasses/CellPlayer.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */