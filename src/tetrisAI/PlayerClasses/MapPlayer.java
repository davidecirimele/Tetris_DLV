 package tetrisAI.PlayerClasses;
 
 import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.Image;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 import javax.swing.JPanel;
 import tetrisAI.PlayerBlocks.iBlockPlayer;
 import tetrisAI.PlayerBlocks.jBlockPlayer;
 import tetrisAI.PlayerBlocks.lBlockPlayer;
 import tetrisAI.PlayerBlocks.oBlockPlayer;
 import tetrisAI.PlayerBlocks.sBlockPlayer;
 import tetrisAI.PlayerBlocks.tBlockPlayer;
 import tetrisAI.PlayerBlocks.zBlockPlayer;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class MapPlayer
   extends JPanel
 {
   private CellPlayer[][] matrix;
   private iBlockPlayer ib;
   private jBlockPlayer jb;
   private lBlockPlayer lb;
   private oBlockPlayer ob;
   private sBlockPlayer sb;
   private tBlockPlayer tb;
   private zBlockPlayer zb;
   private CellPlayer[][] suppMatrix;
   private Image ibl;
   private Image jbl;
   private Image lbl;
   private Image obl;
   private Image sbl;
   private Image tbl;
   private Image zbl;
   private Image wall;
   private PiecePlayer currPiece;
   private PieceController pc;
   private Integer score = Integer.valueOf(0);
 
   
   public MapPlayer(GamePlayer game) {
     this.matrix = new CellPlayer[20][10];
     this.suppMatrix = new CellPlayer[20][10];
 
     
     this.ib = new iBlockPlayer();
     this.ibl = this.ib.getImage();
     
     this.jb = new jBlockPlayer();
     this.jbl = this.jb.getImage();
     
     this.lb = new lBlockPlayer();
     this.lbl = this.lb.getImage();
     
     this.ob = new oBlockPlayer();
     this.obl = this.ob.getImage();
     
     this.sb = new sBlockPlayer();
     this.sbl = this.sb.getImage();
     
     this.tb = new tBlockPlayer();
     this.tbl = this.tb.getImage();
     
     this.zb = new zBlockPlayer();
     this.zbl = this.zb.getImage();
     
     try {
       this.wall = ImageIO.read(getClass().getResource("/resources/wall.png"));
       Image icon = this.wall.getScaledInstance(30, 30, 4);
       this.wall = icon;
     } catch (IOException e) {
       
       e.printStackTrace();
     } 
     
     this.pc = new PieceController(this, game);
     addKeyListener(this.pc);
     
     for (int i = 0; i < this.matrix.length; i++) {
       
       for (int j = 0; j < (this.matrix[i]).length; j++) {
         
         this.matrix[i][j] = new EmptyBlockPlayer(i, j, 0);
         this.suppMatrix[i][j] = new EmptyBlockPlayer(i, j, 0);
       } 
     } 
 
     
     setFocusable(true);
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
 
   
   public synchronized CellPlayer[][] getMatrix() {
     return this.matrix;
   }
 
   
   public synchronized CellPlayer[][] getSuppMatrix() {
     return this.suppMatrix;
   }
   
   public synchronized void update() {
     repaint();
   }
   
   public void addPiece(PiecePlayer piecePlayer) {
     this.currPiece = piecePlayer;
     this.pc.updatePiece(this.currPiece);
   }
   
   public PieceController getController() {
     return this.pc;
   }
 }
