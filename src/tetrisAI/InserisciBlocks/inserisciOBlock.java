/*     */ package tetrisAI.InserisciBlocks;
/*     */ 
/*     */ import it.unical.mat.embasp.languages.Id;
/*     */ import it.unical.mat.embasp.languages.Param;
/*     */ 
/*     */ @Id("inserisciOBlock")
/*     */ public class inserisciOBlock
/*     */   extends inserisciPezzo {
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
/*  29 */     return this.V;
/*     */   }
/*     */   
/*     */   public void setV(int v) {
/*  33 */     this.V = v;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public inserisciOBlock(int X1, int X2, int X3, int X4, int Y1, int Y2, int Y3, int Y4, int V) {
/*  39 */     this.X1 = X1;
/*  40 */     this.X2 = X2;
/*  41 */     this.X3 = X3;
/*  42 */     this.X4 = X4;
/*  43 */     this.Y1 = Y1;
/*  44 */     this.Y2 = Y2;
/*  45 */     this.Y3 = Y3;
/*  46 */     this.Y4 = Y4;
/*  47 */     this.V = V;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public inserisciOBlock() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getX1() {
/*  58 */     return this.X1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX1(int x1) {
/*  63 */     this.X1 = x1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY1() {
/*  68 */     return this.Y1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY1(int y1) {
/*  73 */     this.Y1 = y1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX2() {
/*  78 */     return this.X2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX2(int x2) {
/*  83 */     this.X2 = x2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY2() {
/*  88 */     return this.Y2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY2(int y2) {
/*  93 */     this.Y2 = y2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX3() {
/*  98 */     return this.X3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX3(int x3) {
/* 103 */     this.X3 = x3;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY3() {
/* 108 */     return this.Y3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY3(int y3) {
/* 113 */     this.Y3 = y3;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX4() {
/* 118 */     return this.X4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX4(int x4) {
/* 123 */     this.X4 = x4;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY4() {
/* 128 */     return this.Y4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY4(int y4) {
/* 133 */     this.Y4 = y4;
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/InserisciBlocks/inserisciOBlock.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */