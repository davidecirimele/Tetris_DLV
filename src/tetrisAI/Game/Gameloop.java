package tetrisAI.Game;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tetrisAI.AIClasses.Game;
import tetrisAI.AIClasses.Map;
import tetrisAI.AIClasses.Piece;
import tetrisAI.PlayerClasses.GamePlayer;
import tetrisAI.PlayerClasses.MapPlayer;
import tetrisAI.PlayerClasses.PiecePlayer;
import tetrisAI.View.GamePanel;

public class Gameloop
{
  private Game game;
  private Map map;
  private Piece currPiece;
  private GamePlayer player;
  private MapPlayer map2;
  private List<Piece> pieces;
  private PiecePlayer currPiecePlayer;
  private List<PiecePlayer> piecesPlayer;
  public List<Integer> allPiecesQueue;
  private Thread t;
  private Thread t1;
  private Thread t2;
  private Thread AI;
  private int fps;
  private int playerfps;
  private int levelfps;
  private boolean gameoverai;
  private boolean gameoverplayer;
  private boolean interruptGameloop;
  
  public Gameloop(final Game game, final GamePlayer player, final Map map, final MapPlayer map2, GamePanel gp, final JFrame f) {
     this.game = game;
    
     this.player = player;
    
     this.map = map;
    
     this.map2 = map2;
    
     this.pieces = new ArrayList<>();
    
     this.allPiecesQueue = new ArrayList<>();
     this.allPiecesQueue.add(Integer.valueOf(chooseRandomPiece()));
    
     this.pieces.add(game.createPiece(((Integer)this.allPiecesQueue.get(0)).intValue()));
    
     this.currPiece = this.pieces.get(this.pieces.size() - 1);
    
     this.piecesPlayer = new ArrayList<>();
    
     this.piecesPlayer.add(player.createPiecePlayer(((Integer)this.allPiecesQueue.get(0)).intValue()));

    
     this.currPiecePlayer = this.piecesPlayer.get(this.piecesPlayer.size() - 1);


    
     this.fps = 200;
     this.playerfps = this.fps;
    
     this.interruptGameloop = false;
    
     this.t = new Thread(new Runnable()
        {
          
          public void run()
          {
             while (!Gameloop.this.GameoverPlayer() && !Gameloop.this.Gameoverai() && !Gameloop.this.interruptGameloop) {
              
               if (Gameloop.this.Gameoverai() || Gameloop.this.GameoverPlayer())
                break; 
               game.gameConditions(Gameloop.this.pieces, true);
              
               game.sleepTime(Gameloop.this.fps);
            } 
          }
        });


    
     this.AI = new Thread(new Runnable()
        {
          public void run()
          {
             map.addPiece(Gameloop.this.currPiece);
             game.getASP().addPiece(Gameloop.this.currPiece, map, game);
            
             while (!Gameloop.this.GameoverPlayer() && !Gameloop.this.Gameoverai() && !Gameloop.this.interruptGameloop) {
               game.getASP().updateMovement2(Gameloop.this.currPiece, map);
               game.getASP().updateAspCells(map);
              
               game.sleepTime(Gameloop.this.fps);
            } 
          }
        });

    
     this.t1 = new Thread(new Runnable()
        {
          public void run()
          {
             map2.addPiece(Gameloop.this.currPiecePlayer);
            
             while (!Gameloop.this.GameoverPlayer() && !Gameloop.this.Gameoverai() && !Gameloop.this.interruptGameloop) {
              
               while (!player.wait && 
                 !Gameloop.this.Gameoverai() && !Gameloop.this.GameoverPlayer()) {
                
                 player.gameConditions(Gameloop.this.piecesPlayer, true);
                
                 player.sleepTime(Gameloop.this.playerfps);
              } 
            } 
          }
        });


    
     this.t2 = new Thread(new Runnable()
        {
          
          public void run()
          {
             while (!Gameloop.this.GameoverPlayer() && !Gameloop.this.Gameoverai() && !Gameloop.this.interruptGameloop) {
              
               Gameloop.this.allPiecesQueue.add(Integer.valueOf(Gameloop.this.chooseRandomPiece()));
              
              try {
                 Thread.sleep(100L);
               } catch (InterruptedException e) {
                
                 e.printStackTrace();
              } 
            } 

            
             if (Gameloop.this.GameoverPlayer() || Gameloop.this.Gameoverai()) {
               int n; Object[] options = { "PLAY AGAIN", "EXIT" };

              
               if (player.getGamePanel().getScorePanel().getScorePlayer() > game.getGamePanel().getScorePanel().getScoreAI()) {
                 n = JOptionPane.showOptionDialog(f, "GAME OVER" + System.getProperty("line.separator") + "YOU WIN!!!", null, 1, 3, null, options, options[1]);
              } else {
                 n = JOptionPane.showOptionDialog(f, "GAME OVER" + System.getProperty("line.separator") + "YOU LOST...", null, 1, 3, null, options, options[1]);
              } 
              
               switch (n) {
                case 0:
                   game.getGamePanel().getStartPanel().resetGame(1);
                   game.getGamePanel().getStartPanel().startVSCOMGame();
                   f.dispose();
                  return;
              } 
               f.dispose();
            } 
          }
        });




    
     this.t2.start();
     this.t.start();
     this.AI.start();
     this.t1.start();
  }




  
  public Gameloop(final GamePlayer player, final MapPlayer map2, GamePanel gp, final JFrame f) {
     this.player = player;
    
     this.map2 = map2;
    
     this.allPiecesQueue = new ArrayList<>();
     this.allPiecesQueue.add(Integer.valueOf(chooseRandomPiece()));
    
     this.piecesPlayer = new ArrayList<>();
    
     this.piecesPlayer.add(player.createPiecePlayer(((Integer)this.allPiecesQueue.get(0)).intValue()));
    
     this.currPiecePlayer = this.piecesPlayer.get(this.piecesPlayer.size() - 1);

    
     this.playerfps = 400;
     this.levelfps = 400;

    
     this.t1 = new Thread(new Runnable()
        {
          public void run()
          {
             map2.addPiece(Gameloop.this.currPiecePlayer);
            
             while (!Gameloop.this.GameoverPlayer() && !Gameloop.this.interruptGameloop) {
               while (!player.wait && 
                 !Gameloop.this.GameoverPlayer()) {
                
                 player.gameConditions(Gameloop.this.piecesPlayer, true);
                
                 player.sleepTime(Gameloop.this.playerfps);
              } 
            } 
            
             if (Gameloop.this.GameoverPlayer()) {
               Object[] options = { "PLAY AGAIN", "EXIT" };
              
               int n = JOptionPane.showOptionDialog(f, "GAME OVER" + System.getProperty("line.separator") + "TOTAL SCORE: " + player.getGamePanel().getSingleScorePanel().getScorePlayer(), null, 1, 3, null, options, options[1]);
              
               switch (n) {
                case 0:
                   player.getGamePanel().getStartPanel().resetGame(0);
                   player.getGamePanel().getStartPanel().startSingleGame();
                   f.dispose();
                  return;
              } 
               f.dispose();
            } 
          }
        });



    
     this.t2 = new Thread(new Runnable()
        {
          
          public void run()
          {
             while (!Gameloop.this.GameoverPlayer() && !Gameloop.this.interruptGameloop) {
              
               Gameloop.this.allPiecesQueue.add(Integer.valueOf(Gameloop.this.chooseRandomPiece()));
              
              try {
                 Thread.sleep(100L);
               } catch (InterruptedException e) {
                
                 e.printStackTrace();
              } 
            } 
          }
        });


    
     this.t2.start();
     this.t1.start();
  }



  
  public synchronized Piece getCurrPiece() {
     return this.currPiece;
  }
  
  public synchronized List<Piece> getPieces() {
     return this.pieces;
  }

  
  public synchronized PiecePlayer getCurrPiecePlayer() {
     return this.currPiecePlayer;
  }

  
  public synchronized void setSleepTime(int i) {
     this.fps = i;
  }
  
  public void setGameoverPlayer(boolean b) {
     this.gameoverplayer = b;
  }
  
  public void setGameoverai(boolean b) {
     this.gameoverai = b;
  }
  
  public boolean GameoverPlayer() {
     return this.gameoverplayer;
  }
  
  public boolean Gameoverai() {
     return this.gameoverai;
  }

  
  public int getFPS() {
     return this.fps;
  }

  
  public void setLevelFPS(int lfps) {
     this.levelfps = lfps;
  }

  
  public int getPlayerFPS() {
     return this.levelfps;
  }
  
  public void setPlayerSleepTime(int i) {
     this.playerfps = i;
  }
  
  public void setCurrPiecePlayer(PiecePlayer piecePlayer) {
     this.currPiecePlayer = piecePlayer;
  }
  
  public void setCurrPiece(Piece piece) {
     this.currPiece = piece;
  }
  
  public Thread getThread(int i) {
     switch (i) {
      case 0:
         return this.t;
      case 1:
         return this.t1;
    } 
     return this.t2;
  }

  
  public int chooseRandomPiece() {
     Random random = new Random();
     int min = 1;
     int max = 7;
     int c = max - min + 1;
     int rand = random.nextInt(c) + min;
    
     return rand;
  }
  
  public void interruptGameloop() {
     this.interruptGameloop = true;
  }
  
  public void resetLists() {
     this.pieces = null;
    
     this.allPiecesQueue = null;
    
     this.piecesPlayer = null;
  }
}


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/Game/Gameloop.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */