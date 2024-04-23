 package tetrisAI.View;
 
 import java.awt.Dimension;
 import java.awt.Graphics;
 import java.awt.Image;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.WindowAdapter;
 import java.awt.event.WindowEvent;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 import javax.swing.Box;
 import javax.swing.BoxLayout;
 import javax.swing.ImageIcon;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
 import tetrisAI.AIClasses.Game;
 import tetrisAI.PlayerClasses.GamePlayer;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class StartPanel
   extends JPanel
 {
   private Image background;
   private Image logo;
   private Image singlepicon;
   private Image vscomicon;
   private Image exiticon;
   private JLabel title;
   private JButton singlegame;
   private JButton playervscpu;
   private JButton exit;
   private GamePlayer g1;
   private Game g;
   private GamePanel gp;
   
   public StartPanel() {
     setLayout(new BoxLayout(this, 3));
     
     try {
       this.background = ImageIO.read(getClass().getResource("/resources/wallpaper.jpg"));
       this.logo = ImageIO.read(getClass().getResource("/resources/logo.png"));
       this.singlepicon = ImageIO.read(getClass().getResource("/resources/singleplayericon.png"));
       this.vscomicon = ImageIO.read(getClass().getResource("/resources/vscombuttonicon.png"));
       this.exiticon = ImageIO.read(getClass().getResource("/resources/exiticon.png"));
       Image icon = this.background.getScaledInstance(300, 600, 4);
       this.background = icon;
       icon = this.logo.getScaledInstance(200, 100, 4);
       this.logo = icon;
       icon = this.singlepicon.getScaledInstance(120, 60, 4);
       this.singlepicon = icon;
       icon = this.vscomicon.getScaledInstance(120, 60, 4);
       this.vscomicon = icon;
       icon = this.exiticon.getScaledInstance(120, 60, 4);
       this.exiticon = icon;
     } catch (IOException e) {
       
       e.printStackTrace();
     } 
     
     this.title = new JLabel();
     this.title.setIcon(new ImageIcon(this.logo));
     
     this.singlegame = new JButton();
     
     this.singlegame.setIcon(new ImageIcon(this.singlepicon));
     
     this.singlegame.addActionListener(new ActionListener()
         {
           public void actionPerformed(ActionEvent e)
           {
             StartPanel.this.startSingleGame();
           }
         });
 
     
     this.playervscpu = new JButton();
     
     this.playervscpu.setIcon(new ImageIcon(this.vscomicon));
     
     this.playervscpu.addActionListener(new ActionListener()
         {
           public void actionPerformed(ActionEvent e)
           {
             StartPanel.this.startVSCOMGame();
           }
         });
 
 
     
     this.exit = new JButton();
     
     this.exit.setIcon(new ImageIcon(this.exiticon));
     
     this.exit.addActionListener(new ActionListener()
         {
           public void actionPerformed(ActionEvent e)
           {
             System.exit(0);
           }
         });
 
     
     this.title.setAlignmentX(0.5F);
     this.singlegame.setAlignmentX(0.5F);
     this.playervscpu.setAlignmentX(0.5F);
     this.exit.setAlignmentX(0.5F);
     
     add(Box.createRigidArea(new Dimension(400, 50)));
     add(this.title);
     add(Box.createRigidArea(new Dimension(400, 50)));
     add(this.singlegame);
     add(Box.createRigidArea(new Dimension(400, 50)));
     add(this.playervscpu);
     add(Box.createRigidArea(new Dimension(400, 50)));
     add(this.exit);
   }
 
   
   protected void paintComponent(Graphics g) {
     super.paintComponent(g);
     
     g.drawImage(this.background, 0, 0, 300, 600, null);
   }
   
   public void startSingleGame() {
     JFrame f = new JFrame("Tetris-Single Player");
     
     this.g1 = new GamePlayer();
     this.gp = new GamePanel(this.g1, f, this);
     this.g1.setLoop(this.gp.getLoop(), this.gp);
     f.add(this.gp);
     f.addWindowListener(new WindowAdapter()
         {
           public void windowClosing(WindowEvent e) {
             StartPanel.this.g1.interruptThread();
             StartPanel.this.gp.getLoop().interruptGameloop();
             
             StartPanel.this.resetGame(0);
           }
         });
 
     
     f.setSize(600, 650);
     f.setVisible(true);
     f.setResizable(false);
     f.setDefaultCloseOperation(2);
   }
   
   public void resetGame(int i) {
     this.gp.getLoop().resetLists();
     this.gp.deleteLoop();
     
     this.g1 = null;
     
     if (i == 1) {
       this.g.deleteASP();
       this.g = null;
     } 
     
     this.gp = null;
   }
   public void startVSCOMGame() {
     JFrame f = new JFrame("Tetris-VS COM");
     this.g = new Game();
     this.g1 = new GamePlayer();
     this.gp = new GamePanel(this.g, this.g1, f, this);
     this.g.setLoop(this.gp.getLoop(), this.gp);
     this.g1.setLoop(this.gp.getLoop(), this.gp);
     
     f.add(this.gp);
     f.addWindowListener(new WindowAdapter()
         {
           public void windowClosing(WindowEvent e) {
             StartPanel.this.g.interruptThread();
             StartPanel.this.g1.interruptThread();
             StartPanel.this.gp.getLoop().interruptGameloop();
             StartPanel.this.resetGame(1);
           }
         });
     
     f.setSize(1000, 650);
     f.setVisible(true);
     f.setResizable(false);
     f.setDefaultCloseOperation(2);
   }
 }
