/*     */ package tetrisAI.View;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.Box;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import tetrisAI.AIClasses.Game;
/*     */ import tetrisAI.PlayerClasses.GamePlayer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StartPanel
/*     */   extends JPanel
/*     */ {
/*     */   private Image background;
/*     */   private Image logo;
/*     */   private Image singlepicon;
/*     */   private Image vscomicon;
/*     */   private Image exiticon;
/*     */   private JLabel title;
/*     */   private JButton singlegame;
/*     */   private JButton playervscpu;
/*     */   private JButton exit;
/*     */   private GamePlayer g1;
/*     */   private Game g;
/*     */   private GamePanel gp;
/*     */   
/*     */   public StartPanel() {
/*  59 */     setLayout(new BoxLayout(this, 3));
/*     */     
/*     */     try {
/*  62 */       this.background = ImageIO.read(getClass().getResource("/resources/wallpaper.jpg"));
/*  63 */       this.logo = ImageIO.read(getClass().getResource("/resources/logo.png"));
/*  64 */       this.singlepicon = ImageIO.read(getClass().getResource("/resources/singleplayericon.png"));
/*  65 */       this.vscomicon = ImageIO.read(getClass().getResource("/resources/vscombuttonicon.png"));
/*  66 */       this.exiticon = ImageIO.read(getClass().getResource("/resources/exiticon.png"));
/*  67 */       Image icon = this.background.getScaledInstance(300, 600, 4);
/*  68 */       this.background = icon;
/*  69 */       icon = this.logo.getScaledInstance(200, 100, 4);
/*  70 */       this.logo = icon;
/*  71 */       icon = this.singlepicon.getScaledInstance(120, 60, 4);
/*  72 */       this.singlepicon = icon;
/*  73 */       icon = this.vscomicon.getScaledInstance(120, 60, 4);
/*  74 */       this.vscomicon = icon;
/*  75 */       icon = this.exiticon.getScaledInstance(120, 60, 4);
/*  76 */       this.exiticon = icon;
/*  77 */     } catch (IOException e) {
/*     */       
/*  79 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  82 */     this.title = new JLabel();
/*  83 */     this.title.setIcon(new ImageIcon(this.logo));
/*     */     
/*  85 */     this.singlegame = new JButton();
/*     */     
/*  87 */     this.singlegame.setIcon(new ImageIcon(this.singlepicon));
/*     */     
/*  89 */     this.singlegame.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e)
/*     */           {
/*  93 */             StartPanel.this.startSingleGame();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  98 */     this.playervscpu = new JButton();
/*     */     
/* 100 */     this.playervscpu.setIcon(new ImageIcon(this.vscomicon));
/*     */     
/* 102 */     this.playervscpu.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e)
/*     */           {
/* 106 */             StartPanel.this.startVSCOMGame();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 112 */     this.exit = new JButton();
/*     */     
/* 114 */     this.exit.setIcon(new ImageIcon(this.exiticon));
/*     */     
/* 116 */     this.exit.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e)
/*     */           {
/* 120 */             System.exit(0);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 125 */     this.title.setAlignmentX(0.5F);
/* 126 */     this.singlegame.setAlignmentX(0.5F);
/* 127 */     this.playervscpu.setAlignmentX(0.5F);
/* 128 */     this.exit.setAlignmentX(0.5F);
/*     */     
/* 130 */     add(Box.createRigidArea(new Dimension(400, 50)));
/* 131 */     add(this.title);
/* 132 */     add(Box.createRigidArea(new Dimension(400, 50)));
/* 133 */     add(this.singlegame);
/* 134 */     add(Box.createRigidArea(new Dimension(400, 50)));
/* 135 */     add(this.playervscpu);
/* 136 */     add(Box.createRigidArea(new Dimension(400, 50)));
/* 137 */     add(this.exit);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void paintComponent(Graphics g) {
/* 142 */     super.paintComponent(g);
/*     */     
/* 144 */     g.drawImage(this.background, 0, 0, 300, 600, null);
/*     */   }
/*     */   
/*     */   public void startSingleGame() {
/* 148 */     JFrame f = new JFrame("Tetris-Single Player");
/*     */     
/* 150 */     this.g1 = new GamePlayer();
/* 151 */     this.gp = new GamePanel(this.g1, f, this);
/* 152 */     this.g1.setLoop(this.gp.getLoop(), this.gp);
/* 153 */     f.add(this.gp);
/* 154 */     f.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e) {
/* 157 */             StartPanel.this.g1.interruptThread();
/* 158 */             StartPanel.this.gp.getLoop().interruptGameloop();
/*     */             
/* 160 */             StartPanel.this.resetGame(0);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 165 */     f.setSize(600, 650);
/* 166 */     f.setVisible(true);
/* 167 */     f.setResizable(false);
/* 168 */     f.setDefaultCloseOperation(2);
/*     */   }
/*     */   
/*     */   public void resetGame(int i) {
/* 172 */     this.gp.getLoop().resetLists();
/* 173 */     this.gp.deleteLoop();
/*     */     
/* 175 */     this.g1 = null;
/*     */     
/* 177 */     if (i == 1) {
/* 178 */       this.g.deleteASP();
/* 179 */       this.g = null;
/*     */     } 
/*     */     
/* 182 */     this.gp = null;
/*     */   }
/*     */   public void startVSCOMGame() {
/* 185 */     JFrame f = new JFrame("Tetris-VS COM");
/* 186 */     this.g = new Game();
/* 187 */     this.g1 = new GamePlayer();
/* 188 */     this.gp = new GamePanel(this.g, this.g1, f, this);
/* 189 */     this.g.setLoop(this.gp.getLoop(), this.gp);
/* 190 */     this.g1.setLoop(this.gp.getLoop(), this.gp);
/*     */     
/* 192 */     f.add(this.gp);
/* 193 */     f.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e) {
/* 196 */             StartPanel.this.g.interruptThread();
/* 197 */             StartPanel.this.g1.interruptThread();
/* 198 */             StartPanel.this.gp.getLoop().interruptGameloop();
/* 199 */             StartPanel.this.resetGame(1);
/*     */           }
/*     */         });
/*     */     
/* 203 */     f.setSize(1000, 650);
/* 204 */     f.setVisible(true);
/* 205 */     f.setResizable(false);
/* 206 */     f.setDefaultCloseOperation(2);
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/View/StartPanel.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */