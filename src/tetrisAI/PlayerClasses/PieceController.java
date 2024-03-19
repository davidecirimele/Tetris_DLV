/*    */ package tetrisAI.PlayerClasses;
/*    */ 
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PieceController
/*    */   implements KeyListener
/*    */ {
/*    */   private MapPlayer map;
/*    */   private PiecePlayer piece;
/*    */   private GamePlayer game;
/*    */   
/*    */   public PieceController(MapPlayer map, GamePlayer game2) {
/* 17 */     this.map = map;
/* 18 */     this.game = game2;
/*    */   }
/*    */   
/*    */   public void updatePiece(PiecePlayer currPiece) {
/* 22 */     this.piece = currPiece;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void keyPressed(KeyEvent e) {
/* 33 */     if (this.piece.isMoving()) {
/* 34 */       switch (e.getKeyCode()) {
/*    */         
/*    */         case 37:
/* 37 */           System.out.println(this.piece.canMoveLeft(this.map));
/* 38 */           if (this.piece.canMoveLeft(this.map))
/*    */           {
/* 40 */             for (int i = 0; i < 4; i++) {
/* 41 */               this.piece.getPiece()[i].setColumn(this.piece.getPiece()[i].getColumn() - 1);
/*    */             }
/*    */           }
/*    */           break;
/*    */ 
/*    */         
/*    */         case 39:
/* 48 */           System.out.println(this.piece.canMoveRight(this.map));
/* 49 */           if (this.piece.canMoveRight(this.map))
/*    */           {
/* 51 */             for (int i = 0; i < 4; i++) {
/* 52 */               this.piece.getPiece()[i].setColumn(this.piece.getPiece()[i].getColumn() + 1);
/*    */             }
/*    */           }
/*    */           break;
/*    */ 
/*    */         
/*    */         case 40:
/* 59 */           this.game.getLoop().setPlayerSleepTime(50);
/*    */           break;
/*    */         
/*    */         case 38:
/* 63 */           if ((!this.piece.canMoveLeft(this.map) && !this.piece.canMoveRight(this.map)) || this.piece.getPiece()[0].getRow() < 1)
/*    */             break; 
/* 65 */           this.piece.Rotate(this.map);
/*    */           break;
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 74 */     switch (e.getKeyCode()) {
/*    */       case 40:
/* 76 */         if ((this.game.getGamePanel()).gamemode == 1) {
/* 77 */           this.game.getLoop().setPlayerSleepTime(this.game.getLoop().getPlayerFPS()); break;
/*    */         } 
/* 79 */         this.game.getLoop().setPlayerSleepTime(200);
/*    */         break;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/PlayerClasses/PieceController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */