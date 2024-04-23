 package tetrisAI.PlayerClasses;
 
 import java.util.ArrayList;
 import java.util.List;
 import tetrisAI.Game.Gameloop;
 import tetrisAI.PlayerBlocks.iBlockPlayer;
 import tetrisAI.PlayerBlocks.jBlockPlayer;
 import tetrisAI.PlayerBlocks.lBlockPlayer;
 import tetrisAI.PlayerBlocks.oBlockPlayer;
 import tetrisAI.PlayerBlocks.sBlockPlayer;
 import tetrisAI.PlayerBlocks.tBlockPlayer;
 import tetrisAI.PlayerBlocks.zBlockPlayer;
 import tetrisAI.View.GamePanel;
 
 
 public class GamePlayer
   implements Runnable
 {
   private MapPlayer map;
   private int id = 0;
   private EmptyBlockPlayer eb;
   private PiecePlayer piece;
   private int indexNP = 0;
   private int numRowsAdded = 0;
   
   private boolean interrupt;
   private Gameloop loop;
   private GamePanel gp;
   private List<Integer> linesfull;
   public boolean wait;
   public boolean waitup;
   
   public GamePlayer() {
     this.eb = new EmptyBlockPlayer(0, 0, 0);
     this.map = new MapPlayer(this);
     
     this.interrupt = false;
     this.linesfull = new ArrayList<>();
     
     this.wait = false;
     this.waitup = false;
   }
 
   
   public synchronized void checkDeleteCondition() {
     if (!this.loop.getCurrPiecePlayer().isMoving()) {
       
       checkLinesFull();
       
       if (this.linesfull != null && !this.linesfull.isEmpty()) {
         lowMatrix();
       }
     } 
   }
 
   
   private synchronized void upMatrix(int n) {
     this.waitup = true;
     if (n == 0) {
       return;
     }
     int ix = 0;
 
     
     while (ix < n) {
       for (int j = 1; j < (this.map.getMatrix()).length; j++) {
         for (int k = 0; k < (this.map.getMatrix()[j]).length; k++) {
           if (this.map.getSuppMatrix()[j][k].getValue() <= 0) {
 
 
             
             CellPlayer temp = this.map.getSuppMatrix()[j][k];
             temp.setRow(this.map.getSuppMatrix()[j][k].getRow() - 1);
             
             this.eb.setRow(j);
             this.eb.setColumn(k);
             this.map.getSuppMatrix()[j][k] = this.eb;
             this.map.getSuppMatrix()[j - 1][k] = temp;
           } 
         } 
       }  Copy(this.map.getMatrix(), this.map.getSuppMatrix());
       clearSuppMatrix();
       ix++;
     } 
     
     for (int i = (this.map.getMatrix()).length - n; i < (this.map.getMatrix()).length; i++) {
       for (int j = 0; j < (this.map.getMatrix()[i]).length; j++)
         this.map.getSuppMatrix()[i][j] = new CellPlayer(i, j, -9); 
     }  this.waitup = false;
   }
   
   public synchronized void checkLinesFull() {
     if (this.linesfull != null) {
       this.linesfull.clear();
     }
 
     
     for (int i = 0; i < (this.map.getMatrix()).length; i++) {
       boolean full = true;
       for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
         
         if (this.map.getMatrix()[i][j].getValue() == 0 || this.map.getMatrix()[i][j].getValue() == -9) {
           full = false;
         }
       } 
       if (full) {
         
         if (!this.linesfull.contains(Integer.valueOf(i))) {
           this.linesfull.add(Integer.valueOf(i));
         }
         
         if (this.gp.gamemode == 1) {
           if (this.gp.getSingleScorePanel().getScorePlayer() >= this.gp.getSingleScorePanel().getPrecScore() + this.gp.getSingleScorePanel().getIncreasePoints() * 5) {
             this.gp.getSingleScorePanel().increaseLevel();
             this.gp.getSingleScorePanel().updatePrecScore();
             this.gp.getSingleScorePanel().updateIncreasePoints();
             if (this.loop.getPlayerFPS() > 100) {
               this.loop.setPlayerSleepTime(this.loop.getPlayerFPS() - 20);
               this.loop.setLevelFPS(this.loop.getPlayerFPS() - 20);
             }
             else if (this.loop.getPlayerFPS() <= 100 && this.loop.getPlayerFPS() > 25) {
               this.loop.setPlayerSleepTime(this.loop.getPlayerFPS() - 10);
               this.loop.setLevelFPS(this.loop.getPlayerFPS() - 10);
             } 
           } 
           this.gp.getSingleScorePanel().setScorePlayer(this.gp.getSingleScorePanel().getScorePlayer() + this.gp.getSingleScorePanel().getIncreasePoints());
         }
         else if (this.gp.gamemode == 0) {
           this.gp.getScorePanel().setScorePlayer(this.gp.getScorePanel().getScorePlayer() + 10);
         } 
       } 
     } 
   }
 
   
   private synchronized void lowMatrix() {
     this.wait = true;
     while (this.waitup) {
       if (this.interrupt)
         return; 
       System.out.println("WAITING");
     } 
 
     
     Copy(this.map.getMatrix(), this.map.getSuppMatrix());
     clearSuppMatrix();
     
     checkLinesFull();
     
     this.numRowsAdded = this.linesfull.size();
     if (!this.loop.Gameoverai() && this.gp.gamemode == 0) {
       this.gp.getAI().addRows();
     }
     this.loop.setCurrPiecePlayer(null);
     
     for (int k = 0; k < this.linesfull.size(); k++) {
       int nk = 0;
       for (int i = 1; i < (this.map.getSuppMatrix()).length; i++) {
         for (int j = 0; j < (this.map.getSuppMatrix()[i]).length; j++) {
           if (i == 1) {
             this.eb.setRow(0);
             this.eb.setColumn(j);
             this.map.getSuppMatrix()[0][j] = this.eb;
           } 
           
           if (nk < (this.map.getMatrix()).length)
             this.map.getSuppMatrix()[i][j] = this.map.getMatrix()[nk][j]; 
           if (i == ((Integer)this.linesfull.get(k)).intValue() && j == (this.map.getSuppMatrix()[i]).length - 1 && ((Integer)this.linesfull.get(k)).intValue() != (this.map.getMatrix()).length - 1)
             nk++; 
         } 
         nk++;
       } 
       Copy(this.map.getMatrix(), this.map.getSuppMatrix());
       clearSuppMatrix();
     } 
     
     this.wait = false;
   }
   
   public int getRowsToAdd() {
     return this.numRowsAdded;
   }
   
   public void resetRowsToAdd() {
     this.numRowsAdded = 0;
   }
 
 
   
   public synchronized void clearSuppMatrix() {
     for (int i = 0; i < (this.map.getMatrix()).length; i++) {
       for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
         
         if (this.map.getSuppMatrix()[i][j].getValue() > 0) {
           this.eb.setRow(i);
           this.eb.setColumn(j);
           this.map.getSuppMatrix()[i][j] = this.eb;
         } 
       } 
     } 
   }
 
   
   public synchronized void Copy(CellPlayer[][] matrix, CellPlayer[][] suppMatrix) {
     for (int i = 0; i < matrix.length; i++) {
       for (int j = 0; j < (matrix[i]).length; j++) {
         matrix[i][j] = suppMatrix[i][j];
       }
     } 
   }
 
 
   
   public boolean checkScrollCondition(MapPlayer map2, PiecePlayer currPiecePlayer) {
     for (int i = 0; i < 4; i++) {
       int diff = 0;
       if (this.gp.getAI() != null)
         diff = this.gp.getAI().getRowsToAdd(); 
       if (currPiecePlayer.getPiece()[i].getRow() < (this.map.getMatrix()).length - 1 - diff) {
         
         if (map2.getMatrix()[currPiecePlayer.getPiece()[i].getRow() + 1][currPiecePlayer.getPiece()[i].getColumn()].getId() != currPiecePlayer.getId() && map2.getMatrix()[currPiecePlayer.getPiece()[i].getRow() + 1][currPiecePlayer.getPiece()[i].getColumn()].getValue() != 0) {
           //this.gp.startLandingAnimation();
                    sleepTime(150);
                    return false;
         }
 } else {
                    //this.gp.startLandingAnimation();
                    sleepTime(150);
                      
                    return false;
       } 
     } 
 
     
     return true;
   }
 
   
   public void gameConditions(List<PiecePlayer> pieces, boolean updatable) {
     if (this.loop != null) {
       if (this.loop.getCurrPiecePlayer() == null || !this.loop.getCurrPiecePlayer().isMoving()) {
         
         checkDeleteCondition();
         
         this.indexNP++;
         pieces.add(createPiecePlayer(((Integer)this.loop.allPiecesQueue.get(this.indexNP)).intValue()));
         
         this.gp.fillNextPieces(1, this.indexNP);
 
         
         this.loop.setCurrPiecePlayer(pieces.get(pieces.size() - 1));
         
         this.map.getController().updatePiece(this.loop.getCurrPiecePlayer());
       } 
 
       
       updatable = true;
 
       
       for (int i = 0; i < (this.map.getMatrix()).length; i++) {
 
         
         for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
           
           if (this.map.getMatrix()[i][j].getValue() > 0)
           {
             if (checkScrollCondition(this.map, this.loop.getCurrPiecePlayer())) {
               
               if (updatable) {
                 for (int k = 0; k < 4; k++) {
                   
                   this.loop.getCurrPiecePlayer().getPiece()[k].setRow(this.loop.getCurrPiecePlayer().getPiece()[k].getRow() + 1);
                   this.map.getSuppMatrix()[this.loop.getCurrPiecePlayer().getPiece()[k].getRow()][this.loop.getCurrPiecePlayer().getPiece()[k].getColumn()] = this.loop.getCurrPiecePlayer().getPiece()[k];
                 } 
 
                 
                 updatable = false;
               
               }
             
             }
             else if (!checkScrollCondition(this.map, this.loop.getCurrPiecePlayer()) && this.loop.getCurrPiecePlayer().getPiece()[0].getRow() < 1) {
               if (this.gp.gamemode == 0)
                 this.gp.getScorePanel().setScorePlayer(0); 
               this.loop.setGameoverPlayer(true);
             
             }
             else {
               
               sleepTime(100);
               
               if (!checkScrollCondition(this.map, this.loop.getCurrPiecePlayer())) {
 
                 
                 this.loop.getCurrPiecePlayer().setMoving(false);
                 
                 for (int k = 0; k < 4; k++) {
                   this.loop.getCurrPiecePlayer().getPiece()[k].setValue(this.loop.getCurrPiecePlayer().getPiece()[k].getValue() * -1);
                 }
               } 
             } 
           }
         } 
       } 
     } 
   }
 
 
 
 
 
 
 
 
 
   
   public PiecePlayer createPiecePlayer(int n) {
     this.piece = null;
     
     switch (n) {
       case 1:
         this.piece = (PiecePlayer)new iBlockPlayer();
         addPiecePlayer(this.piece);
         this.piece.setMoving(true);
         break;
       
       case 2:
         this.piece = (PiecePlayer)new jBlockPlayer();
         addPiecePlayer(this.piece);
         this.piece.setMoving(true);
         break;
       
       case 3:
         this.piece = (PiecePlayer)new lBlockPlayer();
         addPiecePlayer(this.piece);
         this.piece.setMoving(true);
         break;
       
       case 4:
         this.piece = (PiecePlayer)new oBlockPlayer();
         addPiecePlayer(this.piece);
         this.piece.setMoving(true);
         break;
       
       case 5:
         this.piece = (PiecePlayer)new sBlockPlayer();
         addPiecePlayer(this.piece);
         this.piece.setMoving(true);
         break;
       
       case 6:
         this.piece = (PiecePlayer)new tBlockPlayer();
         addPiecePlayer(this.piece);
         this.piece.setMoving(true);
         break;
       
       case 7:
         this.piece = (PiecePlayer)new zBlockPlayer();
         addPiecePlayer(this.piece);
         this.piece.setMoving(true);
         break;
     } 
 
 
     
     this.piece.setId(this.id);
     
     for (int k = 0; k < 4; k++) {
       this.piece.getPiece()[k].setId(this.id);
     }
     this.id++;
 
     
     return this.piece;
   }
 
 
   
   public void addPiecePlayer(PiecePlayer piece2) {
     if (piece2 != null)
       for (int i = 0; i < 4; i++) {
         this.map.getSuppMatrix()[piece2.getPiece()[i].getRow()][piece2.getPiece()[i].getColumn()] = piece2.getPiece()[i];
       } 
   }
   
   public boolean SuppMatrixIsEmpty() {
     for (int i = 0; i < (this.map.getMatrix()).length; i++) {
       for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
         if (this.map.getSuppMatrix()[i][j].getValue() != 0)
           return false; 
       } 
     } 
     return true;
   }
 
 
   
   public void run() {
     while (!this.interrupt) {
       while (!this.wait && 
         !this.interrupt) {
         
         if (this.loop != null && 
           this.loop.getCurrPiecePlayer() != null && this.map.getSuppMatrix() != null) {
           Copy(this.map.getMatrix(), this.map.getSuppMatrix());
           clearSuppMatrix();
           addPiecePlayer(this.loop.getCurrPiecePlayer());
         } 
 
         
         this.map.update();
         if (this.gp != null)
           if (this.gp.gamemode == 0) {
             this.gp.getScorePanel().repaint();
           } else {
             this.gp.getSingleScorePanel().repaint();
           }   sleepTime(10);
       } 
     } 
   }
   
   public void sleepTime(long i) {
     try {
       Thread.sleep(i);
     } catch (InterruptedException e) {
       
       e.printStackTrace();
     } 
   }
   
   public MapPlayer getMapPlayer() {
     return this.map;
   }
   
   public Gameloop getLoop() {
     return this.loop;
   }
   
   public GamePanel getGamePanel() {
     return this.gp;
   }
   
   public void interruptThread() {
     this.linesfull = null;
     this.interrupt = true;
   }
   
   public void addRows() {
     upMatrix(this.gp.getAI().getRowsToAdd());
     
     this.gp.getAI().resetRowsToAdd();
   }
   
   public void setLoop(Gameloop loop, GamePanel gp) {
     this.loop = loop;
     this.gp = gp;
   }
 }
