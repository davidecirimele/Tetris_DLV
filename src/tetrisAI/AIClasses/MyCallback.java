 package tetrisAI.AIClasses;
 
 import it.unical.mat.embasp.base.Callback;
 import it.unical.mat.embasp.base.Output;
 import it.unical.mat.embasp.languages.asp.AnswerSet;
 import it.unical.mat.embasp.languages.asp.AnswerSets;
 
 
 public class MyCallback
   implements Callback
 {
   private Cell[][] tetrisMatrix;
   
   public MyCallback(Cell[][] tetrisMatrix) {
     this.tetrisMatrix = tetrisMatrix;
   }
 
 
   
   public void callback(Output o) {
     AnswerSets answers = (AnswerSets)o;
     for (AnswerSet a : answers.getAnswersets()) {
       try {
         for (Object obj : a.getAtoms()) {
           System.out.println(obj);
         }
       } catch (Exception e) {
         e.printStackTrace();
       } 
     } 
   }
 }

