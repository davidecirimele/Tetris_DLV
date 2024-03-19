/*     */ package tetrisAI.Game;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import tetrisAI.AIClasses.Game;
/*     */ import tetrisAI.AIClasses.Map;
/*     */ import tetrisAI.AIClasses.Piece;
/*     */ import tetrisAI.PlayerClasses.GamePlayer;
/*     */ import tetrisAI.PlayerClasses.MapPlayer;
/*     */ import tetrisAI.PlayerClasses.PiecePlayer;
/*     */ import tetrisAI.View.GamePanel;
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
/*     */ public class Gameloop
/*     */ {
/*     */   private Game game;
/*     */   private Map map;
/*     */   private Piece currPiece;
/*     */   private GamePlayer player;
/*     */   private MapPlayer map2;
/*     */   private List<Piece> pieces;
/*     */   private PiecePlayer currPiecePlayer;
/*     */   private List<PiecePlayer> piecesPlayer;
/*     */   public List<Integer> allPiecesQueue;
/*     */   private Thread t;
/*     */   private Thread t1;
/*     */   private Thread t2;
/*     */   private Thread AI;
/*     */   private int fps;
/*     */   private int playerfps;
/*     */   private int levelfps;
/*     */   private boolean gameoverai;
/*     */   private boolean gameoverplayer;
/*     */   private boolean interruptGameloop;
/*     */   
/*     */   public Gameloop(final Game game, final GamePlayer player, final Map map, final MapPlayer map2, GamePanel gp, final JFrame f) {
/*  64 */     this.game = game;
/*     */     
/*  66 */     this.player = player;
/*     */     
/*  68 */     this.map = map;
/*     */     
/*  70 */     this.map2 = map2;
/*     */     
/*  72 */     this.pieces = new ArrayList<>();
/*     */     
/*  74 */     this.allPiecesQueue = new ArrayList<>();
/*  75 */     this.allPiecesQueue.add(Integer.valueOf(chooseRandomPiece()));
/*     */     
/*  77 */     this.pieces.add(game.createPiece(((Integer)this.allPiecesQueue.get(0)).intValue()));
/*     */     
/*  79 */     this.currPiece = this.pieces.get(this.pieces.size() - 1);
/*     */     
/*  81 */     this.piecesPlayer = new ArrayList<>();
/*     */     
/*  83 */     this.piecesPlayer.add(player.createPiecePlayer(((Integer)this.allPiecesQueue.get(0)).intValue()));
/*     */ 
/*     */     
/*  86 */     this.currPiecePlayer = this.piecesPlayer.get(this.piecesPlayer.size() - 1);
/*     */ 
/*     */ 
/*     */     
/*  90 */     this.fps = 200;
/*  91 */     this.playerfps = this.fps;
/*     */     
/*  93 */     this.interruptGameloop = false;
/*     */     
/*  95 */     this.t = new Thread(new Runnable()
/*     */         {
/*     */           
/*     */           public void run()
/*     */           {
/* 100 */             while (!Gameloop.this.GameoverPlayer() && !Gameloop.this.Gameoverai() && !Gameloop.this.interruptGameloop) {
/*     */               
/* 102 */               if (Gameloop.this.Gameoverai() || Gameloop.this.GameoverPlayer())
/*     */                 break; 
/* 104 */               game.gameConditions(Gameloop.this.pieces, true);
/*     */               
/* 106 */               game.sleepTime(Gameloop.this.fps);
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 113 */     this.AI = new Thread(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 117 */             map.addPiece(Gameloop.this.currPiece);
/* 118 */             game.getASP().addPiece(Gameloop.this.currPiece, map, game);
/*     */             
/* 120 */             while (!Gameloop.this.GameoverPlayer() && !Gameloop.this.Gameoverai() && !Gameloop.this.interruptGameloop) {
/* 121 */               game.getASP().updateMovement2(Gameloop.this.currPiece, map);
/* 122 */               game.getASP().updateAspCells(map);
/*     */               
/* 124 */               game.sleepTime(Gameloop.this.fps);
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 130 */     this.t1 = new Thread(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 134 */             map2.addPiece(Gameloop.this.currPiecePlayer);
/*     */             
/* 136 */             while (!Gameloop.this.GameoverPlayer() && !Gameloop.this.Gameoverai() && !Gameloop.this.interruptGameloop) {
/*     */               
/* 138 */               while (!player.wait && 
/* 139 */                 !Gameloop.this.Gameoverai() && !Gameloop.this.GameoverPlayer()) {
/*     */                 
/* 141 */                 player.gameConditions(Gameloop.this.piecesPlayer, true);
/*     */                 
/* 143 */                 player.sleepTime(Gameloop.this.playerfps);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 151 */     this.t2 = new Thread(new Runnable()
/*     */         {
/*     */           
/*     */           public void run()
/*     */           {
/* 156 */             while (!Gameloop.this.GameoverPlayer() && !Gameloop.this.Gameoverai() && !Gameloop.this.interruptGameloop) {
/*     */               
/* 158 */               Gameloop.this.allPiecesQueue.add(Integer.valueOf(Gameloop.this.chooseRandomPiece()));
/*     */               
/*     */               try {
/* 161 */                 Thread.sleep(100L);
/* 162 */               } catch (InterruptedException e) {
/*     */                 
/* 164 */                 e.printStackTrace();
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 169 */             if (Gameloop.this.GameoverPlayer() || Gameloop.this.Gameoverai()) {
/* 170 */               int n; Object[] options = { "PLAY AGAIN", "EXIT" };
/*     */ 
/*     */               
/* 173 */               if (player.getGamePanel().getScorePanel().getScorePlayer() > game.getGamePanel().getScorePanel().getScoreAI()) {
/* 174 */                 n = JOptionPane.showOptionDialog(f, "GAME OVER" + System.getProperty("line.separator") + "YOU WIN!!!", null, 1, 3, null, options, options[1]);
/*     */               } else {
/* 176 */                 n = JOptionPane.showOptionDialog(f, "GAME OVER" + System.getProperty("line.separator") + "YOU LOST...", null, 1, 3, null, options, options[1]);
/*     */               } 
/*     */               
/* 179 */               switch (n) {
/*     */                 case 0:
/* 181 */                   game.getGamePanel().getStartPanel().resetGame(1);
/* 182 */                   game.getGamePanel().getStartPanel().startVSCOMGame();
/* 183 */                   f.dispose();
/*     */                   return;
/*     */               } 
/* 186 */               f.dispose();
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     this.t2.start();
/* 196 */     this.t.start();
/* 197 */     this.AI.start();
/* 198 */     this.t1.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Gameloop(final GamePlayer player, final MapPlayer map2, GamePanel gp, final JFrame f) {
/* 206 */     this.player = player;
/*     */     
/* 208 */     this.map2 = map2;
/*     */     
/* 210 */     this.allPiecesQueue = new ArrayList<>();
/* 211 */     this.allPiecesQueue.add(Integer.valueOf(chooseRandomPiece()));
/*     */     
/* 213 */     this.piecesPlayer = new ArrayList<>();
/*     */     
/* 215 */     this.piecesPlayer.add(player.createPiecePlayer(((Integer)this.allPiecesQueue.get(0)).intValue()));
/*     */     
/* 217 */     this.currPiecePlayer = this.piecesPlayer.get(this.piecesPlayer.size() - 1);
/*     */ 
/*     */     
/* 220 */     this.playerfps = 400;
/* 221 */     this.levelfps = 400;
/*     */ 
/*     */     
/* 224 */     this.t1 = new Thread(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 228 */             map2.addPiece(Gameloop.this.currPiecePlayer);
/*     */             
/* 230 */             while (!Gameloop.this.GameoverPlayer() && !Gameloop.this.interruptGameloop) {
/* 231 */               while (!player.wait && 
/* 232 */                 !Gameloop.this.GameoverPlayer()) {
/*     */                 
/* 234 */                 player.gameConditions(Gameloop.this.piecesPlayer, true);
/*     */                 
/* 236 */                 player.sleepTime(Gameloop.this.playerfps);
/*     */               } 
/*     */             } 
/*     */             
/* 240 */             if (Gameloop.this.GameoverPlayer()) {
/* 241 */               Object[] options = { "PLAY AGAIN", "EXIT" };
/*     */               
/* 243 */               int n = JOptionPane.showOptionDialog(f, "GAME OVER" + System.getProperty("line.separator") + "TOTAL SCORE: " + player.getGamePanel().getSingleScorePanel().getScorePlayer(), null, 1, 3, null, options, options[1]);
/*     */               
/* 245 */               switch (n) {
/*     */                 case 0:
/* 247 */                   player.getGamePanel().getStartPanel().resetGame(0);
/* 248 */                   player.getGamePanel().getStartPanel().startSingleGame();
/* 249 */                   f.dispose();
/*     */                   return;
/*     */               } 
/* 252 */               f.dispose();
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 260 */     this.t2 = new Thread(new Runnable()
/*     */         {
/*     */           
/*     */           public void run()
/*     */           {
/* 265 */             while (!Gameloop.this.GameoverPlayer() && !Gameloop.this.interruptGameloop) {
/*     */               
/* 267 */               Gameloop.this.allPiecesQueue.add(Integer.valueOf(Gameloop.this.chooseRandomPiece()));
/*     */               
/*     */               try {
/* 270 */                 Thread.sleep(100L);
/* 271 */               } catch (InterruptedException e) {
/*     */                 
/* 273 */                 e.printStackTrace();
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 281 */     this.t2.start();
/* 282 */     this.t1.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Piece getCurrPiece() {
/* 289 */     return this.currPiece;
/*     */   }
/*     */   
/*     */   public synchronized List<Piece> getPieces() {
/* 293 */     return this.pieces;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized PiecePlayer getCurrPiecePlayer() {
/* 298 */     return this.currPiecePlayer;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void setSleepTime(int i) {
/* 303 */     this.fps = i;
/*     */   }
/*     */   
/*     */   public void setGameoverPlayer(boolean b) {
/* 307 */     this.gameoverplayer = b;
/*     */   }
/*     */   
/*     */   public void setGameoverai(boolean b) {
/* 311 */     this.gameoverai = b;
/*     */   }
/*     */   
/*     */   public boolean GameoverPlayer() {
/* 315 */     return this.gameoverplayer;
/*     */   }
/*     */   
/*     */   public boolean Gameoverai() {
/* 319 */     return this.gameoverai;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFPS() {
/* 324 */     return this.fps;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLevelFPS(int lfps) {
/* 329 */     this.levelfps = lfps;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPlayerFPS() {
/* 334 */     return this.levelfps;
/*     */   }
/*     */   
/*     */   public void setPlayerSleepTime(int i) {
/* 338 */     this.playerfps = i;
/*     */   }
/*     */   
/*     */   public void setCurrPiecePlayer(PiecePlayer piecePlayer) {
/* 342 */     this.currPiecePlayer = piecePlayer;
/*     */   }
/*     */   
/*     */   public void setCurrPiece(Piece piece) {
/* 346 */     this.currPiece = piece;
/*     */   }
/*     */   
/*     */   public Thread getThread(int i) {
/* 350 */     switch (i) {
/*     */       case 0:
/* 352 */         return this.t;
/*     */       case 1:
/* 354 */         return this.t1;
/*     */     } 
/* 356 */     return this.t2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int chooseRandomPiece() {
/* 361 */     Random random = new Random();
/* 362 */     int min = 1;
/* 363 */     int max = 7;
/* 364 */     int c = max - min + 1;
/* 365 */     int rand = random.nextInt(c) + min;
/*     */     
/* 367 */     return rand;
/*     */   }
/*     */   
/*     */   public void interruptGameloop() {
/* 371 */     this.interruptGameloop = true;
/*     */   }
/*     */   
/*     */   public void resetLists() {
/* 375 */     this.pieces = null;
/*     */     
/* 377 */     this.allPiecesQueue = null;
/*     */     
/* 379 */     this.piecesPlayer = null;
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/Game/Gameloop.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */