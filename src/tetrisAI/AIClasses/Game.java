/*     */ package tetrisAI.AIClasses;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import tetrisAI.AIBlocks.iBlock;
/*     */ import tetrisAI.AIBlocks.jBlock;
/*     */ import tetrisAI.AIBlocks.lBlock;
/*     */ import tetrisAI.AIBlocks.oBlock;
/*     */ import tetrisAI.AIBlocks.sBlock;
/*     */ import tetrisAI.AIBlocks.tBlock;
/*     */ import tetrisAI.AIBlocks.zBlock;
/*     */ import tetrisAI.Game.Gameloop;
/*     */ import tetrisAI.View.GamePanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Game
/*     */   implements Runnable
/*     */ {
/*     */   private Map map;
/*  22 */   private int id = 0;
/*     */   private EmptyBlock eb;
/*     */   private Piece piece;
/*  25 */   private int indexNP = 0;
/*     */   private Thread t;
/*  27 */   private int numRowsAdded = 0;
/*     */   
/*     */   private boolean interrupt;
/*     */   
/*     */   private Gameloop loop;
/*     */   private GamePanel gp;
/*     */   private List<Integer> linesfull;
/*     */   public boolean wait;
/*     */   private ASPSolver asp;
/*     */   private boolean waitup;
/*     */   
/*     */   public Game() {
/*  39 */     this.eb = new EmptyBlock(0, 0, 0);
/*  40 */     this.map = new Map(this);
/*     */     
/*  42 */     this.asp = new ASPSolver();
/*  43 */     this.interrupt = false;
/*     */     
/*  45 */     this.linesfull = new ArrayList<>();
/*     */     
/*  47 */     this.wait = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void checkDeleteCondition() {
/*  52 */     if (!this.loop.getCurrPiece().isMoving()) {
/*     */       
/*  54 */       checkLinesFull();
/*     */       
/*  56 */       if (this.linesfull != null && !this.linesfull.isEmpty()) {
/*  57 */         lowMatrix();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void checkLinesFull() {
/*  64 */     if (this.linesfull != null) {
/*  65 */       this.linesfull.clear();
/*     */     }
/*     */ 
/*     */     
/*  69 */     for (int i = 0; i < (this.map.getMatrix()).length; i++) {
/*  70 */       boolean full = true;
/*  71 */       for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
/*     */         
/*  73 */         if (this.map.getMatrix()[i][j].getValue() == 0 || this.map.getMatrix()[i][j].getValue() == -9) {
/*  74 */           full = false;
/*     */         }
/*     */       } 
/*  77 */       if (full) {
/*  78 */         if (!this.linesfull.contains(Integer.valueOf(i))) {
/*  79 */           this.linesfull.add(Integer.valueOf(i));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*  84 */         this.gp.getScorePanel().setScoreAI(this.gp.getScorePanel().getScoreAI() + 10);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private synchronized void lowMatrix() {
/*  91 */     this.wait = true;
/*  92 */     while (this.waitup) {
/*  93 */       if (this.interrupt)
/*     */         return; 
/*  95 */       System.out.println("WAITING");
/*     */     } 
/*     */     
/*  98 */     Copy(this.map.getMatrix(), this.map.getSuppMatrix());
/*  99 */     clearSuppMatrix();
/*     */     
/* 101 */     checkLinesFull();
/*     */     
/* 103 */     this.numRowsAdded = this.linesfull.size();
/* 104 */     if (!this.loop.GameoverPlayer()) {
/* 105 */       this.gp.getPlayer().addRows();
/*     */     }
/* 107 */     this.loop.setCurrPiece(null);
/*     */ 
/*     */ 
/*     */     
/* 111 */     for (int k = 0; k < this.linesfull.size(); k++) {
/* 112 */       int nk = 0;
/* 113 */       for (int i = 1; i < (this.map.getSuppMatrix()).length; i++) {
/* 114 */         for (int j = 0; j < (this.map.getSuppMatrix()[i]).length; j++) {
/* 115 */           if (i == 1) {
/* 116 */             this.eb.setRow(0);
/* 117 */             this.eb.setColumn(j);
/* 118 */             this.map.getSuppMatrix()[0][j] = this.eb;
/*     */           } 
/*     */           
/* 121 */           if (nk < (this.map.getMatrix()).length)
/* 122 */             this.map.getSuppMatrix()[i][j] = this.map.getMatrix()[nk][j]; 
/* 123 */           if (i == ((Integer)this.linesfull.get(k)).intValue() && j == (this.map.getSuppMatrix()[i]).length - 1 && ((Integer)this.linesfull.get(k)).intValue() != (this.map.getMatrix()).length - 1)
/* 124 */             nk++; 
/*     */         } 
/* 126 */         nk++;
/*     */       } 
/* 128 */       Copy(this.map.getMatrix(), this.map.getSuppMatrix());
/* 129 */       clearSuppMatrix();
/*     */     } 
/*     */     
/* 132 */     this.wait = false;
/*     */   }
/*     */   
/*     */   private synchronized void upMatrix(int n) {
/* 136 */     this.waitup = true;
/*     */     
/* 138 */     if (n == 0) {
/*     */       return;
/*     */     }
/* 141 */     int ix = 0;
/*     */ 
/*     */     
/* 144 */     while (ix < n) {
/* 145 */       for (int j = 1; j < (this.map.getMatrix()).length; j++) {
/* 146 */         for (int k = 0; k < (this.map.getMatrix()[j]).length; k++) {
/* 147 */           if (this.map.getSuppMatrix()[j][k].getValue() <= 0) {
/*     */ 
/*     */             
/* 150 */             Cell temp = this.map.getSuppMatrix()[j][k];
/* 151 */             temp.setRow(this.map.getSuppMatrix()[j][k].getRow() - 1);
/*     */             
/* 153 */             this.eb.setRow(j);
/* 154 */             this.eb.setColumn(k);
/* 155 */             this.map.getSuppMatrix()[j][k] = this.eb;
/* 156 */             this.map.getSuppMatrix()[j - 1][k] = temp;
/*     */           } 
/*     */         } 
/* 159 */       }  Copy(this.map.getMatrix(), this.map.getSuppMatrix());
/* 160 */       clearSuppMatrix();
/* 161 */       ix++;
/*     */     } 
/*     */     
/* 164 */     for (int i = (this.map.getMatrix()).length - n; i < (this.map.getMatrix()).length; i++) {
/* 165 */       for (int j = 0; j < (this.map.getMatrix()[i]).length; j++)
/* 166 */         this.map.getSuppMatrix()[i][j] = new Cell(i, j, -9); 
/* 167 */     }  this.waitup = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void clearSuppMatrix() {
/* 174 */     if (!SuppMatrixIsEmpty()) {
/* 175 */       for (int i = 0; i < (this.map.getMatrix()).length; i++) {
/* 176 */         for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
/* 177 */           if (this.map.getSuppMatrix() != null && 
/* 178 */             this.map.getSuppMatrix()[i][j].getValue() > 0) {
/* 179 */             this.eb.setRow(i);
/* 180 */             this.eb.setColumn(j);
/* 181 */             this.map.getSuppMatrix()[i][j] = this.eb;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public synchronized void Copy(Cell[][] matrix, Cell[][] suppMatrix) {
/* 189 */     for (int i = 0; i < matrix.length; i++) {
/* 190 */       for (int j = 0; j < (matrix[i]).length; j++) {
/* 191 */         matrix[i][j] = suppMatrix[i][j];
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkScrollCondition(Map map, Piece currPiece) {
/* 199 */     for (int i = 0; i < 4; i++) {
/*     */       
/* 201 */       if (currPiece.getPiece()[i].getRow() < (map.getMatrix()).length - 1 - this.gp.getPlayer().getRowsToAdd()) {
/*     */         
/* 203 */         if (map.getMatrix()[currPiece.getPiece()[i].getRow() + 1][currPiece.getPiece()[i].getColumn()].getId() != currPiece.getId() && map.getMatrix()[currPiece.getPiece()[i].getRow() + 1][currPiece.getPiece()[i].getColumn()].getValue() != 0) {
/* 204 */           return false;
/*     */         }
/*     */       } else {
/*     */         
/* 208 */         return false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 213 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Piece createPiece(int n) {
/* 222 */     this.piece = null;
/*     */     
/* 224 */     switch (n) {
/*     */       case 1:
/* 226 */         this.piece = (Piece)new iBlock();
/* 227 */         addPiece(this.piece);
/* 228 */         ((iBlock)this.piece).setMoving(true);
/*     */         break;
/*     */       
/*     */       case 2:
/* 232 */         this.piece = (Piece)new jBlock();
/* 233 */         addPiece(this.piece);
/* 234 */         ((jBlock)this.piece).setMoving(true);
/*     */         break;
/*     */       
/*     */       case 3:
/* 238 */         this.piece = (Piece)new lBlock();
/* 239 */         addPiece(this.piece);
/* 240 */         ((lBlock)this.piece).setMoving(true);
/*     */         break;
/*     */       
/*     */       case 4:
/* 244 */         this.piece = (Piece)new oBlock();
/* 245 */         addPiece(this.piece);
/* 246 */         ((oBlock)this.piece).setMoving(true);
/*     */         break;
/*     */       
/*     */       case 5:
/* 250 */         this.piece = (Piece)new sBlock();
/* 251 */         addPiece(this.piece);
/* 252 */         ((sBlock)this.piece).setMoving(true);
/*     */         break;
/*     */       
/*     */       case 6:
/* 256 */         this.piece = (Piece)new tBlock();
/* 257 */         addPiece(this.piece);
/* 258 */         ((tBlock)this.piece).setMoving(true);
/*     */         break;
/*     */       
/*     */       case 7:
/* 262 */         this.piece = (Piece)new zBlock();
/* 263 */         addPiece(this.piece);
/* 264 */         ((zBlock)this.piece).setMoving(true);
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 270 */     this.piece.setId(this.id);
/*     */     
/* 272 */     for (int k = 0; k < 4; k++) {
/* 273 */       this.piece.getPiece()[k].setId(this.id);
/*     */     }
/* 275 */     this.id++;
/*     */     
/* 277 */     return this.piece;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPiece(Piece piece) {
/* 283 */     if (piece != null)
/* 284 */       for (int i = 0; i < 4; i++)
/* 285 */         this.map.getSuppMatrix()[piece.getPiece()[i].getRow()][piece.getPiece()[i].getColumn()] = piece.getPiece()[i];  
/*     */   }
/*     */   
/*     */   public boolean SuppMatrixIsEmpty() {
/* 289 */     for (int i = 0; i < (this.map.getMatrix()).length; i++) {
/* 290 */       for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
/* 291 */         if (this.map.getSuppMatrix()[i][j].getValue() != 0)
/* 292 */           return false; 
/*     */       } 
/*     */     } 
/* 295 */     return true;
/*     */   }
/*     */   
/*     */   public void gameConditions(List<Piece> pieces, boolean updatable) {
/* 299 */     if (this.loop != null) {
/* 300 */       if (this.wait) {
/* 301 */         this.indexNP++;
/* 302 */         pieces.add(createPiece(((Integer)this.loop.allPiecesQueue.get(this.indexNP)).intValue()));
/*     */         
/* 304 */         this.gp.fillNextPieces(0, this.indexNP);
/*     */         
/* 306 */         this.loop.setCurrPiece(pieces.get(pieces.size() - 1));
/*     */         
/* 308 */         this.asp.addPiece(this.loop.getCurrPiece(), this.map, this);
/*     */ 
/*     */         
/* 311 */         this.asp.updateAspCells(this.map);
/*     */       } else {
/*     */         
/* 314 */         if (!this.loop.getCurrPiece().isMoving()) {
/* 315 */           checkDeleteCondition();
/* 316 */           this.indexNP++;
/* 317 */           pieces.add(createPiece(((Integer)this.loop.allPiecesQueue.get(this.indexNP)).intValue()));
/*     */           
/* 319 */           this.gp.fillNextPieces(0, this.indexNP);
/*     */           
/* 321 */           this.loop.setCurrPiece(pieces.get(pieces.size() - 1));
/*     */           
/* 323 */           this.asp.addPiece(this.loop.getCurrPiece(), this.map, this);
/*     */ 
/*     */           
/* 326 */           this.asp.updateAspCells(this.map);
/*     */         } 
/*     */         
/* 329 */         updatable = true;
/*     */         
/* 331 */         for (int i = 0; i < (this.map.getMatrix()).length; i++) {
/*     */ 
/*     */           
/* 334 */           for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
/*     */             
/* 336 */             if (this.map.getMatrix()[i][j].getValue() > 0)
/*     */             {
/*     */               
/* 339 */               if (checkScrollCondition(this.map, this.loop.getCurrPiece())) {
/*     */                 
/* 341 */                 if (updatable) {
/* 342 */                   for (int k = 0; k < 4; k++) {
/* 343 */                     this.loop.getCurrPiece().getPiece()[k].setRow(this.loop.getCurrPiece().getPiece()[k].getRow() + 1);
/* 344 */                     this.map.getSuppMatrix()[this.loop.getCurrPiece().getPiece()[k].getRow()][this.loop.getCurrPiece().getPiece()[k].getColumn()] = this.loop.getCurrPiece().getPiece()[k];
/*     */                   } 
/*     */ 
/*     */                   
/* 348 */                   updatable = false;
/*     */                 
/*     */                 }
/*     */               
/*     */               }
/* 353 */               else if (!checkScrollCondition(this.map, this.loop.getCurrPiece()) && this.loop.getCurrPiece().getPiece()[0].getRow() < 1) {
/* 354 */                 this.gp.getScorePanel().setScoreAI(0);
/* 355 */                 this.loop.setGameoverai(true);
/*     */               }
/*     */               else {
/*     */                 
/* 359 */                 sleepTime(100);
/*     */                 
/* 361 */                 if (!checkScrollCondition(this.map, this.loop.getCurrPiece())) {
/*     */ 
/*     */                   
/* 364 */                   this.loop.getCurrPiece().setMoving(false);
/*     */                   
/* 366 */                   for (int k = 0; k < 4; k++) {
/* 367 */                     this.loop.getCurrPiece().getPiece()[k].setValue(this.loop.getCurrPiece().getPiece()[k].getValue() * -1);
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
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
/*     */   public void run() {
/* 389 */     while (!this.interrupt) {
/* 390 */       while (!this.wait && 
/* 391 */         !this.interrupt) {
/*     */         
/* 393 */         if (this.loop != null && 
/* 394 */           this.loop.getCurrPiece() != null && this.map.getSuppMatrix() != null) {
/*     */           
/* 396 */           Copy(this.map.getMatrix(), this.map.getSuppMatrix());
/* 397 */           clearSuppMatrix();
/* 398 */           addPiece(this.loop.getCurrPiece());
/*     */         } 
/*     */ 
/*     */         
/* 402 */         this.map.update();
/* 403 */         if (this.gp != null) {
/* 404 */           this.gp.getScorePanel().repaint();
/*     */         }
/* 406 */         sleepTime(10);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sleepTime(int i) {
/*     */     try {
/* 413 */       Thread.sleep(i);
/* 414 */     } catch (InterruptedException e) {
/*     */       
/* 416 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public Map getMap() {
/* 421 */     return this.map;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRows() {
/* 426 */     upMatrix(this.gp.getPlayer().getRowsToAdd());
/*     */     
/* 428 */     this.gp.getPlayer().resetRowsToAdd();
/*     */   }
/*     */   
/*     */   public void setThread(Thread t1) {
/* 432 */     this.t = t1;
/*     */   }
/*     */   public Thread getThread() {
/* 435 */     return this.t;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowsToAdd() {
/* 440 */     return this.numRowsAdded;
/*     */   }
/*     */   
/*     */   public void resetRowsToAdd() {
/* 444 */     this.numRowsAdded = 0;
/*     */   }
/*     */   
/*     */   public void interruptThread() {
/* 448 */     this.linesfull = null;
/* 449 */     this.interrupt = true;
/*     */   }
/*     */   
/*     */   public Gameloop getLoop() {
/* 453 */     return this.loop;
/*     */   }
/*     */   
/*     */   public ASPSolver getASP() {
/* 457 */     return this.asp;
/*     */   }
/*     */   
/*     */   public void setLoop(Gameloop loop, GamePanel gp) {
/* 461 */     this.loop = loop;
/* 462 */     this.gp = gp;
/*     */   }
/*     */   
/*     */   public void deleteASP() {
/* 466 */     this.asp = null;
/*     */   }
/*     */   
/*     */   public GamePanel getGamePanel() {
/* 470 */     return this.gp;
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/AIClasses/Game.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */