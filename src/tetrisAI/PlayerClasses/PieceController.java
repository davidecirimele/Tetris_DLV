 package tetrisAI.PlayerClasses;
 
 import java.awt.event.KeyEvent;
 import java.awt.event.KeyListener;
 
 
 
 
 public class PieceController
   implements KeyListener
 {
   private MapPlayer map;
   private PiecePlayer piece;
   private GamePlayer game;
   
   public PieceController(MapPlayer map, GamePlayer game2) {
     this.map = map;
     this.game = game2;
   }
   
   public void updatePiece(PiecePlayer currPiece) {
     this.piece = currPiece;
   }
 
 
 
   
   public void keyTyped(KeyEvent e) {}
 
 
   
   public void keyPressed(KeyEvent e) {
     if (this.piece.isMoving()) {
       switch (e.getKeyCode()) {
         
         case 37:
           System.out.println(this.piece.canMoveLeft(this.map));
           if (this.piece.canMoveLeft(this.map))
           {
             for (int i = 0; i < 4; i++) {
               this.piece.getPiece()[i].setColumn(this.piece.getPiece()[i].getColumn() - 1);
             }
           }
           break;
 
         
         case 39:
           System.out.println(this.piece.canMoveRight(this.map));
           if (this.piece.canMoveRight(this.map))
           {
             for (int i = 0; i < 4; i++) {
               this.piece.getPiece()[i].setColumn(this.piece.getPiece()[i].getColumn() + 1);
             }
           }
           break;
 
         
         case 40:
           this.game.getLoop().setPlayerSleepTime(50);
           break;
         
         case 38:
           if ((!this.piece.canMoveLeft(this.map) && !this.piece.canMoveRight(this.map)) || this.piece.getPiece()[0].getRow() < 1)
             break; 
           this.piece.Rotate(this.map);
           break;
       } 
     }
   }
 
 
   
   public void keyReleased(KeyEvent e) {
     switch (e.getKeyCode()) {
       case 40:
         if ((this.game.getGamePanel()).gamemode == 1) {
           this.game.getLoop().setPlayerSleepTime(this.game.getLoop().getPlayerFPS()); break;
         } 
         this.game.getLoop().setPlayerSleepTime(200);
         break;
     } 
   }
 }
