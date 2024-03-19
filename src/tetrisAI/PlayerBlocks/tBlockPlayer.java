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
/*     */ public class tBlockPlayer
/*     */   extends PiecePlayer
/*     */ {
/*  17 */   private int id = 6;
/*     */   
/*  19 */   private int value = 6;
/*     */ 
/*     */ 
/*     */   
/*     */   public tBlockPlayer() {
/*  24 */     this.blocks[0].setRow(0);
/*  25 */     this.blocks[0].setColumn(4);
/*  26 */     this.blocks[0].setValue(6);
/*  27 */     this.blocks[1].setRow(1);
/*  28 */     this.blocks[1].setColumn(3);
/*  29 */     this.blocks[1].setValue(6);
/*  30 */     this.blocks[2].setRow(1);
/*  31 */     this.blocks[2].setColumn(4);
/*  32 */     this.blocks[2].setValue(6);
/*  33 */     this.blocks[3].setRow(1);
/*  34 */     this.blocks[3].setColumn(5);
/*  35 */     this.blocks[3].setValue(6);
/*  36 */     setState(true, 0);
/*     */     
/*     */     try {
/*  39 */       this.image = ImageIO.read(getClass().getResource("/resources/purple.png"));
/*  40 */       Image icon = this.image.getScaledInstance(30, 30, 4);
/*  41 */       this.image = icon;
/*  42 */     } catch (IOException e) {
/*     */       
/*  44 */       e.printStackTrace();
/*     */     } 
/*     */   }
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
/*     */ 
/*     */   
/*     */   public void Rotate(MapPlayer map) {
/*  66 */     if (this.state[0]) {
/*     */       
/*  68 */       this.blocks[0].setRow(this.blocks[0].getRow() + 1);
/*  69 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/*     */       
/*  71 */       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
/*  72 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*     */       
/*  74 */       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
/*  75 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*     */       
/*  77 */       this.state[0] = false;
/*  78 */       this.state[1] = true;
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  83 */     else if (this.state[1]) {
/*  84 */       this.blocks[0].setRow(this.blocks[0].getRow() + 1);
/*  85 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/*     */       
/*  87 */       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
/*  88 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*     */       
/*  90 */       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
/*  91 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*     */       
/*  93 */       this.state[2] = true;
/*  94 */       this.state[1] = false;
/*     */ 
/*     */     
/*     */     }
/*  98 */     else if (this.state[2]) {
/*  99 */       this.blocks[0].setRow(this.blocks[0].getRow() - 1);
/* 100 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/*     */       
/* 102 */       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
/* 103 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*     */       
/* 105 */       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
/* 106 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*     */       
/* 108 */       this.state[3] = true;
/* 109 */       this.state[2] = false;
/*     */ 
/*     */     
/*     */     }
/* 113 */     else if (this.state[3]) {
/*     */       
/* 115 */       this.blocks[0].setRow(this.blocks[0].getRow() - 1);
/* 116 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/*     */       
/* 118 */       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
/* 119 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*     */       
/* 121 */       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
/* 122 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*     */       
/* 124 */       this.state[0] = true;
/* 125 */       this.state[3] = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/PlayerBlocks/tBlockPlayer.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */