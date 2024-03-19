/*     */ package tetrisAI.InserisciBlocks;
/*     */ 
/*     */ import it.unical.mat.embasp.languages.Id;
/*     */ import it.unical.mat.embasp.languages.Param;
/*     */ 
/*     */ 
/*     */ @Id("inserisciSBlock")
/*     */ public class inserisciSBlock
/*     */   extends inserisciPezzo
/*     */ {
/*     */   @Param(0)
/*     */   private int X1;
/*     */   @Param(1)
/*     */   private int Y1;
/*     */   @Param(2)
/*     */   private int X2;
/*     */   @Param(3)
/*     */   private int Y2;
/*     */   @Param(4)
/*     */   private int X3;
/*     */   @Param(5)
/*     */   private int Y3;
/*     */   @Param(6)
/*     */   private int X4;
/*     */   @Param(7)
/*     */   private int Y4;
/*     */   @Param(8)
/*     */   private int V;
/*     */   
/*     */   public int getV() {
/*  31 */     return this.V;
/*     */   }
/*     */   
/*     */   public void setV(int v) {
/*  35 */     this.V = v;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public inserisciSBlock(int X1, int X2, int X3, int X4, int Y1, int Y2, int Y3, int Y4, int V) {
/*  42 */     this.X1 = X1;
/*  43 */     this.X2 = X2;
/*  44 */     this.X3 = X3;
/*  45 */     this.X4 = X4;
/*  46 */     this.Y1 = Y1;
/*  47 */     this.Y2 = Y2;
/*  48 */     this.Y3 = Y3;
/*  49 */     this.Y4 = Y4;
/*  50 */     this.V = V;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public inserisciSBlock() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getX1() {
/*  61 */     return this.X1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX1(int x1) {
/*  66 */     this.X1 = x1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY1() {
/*  71 */     return this.Y1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY1(int y1) {
/*  76 */     this.Y1 = y1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX2() {
/*  81 */     return this.X2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX2(int x2) {
/*  86 */     this.X2 = x2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY2() {
/*  91 */     return this.Y2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY2(int y2) {
/*  96 */     this.Y2 = y2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX3() {
/* 101 */     return this.X3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX3(int x3) {
/* 106 */     this.X3 = x3;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY3() {
/* 111 */     return this.Y3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY3(int y3) {
/* 116 */     this.Y3 = y3;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX4() {
/* 121 */     return this.X4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX4(int x4) {
/* 126 */     this.X4 = x4;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY4() {
/* 131 */     return this.Y4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY4(int y4) {
/* 136 */     this.Y4 = y4;
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/InserisciBlocks/inserisciSBlock.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */