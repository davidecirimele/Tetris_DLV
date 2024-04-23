 package tetrisAI.PlayerClasses;
 
 
 
 
 
 
 
 
 public class CellPlayer
 {
   private int row;
   private int column;
   private int value;
   private int id;
   
   public int getId() {
     return this.id;
   }
   
   public void setId(int id) {
     this.id = id;
   }
   
   public CellPlayer(int r, int c, int v) {
     this.row = r;
     this.column = c;
     this.value = v;
   }
 
   
   public CellPlayer() {}
   
   public int getRow() {
     return this.row;
   }
   
   public void setRow(int row) {
     this.row = row;
   }
   
   public int getColumn() {
     return this.column;
   }
   
   public void setColumn(int column) {
     this.column = column;
   }
   
   public int getValue() {
     return this.value;
   }
   
   public void setValue(int value) {
     this.value = value;
   }
 }
