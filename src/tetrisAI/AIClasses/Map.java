/*     */ package tetrisAI.AIClasses;
/*     */ 
/*     */ import it.unical.mat.embasp.languages.Id;
/*     */ import it.unical.mat.embasp.languages.Param;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JPanel;
/*     */ import tetrisAI.AIBlocks.iBlock;
/*     */ import tetrisAI.AIBlocks.jBlock;
/*     */ import tetrisAI.AIBlocks.lBlock;
/*     */ import tetrisAI.AIBlocks.oBlock;
/*     */ import tetrisAI.AIBlocks.sBlock;
/*     */ import tetrisAI.AIBlocks.tBlock;
/*     */ import tetrisAI.AIBlocks.zBlock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Id("map")
/*     */ public class Map
/*     */   extends JPanel
/*     */ {
/*     */   @Param(0)
/*     */   private Cell[][] matrix;
/*     */   @Param(1)
/*     */   private iBlock ib;
/*     */   @Param(2)
/*     */   private jBlock jb;
/*     */   @Param(3)
/*     */   private lBlock lb;
/*     */   @Param(4)
/*     */   private oBlock ob;
/*     */   @Param(5)
/*     */   private sBlock sb;
/*     */   @Param(6)
/*     */   private tBlock tb;
/*     */   @Param(7)
/*     */   private zBlock zb;
/*     */   @Param(8)
/*     */   private EmptyBlock eb;
/*     */   @Param(9)
/*     */   private Cell[][] suppMatrix;
/*     */   private Image ibl;
/*     */   private Image jbl;
/*     */   private Image lbl;
/*     */   private Image obl;
/*     */   private Image sbl;
/*     */   private Image tbl;
/*     */   private Image zbl;
/*     */   private Image wall;
/*     */   private Piece currPiece;
/*  77 */   private Integer score = Integer.valueOf(0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map(Game game) {
/*  84 */     this.matrix = new Cell[20][10];
/*  85 */     this.suppMatrix = new Cell[20][10];
/*     */ 
/*     */     
/*  88 */     this.ib = new iBlock();
/*  89 */     this.ibl = this.ib.getImage();
/*     */     
/*  91 */     this.jb = new jBlock();
/*  92 */     this.jbl = this.jb.getImage();
/*     */     
/*  94 */     this.lb = new lBlock();
/*  95 */     this.lbl = this.lb.getImage();
/*     */     
/*  97 */     this.ob = new oBlock();
/*  98 */     this.obl = this.ob.getImage();
/*     */     
/* 100 */     this.sb = new sBlock();
/* 101 */     this.sbl = this.sb.getImage();
/*     */     
/* 103 */     this.tb = new tBlock();
/* 104 */     this.tbl = this.tb.getImage();
/*     */     
/* 106 */     this.zb = new zBlock();
/* 107 */     this.zbl = this.zb.getImage();
/*     */     
/*     */     try {
/* 110 */       this.wall = ImageIO.read(getClass().getResource("/resources/wall.png"));
/* 111 */       Image icon = this.wall.getScaledInstance(30, 30, 4);
/* 112 */       this.wall = icon;
/* 113 */     } catch (IOException e) {
/*     */       
/* 115 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 118 */     for (int i = 0; i < this.matrix.length; i++) {
/*     */       
/* 120 */       for (int j = 0; j < (this.matrix[i]).length; j++) {
/*     */         
/* 122 */         this.matrix[i][j] = new EmptyBlock(i, j, 0);
/* 123 */         this.suppMatrix[i][j] = new EmptyBlock(i, j, 0);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 128 */     repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void paintComponent(Graphics g) {
/* 135 */     super.paintComponent(g);
/*     */ 
/*     */ 
/*     */     
/* 139 */     for (int i = 0; i < this.matrix.length; i++) {
/*     */       
/* 141 */       for (int j = 0; j < (this.matrix[i]).length; j++) {
/*     */ 
/*     */         
/* 144 */         if (this.matrix[i][j].getValue() == 0) {
/* 145 */           int x = 0 + j * 30;
/* 146 */           int y = 0 + i * 30;
/* 147 */           g.setColor(Color.BLACK);
/* 148 */           g.fillRect(x, y, 30, 30);
/*     */ 
/*     */         
/*     */         }
/* 152 */         else if (this.matrix[i][j].getValue() == 1 || this.matrix[i][j].getValue() == -1) {
/* 153 */           int x = 0 + j * 30;
/* 154 */           int y = 0 + i * 30;
/*     */           
/* 156 */           g.drawImage(this.ibl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 159 */         else if (this.matrix[i][j].getValue() == 2 || this.matrix[i][j].getValue() == -2) {
/* 160 */           int x = 0 + j * 30;
/* 161 */           int y = 0 + i * 30;
/*     */           
/* 163 */           g.drawImage(this.jbl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 166 */         else if (this.matrix[i][j].getValue() == 3 || this.matrix[i][j].getValue() == -3) {
/* 167 */           int x = 0 + j * 30;
/* 168 */           int y = 0 + i * 30;
/*     */           
/* 170 */           g.drawImage(this.lbl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 173 */         else if (this.matrix[i][j].getValue() == 4 || this.matrix[i][j].getValue() == -4) {
/* 174 */           int x = 0 + j * 30;
/* 175 */           int y = 0 + i * 30;
/*     */           
/* 177 */           g.drawImage(this.obl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 180 */         else if (this.matrix[i][j].getValue() == 5 || this.matrix[i][j].getValue() == -5) {
/* 181 */           int x = 0 + j * 30;
/* 182 */           int y = 0 + i * 30;
/*     */           
/* 184 */           g.drawImage(this.sbl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 187 */         else if (this.matrix[i][j].getValue() == 6 || this.matrix[i][j].getValue() == -6) {
/* 188 */           int x = 0 + j * 30;
/* 189 */           int y = 0 + i * 30;
/*     */           
/* 191 */           g.drawImage(this.tbl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 194 */         else if (this.matrix[i][j].getValue() == 7 || this.matrix[i][j].getValue() == -7) {
/* 195 */           int x = 0 + j * 30;
/* 196 */           int y = 0 + i * 30;
/*     */           
/* 198 */           g.drawImage(this.zbl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 201 */         else if (this.matrix[i][j].getValue() == 9 || this.matrix[i][j].getValue() == -9) {
/* 202 */           int x = 0 + j * 30;
/* 203 */           int y = 0 + i * 30;
/*     */           
/* 205 */           g.drawImage(this.wall, x, y, 30, 30, null);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 211 */     g.setColor(Color.LIGHT_GRAY);
/* 212 */     g.drawLine(0, 0, 300, 0);
/* 213 */     g.drawLine(0, 600, 300, 600);
/* 214 */     g.drawLine(300, 0, 300, 600);
/* 215 */     g.drawLine(0, 0, 0, 600);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getScore() {
/* 222 */     return this.score;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScore(Integer score) {
/* 227 */     this.score = score;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Cell[][] getMatrix() {
/* 232 */     return this.matrix;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Cell[][] getSuppMatrix() {
/* 237 */     return this.suppMatrix;
/*     */   }
/*     */   
/*     */   public synchronized void update() {
/* 241 */     repaint();
/*     */   }
/*     */   
/*     */   public synchronized void addPiece(Piece piece) {
/* 245 */     this.currPiece = piece;
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/AIClasses/Map.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */