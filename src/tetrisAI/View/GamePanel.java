 package tetrisAI.View;
 
 import java.awt.Color;
 import java.awt.Component;
 import java.awt.Dimension;
 import java.awt.Graphics;
 import java.awt.Image;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.List;
 import javax.imageio.ImageIO;
 import javax.swing.Box;
 import javax.swing.BoxLayout;
 import javax.swing.ImageIcon;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
 import tetrisAI.AIClasses.Game;
 import tetrisAI.Game.Gameloop;
 import tetrisAI.PlayerClasses.GamePlayer;
 
 
 
 
 public class GamePanel
         extends JPanel
 {
     private Image wallpaper;
     private List<Image> icons;
     private JPanel nextPieceAIPanel;
     private JPanel nextPiecePlayerPanel;
     public List<JLabel> nextPiecesAI;
     public List<JLabel> nextPiecesPlayer;
     public int gamemode;
     private SingleScorePanel ssp;
     private ScorePanel sp;
     private StartPanel startpanel;
     private Gameloop gl;
     private Game g;
     private GamePlayer g1;
    


    
     public GamePanel(Game g, GamePlayer g2, JFrame f, StartPanel startpanel) {
         this.gamemode = 0;
         this.g = g;
         this.g1 = g2;
        
         this.startpanel = startpanel;
        
         this.sp = new ScorePanel();
        
         this.gl = new Gameloop(g, g2, g.getMap(), g2.getMapPlayer(), this, f);
        
         try {
             this.wallpaper = ImageIO.read(getClass().getResource("/resources/wallpaper.jpg"));
             Image icon = this.wallpaper.getScaledInstance(1000, 650, 4);
             this.wallpaper = icon;
             } catch (IOException e) {
            
             e.printStackTrace();
             }
        
         this.icons = new ArrayList<>();
        
         this.nextPiecesAI = new ArrayList<>();
         this.nextPiecesPlayer = new ArrayList<>();
        
         loadIcons();
        
         this.nextPieceAIPanel = new JPanel();
         this.nextPiecePlayerPanel = new JPanel();
        
         this.nextPieceAIPanel.setBackground(Color.BLACK);
         this.nextPiecePlayerPanel.setBackground(Color.BLACK);
        
         this.nextPieceAIPanel.setLayout(new BoxLayout(this.nextPieceAIPanel, 3));
         this.nextPiecePlayerPanel.setLayout(new BoxLayout(this.nextPiecePlayerPanel, 3));
        
         this.nextPieceAIPanel.setPreferredSize(new Dimension(50, 200));
         this.nextPiecePlayerPanel.setPreferredSize(new Dimension(50, 200));
        
         for (int i = 0; i < 5; i++) {
            
             this.nextPiecesAI.add(new JLabel());
            
             this.nextPiecesPlayer.add(new JLabel());
            
             this.nextPieceAIPanel.add(this.nextPiecesAI.get(i), 0);
             this.nextPiecePlayerPanel.add(this.nextPiecesPlayer.get(i), 0);
             this.nextPieceAIPanel.add(Box.createRigidArea(new Dimension(5, 10)), 0);
             this.nextPiecePlayerPanel.add(Box.createRigidArea(new Dimension(5, 10)), 0);
             }
        
         g.getMap().setPreferredSize(new Dimension(301, 601));
        
        
         g2.getMapPlayer().setPreferredSize(new Dimension(301, 601));
        
        
        
         add((Component) g.getMap());
         add(this.nextPieceAIPanel);
         add(this.sp);
         add(this.nextPiecePlayerPanel);
         add((Component) g2.getMapPlayer());
        
        
         Thread t1 = new Thread((Runnable) g);
         Thread t2 = new Thread((Runnable) g2);
        
         fillNextPieces(0, 0);
         fillNextPieces(1, 0);
        
         t1.start();
         t2.start();
         }

    
    
    
     public GamePanel(GamePlayer g2, JFrame f, StartPanel startpanel) {
         this.gamemode = 1;
         this.g1 = g2;
        
         this.startpanel = startpanel;
        
         this.ssp = new SingleScorePanel();
        
         this.gl = new Gameloop(g2, g2.getMapPlayer(), this, f);
        
         try {
             this.wallpaper = ImageIO.read(getClass().getResource("/resources/wallpaper.jpg"));
             Image icon = this.wallpaper.getScaledInstance(600, 650, 4);
             this.wallpaper = icon;
             } catch (IOException e) {
            
             e.printStackTrace();
             }
        
         this.icons = new ArrayList<>();
        
         this.nextPiecesPlayer = new ArrayList<>();
        
         loadIcons();
        
         this.nextPiecePlayerPanel = new JPanel();
        
         this.nextPiecePlayerPanel.setBackground(Color.BLACK);
        
         this.nextPiecePlayerPanel.setLayout(new BoxLayout(this.nextPiecePlayerPanel, 3));
        
         this.nextPiecePlayerPanel.setPreferredSize(new Dimension(50, 200));
        
         for (int i = 0; i < 5; i++) {
            
            
             this.nextPiecesPlayer.add(new JLabel());
            
            
             this.nextPiecePlayerPanel.add(this.nextPiecesPlayer.get(i), 0);
            
             this.nextPiecePlayerPanel.add(Box.createRigidArea(new Dimension(5, 10)), 0);
             }
        
        
         g2.getMapPlayer().setPreferredSize(new Dimension(301, 601));
        
         add(this.ssp);
         add(this.nextPiecePlayerPanel);
         add((Component) g2.getMapPlayer());
        
         Thread t2 = new Thread((Runnable) g2);
        
         fillNextPieces(1, 0);
        
         t2.start();
         }

    
    
    
     private void loadIcons() {
         String[] iconsname = { "IblockIcon.png", "OblockIcon.png", "JblockIcon.png", "LblockIcon.png",
                "SblockIcon.png", "TblockIcon.png", "ZblockIcon.png" };
        
        
         for (int i = 0; i < 7; i++) {
            
             try {
                 Image img = ImageIO.read(getClass().getResource("/resources/BlocksIcons/" + iconsname[i]));
                 img = scaleIcon(img, iconsname[i]);
                 this.icons.add(img);
                 } catch (IOException e) {
                
                 e.printStackTrace();
                 }
             }
         }

    
    
    
     public void paintComponent(Graphics g) {
         super.paintComponent(g);
        
         switch (this.gamemode) {
             case 0:
                 g.drawImage(this.wallpaper, 0, 0, 1000, 650, null);
                 break;
             case 1:
                 g.drawImage(this.wallpaper, 0, 0, 600, 650, null);
                 break;
             }
         }

    
    
    
     public Image scaleIcon(Image img, String s) {
         Image icon = null;
         String str;
         switch ((str = s).hashCode()) {
            case -2116524275:
                if (!str.equals("TblockIcon.png")) {
                     break;
                     }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                 icon = img.getScaledInstance(50, 32, 4);
                break;
            case -1610965650:
                if (!str.equals("SblockIcon.png"))
                     break;
                icon = img.getScaledInstance(50, 35, 4);
                break;
            case -1355905321:
                if (!str.equals("JblockIcon.png"))
                     break;
                icon = img.getScaledInstance(50, 33, 4);
                break;
            case -854908729:
                if (!str.equals("ZblockIcon.png"))
                     break;
                icon = img.getScaledInstance(50, 35, 4);
                break;
            case -850346696:
                if (!str.equals("IblockIcon.png"))
                     break;
                icon = img.getScaledInstance(50, 12, 4);
                break;
            case 411268850:
                if (!str.equals("OblockIcon.png"))
                     break;
                icon = img.getScaledInstance(30, 30, 4);
                break;
            case 1927944725:
                if (!str.equals("LblockIcon.png"))
                     break;
                icon = img.getScaledInstance(50, 33, 4);
                break;
        }
        return icon;
         }

    
     public void switchIcons(int type, int j, int n) {
         if (type == 0) {
             switch (n) {
                 case 1:
                     ((JLabel) this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(0)));
                     break;
                 case 2:
                     ((JLabel) this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(2)));
                     break;
                 case 3:
                     ((JLabel) this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(3)));
                     break;
                 case 4:
                     ((JLabel) this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(1)));
                     break;
                 case 5:
                     ((JLabel) this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(4)));
                     break;
                 case 6:
                     ((JLabel) this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(5)));
                     break;
                 case 7:
                     ((JLabel) this.nextPiecesAI.get(j)).setIcon(new ImageIcon(this.icons.get(6)));
                     break;
                 }
            
             } else if (type == 1) {
            
             switch (n) {
                 case 1:
                     ((JLabel) this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(0)));
                     break;
                 case 2:
                     ((JLabel) this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(2)));
                     break;
                 case 3:
                     ((JLabel) this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(3)));
                     break;
                 case 4:
                     ((JLabel) this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(1)));
                     break;
                 case 5:
                     ((JLabel) this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(4)));
                     break;
                 case 6:
                     ((JLabel) this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(5)));
                     break;
                 case 7:
                     ((JLabel) this.nextPiecesPlayer.get(j)).setIcon(new ImageIcon(this.icons.get(6)));
                     break;
                 }
             }
         }

    
    
     public void fillNextPieces(int type, int index) {
         int j = 0;
         for (int i = index + 1; i < index + 5; i++) {
            
             if (index == 0) {
                
                 switchIcons(type, j, ((Integer) this.gl.allPiecesQueue.get(0)).intValue());
                
                 break;
                 }
             switchIcons(type, j, ((Integer) this.gl.allPiecesQueue.get(i)).intValue());
             j++;
             if (type == 0) {
                 this.nextPieceAIPanel.revalidate();
                 } else {
                 this.nextPiecePlayerPanel.revalidate();
                 }
             }
         }

     public Gameloop getLoop() {
         return this.gl;
         }

    
     public Game getAI() {
         return this.g;
         }

    
     public GamePlayer getPlayer() {
         return this.g1;
         }

    
     public SingleScorePanel getSingleScorePanel() {
         return this.ssp;
         }

    
     public ScorePanel getScorePanel() {
         return this.sp;
         }

    
     public StartPanel getStartPanel() {
         return this.startpanel;
         }

    
     public void deleteLoop() {
         this.gl = null;
         }
  }

    
