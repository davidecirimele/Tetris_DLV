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
/*     */ 
/*     */ public class iBlock
/*     */   extends Piece
/*     */ {
/*  18 */   private int id = 1;
/*     */ 
/*     */   
/*     */   private int X1;
/*     */   
/*     */   private int Y1;
/*     */   
/*     */   private int X2;
/*     */   
/*     */   private int Y2;
/*     */   
/*     */   private int X3;
/*     */   
/*     */   private int Y3;
/*     */   
/*     */   private int X4;
/*     */   
/*     */   private int Y4;
/*     */   
/*  37 */   private int value = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public iBlock() {
/*  45 */     this.blocks[0].setRow(0);
/*  46 */     this.blocks[0].setColumn(4);
/*  47 */     this.blocks[0].setValue(1);
/*  48 */     this.blocks[1].setRow(0);
/*  49 */     this.blocks[1].setColumn(5);
/*  50 */     this.blocks[1].setValue(1);
/*  51 */     this.blocks[2].setRow(0);
/*  52 */     this.blocks[2].setColumn(6);
/*  53 */     this.blocks[2].setValue(1);
/*  54 */     this.blocks[3].setRow(0);
/*  55 */     this.blocks[3].setColumn(7);
/*  56 */     this.blocks[3].setValue(1);
/*  57 */     setState(true, 0);
/*     */     
/*  59 */     this.X1 = this.blocks[0].getRow();
/*  60 */     this.Y1 = this.blocks[0].getColumn();
/*     */     
/*  62 */     this.X2 = this.blocks[1].getRow();
/*  63 */     this.Y2 = this.blocks[1].getColumn();
/*     */     
/*  65 */     this.X3 = this.blocks[2].getRow();
/*  66 */     this.Y3 = this.blocks[2].getColumn();
/*     */     
/*  68 */     this.X4 = this.blocks[3].getRow();
/*  69 */     this.Y4 = this.blocks[3].getColumn();
/*     */     
/*     */     try {
/*  72 */       this.image = ImageIO.read(getClass().getResource("/resources/cyan.png"));
/*  73 */       Image icon = this.image.getScaledInstance(30, 30, 4);
/*  74 */       this.image = icon;
/*  75 */     } catch (IOException e) {
/*     */       
/*  77 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public iBlock(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int v) {
/*  85 */     this.X1 = x1;
/*  86 */     this.X2 = x2;
/*  87 */     this.X3 = x3;
/*  88 */     this.X4 = x4;
/*  89 */     this.Y1 = y1;
/*  90 */     this.Y2 = y2;
/*  91 */     this.Y3 = y3;
/*  92 */     this.Y4 = y4;
/*  93 */     this.value = v;
/*     */   }
/*     */   
/*     */   public int getX1() {
/*  97 */     return this.X1;
/*     */   }
/*     */   
/*     */   public void setX1(int x1) {
/* 101 */     this.X1 = x1;
/*     */   }
/*     */   
/*     */   public int getY1() {
/* 105 */     return this.Y1;
/*     */   }
/*     */   
/*     */   public void setY1(int y1) {
/* 109 */     this.Y1 = y1;
/*     */   }
/*     */   
/*     */   public int getX2() {
/* 113 */     return this.X2;
/*     */   }
/*     */   
/*     */   public void setX2(int x2) {
/* 117 */     this.X2 = x2;
/*     */   }
/*     */   
/*     */   public int getY2() {
/* 121 */     return this.Y2;
/*     */   }
/*     */   
/*     */   public void setY2(int y2) {
/* 125 */     this.Y2 = y2;
/*     */   }
/*     */   
/*     */   public int getX3() {
/* 129 */     return this.X3;
/*     */   }
/*     */   
/*     */   public void setX3(int x3) {
/* 133 */     this.X3 = x3;
/*     */   }
/*     */   
/*     */   public int getY3() {
/* 137 */     return this.Y3;
/*     */   }
/*     */   
/*     */   public void setY3(int y3) {
/* 141 */     this.Y3 = y3;
/*     */   }
/*     */   
/*     */   public int getX4() {
/* 145 */     return this.X4;
/*     */   }
/*     */   
/*     */   public void setX4(int x4) {
/* 149 */     this.X4 = x4;
/*     */   }
/*     */   
/*     */   public int getY4() {
/* 153 */     return this.Y4;
/*     */   }
/*     */   
/*     */   public void setY4(int y4) {
/* 157 */     this.Y4 = y4;
/*     */   }
/*     */   
/*     */   public int getValue() {
/* 161 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(int value) {
/* 165 */     this.value = value;
/*     */   }
/*     */   
/*     */   public iBlock getType() {
/* 169 */     return this;
/*     */   }
/*     */   
/*     */   public Cell[] getPiece() {
/* 173 */     return this.blocks;
/*     */   }
/*     */ 
/*     */   
/*     */   public void Rotate(Map map) {
/* 178 */     boolean restoreLeft = false;
/* 179 */     boolean restoreRight = false;
/*     */     
/* 181 */     if (!canMoveLeft(map)) {
/* 182 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 2);
/* 183 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 2);
/* 184 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 2);
/* 185 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 2);
/* 186 */       restoreLeft = true;
/*     */     
/*     */     }
/* 189 */     else if (!canMoveRight(map)) {
/* 190 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/* 191 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/* 192 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
/* 193 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/* 194 */       restoreRight = true;
/*     */     } 
/*     */     
/* 197 */     if (this.state[0]) {
/*     */       
/* 199 */       this.blocks[0].setRow(this.blocks[0].getRow() + 2);
/* 200 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 2);
/*     */       
/* 202 */       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
/* 203 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*     */       
/* 205 */       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
/* 206 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*     */       
/* 208 */       this.state[0] = false;
/* 209 */       this.state[1] = true;
/*     */ 
/*     */     
/*     */     }
/* 213 */     else if (this.state[1]) {
/* 214 */       this.blocks[0].setRow(this.blocks[0].getRow() - 2);
/* 215 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 2);
/*     */       
/* 217 */       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
/* 218 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*     */       
/* 220 */       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
/* 221 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*     */       
/* 223 */       this.state[0] = true;
/* 224 */       this.state[1] = false;
/*     */     } 
/*     */ 
/*     */     
/* 228 */     if (canMoveLeft(map) && restoreLeft) {
/* 229 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 2);
/* 230 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 2);
/* 231 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 2);
/* 232 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 2);
/* 233 */       restoreLeft = false;
/*     */     } 
/*     */     
/* 236 */     if (canMoveRight(map) && restoreRight) {
/* 237 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/* 238 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/* 239 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
/* 240 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/* 241 */       restoreRight = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/AIBlocks/iBlock.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */