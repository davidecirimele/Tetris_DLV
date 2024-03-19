/*     */ package tetrisAI.AIClasses;
/*     */ 
/*     */ import it.unical.mat.embasp.languages.Id;
/*     */ import it.unical.mat.embasp.languages.Param;
/*     */ import java.awt.Image;
/*     */ import tetrisAI.PlayerClasses.CellPlayer;
/*     */ import tetrisAI.PlayerClasses.PiecePlayer;
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
/*     */ @Id("piece")
/*     */ public class Piece
/*     */   extends PiecePlayer
/*     */ {
/*     */   @Param(0)
/*  26 */   protected Cell[] blocks = new Cell[4]; @Param(1)
/*  27 */   protected boolean[] state = new boolean[4]; public Piece() {
/*  28 */     for (int i = 0; i < 4; i++) {
/*  29 */       this.blocks[i] = new Cell();
/*  30 */       this.state[i] = false;
/*     */     } 
/*     */   }
/*     */   protected Image image;
/*     */   protected int id;
/*     */   public boolean isMoving;
/*     */   
/*     */   public Cell[] getPiece() {
/*  38 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Image getImage() {
/*  43 */     return this.image;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void Rotate(Map map) {}
/*     */ 
/*     */   
/*     */   public int getId() {
/*  52 */     return this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setId(int id) {
/*  57 */     this.id = id;
/*     */   }
/*     */   
/*     */   public boolean[] getState() {
/*  61 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setState(boolean state, int i) {
/*  66 */     this.state[i] = state;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMoving() {
/*  71 */     return this.isMoving;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMoving(boolean isMoving) {
/*  76 */     this.isMoving = isMoving;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMoveLeft(Map map) {
/*  82 */     for (int i = 0; i < 4; i++) {
/*  83 */       if (this.blocks[i].getColumn() == 0)
/*  84 */         return false; 
/*  85 */       Cell adj = map.getMatrix()[this.blocks[i].getRow()][this.blocks[i].getColumn() - 1];
/*  86 */       if (adj.getValue() != 0 && adj.getId() != this.id) {
/*  87 */         return false;
/*     */       }
/*     */     } 
/*  90 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMoveRight(Map map) {
/*  97 */     for (int i = 0; i < 4; i++) {
/*  98 */       if (this.blocks[i].getColumn() == 9)
/*  99 */         return false; 
/* 100 */       Cell adj = map.getMatrix()[this.blocks[i].getRow()][this.blocks[i].getColumn() + 1];
/* 101 */       if (adj.getValue() != 0 && adj.getId() != this.id)
/* 102 */         return false; 
/*     */     } 
/* 104 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/AIClasses/Piece.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */