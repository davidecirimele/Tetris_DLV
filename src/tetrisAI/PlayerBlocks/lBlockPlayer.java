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
/*     */ 
/*     */ public class lBlockPlayer
/*     */   extends PiecePlayer
/*     */ {
/*  18 */   private int id = 3;
/*     */   
/*  20 */   private int value = 3;
/*     */ 
/*     */ 
/*     */   
/*     */   public lBlockPlayer() {
/*  25 */     this.blocks[0].setRow(0);
/*  26 */     this.blocks[0].setColumn(5);
/*  27 */     this.blocks[0].setValue(3);
/*  28 */     this.blocks[1].setRow(1);
/*  29 */     this.blocks[1].setColumn(5);
/*  30 */     this.blocks[1].setValue(3);
/*  31 */     this.blocks[2].setRow(1);
/*  32 */     this.blocks[2].setColumn(4);
/*  33 */     this.blocks[2].setValue(3);
/*  34 */     this.blocks[3].setRow(1);
/*  35 */     this.blocks[3].setColumn(3);
/*  36 */     this.blocks[3].setValue(3);
/*  37 */     setState(true, 0);
/*     */     
/*     */     try {
/*  40 */       this.image = ImageIO.read(getClass().getResource("/resources/orange.png"));
/*  41 */       Image icon = this.image.getScaledInstance(30, 30, 4);
/*  42 */       this.image = icon;
/*  43 */     } catch (IOException e) {
/*     */       
/*  45 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CellPlayer[] getPiece() {
/*  52 */     return this.blocks;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getValue() {
/*  58 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(int value) {
/*  62 */     this.value = value;
/*     */   }
/*     */   
/*     */   public void Rotate(MapPlayer map) {
/*  66 */     boolean restoreLeft = false;
/*  67 */     boolean restoreRight = false;
/*     */     
/*  69 */     if (!canMoveLeft(map)) {
/*  70 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/*  71 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*  72 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
/*  73 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*  74 */       restoreLeft = true;
/*     */     
/*     */     }
/*  77 */     else if (!canMoveRight(map)) {
/*  78 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/*  79 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*  80 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
/*  81 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*  82 */       restoreRight = true;
/*     */     } 
/*     */     
/*  85 */     if (this.state[0]) {
/*     */       
/*  87 */       this.blocks[0].setRow(this.blocks[0].getRow());
/*  88 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 2);
/*     */       
/*  90 */       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
/*  91 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*     */       
/*  93 */       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
/*  94 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*     */       
/*  96 */       this.state[0] = false;
/*  97 */       this.state[1] = true;
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 102 */     else if (this.state[1]) {
/* 103 */       this.blocks[0].setRow(this.blocks[0].getRow() + 2);
/* 104 */       this.blocks[0].setColumn(this.blocks[0].getColumn());
/*     */       
/* 106 */       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
/* 107 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*     */       
/* 109 */       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
/* 110 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*     */       
/* 112 */       this.state[2] = true;
/* 113 */       this.state[1] = false;
/*     */ 
/*     */     
/*     */     }
/* 117 */     else if (this.state[2]) {
/* 118 */       this.blocks[0].setRow(this.blocks[0].getRow());
/* 119 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 2);
/*     */       
/* 121 */       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
/* 122 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*     */       
/* 124 */       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
/* 125 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*     */       
/* 127 */       this.state[3] = true;
/* 128 */       this.state[2] = false;
/*     */ 
/*     */     
/*     */     }
/* 132 */     else if (this.state[3]) {
/*     */       
/* 134 */       this.blocks[0].setRow(this.blocks[0].getRow() - 2);
/* 135 */       this.blocks[0].setColumn(this.blocks[0].getColumn());
/*     */       
/* 137 */       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
/* 138 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*     */       
/* 140 */       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
/* 141 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*     */       
/* 143 */       this.state[0] = true;
/* 144 */       this.state[3] = false;
/*     */     } 
/*     */     
/* 147 */     if (canMoveLeft(map) && restoreLeft) {
/* 148 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/* 149 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/* 150 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
/* 151 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/* 152 */       restoreLeft = false;
/*     */     } 
/*     */     
/* 155 */     if (canMoveRight(map) && restoreRight) {
/* 156 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/* 157 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/* 158 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
/* 159 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/* 160 */       restoreRight = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/PlayerBlocks/lBlockPlayer.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */