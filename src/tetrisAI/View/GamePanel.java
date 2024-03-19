/*     */ package tetrisAI.View;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.Box;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import tetrisAI.AIClasses.Game;
/*     */ import tetrisAI.Game.Gameloop;
/*     */ import tetrisAI.PlayerClasses.GamePlayer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GamePanel
/*     */   extends JPanel
/*     */ {
/*     */   private Image wallpaper;
/*     */   private List<Image> icons;
/*     */   private JPanel nextPieceAIPanel;
/*     */   private JPanel nextPiecePlayerPanel;
/*     */   public List<JLabel> nextPiecesAI;
/*     */   public List<JLabel> nextPiecesPlayer;
/*     */   public int gamemode;
/*     */   private SingleScorePanel ssp;
/*     */   private ScorePanel sp;
/*     */   private StartPanel startpanel;
/*     */   private Gameloop gl;
/*     */   private Game g;
/*     */   private GamePlayer g1;
/*     */   
/*     */   public GamePanel(Game g, GamePlayer g2, JFrame f, StartPanel startpanel) {
/*  43 */     this.gamemode = 0;
/*  44 */     this.g = g;
/*  45 */     this.g1 = g2;
/*     */     
/*  47 */     this.startpanel = startpanel;
/*     */     
/*  49 */     this.sp = new ScorePanel();
/*     */     
/*  51 */     this.gl = new Gameloop(g, g2, g.getMap(), g2.getMapPlayer(), this, f);
/*     */     
/*     */     try {
/*  54 */       this.wallpaper = ImageIO.read(getClass().getResource("/resources/wallpaper.jpg"));
/*  55 */       Image icon = this.wallpaper.getScaledInstance(1000, 650, 4);
/*  56 */       this.wallpaper = icon;
/*  57 */     } catch (IOException e) {
/*     */       
/*  59 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  62 */     this.icons = new ArrayList<>();
/*     */     
/*  64 */     this.nextPiecesAI = new ArrayList<>();
/*  65 */     this.nextPiecesPlayer = new ArrayList<>();
/*     */     
/*  67 */     loadIcons();
/*     */     
/*  69 */     this.nextPieceAIPanel = new JPanel();
/*  70 */     this.nextPiecePlayerPanel = new JPanel();
/*     */     
/*  72 */     this.nextPieceAIPanel.setBackground(Color.BLACK);
/*  73 */     this.nextPiecePlayerPanel.setBackground(Color.BLACK);
/*     */     
/*  75 */     this.nextPieceAIPanel.setLayout(new BoxLayout(this.nextPieceAIPanel, 3));
/*  76 */     this.nextPiecePlayerPanel.setLayout(new BoxLayout(this.nextPiecePlayerPanel, 3));
/*     */     
/*  78 */     this.nextPieceAIPanel.setPreferredSize(new Dimension(50, 200));
/*  79 */     this.nextPiecePlayerPanel.setPreferredSize(new Dimension(50, 200));
/*     */     
/*  81 */     for (int i = 0; i < 5; i++) {
/*     */       
/*  83 */       this.nextPiecesAI.add(new JLabel());
/*     */       
/*  85 */       this.nextPiecesPlayer.add(new JLabel());
/*     */       
/*  87 */       this.nextPieceAIPanel.add(this.nextPiecesAI.get(i), 0);
/*  88 */       this.nextPiecePlayerPanel.add(this.nextPiecesPlayer.get(i), 0);
/*  89 */       this.nextPieceAIPanel.add(Box.createRigidArea(new Dimension(5, 10)), 0);
/*  90 */       this.nextPiecePlayerPanel.add(Box.createRigidArea(new Dimension(5, 10)), 0);
/*     */     } 
/*     */     
/*  93 */     g.getMap().setPreferredSize(new Dimension(301, 601));
/*     */ 
/*     */     
/*  96 */     g2.getMapPlayer().setPreferredSize(new Dimension(301, 601));
/*     */ 
/*     */ 
/*     */     
/* 100 */     add((Component)g.getMap());
/* 101 */     add(this.nextPieceAIPanel);
/* 102 */     add(this.sp);
/* 103 */     add(this.nextPiecePlayerPanel);
/* 104 */     add((Component)g2.getMapPlayer());
/*     */ 
/*     */     
/* 107 */     Thread t1 = new Thread((Runnable)g);
/* 108 */     Thread t2 = new Thread((Runnable)g2);
/*     */     
/* 110 */     fillNextPieces(0, 0);
/* 111 */     fillNextPieces(1, 0);
/*     */     
/* 113 */     t1.start();
/* 114 */     t2.start();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GamePanel(GamePlayer g2, JFrame f, StartPanel startpanel) {
/* 120 */     this.gamemode = 1;
/* 121 */     this.g1 = g2;
/*     */     
/* 123 */     this.startpanel = startpanel;
/*     */     
/* 125 */     this.ssp = new SingleScorePanel();
/*     */     
/* 127 */     this.gl = new Gameloop(g2, g2.getMapPlayer(), this, f);
/*     */     
/*     */     try {
/* 130 */       this.wallpaper = ImageIO.read(getClass().getResource("/resources/wallpaper.jpg"));
/* 131 */       Image icon = this.wallpaper.getScaledInstance(600, 650, 4);
/* 132 */       this.wallpaper = icon;
/* 133 */     } catch (IOException e) {
/*     */       
/* 135 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 138 */     this.icons = new ArrayList<>();
/*     */     
/* 140 */     this.nextPiecesPlayer = new ArrayList<>();
/*     */     
/* 142 */     loadIcons();
/*     */     
/* 144 */     this.nextPiecePlayerPanel = new JPanel();
/*     */     
/* 146 */     this.nextPiecePlayerPanel.setBackground(Color.BLACK);
/*     */     
/* 148 */     this.nextPiecePlayerPanel.setLayout(new BoxLayout(this.nextPiecePlayerPanel, 3));
/*     */     
/* 150 */     this.nextPiecePlayerPanel.setPreferredSize(new Dimension(50, 200));
/*     */     
/* 152 */     for (int i = 0; i < 5; i++) {
/*     */ 
/*     */       
/* 155 */       this.nextPiecesPlayer.add(new JLabel());
/*     */ 
/*     */       
/* 158 */       this.nextPiecePlayerPanel.add(this.nextPiecesPlayer.get(i), 0);
/*     */       
/* 160 */       this.nextPiecePlayerPanel.add(Box.createRigidArea(new Dimension(5, 10)), 0);
/*     */     } 
/*     */ 
/*     */     
/* 164 */     g2.getMapPlayer().setPreferredSize(new Dimension(301, 601));
/*     */     
/* 166 */     add(this.ssp);
/* 167 */     add(this.nextPiecePlayerPanel);
/* 168 */     add((Component)g2.getMapPlayer());
/*     */     
/* 170 */     Thread t2 = new Thread((Runnable)g2);
/*     */     
/* 172 */     fillNextPieces(1, 0);
/*     */     
/* 174 */     t2.start();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void loadIcons() {
/* 180 */     String[] iconsname = { "IblockIcon.png", "OblockIcon.png", "JblockIcon.png", "LblockIcon.png", "SblockIcon.png", "TblockIcon.png", "ZblockIcon.png" };
/*     */ 
/*     */     
/* 183 */     for (int i = 0; i < 7; i++) {
/*     */       
/*     */       try {
/* 186 */         Image img = ImageIO.read(getClass().getResource("/resources/BlocksIcons/" + iconsname[i]));
/* 187 */         img = scaleIcon(img, iconsname[i]);
/* 188 */         this.icons.add(img);
/* 189 */       } catch (IOException e) {
/*     */         
/* 191 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void paintComponent(Graphics g) {
/* 199 */     super.paintComponent(g);
/*     */     
/* 201 */     switch (this.gamemode) {
/*     */       case 0:
/* 203 */         g.drawImage(this.wallpaper, 0, 0, 1000, 650, null);
/*     */         break;
/*     */       case 1:
/* 206 */         g.drawImage(this.wallpaper, 0, 0, 600, 650, null);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Image scaleIcon(Image img, String s) {
/* 214 */     Image icon = null;
/*     */     String str;
/* 216 */     switch ((str = s).hashCode()) { case -2116524275: if (!str.equals("TblockIcon.png")) {
/*     */           break;
/*     */         }
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
/*     */         
/* 233 */         icon = img.getScaledInstance(50, 32, 4); break;case -1610965650: if (!str.equals("SblockIcon.png"))
/*     */           break;  icon = img.getScaledInstance(50, 35, 4); break;case -1355905321: if (!str.equals("JblockIcon.png"))
/*     */           break;  icon = img.getScaledInstance(50, 33, 4); break;case -854908729: if (!str.equals("ZblockIcon.png"))
/* 236 */           break;  icon = img.getScaledInstance(50, 35, 4); break;case -850346696: if (!str.equals("IblockIcon.png"))
/*     */           break;  icon = img.getScaledInstance(50, 12, 4); break;case 411268850: if (!str.equals("OblockIcon.png"))
/*     */           break;  icon = img.getScaledInstance(30, 30, 4); break;case 1927944725: if (!str.equals("LblockIcon.png"))
/* 239 */           break;  icon = img.getScaledInstance(50, 33, 4); break; }  return icon;
/*     */   }
/*     */   
/*     */   public void switchIcons(int type, int j, int n) {
/* 243 */     if (type == 0) {
/* 244 */       switch (n) {
/*     */         case 1:
/* 246 */           ((JLabel)this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(0)));
/*     */           break;
/*     */         case 2:
/* 249 */           ((JLabel)this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(2)));
/*     */           break;
/*     */         case 3:
/* 252 */           ((JLabel)this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(3)));
/*     */           break;
/*     */         case 4:
/* 255 */           ((JLabel)this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(1)));
/*     */           break;
/*     */         case 5:
/* 258 */           ((JLabel)this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(4)));
/*     */           break;
/*     */         case 6:
/* 261 */           ((JLabel)this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(5)));
/*     */           break;
/*     */         case 7:
/* 264 */           ((JLabel)this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(6)));
/*     */           break;
/*     */       } 
/*     */     
/* 268 */     } else if (type == 1) {
/*     */       
/* 270 */       switch (n) {
/*     */         case 1:
/* 272 */           ((JLabel)this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(0)));
/*     */           break;
/*     */         case 2:
/* 275 */           ((JLabel)this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(2)));
/*     */           break;
/*     */         case 3:
/* 278 */           ((JLabel)this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(3)));
/*     */           break;
/*     */         case 4:
/* 281 */           ((JLabel)this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(1)));
/*     */           break;
/*     */         case 5:
/* 284 */           ((JLabel)this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(4)));
/*     */           break;
/*     */         case 6:
/* 287 */           ((JLabel)this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(5)));
/*     */           break;
/*     */         case 7:
/* 290 */           ((JLabel)this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(6)));
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillNextPieces(int type, int index) {
/* 298 */     int j = 0;
/* 299 */     for (int i = index + 1; i < index + 5; i++) {
/*     */       
/* 301 */       if (index == 0) {
/*     */         
/* 303 */         switchIcons(type, j, ((Integer)this.gl.allPiecesQueue.get(0)).intValue());
/*     */         
/*     */         break;
/*     */       } 
/* 307 */       switchIcons(type, j, ((Integer)this.gl.allPiecesQueue.get(i)).intValue());
/* 308 */       j++;
/* 309 */       if (type == 0) {
/* 310 */         this.nextPieceAIPanel.revalidate();
/*     */       } else {
/* 312 */         this.nextPiecePlayerPanel.revalidate();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public Gameloop getLoop() {
/* 317 */     return this.gl;
/*     */   }
/*     */   
/*     */   public Game getAI() {
/* 321 */     return this.g;
/*     */   }
/*     */   
/*     */   public GamePlayer getPlayer() {
/* 325 */     return this.g1;
/*     */   }
/*     */   
/*     */   public SingleScorePanel getSingleScorePanel() {
/* 329 */     return this.ssp;
/*     */   }
/*     */   
/*     */   public ScorePanel getScorePanel() {
/* 333 */     return this.sp;
/*     */   }
/*     */   
/*     */   public StartPanel getStartPanel() {
/* 337 */     return this.startpanel;
/*     */   }
/*     */   
/*     */   public void deleteLoop() {
/* 341 */     this.gl = null;
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/View/GamePanel.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */