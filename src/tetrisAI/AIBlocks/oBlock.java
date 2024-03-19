/*    */ package tetrisAI.AIBlocks;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ import tetrisAI.AIClasses.Cell;
/*    */ import tetrisAI.AIClasses.Piece;
/*    */ import tetrisAI.PlayerClasses.CellPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class oBlock
/*    */   extends Piece
/*    */ {
/* 17 */   private int id = 4;
/*    */   
/* 19 */   private int value = 4;
/*    */ 
/*    */ 
/*    */   
/*    */   public oBlock() {
/* 24 */     this.blocks[0].setRow(0);
/* 25 */     this.blocks[0].setColumn(4);
/* 26 */     this.blocks[0].setValue(4);
/* 27 */     this.blocks[1].setRow(0);
/* 28 */     this.blocks[1].setColumn(5);
/* 29 */     this.blocks[1].setValue(4);
/* 30 */     this.blocks[2].setRow(1);
/* 31 */     this.blocks[2].setColumn(4);
/* 32 */     this.blocks[2].setValue(4);
/* 33 */     this.blocks[3].setRow(1);
/* 34 */     this.blocks[3].setColumn(5);
/* 35 */     this.blocks[3].setValue(4);
/* 36 */     setState(true, 0);
/*    */     
/*    */     try {
/* 39 */       this.image = ImageIO.read(getClass().getResource("/resources/yellow.png"));
/* 40 */       Image icon = this.image.getScaledInstance(30, 30, 4);
/* 41 */       this.image = icon;
/* 42 */     } catch (IOException e) {
/*    */       
/* 44 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Cell[] getPiece() {
/* 50 */     return this.blocks;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getValue() {
/* 56 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(int value) {
/* 60 */     this.value = value;
/*    */   }
/*    */   
/*    */   public void Rotate() {}
/*    */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/AIBlocks/oBlock.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */