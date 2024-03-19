/*     */ package tetrisAI.PlayerBlocks;
/*     */ 
/*     */ import java.awt.Image;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import tetrisAI.PlayerClasses.CellPlayer;
/*     */ import tetrisAI.PlayerClasses.MapPlayer;
/*     */ import tetrisAI.PlayerClasses.PiecePlayer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class sBlockPlayer
/*     */   extends PiecePlayer
/*     */ {
/*  17 */   private int id = 5;
/*     */   
/*  19 */   private int value = 5;
/*     */ 
/*     */ 
/*     */   
/*     */   public sBlockPlayer() {
/*  24 */     this.blocks[0].setRow(0);
/*  25 */     this.blocks[0].setColumn(5);
/*  26 */     this.blocks[0].setValue(5);
/*  27 */     this.blocks[1].setRow(0);
/*  28 */     this.blocks[1].setColumn(6);
/*  29 */     this.blocks[1].setValue(5);
/*  30 */     this.blocks[2].setRow(1);
/*  31 */     this.blocks[2].setColumn(4);
/*  32 */     this.blocks[2].setValue(5);
/*  33 */     this.blocks[3].setRow(1);
/*  34 */     this.blocks[3].setColumn(5);
/*  35 */     this.blocks[3].setValue(5);
/*  36 */     setState(true, 0);
/*     */     try {
/*  38 */       this.image = ImageIO.read(getClass().getResource("/resources/green.png"));
/*  39 */       Image icon = this.image.getScaledInstance(30, 30, 4);
/*  40 */       this.image = icon;
/*  41 */     } catch (IOException e) {
/*     */       
/*  43 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CellPlayer[] getPiece() {
/*  50 */     return this.blocks;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getValue() {
/*  56 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(int value) {
/*  60 */     this.value = value;
/*     */   }
/*     */   
/*     */   public void Rotate(MapPlayer map) {
/*  64 */     boolean restoreLeft = false;
/*  65 */     boolean restoreRight = false;
/*     */     
/*  67 */     if (!canMoveLeft(map)) {
/*  68 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/*  69 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*  70 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
/*  71 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*  72 */       restoreLeft = true;
/*     */     
/*     */     }
/*  75 */     else if (!canMoveRight(map)) {
/*  76 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/*  77 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*  78 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
/*  79 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*  80 */       restoreRight = true;
/*     */     } 
/*     */     
/*  83 */     if (this.state[0]) {
/*     */ 
/*     */       
/*  86 */       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
/*  87 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*     */       
/*  89 */       this.blocks[2].setRow(this.blocks[2].getRow());
/*  90 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 2);
/*     */       
/*  92 */       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
/*  93 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*     */       
/*  95 */       this.state[0] = false;
/*  96 */       this.state[1] = true;
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 101 */     else if (this.state[1]) {
/* 102 */       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
/* 103 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*     */       
/* 105 */       this.blocks[2].setRow(this.blocks[2].getRow());
/* 106 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 2);
/*     */       
/* 108 */       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
/* 109 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*     */       
/* 111 */       this.state[0] = true;
/* 112 */       this.state[1] = false;
/*     */     } 
/*     */     
/* 115 */     if (canMoveLeft(map) && restoreLeft) {
/* 116 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/* 117 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/* 118 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
/* 119 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/* 120 */       restoreLeft = false;
/*     */     } 
/*     */     
/* 123 */     if (canMoveRight(map) && restoreRight) {
/* 124 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/* 125 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/* 126 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
/* 127 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/* 128 */       restoreRight = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/PlayerBlocks/sBlockPlayer.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */