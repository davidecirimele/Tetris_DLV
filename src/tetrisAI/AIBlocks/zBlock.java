/*     */ package tetrisAI.AIBlocks;
/*     */ 
/*     */ import java.awt.Image;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import tetrisAI.AIClasses.Cell;
/*     */ import tetrisAI.AIClasses.Map;
/*     */ import tetrisAI.AIClasses.Piece;
/*     */ import tetrisAI.PlayerClasses.CellPlayer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class zBlock
/*     */   extends Piece
/*     */ {
/*  17 */   private int id = 7;
/*     */   
/*  19 */   private int value = 7;
/*     */ 
/*     */ 
/*     */   
/*     */   public zBlock() {
/*  24 */     this.blocks[0].setRow(0);
/*  25 */     this.blocks[0].setColumn(4);
/*  26 */     this.blocks[0].setValue(7);
/*  27 */     this.blocks[1].setRow(0);
/*  28 */     this.blocks[1].setColumn(5);
/*  29 */     this.blocks[1].setValue(7);
/*  30 */     this.blocks[2].setRow(1);
/*  31 */     this.blocks[2].setColumn(5);
/*  32 */     this.blocks[2].setValue(7);
/*  33 */     this.blocks[3].setRow(1);
/*  34 */     this.blocks[3].setColumn(6);
/*  35 */     this.blocks[3].setValue(7);
/*  36 */     setState(true, 0);
/*     */     
/*     */     try {
/*  39 */       this.image = ImageIO.read(getClass().getResource("/resources/redsquare.png"));
/*  40 */       Image icon = this.image.getScaledInstance(30, 30, 4);
/*  41 */       this.image = icon;
/*  42 */     } catch (IOException e) {
/*     */       
/*  44 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Cell[] getPiece() {
/*  51 */     return this.blocks;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getValue() {
/*  57 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(int value) {
/*  61 */     this.value = value;
/*     */   }
/*     */   
/*     */   public void Rotate(Map map) {
/*  65 */     boolean restoreLeft = false;
/*  66 */     boolean restoreRight = false;
/*     */     
/*  68 */     if (!canMoveLeft(map)) {
/*  69 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/*  70 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*  71 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
/*  72 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*  73 */       restoreLeft = true;
/*     */     
/*     */     }
/*  76 */     else if (!canMoveRight(map)) {
/*  77 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/*  78 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*  79 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
/*  80 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*  81 */       restoreRight = true;
/*     */     } 
/*     */     
/*  84 */     if (this.state[0]) {
/*     */       
/*  86 */       this.blocks[0].setRow(this.blocks[0].getRow() + 1);
/*  87 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/*     */       
/*  89 */       this.blocks[2].setRow(this.blocks[2].getRow() - 1);
/*  90 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
/*     */       
/*  92 */       this.blocks[3].setRow(this.blocks[3].getRow() - 2);
/*  93 */       this.blocks[3].setColumn(this.blocks[3].getColumn());
/*     */       
/*  95 */       this.state[0] = false;
/*  96 */       this.state[1] = true;
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 101 */     else if (this.state[1]) {
/* 102 */       this.blocks[0].setRow(this.blocks[0].getRow() - 1);
/* 103 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/*     */       
/* 105 */       this.blocks[2].setRow(this.blocks[2].getRow() + 1);
/* 106 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
/*     */       
/* 108 */       this.blocks[3].setRow(this.blocks[3].getRow() + 2);
/* 109 */       this.blocks[3].setColumn(this.blocks[3].getColumn());
/*     */       
/* 111 */       this.state[0] = true;
/* 112 */       this.state[1] = false;
/*     */     } 
/*     */ 
/*     */     
/* 116 */     if (canMoveLeft(map) && restoreLeft) {
/* 117 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/* 118 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/* 119 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
/* 120 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/* 121 */       restoreLeft = false;
/*     */     } 
/*     */     
/* 124 */     if (canMoveRight(map) && restoreRight) {
/* 125 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/* 126 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/* 127 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
/* 128 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/* 129 */       restoreRight = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/AIBlocks/zBlock.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */