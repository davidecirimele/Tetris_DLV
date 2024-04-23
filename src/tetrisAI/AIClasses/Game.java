 package tetrisAI.AIClasses;
 
 import java.util.ArrayList;
 import java.util.List;
 import tetrisAI.AIBlocks.iBlock;
 import tetrisAI.AIBlocks.jBlock;
 import tetrisAI.AIBlocks.lBlock;
 import tetrisAI.AIBlocks.oBlock;
 import tetrisAI.AIBlocks.sBlock;
 import tetrisAI.AIBlocks.tBlock;
 import tetrisAI.AIBlocks.zBlock;
 import tetrisAI.Game.Gameloop;
 import tetrisAI.View.GamePanel;
 
 
 
 
 public class Game
   implements Runnable
 {
   private Map map;
   private int id = 0;
   private EmptyBlock eb;
   private Piece piece;
   private int indexNP = 0;
   private Thread t;
   private int numRowsAdded = 0;
   
   private boolean interrupt;
   
   private Gameloop loop;
   private GamePanel gp;
   private List<Integer> linesfull;
   public boolean wait;
   private ASPSolver asp;
   private boolean waitup;
   
   public Game() {
     this.eb = new EmptyBlock(0, 0, 0);
     this.map = new Map(this);
     
     this.asp = new ASPSolver();
     this.interrupt = false;
     
     this.linesfull = new ArrayList<>();
     
     this.wait = false;
   }
 
   
   public synchronized void checkDeleteCondition() {
     if (!this.loop.getCurrPiece().isMoving()) {
       
       checkLinesFull();
       
       if (this.linesfull != null && !this.linesfull.isEmpty()) {
         lowMatrix();
       }
     } 
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
 
 
         
         this.gp.getScorePanel().setScoreAI(this.gp.getScorePanel().getScoreAI() + 10);
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
     if (!this.loop.GameoverPlayer()) {
       this.gp.getPlayer().addRows();
     }
     this.loop.setCurrPiece(null);
 
 
     
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
 
             
             Cell temp = this.map.getSuppMatrix()[j][k];
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
         this.map.getSuppMatrix()[i][j] = new Cell(i, j, -9); 
     }  this.waitup = false;
   }
 
 
 
   
   public synchronized void clearSuppMatrix() {
     if (!SuppMatrixIsEmpty()) {
       for (int i = 0; i < (this.map.getMatrix()).length; i++) {
         for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
           if (this.map.getSuppMatrix() != null && 
             this.map.getSuppMatrix()[i][j].getValue() > 0) {
             this.eb.setRow(i);
             this.eb.setColumn(j);
             this.map.getSuppMatrix()[i][j] = this.eb;
           } 
         } 
       } 
     }
   }
   
   public synchronized void Copy(Cell[][] matrix, Cell[][] suppMatrix) {
     for (int i = 0; i < matrix.length; i++) {
       for (int j = 0; j < (matrix[i]).length; j++) {
         matrix[i][j] = suppMatrix[i][j];
       }
     } 
   }
 
 
   
   public boolean checkScrollCondition(Map map, Piece currPiece) {
     for (int i = 0; i < 4; i++) {
       
       if (currPiece.getPiece()[i].getRow() < (map.getMatrix()).length - 1 - this.gp.getPlayer().getRowsToAdd()) {
         
         if (map.getMatrix()[currPiece.getPiece()[i].getRow() + 1][currPiece.getPiece()[i].getColumn()].getId() != currPiece.getId() && map.getMatrix()[currPiece.getPiece()[i].getRow() + 1][currPiece.getPiece()[i].getColumn()].getValue() != 0) {
           return false;
         }
       } else {
         
         return false;
       } 
     } 
 
     
     return true;
   }
 
 
 
 
 
   
   public Piece createPiece(int n) {
     this.piece = null;
     
     switch (n) {
       case 1:
         this.piece = (Piece)new iBlock();
         addPiece(this.piece);
         ((iBlock)this.piece).setMoving(true);
         break;
       
       case 2:
         this.piece = (Piece)new jBlock();
         addPiece(this.piece);
         ((jBlock)this.piece).setMoving(true);
         break;
       
       case 3:
         this.piece = (Piece)new lBlock();
         addPiece(this.piece);
         ((lBlock)this.piece).setMoving(true);
         break;
       
       case 4:
         this.piece = (Piece)new oBlock();
         addPiece(this.piece);
         ((oBlock)this.piece).setMoving(true);
         break;
       
       case 5:
         this.piece = (Piece)new sBlock();
         addPiece(this.piece);
         ((sBlock)this.piece).setMoving(true);
         break;
       
       case 6:
         this.piece = (Piece)new tBlock();
         addPiece(this.piece);
         ((tBlock)this.piece).setMoving(true);
         break;
       
       case 7:
         this.piece = (Piece)new zBlock();
         addPiece(this.piece);
         ((zBlock)this.piece).setMoving(true);
         break;
     } 
 
 
     
     this.piece.setId(this.id);
     
     for (int k = 0; k < 4; k++) {
       this.piece.getPiece()[k].setId(this.id);
     }
     this.id++;
     
     return this.piece;
   }
 
 
   
   public void addPiece(Piece piece) {
     if (piece != null)
       for (int i = 0; i < 4; i++)
         this.map.getSuppMatrix()[piece.getPiece()[i].getRow()][piece.getPiece()[i].getColumn()] = piece.getPiece()[i];  
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
   
   public void gameConditions(List<Piece> pieces, boolean updatable) {
     if (this.loop != null) {
       if (this.wait) {
         this.indexNP++;
         pieces.add(createPiece(((Integer)this.loop.allPiecesQueue.get(this.indexNP)).intValue()));
         
         this.gp.fillNextPieces(0, this.indexNP);
         
         this.loop.setCurrPiece(pieces.get(pieces.size() - 1));
         
         this.asp.addPiece(this.loop.getCurrPiece(), this.map, this);
 
         
         this.asp.updateAspCells(this.map);
       } else {
         
         if (!this.loop.getCurrPiece().isMoving()) {
           checkDeleteCondition();
           this.indexNP++;
           pieces.add(createPiece(((Integer)this.loop.allPiecesQueue.get(this.indexNP)).intValue()));
           
           this.gp.fillNextPieces(0, this.indexNP);
           
           this.loop.setCurrPiece(pieces.get(pieces.size() - 1));
           
           this.asp.addPiece(this.loop.getCurrPiece(), this.map, this);
 
           
           this.asp.updateAspCells(this.map);
         } 
         
         updatable = true;
         
         for (int i = 0; i < (this.map.getMatrix()).length; i++) {
 
           
           for (int j = 0; j < (this.map.getMatrix()[i]).length; j++) {
             
             if (this.map.getMatrix()[i][j].getValue() > 0)
             {
               
               if (checkScrollCondition(this.map, this.loop.getCurrPiece())) {
                 
                 if (updatable) {
                   for (int k = 0; k < 4; k++) {
                     this.loop.getCurrPiece().getPiece()[k].setRow(this.loop.getCurrPiece().getPiece()[k].getRow() + 1);
                     this.map.getSuppMatrix()[this.loop.getCurrPiece().getPiece()[k].getRow()][this.loop.getCurrPiece().getPiece()[k].getColumn()] = this.loop.getCurrPiece().getPiece()[k];
                   } 
 
                   
                   updatable = false;
                 
                 }
               
               }
               else if (!checkScrollCondition(this.map, this.loop.getCurrPiece()) && this.loop.getCurrPiece().getPiece()[0].getRow() < 1) {
                 this.gp.getScorePanel().setScoreAI(0);
                 this.loop.setGameoverai(true);
               }
               else {
                 
                 sleepTime(100);
                 
                 if (!checkScrollCondition(this.map, this.loop.getCurrPiece())) {
 
                   
                   this.loop.getCurrPiece().setMoving(false);
                   
                   for (int k = 0; k < 4; k++) {
                     this.loop.getCurrPiece().getPiece()[k].setValue(this.loop.getCurrPiece().getPiece()[k].getValue() * -1);
                   }
                 } 
               } 
             }
           } 
         } 
       } 
     }
   }
 
 
 
 
 
 
 
 
 
 
   
   public void run() {
     while (!this.interrupt) {
       while (!this.wait && 
         !this.interrupt) {
         
         if (this.loop != null && 
           this.loop.getCurrPiece() != null && this.map.getSuppMatrix() != null) {
           
           Copy(this.map.getMatrix(), this.map.getSuppMatrix());
           clearSuppMatrix();
           addPiece(this.loop.getCurrPiece());
         } 
 
         
         this.map.update();
         if (this.gp != null) {
           this.gp.getScorePanel().repaint();
         }
         sleepTime(10);
       } 
     } 
   }
   
   public void sleepTime(int i) {
     try {
       Thread.sleep(i);
     } catch (InterruptedException e) {
       
       e.printStackTrace();
     } 
   }
   
   public Map getMap() {
     return this.map;
   }
 
   
   public void addRows() {
     upMatrix(this.gp.getPlayer().getRowsToAdd());
     
     this.gp.getPlayer().resetRowsToAdd();
   }
   
   public void setThread(Thread t1) {
     this.t = t1;
   }
   public Thread getThread() {
     return this.t;
   }
 
   
   public int getRowsToAdd() {
     return this.numRowsAdded;
   }
   
   public void resetRowsToAdd() {
     this.numRowsAdded = 0;
   }
   
   public void interruptThread() {
     this.linesfull = null;
     this.interrupt = true;
   }
   
   public Gameloop getLoop() {
     return this.loop;
   }
   
   public ASPSolver getASP() {
     return this.asp;
   }
   
   public void setLoop(Gameloop loop, GamePanel gp) {
     this.loop = loop;
     this.gp = gp;
   }
   
   public void deleteASP() {
     this.asp = null;
   }
   
   public GamePanel getGamePanel() {
     return this.gp;
   }
 }
