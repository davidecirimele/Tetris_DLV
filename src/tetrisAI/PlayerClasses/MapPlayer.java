/*     */ package tetrisAI.PlayerClasses;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JPanel;
/*     */ import tetrisAI.PlayerBlocks.iBlockPlayer;
/*     */ import tetrisAI.PlayerBlocks.jBlockPlayer;
/*     */ import tetrisAI.PlayerBlocks.lBlockPlayer;
/*     */ import tetrisAI.PlayerBlocks.oBlockPlayer;
/*     */ import tetrisAI.PlayerBlocks.sBlockPlayer;
/*     */ import tetrisAI.PlayerBlocks.tBlockPlayer;
/*     */ import tetrisAI.PlayerBlocks.zBlockPlayer;
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
/*     */ 
/*     */ public class MapPlayer
/*     */   extends JPanel
/*     */ {
/*     */   private CellPlayer[][] matrix;
/*     */   private iBlockPlayer ib;
/*     */   private jBlockPlayer jb;
/*     */   private lBlockPlayer lb;
/*     */   private oBlockPlayer ob;
/*     */   private sBlockPlayer sb;
/*     */   private tBlockPlayer tb;
/*     */   private zBlockPlayer zb;
/*     */   private CellPlayer[][] suppMatrix;
/*     */   private Image ibl;
/*     */   private Image jbl;
/*     */   private Image lbl;
/*     */   private Image obl;
/*     */   private Image sbl;
/*     */   private Image tbl;
/*     */   private Image zbl;
/*     */   private Image wall;
/*     */   private PiecePlayer currPiece;
/*     */   private PieceController pc;
/*  65 */   private Integer score = Integer.valueOf(0);
/*     */ 
/*     */   
/*     */   public MapPlayer(GamePlayer game) {
/*  69 */     this.matrix = new CellPlayer[20][10];
/*  70 */     this.suppMatrix = new CellPlayer[20][10];
/*     */ 
/*     */     
/*  73 */     this.ib = new iBlockPlayer();
/*  74 */     this.ibl = this.ib.getImage();
/*     */     
/*  76 */     this.jb = new jBlockPlayer();
/*  77 */     this.jbl = this.jb.getImage();
/*     */     
/*  79 */     this.lb = new lBlockPlayer();
/*  80 */     this.lbl = this.lb.getImage();
/*     */     
/*  82 */     this.ob = new oBlockPlayer();
/*  83 */     this.obl = this.ob.getImage();
/*     */     
/*  85 */     this.sb = new sBlockPlayer();
/*  86 */     this.sbl = this.sb.getImage();
/*     */     
/*  88 */     this.tb = new tBlockPlayer();
/*  89 */     this.tbl = this.tb.getImage();
/*     */     
/*  91 */     this.zb = new zBlockPlayer();
/*  92 */     this.zbl = this.zb.getImage();
/*     */     
/*     */     try {
/*  95 */       this.wall = ImageIO.read(getClass().getResource("/resources/wall.png"));
/*  96 */       Image icon = this.wall.getScaledInstance(30, 30, 4);
/*  97 */       this.wall = icon;
/*  98 */     } catch (IOException e) {
/*     */       
/* 100 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 103 */     this.pc = new PieceController(this, game);
/* 104 */     addKeyListener(this.pc);
/*     */     
/* 106 */     for (int i = 0; i < this.matrix.length; i++) {
/*     */       
/* 108 */       for (int j = 0; j < (this.matrix[i]).length; j++) {
/*     */         
/* 110 */         this.matrix[i][j] = new EmptyBlockPlayer(i, j, 0);
/* 111 */         this.suppMatrix[i][j] = new EmptyBlockPlayer(i, j, 0);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 116 */     setFocusable(true);
/* 117 */     repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void paintComponent(Graphics g) {
/* 125 */     super.paintComponent(g);
/*     */ 
/*     */ 
/*     */     
/* 129 */     for (int i = 0; i < this.matrix.length; i++) {
/*     */       
/* 131 */       for (int j = 0; j < (this.matrix[i]).length; j++) {
/*     */ 
/*     */         
/* 134 */         if (this.matrix[i][j].getValue() == 0) {
/* 135 */           int x = 0 + j * 30;
/* 136 */           int y = 0 + i * 30;
/* 137 */           g.setColor(Color.BLACK);
/* 138 */           g.fillRect(x, y, 30, 30);
/*     */ 
/*     */         
/*     */         }
/* 142 */         else if (this.matrix[i][j].getValue() == 1 || this.matrix[i][j].getValue() == -1) {
/* 143 */           int x = 0 + j * 30;
/* 144 */           int y = 0 + i * 30;
/*     */           
/* 146 */           g.drawImage(this.ibl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 149 */         else if (this.matrix[i][j].getValue() == 2 || this.matrix[i][j].getValue() == -2) {
/* 150 */           int x = 0 + j * 30;
/* 151 */           int y = 0 + i * 30;
/*     */           
/* 153 */           g.drawImage(this.jbl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 156 */         else if (this.matrix[i][j].getValue() == 3 || this.matrix[i][j].getValue() == -3) {
/* 157 */           int x = 0 + j * 30;
/* 158 */           int y = 0 + i * 30;
/*     */           
/* 160 */           g.drawImage(this.lbl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 163 */         else if (this.matrix[i][j].getValue() == 4 || this.matrix[i][j].getValue() == -4) {
/* 164 */           int x = 0 + j * 30;
/* 165 */           int y = 0 + i * 30;
/*     */           
/* 167 */           g.drawImage(this.obl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 170 */         else if (this.matrix[i][j].getValue() == 5 || this.matrix[i][j].getValue() == -5) {
/* 171 */           int x = 0 + j * 30;
/* 172 */           int y = 0 + i * 30;
/*     */           
/* 174 */           g.drawImage(this.sbl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 177 */         else if (this.matrix[i][j].getValue() == 6 || this.matrix[i][j].getValue() == -6) {
/* 178 */           int x = 0 + j * 30;
/* 179 */           int y = 0 + i * 30;
/*     */           
/* 181 */           g.drawImage(this.tbl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 184 */         else if (this.matrix[i][j].getValue() == 7 || this.matrix[i][j].getValue() == -7) {
/* 185 */           int x = 0 + j * 30;
/* 186 */           int y = 0 + i * 30;
/*     */           
/* 188 */           g.drawImage(this.zbl, x, y, 30, 30, null);
/*     */         
/*     */         }
/* 191 */         else if (this.matrix[i][j].getValue() == 9 || this.matrix[i][j].getValue() == -9) {
/* 192 */           int x = 0 + j * 30;
/* 193 */           int y = 0 + i * 30;
/*     */           
/* 195 */           g.drawImage(this.wall, x, y, 30, 30, null);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 201 */     g.setColor(Color.LIGHT_GRAY);
/* 202 */     g.drawLine(0, 0, 300, 0);
/* 203 */     g.drawLine(0, 600, 300, 600);
/* 204 */     g.drawLine(300, 0, 300, 600);
/* 205 */     g.drawLine(0, 0, 0, 600);
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getScore() {
/* 210 */     return this.score;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScore(Integer score) {
/* 215 */     this.score = score;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized CellPlayer[][] getMatrix() {
/* 220 */     return this.matrix;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized CellPlayer[][] getSuppMatrix() {
/* 225 */     return this.suppMatrix;
/*     */   }
/*     */   
/*     */   public synchronized void update() {
/* 229 */     repaint();
/*     */   }
/*     */   
/*     */   public void addPiece(PiecePlayer piecePlayer) {
/* 233 */     this.currPiece = piecePlayer;
/* 234 */     this.pc.updatePiece(this.currPiece);
/*     */   }
/*     */   
/*     */   public PieceController getController() {
/* 238 */     return this.pc;
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/PlayerClasses/MapPlayer.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */