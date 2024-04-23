 package tetrisAI.AIClasses;
 
 import it.unical.mat.embasp.languages.Id;
 import it.unical.mat.embasp.languages.Param;
 import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.Image;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 import javax.swing.JPanel;
 import tetrisAI.AIBlocks.iBlock;
 import tetrisAI.AIBlocks.jBlock;
 import tetrisAI.AIBlocks.lBlock;
 import tetrisAI.AIBlocks.oBlock;
 import tetrisAI.AIBlocks.sBlock;
 import tetrisAI.AIBlocks.tBlock;
 import tetrisAI.AIBlocks.zBlock;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 @Id("map")
 public class Map
   extends JPanel
 {
   @Param(0)
   private Cell[][] matrix;
   @Param(1)
   private iBlock ib;
   @Param(2)
   private jBlock jb;
   @Param(3)
   private lBlock lb;
   @Param(4)
   private oBlock ob;
   @Param(5)
   private sBlock sb;
   @Param(6)
   private tBlock tb;
   @Param(7)
   private zBlock zb;
   @Param(8)
   private EmptyBlock eb;
   @Param(9)
   private Cell[][] suppMatrix;
   private Image ibl;
   private Image jbl;
   private Image lbl;
   private Image obl;
   private Image sbl;
   private Image tbl;
   private Image zbl;
   private Image wall;
   private Piece currPiece;
   private Integer score = Integer.valueOf(0);
 
 
 
 
   
   public Map(Game game) {
     this.matrix = new Cell[20][10];
     this.suppMatrix = new Cell[20][10];
 
     
     this.ib = new iBlock();
     this.ibl = this.ib.getImage();
     
     this.jb = new jBlock();
     this.jbl = this.jb.getImage();
     
     this.lb = new lBlock();
     this.lbl = this.lb.getImage();
     
     this.ob = new oBlock();
     this.obl = this.ob.getImage();
     
     this.sb = new sBlock();
     this.sbl = this.sb.getImage();
     
     this.tb = new tBlock();
     this.tbl = this.tb.getImage();
     
     this.zb = new zBlock();
     this.zbl = this.zb.getImage();
     
     try {
       this.wall = ImageIO.read(getClass().getResource("/resources/wall.png"));
       Image icon = this.wall.getScaledInstance(30, 30, 4);
       this.wall = icon;
     } catch (IOException e) {
       
       e.printStackTrace();
     } 
     
     for (int i = 0; i < this.matrix.length; i++) {
       
       for (int j = 0; j < (this.matrix[i]).length; j++) {
         
         this.matrix[i][j] = new EmptyBlock(i, j, 0);
         this.suppMatrix[i][j] = new EmptyBlock(i, j, 0);
       } 
     } 
 
     
     repaint();
   }
 
 
 
   
   public synchronized void paintComponent(Graphics g) {
     super.paintComponent(g);
 
 
     
     for (int i = 0; i < this.matrix.length; i++) {
       
       for (int j = 0; j < (this.matrix[i]).length; j++) {
 
         
         if (this.matrix[i][j].getValue() == 0) {
           int x = 0 + j * 30;
           int y = 0 + i * 30;
           g.setColor(Color.BLACK);
           g.fillRect(x, y, 30, 30);
 
         
         }
         else if (this.matrix[i][j].getValue() == 1 || this.matrix[i][j].getValue() == -1) {
           int x = 0 + j * 30;
           int y = 0 + i * 30;
           
           g.drawImage(this.ibl, x, y, 30, 30, null);
         
         }
         else if (this.matrix[i][j].getValue() == 2 || this.matrix[i][j].getValue() == -2) {
           int x = 0 + j * 30;
           int y = 0 + i * 30;
           
           g.drawImage(this.jbl, x, y, 30, 30, null);
         
         }
         else if (this.matrix[i][j].getValue() == 3 || this.matrix[i][j].getValue() == -3) {
           int x = 0 + j * 30;
           int y = 0 + i * 30;
           
           g.drawImage(this.lbl, x, y, 30, 30, null);
         
         }
         else if (this.matrix[i][j].getValue() == 4 || this.matrix[i][j].getValue() == -4) {
           int x = 0 + j * 30;
           int y = 0 + i * 30;
           
           g.drawImage(this.obl, x, y, 30, 30, null);
         
         }
         else if (this.matrix[i][j].getValue() == 5 || this.matrix[i][j].getValue() == -5) {
           int x = 0 + j * 30;
           int y = 0 + i * 30;
           
           g.drawImage(this.sbl, x, y, 30, 30, null);
         
         }
         else if (this.matrix[i][j].getValue() == 6 || this.matrix[i][j].getValue() == -6) {
           int x = 0 + j * 30;
           int y = 0 + i * 30;
           
           g.drawImage(this.tbl, x, y, 30, 30, null);
         
         }
         else if (this.matrix[i][j].getValue() == 7 || this.matrix[i][j].getValue() == -7) {
           int x = 0 + j * 30;
           int y = 0 + i * 30;
           
           g.drawImage(this.zbl, x, y, 30, 30, null);
         
         }
         else if (this.matrix[i][j].getValue() == 9 || this.matrix[i][j].getValue() == -9) {
           int x = 0 + j * 30;
           int y = 0 + i * 30;
           
           g.drawImage(this.wall, x, y, 30, 30, null);
         } 
       } 
     } 
 
     
     g.setColor(Color.LIGHT_GRAY);
     g.drawLine(0, 0, 300, 0);
     g.drawLine(0, 600, 300, 600);
     g.drawLine(300, 0, 300, 600);
     g.drawLine(0, 0, 0, 600);
   }
 
 
 
   
   public Integer getScore() {
     return this.score;
   }
 
   
   public void setScore(Integer score) {
     this.score = score;
   }
 
   
   public synchronized Cell[][] getMatrix() {
     return this.matrix;
   }
 
   
   public synchronized Cell[][] getSuppMatrix() {
     return this.suppMatrix;
   }
   
   public synchronized void update() {
     repaint();
   }
   
   public synchronized void addPiece(Piece piece) {
     this.currPiece = piece;
   }
 }
