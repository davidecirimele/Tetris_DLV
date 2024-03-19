/*    */ package tetrisAI.AIClasses;
/*    */ 
/*    */ import it.unical.mat.embasp.languages.Id;
/*    */ import it.unical.mat.embasp.languages.Param;
/*    */ import tetrisAI.PlayerClasses.CellPlayer;
/*    */ 
/*    */ 
/*    */ @Id("cell")
/*    */ public class Cell
/*    */   extends CellPlayer
/*    */ {
/*    */   @Param(0)
/*    */   private int row;
/*    */   @Param(1)
/*    */   private int column;
/*    */   @Param(2)
/*    */   private int value;
/*    */   private int id;
/*    */   
/*    */   public int getId() {
/* 21 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 25 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Cell(int r, int c, int v) {
/* 29 */     this.row = r;
/* 30 */     this.column = c;
/* 31 */     this.value = v;
/*    */   }
/*    */ 
/*    */   
/*    */   public Cell() {}
/*    */   
/*    */   public int getRow() {
/* 38 */     return this.row;
/*    */   }
/*    */   
/*    */   public void setRow(int row) {
/* 42 */     this.row = row;
/*    */   }
/*    */   
/*    */   public int getColumn() {
/* 46 */     return this.column;
/*    */   }
/*    */   
/*    */   public void setColumn(int column) {
/* 50 */     this.column = column;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 54 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(int value) {
/* 58 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/AIClasses/Cell.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */