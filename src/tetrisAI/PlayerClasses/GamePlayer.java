/*     */ package tetrisAI.PlayerClasses;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import tetrisAI.Game.Gameloop;
/*     */ import tetrisAI.PlayerBlocks.iBlockPlayer;
/*     */ import tetrisAI.PlayerBlocks.jBlockPlayer;
/*     */ import tetrisAI.PlayerBlocks.lBlockPlayer;
/*     */ import tetrisAI.PlayerBlocks.oBlockPlayer;
/*     */ import tetrisAI.PlayerBlocks.sBlockPlayer;
/*     */ import tetrisAI.PlayerBlocks.tBlockPlayer;
/*     */ import tetrisAI.PlayerBlocks.zBlockPlayer;
/*     */ import tetrisAI.View.GamePanel;
/*     */ 
/*     */ 
/*     */ public class GamePlayer
/*     */   implements Runnable
/*     */ {
/*     */   private MapPlayer map;
/*  20 */   private int id = 0;
/*     */   private EmptyBlockPlayer eb;
/*     */   private PiecePlayer piece;
/*  23 */   private int indexNP = 0;
/*  24 */   private int numRowsAdded = 0;
/*     */   
/*     */   private boolean interrupt;
/*     */   private Gameloop loop;
/*     */   private GamePanel gp;
/*     */   private List<Integer> linesfull;
/*     */   public boolean wait;
/*     */   public boolean waitup;
/*     */   
/*     */   public GamePlayer() {
/*  34 */     this.eb = new EmptyBlockPlayer(0, 0, 0);
/*  35 */     this.map = new MapPlayer(this);
/*     */     
/*  37 */     this.interrupt = false;
/*  38 */     this.linesfull = new ArrayList<>();
/*     */     
/*  40 */     this.wait = false;
/*  41 */     this.waitup = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void checkDeleteCondition() {
/*  46 */     if (!this.loop.getCurrPiecePlayer().isMoving()) {
/*     */       
/*  48 */       checkLinesFull();
/*     */       
/*  50 */       if (this.linesfull != null && !this.linesfull.isEmpty()) {
/*  51 */         lowMatrix();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private synchronized void upMatrix(int n) {
/*  58 */     this.waitup = true;
/*  59 */     if (n == 0) {
/*     */       return;
/*     */     }
/*  62 */     int ix = 0;
/*     */ 
/*     */     
/*  65 */     while (ix < n) {
/*  66 */       for (int j = 1; j < (this.map.getMatrix()).length; j++) {
/*  67 */         for (int k = 0; k < (this.map.getMatrix()[j]).length; k++) {
/*  68 */           if (this.map.getSuppMatrix()[j][k].getValue() <= 0) {
/*     */ 
/*     */ 
/*     */             
/*  72 */             CellPlayer temp = this.map.getSuppMatrix()[j][k];
/*  73 */             temp.setRow(this.map.getSuppMatrix()[j][k].getRow() - 1);
/*     */             
/*  75 */             this.eb.setRow(j);
/*  76 */             this.eb.setColumn(k);
/*  77 */             this.map.getSuppMatrix()[j][k] = this.eb;
/*  78 */             this.map.getSuppMatrix()[j - 1][k] = temp;
/*     */           } 
/*     */         } 
/*  81 */       }  Copy(this.map.getMatrix(), this.map.getSuppMatrix());
/*  82 */       clearSuppMatrix();
/*  83 */       ix++;
/*     */     } 
/*     */     
/*  86 */     for (int i = (this.map.getMatrix()).length - n; i < (this.map.getMatrix()).length; i++) {
/*  87 */       for (int j = 0; j < (this.map.getMatrix()[i]).length; j++)
/*  88 */         this.map.getSuppMatrix()[i][j] = new CellPlayer(i, j, -9); 
/*  89 */     }  this.waitup = false;
/*     */   }
/*     */   
/*     */   public synchronized void checkLinesFull() {
/*  93 */     if (this.linesfull != null) {
/*  94 */       this.linesfull.clear();
/*     */     }
/*     */ 
/*     */     
/*  98 */     for (int i = 0; i < (this.map.getMatrix()).length; i++) {
/*  99 */       boolean full = true;
/* 100 */       for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
/*     */         
/* 102 */         if (this.map.getMatrix()[i][j].getValue() == 0 || this.map.getMatrix()[i][j].getValue() == -9) {
/* 103 */           full = false;
/*     */         }
/*     */       } 
/* 106 */       if (full) {
/*     */         
/* 108 */         if (!this.linesfull.contains(Integer.valueOf(i))) {
/* 109 */           this.linesfull.add(Integer.valueOf(i));
/*     */         }
/*     */         
/* 112 */         if (this.gp.gamemode == 1) {
/* 113 */           if (this.gp.getSingleScorePanel().getScorePlayer() >= this.gp.getSingleScorePanel().getPrecScore() + this.gp.getSingleScorePanel().getIncreasePoints() * 5) {
/* 114 */             this.gp.getSingleScorePanel().increaseLevel();
/* 115 */             this.gp.getSingleScorePanel().updatePrecScore();
/* 116 */             this.gp.getSingleScorePanel().updateIncreasePoints();
/* 117 */             if (this.loop.getPlayerFPS() > 100) {
/* 118 */               this.loop.setPlayerSleepTime(this.loop.getPlayerFPS() - 20);
/* 119 */               this.loop.setLevelFPS(this.loop.getPlayerFPS() - 20);
/*     */             }
/* 121 */             else if (this.loop.getPlayerFPS() <= 100 && this.loop.getPlayerFPS() > 25) {
/* 122 */               this.loop.setPlayerSleepTime(this.loop.getPlayerFPS() - 10);
/* 123 */               this.loop.setLevelFPS(this.loop.getPlayerFPS() - 10);
/*     */             } 
/*     */           } 
/* 126 */           this.gp.getSingleScorePanel().setScorePlayer(this.gp.getSingleScorePanel().getScorePlayer() + this.gp.getSingleScorePanel().getIncreasePoints());
/*     */         }
/* 128 */         else if (this.gp.gamemode == 0) {
/* 129 */           this.gp.getScorePanel().setScorePlayer(this.gp.getScorePanel().getScorePlayer() + 10);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private synchronized void lowMatrix() {
/* 137 */     this.wait = true;
/* 138 */     while (this.waitup) {
/* 139 */       if (this.interrupt)
/*     */         return; 
/* 141 */       System.out.println("WAITING");
/*     */     } 
/*     */ 
/*     */     
/* 145 */     Copy(this.map.getMatrix(), this.map.getSuppMatrix());
/* 146 */     clearSuppMatrix();
/*     */     
/* 148 */     checkLinesFull();
/*     */     
/* 150 */     this.numRowsAdded = this.linesfull.size();
/* 151 */     if (!this.loop.Gameoverai() && this.gp.gamemode == 0) {
/* 152 */       this.gp.getAI().addRows();
/*     */     }
/* 154 */     this.loop.setCurrPiecePlayer(null);
/*     */     
/* 156 */     for (int k = 0; k < this.linesfull.size(); k++) {
/* 157 */       int nk = 0;
/* 158 */       for (int i = 1; i < (this.map.getSuppMatrix()).length; i++) {
/* 159 */         for (int j = 0; j < (this.map.getSuppMatrix()[i]).length; j++) {
/* 160 */           if (i == 1) {
/* 161 */             this.eb.setRow(0);
/* 162 */             this.eb.setColumn(j);
/* 163 */             this.map.getSuppMatrix()[0][j] = this.eb;
/*     */           } 
/*     */           
/* 166 */           if (nk < (this.map.getMatrix()).length)
/* 167 */             this.map.getSuppMatrix()[i][j] = this.map.getMatrix()[nk][j]; 
/* 168 */           if (i == ((Integer)this.linesfull.get(k)).intValue() && j == (this.map.getSuppMatrix()[i]).length - 1 && ((Integer)this.linesfull.get(k)).intValue() != (this.map.getMatrix()).length - 1)
/* 169 */             nk++; 
/*     */         } 
/* 171 */         nk++;
/*     */       } 
/* 173 */       Copy(this.map.getMatrix(), this.map.getSuppMatrix());
/* 174 */       clearSuppMatrix();
/*     */     } 
/*     */     
/* 177 */     this.wait = false;
/*     */   }
/*     */   
/*     */   public int getRowsToAdd() {
/* 181 */     return this.numRowsAdded;
/*     */   }
/*     */   
/*     */   public void resetRowsToAdd() {
/* 185 */     this.numRowsAdded = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void clearSuppMatrix() {
/* 191 */     for (int i = 0; i < (this.map.getMatrix()).length; i++) {
/* 192 */       for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
/*     */         
/* 194 */         if (this.map.getSuppMatrix()[i][j].getValue() > 0) {
/* 195 */           this.eb.setRow(i);
/* 196 */           this.eb.setColumn(j);
/* 197 */           this.map.getSuppMatrix()[i][j] = this.eb;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void Copy(CellPlayer[][] matrix, CellPlayer[][] suppMatrix) {
/* 205 */     for (int i = 0; i < matrix.length; i++) {
/* 206 */       for (int j = 0; j < (matrix[i]).length; j++) {
/* 207 */         matrix[i][j] = suppMatrix[i][j];
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkScrollCondition(MapPlayer map2, PiecePlayer currPiecePlayer) {
/* 215 */     for (int i = 0; i < 4; i++) {
/* 216 */       int diff = 0;
/* 217 */       if (this.gp.getAI() != null)
/* 218 */         diff = this.gp.getAI().getRowsToAdd(); 
/* 219 */       if (currPiecePlayer.getPiece()[i].getRow() < (this.map.getMatrix()).length - 1 - diff) {
/*     */         
/* 221 */         if (map2.getMatrix()[currPiecePlayer.getPiece()[i].getRow() + 1][currPiecePlayer.getPiece()[i].getColumn()].getId() != currPiecePlayer.getId() && map2.getMatrix()[currPiecePlayer.getPiece()[i].getRow() + 1][currPiecePlayer.getPiece()[i].getColumn()].getValue() != 0) {
/* 222 */           return false;
/*     */         }
/*     */       } else {
/*     */         
/* 226 */         return false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 231 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void gameConditions(List<PiecePlayer> pieces, boolean updatable) {
/* 236 */     if (this.loop != null) {
/* 237 */       if (this.loop.getCurrPiecePlayer() == null || !this.loop.getCurrPiecePlayer().isMoving()) {
/*     */         
/* 239 */         checkDeleteCondition();
/*     */         
/* 241 */         this.indexNP++;
/* 242 */         pieces.add(createPiecePlayer(((Integer)this.loop.allPiecesQueue.get(this.indexNP)).intValue()));
/*     */         
/* 244 */         this.gp.fillNextPieces(1, this.indexNP);
/*     */ 
/*     */         
/* 247 */         this.loop.setCurrPiecePlayer(pieces.get(pieces.size() - 1));
/*     */         
/* 249 */         this.map.getController().updatePiece(this.loop.getCurrPiecePlayer());
/*     */       } 
/*     */ 
/*     */       
/* 253 */       updatable = true;
/*     */ 
/*     */       
/* 256 */       for (int i = 0; i < (this.map.getMatrix()).length; i++) {
/*     */ 
/*     */         
/* 259 */         for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
/*     */           
/* 261 */           if (this.map.getMatrix()[i][j].getValue() > 0)
/*     */           {
/* 263 */             if (checkScrollCondition(this.map, this.loop.getCurrPiecePlayer())) {
/*     */               
/* 265 */               if (updatable) {
/* 266 */                 for (int k = 0; k < 4; k++) {
/*     */                   
/* 268 */                   this.loop.getCurrPiecePlayer().getPiece()[k].setRow(this.loop.getCurrPiecePlayer().getPiece()[k].getRow() + 1);
/* 269 */                   this.map.getSuppMatrix()[this.loop.getCurrPiecePlayer().getPiece()[k].getRow()][this.loop.getCurrPiecePlayer().getPiece()[k].getColumn()] = this.loop.getCurrPiecePlayer().getPiece()[k];
/*     */                 } 
/*     */ 
/*     */                 
/* 273 */                 updatable = false;
/*     */               
/*     */               }
/*     */             
/*     */             }
/* 278 */             else if (!checkScrollCondition(this.map, this.loop.getCurrPiecePlayer()) && this.loop.getCurrPiecePlayer().getPiece()[0].getRow() < 1) {
/* 279 */               if (this.gp.gamemode == 0)
/* 280 */                 this.gp.getScorePanel().setScorePlayer(0); 
/* 281 */               this.loop.setGameoverPlayer(true);
/*     */             
/*     */             }
/*     */             else {
/*     */               
/* 286 */               sleepTime(100);
/*     */               
/* 288 */               if (!checkScrollCondition(this.map, this.loop.getCurrPiecePlayer())) {
/*     */ 
/*     */                 
/* 291 */                 this.loop.getCurrPiecePlayer().setMoving(false);
/*     */                 
/* 293 */                 for (int k = 0; k < 4; k++) {
/* 294 */                   this.loop.getCurrPiecePlayer().getPiece()[k].setValue(this.loop.getCurrPiecePlayer().getPiece()[k].getValue() * -1);
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
/*     */   public PiecePlayer createPiecePlayer(int n) {
/* 314 */     this.piece = null;
/*     */     
/* 316 */     switch (n) {
/*     */       case 1:
/* 318 */         this.piece = (PiecePlayer)new iBlockPlayer();
/* 319 */         addPiecePlayer(this.piece);
/* 320 */         this.piece.setMoving(true);
/*     */         break;
/*     */       
/*     */       case 2:
/* 324 */         this.piece = (PiecePlayer)new jBlockPlayer();
/* 325 */         addPiecePlayer(this.piece);
/* 326 */         this.piece.setMoving(true);
/*     */         break;
/*     */       
/*     */       case 3:
/* 330 */         this.piece = (PiecePlayer)new lBlockPlayer();
/* 331 */         addPiecePlayer(this.piece);
/* 332 */         this.piece.setMoving(true);
/*     */         break;
/*     */       
/*     */       case 4:
/* 336 */         this.piece = (PiecePlayer)new oBlockPlayer();
/* 337 */         addPiecePlayer(this.piece);
/* 338 */         this.piece.setMoving(true);
/*     */         break;
/*     */       
/*     */       case 5:
/* 342 */         this.piece = (PiecePlayer)new sBlockPlayer();
/* 343 */         addPiecePlayer(this.piece);
/* 344 */         this.piece.setMoving(true);
/*     */         break;
/*     */       
/*     */       case 6:
/* 348 */         this.piece = (PiecePlayer)new tBlockPlayer();
/* 349 */         addPiecePlayer(this.piece);
/* 350 */         this.piece.setMoving(true);
/*     */         break;
/*     */       
/*     */       case 7:
/* 354 */         this.piece = (PiecePlayer)new zBlockPlayer();
/* 355 */         addPiecePlayer(this.piece);
/* 356 */         this.piece.setMoving(true);
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 362 */     this.piece.setId(this.id);
/*     */     
/* 364 */     for (int k = 0; k < 4; k++) {
/* 365 */       this.piece.getPiece()[k].setId(this.id);
/*     */     }
/* 367 */     this.id++;
/*     */ 
/*     */     
/* 370 */     return this.piece;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPiecePlayer(PiecePlayer piece2) {
/* 376 */     if (piece2 != null)
/* 377 */       for (int i = 0; i < 4; i++) {
/* 378 */         this.map.getSuppMatrix()[piece2.getPiece()[i].getRow()][piece2.getPiece()[i].getColumn()] = piece2.getPiece()[i];
/*     */       } 
/*     */   }
/*     */   
/*     */   public boolean SuppMatrixIsEmpty() {
/* 383 */     for (int i = 0; i < (this.map.getMatrix()).length; i++) {
/* 384 */       for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
/* 385 */         if (this.map.getSuppMatrix()[i][j].getValue() != 0)
/* 386 */           return false; 
/*     */       } 
/*     */     } 
/* 389 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 395 */     while (!this.interrupt) {
/* 396 */       while (!this.wait && 
/* 397 */         !this.interrupt) {
/*     */         
/* 399 */         if (this.loop != null && 
/* 400 */           this.loop.getCurrPiecePlayer() != null && this.map.getSuppMatrix() != null) {
/* 401 */           Copy(this.map.getMatrix(), this.map.getSuppMatrix());
/* 402 */           clearSuppMatrix();
/* 403 */           addPiecePlayer(this.loop.getCurrPiecePlayer());
/*     */         } 
/*     */ 
/*     */         
/* 407 */         this.map.update();
/* 408 */         if (this.gp != null)
/* 409 */           if (this.gp.gamemode == 0) {
/* 410 */             this.gp.getScorePanel().repaint();
/*     */           } else {
/* 412 */             this.gp.getSingleScorePanel().repaint();
/* 413 */           }   sleepTime(10);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sleepTime(int i) {
/*     */     try {
/* 420 */       Thread.sleep(i);
/* 421 */     } catch (InterruptedException e) {
/*     */       
/* 423 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public MapPlayer getMapPlayer() {
/* 428 */     return this.map;
/*     */   }
/*     */   
/*     */   public Gameloop getLoop() {
/* 432 */     return this.loop;
/*     */   }
/*     */   
/*     */   public GamePanel getGamePanel() {
/* 436 */     return this.gp;
/*     */   }
/*     */   
/*     */   public void interruptThread() {
/* 440 */     this.linesfull = null;
/* 441 */     this.interrupt = true;
/*     */   }
/*     */   
/*     */   public void addRows() {
/* 445 */     upMatrix(this.gp.getAI().getRowsToAdd());
/*     */     
/* 447 */     this.gp.getAI().resetRowsToAdd();
/*     */   }
/*     */   
/*     */   public void setLoop(Gameloop loop, GamePanel gp) {
/* 451 */     this.loop = loop;
/* 452 */     this.gp = gp;
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/PlayerClasses/GamePlayer.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */