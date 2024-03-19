/*     */ package tetrisAI.BlockBeans;
/*     */ 
/*     */ import it.unical.mat.embasp.languages.Id;
/*     */ import it.unical.mat.embasp.languages.Param;
/*     */ 
/*     */ @Id("zblockbean")
/*     */ public class zBlockBean {
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
/*     */   private int value;
/*     */   
/*     */   public zBlockBean(int X1, int X2, int X3, int X4, int Y1, int Y2, int Y3, int Y4, int v) {
/*  28 */     this.X1 = X1;
/*  29 */     this.X2 = X2;
/*  30 */     this.X3 = X3;
/*  31 */     this.X4 = X4;
/*  32 */     this.Y1 = Y1;
/*  33 */     this.Y2 = Y2;
/*  34 */     this.Y3 = Y3;
/*  35 */     this.Y4 = Y4;
/*  36 */     this.value = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public zBlockBean() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getX1() {
/*  46 */     return this.X1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX1(int x1) {
/*  51 */     this.X1 = x1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY1() {
/*  56 */     return this.Y1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY1(int y1) {
/*  61 */     this.Y1 = y1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX2() {
/*  66 */     return this.X2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX2(int x2) {
/*  71 */     this.X2 = x2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY2() {
/*  76 */     return this.Y2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY2(int y2) {
/*  81 */     this.Y2 = y2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX3() {
/*  86 */     return this.X3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX3(int x3) {
/*  91 */     this.X3 = x3;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY3() {
/*  96 */     return this.Y3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY3(int y3) {
/* 101 */     this.Y3 = y3;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX4() {
/* 106 */     return this.X4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX4(int x4) {
/* 111 */     this.X4 = x4;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY4() {
/* 116 */     return this.Y4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY4(int y4) {
/* 121 */     this.Y4 = y4;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getValue() {
/* 126 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValue(int value) {
/* 131 */     this.value = value;
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/BlockBeans/zBlockBean.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */