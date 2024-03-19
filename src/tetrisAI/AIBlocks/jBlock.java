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
/*     */ public class jBlock
/*     */   extends Piece
/*     */ {
/*  17 */   private int id = 2;
/*     */   
/*  19 */   private int value = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public jBlock() {
/*  26 */     this.blocks[0].setRow(0);
/*  27 */     this.blocks[0].setColumn(4);
/*  28 */     this.blocks[0].setValue(2);
/*  29 */     this.blocks[1].setRow(1);
/*  30 */     this.blocks[1].setColumn(4);
/*  31 */     this.blocks[1].setValue(2);
/*  32 */     this.blocks[2].setRow(1);
/*  33 */     this.blocks[2].setColumn(5);
/*  34 */     this.blocks[2].setValue(2);
/*  35 */     this.blocks[3].setRow(1);
/*  36 */     this.blocks[3].setColumn(6);
/*  37 */     this.blocks[3].setValue(2);
/*  38 */     setState(true, 0);
/*     */ 
/*     */     
/*     */     try {
/*  42 */       this.image = ImageIO.read(getClass().getResource("/resources/blue.png"));
/*  43 */       Image icon = this.image.getScaledInstance(30, 30, 4);
/*  44 */       this.image = icon;
/*  45 */     } catch (IOException e) {
/*     */       
/*  47 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Cell[] getPiece() {
/*  54 */     return this.blocks;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getValue() {
/*  60 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(int value) {
/*  64 */     this.value = value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void Rotate(Map map) {
/*  70 */     boolean restoreLeft = false;
/*  71 */     boolean restoreRight = false;
/*     */     
/*  73 */     if (!canMoveLeft(map)) {
/*  74 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/*  75 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*  76 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
/*  77 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*  78 */       restoreLeft = true;
/*     */     
/*     */     }
/*  81 */     else if (!canMoveRight(map)) {
/*  82 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/*  83 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*  84 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
/*  85 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*  86 */       restoreRight = true;
/*     */     } 
/*     */     
/*  89 */     if (this.state[0]) {
/*     */       
/*  91 */       this.blocks[0].setRow(this.blocks[0].getRow() + 2);
/*  92 */       this.blocks[0].setColumn(this.blocks[0].getColumn());
/*     */       
/*  94 */       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
/*  95 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*     */       
/*  97 */       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
/*  98 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*     */       
/* 100 */       this.state[0] = false;
/* 101 */       this.state[1] = true;
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 106 */     else if (this.state[1]) {
/* 107 */       this.blocks[0].setRow(this.blocks[0].getRow());
/* 108 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 2);
/*     */       
/* 110 */       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
/* 111 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*     */       
/* 113 */       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
/* 114 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*     */       
/* 116 */       this.state[2] = true;
/* 117 */       this.state[1] = false;
/*     */ 
/*     */     
/*     */     }
/* 121 */     else if (this.state[2]) {
/* 122 */       this.blocks[0].setRow(this.blocks[0].getRow() - 2);
/* 123 */       this.blocks[0].setColumn(this.blocks[0].getColumn());
/*     */       
/* 125 */       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
/* 126 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*     */       
/* 128 */       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
/* 129 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*     */       
/* 131 */       this.state[3] = true;
/* 132 */       this.state[2] = false;
/*     */ 
/*     */     
/*     */     }
/* 136 */     else if (this.state[3]) {
/*     */       
/* 138 */       this.blocks[0].setRow(this.blocks[0].getRow());
/* 139 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 2);
/*     */       
/* 141 */       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
/* 142 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*     */       
/* 144 */       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
/* 145 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*     */       
/* 147 */       this.state[0] = true;
/* 148 */       this.state[3] = false;
/*     */     } 
/*     */     
/* 151 */     if (canMoveLeft(map) && restoreLeft) {
/* 152 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/* 153 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/* 154 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
/* 155 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/* 156 */       restoreLeft = false;
/*     */     } 
/*     */     
/* 159 */     if (canMoveRight(map) && restoreRight) {
/* 160 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/* 161 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/* 162 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
/* 163 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/* 164 */       restoreRight = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/AIBlocks/jBlock.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */