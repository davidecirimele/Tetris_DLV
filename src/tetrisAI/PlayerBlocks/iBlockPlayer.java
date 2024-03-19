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
/*     */ 
/*     */ public class iBlockPlayer
/*     */   extends PiecePlayer
/*     */ {
/*  19 */   private int id = 1;
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
/*  38 */   private int value = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public iBlockPlayer() {
/*  46 */     this.blocks[0].setRow(0);
/*  47 */     this.blocks[0].setColumn(4);
/*  48 */     this.blocks[0].setValue(1);
/*  49 */     this.blocks[1].setRow(0);
/*  50 */     this.blocks[1].setColumn(5);
/*  51 */     this.blocks[1].setValue(1);
/*  52 */     this.blocks[2].setRow(0);
/*  53 */     this.blocks[2].setColumn(6);
/*  54 */     this.blocks[2].setValue(1);
/*  55 */     this.blocks[3].setRow(0);
/*  56 */     this.blocks[3].setColumn(7);
/*  57 */     this.blocks[3].setValue(1);
/*  58 */     setState(true, 0);
/*     */     
/*  60 */     this.X1 = this.blocks[0].getRow();
/*  61 */     this.Y1 = this.blocks[0].getColumn();
/*     */     
/*  63 */     this.X2 = this.blocks[1].getRow();
/*  64 */     this.Y2 = this.blocks[1].getColumn();
/*     */     
/*  66 */     this.X3 = this.blocks[2].getRow();
/*  67 */     this.Y3 = this.blocks[2].getColumn();
/*     */     
/*  69 */     this.X4 = this.blocks[3].getRow();
/*  70 */     this.Y4 = this.blocks[3].getColumn();
/*     */     
/*     */     try {
/*  73 */       this.image = ImageIO.read(getClass().getResource("/resources/cyan.png"));
/*  74 */       Image icon = this.image.getScaledInstance(30, 30, 4);
/*  75 */       this.image = icon;
/*  76 */     } catch (IOException e) {
/*     */       
/*  78 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public iBlockPlayer(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int v) {
/*  86 */     this.X1 = x1;
/*  87 */     this.X2 = x2;
/*  88 */     this.X3 = x3;
/*  89 */     this.X4 = x4;
/*  90 */     this.Y1 = y1;
/*  91 */     this.Y2 = y2;
/*  92 */     this.Y3 = y3;
/*  93 */     this.Y4 = y4;
/*  94 */     this.value = v;
/*     */   }
/*     */   
/*     */   public int getX1() {
/*  98 */     return this.X1;
/*     */   }
/*     */   
/*     */   public void setX1(int x1) {
/* 102 */     this.X1 = x1;
/*     */   }
/*     */   
/*     */   public int getY1() {
/* 106 */     return this.Y1;
/*     */   }
/*     */   
/*     */   public void setY1(int y1) {
/* 110 */     this.Y1 = y1;
/*     */   }
/*     */   
/*     */   public int getX2() {
/* 114 */     return this.X2;
/*     */   }
/*     */   
/*     */   public void setX2(int x2) {
/* 118 */     this.X2 = x2;
/*     */   }
/*     */   
/*     */   public int getY2() {
/* 122 */     return this.Y2;
/*     */   }
/*     */   
/*     */   public void setY2(int y2) {
/* 126 */     this.Y2 = y2;
/*     */   }
/*     */   
/*     */   public int getX3() {
/* 130 */     return this.X3;
/*     */   }
/*     */   
/*     */   public void setX3(int x3) {
/* 134 */     this.X3 = x3;
/*     */   }
/*     */   
/*     */   public int getY3() {
/* 138 */     return this.Y3;
/*     */   }
/*     */   
/*     */   public void setY3(int y3) {
/* 142 */     this.Y3 = y3;
/*     */   }
/*     */   
/*     */   public int getX4() {
/* 146 */     return this.X4;
/*     */   }
/*     */   
/*     */   public void setX4(int x4) {
/* 150 */     this.X4 = x4;
/*     */   }
/*     */   
/*     */   public int getY4() {
/* 154 */     return this.Y4;
/*     */   }
/*     */   
/*     */   public void setY4(int y4) {
/* 158 */     this.Y4 = y4;
/*     */   }
/*     */   
/*     */   public int getValue() {
/* 162 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(int value) {
/* 166 */     this.value = value;
/*     */   }
/*     */   
/*     */   public iBlockPlayer getType() {
/* 170 */     return this;
/*     */   }
/*     */   
/*     */   public CellPlayer[] getPiece() {
/* 174 */     return this.blocks;
/*     */   }
/*     */ 
/*     */   
/*     */   public void Rotate(MapPlayer map) {
/* 179 */     boolean restoreLeft = false;
/* 180 */     boolean restoreRight = false;
/*     */     
/* 182 */     if (!canMoveLeft(map)) {
/* 183 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 2);
/* 184 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 2);
/* 185 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 2);
/* 186 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 2);
/* 187 */       restoreLeft = true;
/*     */     
/*     */     }
/* 190 */     else if (!canMoveRight(map)) {
/* 191 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 1);
/* 192 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/* 193 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 1);
/* 194 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/* 195 */       restoreRight = true;
/*     */     } 
/*     */     
/* 198 */     if (this.state[0]) {
/*     */       
/* 200 */       this.blocks[0].setRow(this.blocks[0].getRow() + 2);
/* 201 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 2);
/*     */       
/* 203 */       this.blocks[1].setRow(this.blocks[1].getRow() + 1);
/* 204 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/*     */       
/* 206 */       this.blocks[3].setRow(this.blocks[3].getRow() - 1);
/* 207 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 1);
/*     */       
/* 209 */       this.state[0] = false;
/* 210 */       this.state[1] = true;
/*     */ 
/*     */     
/*     */     }
/* 214 */     else if (this.state[1]) {
/* 215 */       this.blocks[0].setRow(this.blocks[0].getRow() - 2);
/* 216 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 2);
/*     */       
/* 218 */       this.blocks[1].setRow(this.blocks[1].getRow() - 1);
/* 219 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 1);
/*     */       
/* 221 */       this.blocks[3].setRow(this.blocks[3].getRow() + 1);
/* 222 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/*     */       
/* 224 */       this.state[0] = true;
/* 225 */       this.state[1] = false;
/*     */     } 
/*     */ 
/*     */     
/* 229 */     if (canMoveLeft(map) && restoreLeft) {
/* 230 */       this.blocks[0].setColumn(this.blocks[0].getColumn() - 2);
/* 231 */       this.blocks[1].setColumn(this.blocks[1].getColumn() - 2);
/* 232 */       this.blocks[2].setColumn(this.blocks[2].getColumn() - 2);
/* 233 */       this.blocks[3].setColumn(this.blocks[3].getColumn() - 2);
/* 234 */       restoreLeft = false;
/*     */     } 
/*     */     
/* 237 */     if (canMoveRight(map) && restoreRight) {
/* 238 */       this.blocks[0].setColumn(this.blocks[0].getColumn() + 1);
/* 239 */       this.blocks[1].setColumn(this.blocks[1].getColumn() + 1);
/* 240 */       this.blocks[2].setColumn(this.blocks[2].getColumn() + 1);
/* 241 */       this.blocks[3].setColumn(this.blocks[3].getColumn() + 1);
/* 242 */       restoreRight = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/PlayerBlocks/iBlockPlayer.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */