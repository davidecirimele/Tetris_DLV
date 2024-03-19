/*    */ package tetrisAI.AIClasses;
/*    */ 
/*    */ import it.unical.mat.embasp.base.Callback;
/*    */ import it.unical.mat.embasp.base.Output;
/*    */ import it.unical.mat.embasp.languages.asp.AnswerSet;
/*    */ import it.unical.mat.embasp.languages.asp.AnswerSets;
/*    */ 
/*    */ 
/*    */ public class MyCallback
/*    */   implements Callback
/*    */ {
/*    */   private Cell[][] tetrisMatrix;
/*    */   
/*    */   public MyCallback(Cell[][] tetrisMatrix) {
/* 15 */     this.tetrisMatrix = tetrisMatrix;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void callback(Output o) {
/* 21 */     AnswerSets answers = (AnswerSets)o;
/* 22 */     for (AnswerSet a : answers.getAnswersets()) {
/*    */       try {
/* 24 */         for (Object obj : a.getAtoms()) {
/* 25 */           System.out.println(obj);
/*    */         }
/* 27 */       } catch (Exception e) {
/* 28 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/AIClasses/MyCallback.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */