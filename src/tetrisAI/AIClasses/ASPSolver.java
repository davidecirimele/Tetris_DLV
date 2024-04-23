 package tetrisAI.AIClasses;
 import it.unical.mat.embasp.base.Handler;
 import it.unical.mat.embasp.base.InputProgram;
 import it.unical.mat.embasp.base.Output;
 import it.unical.mat.embasp.languages.ObjectNotValidException;
 import it.unical.mat.embasp.languages.asp.ASPInputProgram;
 import it.unical.mat.embasp.languages.asp.ASPMapper;
 import it.unical.mat.embasp.languages.asp.AnswerSet;
 import it.unical.mat.embasp.languages.asp.AnswerSets;
 import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
 import it.unical.mat.embasp.platforms.desktop.DesktopService;
 import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;
 import java.io.File;
 import java.io.IOException;
 import tetrisAI.AIBlocks.iBlock;
import tetrisAI.AIBlocks.jBlock;
 import tetrisAI.AIBlocks.lBlock;
 import tetrisAI.AIBlocks.oBlock;
import tetrisAI.AIBlocks.sBlock;
import tetrisAI.AIBlocks.tBlock;
import tetrisAI.AIBlocks.zBlock;
 import tetrisAI.BlockBeans.iBlockBean;
 import tetrisAI.BlockBeans.jBlockBean;
 import tetrisAI.BlockBeans.lBlockBean;
 import tetrisAI.BlockBeans.oBlockBean;
 import tetrisAI.BlockBeans.sBlockBean;
 import tetrisAI.BlockBeans.tBlockBean;
 import tetrisAI.BlockBeans.zBlockBean;
 import tetrisAI.InserisciBlocks.inserisciIBlock;
 import tetrisAI.InserisciBlocks.inserisciJBlock;
 import tetrisAI.InserisciBlocks.inserisciLBlock;
 import tetrisAI.InserisciBlocks.inserisciOBlock;
 import tetrisAI.InserisciBlocks.inserisciPezzo;
 import tetrisAI.InserisciBlocks.inserisciSBlock;
 import tetrisAI.InserisciBlocks.inserisciTBlock;
 import tetrisAI.InserisciBlocks.inserisciZBlock;
 import tetrisAI.InserisciBlocks.movePiece;
 
 public class ASPSolver {
   private String encodingResource = "encodings/tetris";
   private Handler handler;
   private InputProgram currMatrix;
   private InputProgram variablecurrMatrix;
   private Map map;
   private inserisciPezzo position;
   private int movement = 0;
 
   
   private Game game;
   
   private int speed;
 
   
   public ASPSolver() {
     if (System.getProperty("os.name").equals("Mac OS X")) {
 
       
       try {
         this.handler = (Handler)new DesktopHandler((DesktopService)new DLV2DesktopService((new File("lib/dlv2-mac")).getCanonicalPath()));
       } catch (IOException e) {
         
         e.printStackTrace();
       } 
 
       
       System.out.println("Sistema operativo Mac OS");
     }
     else if (System.getProperty("os.name").equals("Windows 10")) {
       
       try {
         this.handler = (Handler)new DesktopHandler((DesktopService)new DLV2DesktopService((new File("lib/dlv2.exe")).getCanonicalPath()));
       } catch (IOException e) {
         
         e.printStackTrace();
       } 
       
       System.out.println("Sistema operativo Windows 10");
     } else {
       
       System.out.println("Errore, sistema operativo non riconosciuto con IDLV");
     } 
 
 
     
     try {
       ASPMapper.getInstance().registerClass(Cell.class);
       ASPMapper.getInstance().registerClass(Piece.class);
       ASPMapper.getInstance().registerClass(iBlockBean.class);
       ASPMapper.getInstance().registerClass(jBlockBean.class);
       ASPMapper.getInstance().registerClass(lBlockBean.class);
       ASPMapper.getInstance().registerClass(oBlockBean.class);
       ASPMapper.getInstance().registerClass(sBlockBean.class);
       ASPMapper.getInstance().registerClass(tBlockBean.class);
       ASPMapper.getInstance().registerClass(zBlockBean.class);
       ASPMapper.getInstance().registerClass(inserisciIBlock.class);
       ASPMapper.getInstance().registerClass(inserisciJBlock.class);
       ASPMapper.getInstance().registerClass(inserisciLBlock.class);
       ASPMapper.getInstance().registerClass(inserisciOBlock.class);
       ASPMapper.getInstance().registerClass(inserisciSBlock.class);
       ASPMapper.getInstance().registerClass(inserisciTBlock.class);
       ASPMapper.getInstance().registerClass(inserisciZBlock.class);
       ASPMapper.getInstance().registerClass(movePiece.class);
     
     }
     catch (ObjectNotValidException|it.unical.mat.embasp.languages.IllegalAnnotationException e1) {
       e1.printStackTrace();
     } 
     
     this.currMatrix = (InputProgram)new ASPInputProgram();
     this.variablecurrMatrix = (InputProgram)new ASPInputProgram();
     
     for (int i = 0; i < 20; i++) {
       for (int j = 0; j < 10; j++) {
         try {
           this.currMatrix.addObjectInput(new Cell(i, j, 0));
         } catch (Exception e) {
           
           e.printStackTrace();
         } 
       } 
     } 
     this.handler.addProgram(this.currMatrix);
     System.out.println(this.currMatrix.getPrograms());
 
 
     
     ASPInputProgram aSPInputProgram = new ASPInputProgram();
     try {
       aSPInputProgram.addFilesPath((new File(this.encodingResource)).getCanonicalPath());
     } catch (IOException e) {
       
       e.printStackTrace();
     } 
     this.handler.addProgram((InputProgram)aSPInputProgram);
   }
 
 
   
   public void addPiece(Piece currPiece, Map map, Game game) {
     this.variablecurrMatrix.clearAll();
     
     if (this.game == null) {
       this.game = game;
     }
     int X1 = currPiece.getPiece()[0].getRow();
     int X2 = currPiece.getPiece()[1].getRow();
     int X3 = currPiece.getPiece()[2].getRow();
     int X4 = currPiece.getPiece()[3].getRow();
     int Y1 = currPiece.getPiece()[0].getColumn();
     int Y2 = currPiece.getPiece()[1].getColumn();
     int Y3 = currPiece.getPiece()[2].getColumn();
     int Y4 = currPiece.getPiece()[3].getColumn();
     
     if (currPiece instanceof iBlock) {
       int v = ((iBlock)currPiece).getValue();
       iBlockBean ibb = new iBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
       try {
         this.variablecurrMatrix.addObjectInput(ibb);
       } catch (Exception e) {
         
         e.printStackTrace();
       }
     
     }
     else if (currPiece instanceof jBlock) {
       int v = ((jBlock)currPiece).getValue();
       jBlockBean jbb = new jBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
       
       try {
         this.variablecurrMatrix.addObjectInput(jbb);
       }
       catch (Exception e) {
         
         e.printStackTrace();
       }
     
     }
     else if (currPiece instanceof lBlock) {
       int v = ((lBlock)currPiece).getValue();
       lBlockBean lbb = new lBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
       
       try {
         this.variablecurrMatrix.addObjectInput(lbb);
       }
       catch (Exception e) {
         
         e.printStackTrace();
       
       }
     
     }
     else if (currPiece instanceof oBlock) {
       int v = ((oBlock)currPiece).getValue();
       oBlockBean obb = new oBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
       
       try {
         this.variablecurrMatrix.addObjectInput(obb);
       }
       catch (Exception e) {
         
         e.printStackTrace();
       
       }
     
     }
     else if (currPiece instanceof sBlock) {
       int v = ((sBlock)currPiece).getValue();
       sBlockBean sbb = new sBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
       
       try {
         this.variablecurrMatrix.addObjectInput(sbb);
       }
       catch (Exception e) {
         
         e.printStackTrace();
       
       }
     
     }
     else if (currPiece instanceof tBlock) {
       int v = ((tBlock)currPiece).getValue();
       tBlockBean tbb = new tBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
       
       try {
         this.variablecurrMatrix.addObjectInput(tbb);
       }
       catch (Exception e) {
         
         e.printStackTrace();
       
       }
     
     }
     else if (currPiece instanceof zBlock) {
       int v = ((zBlock)currPiece).getValue();
       zBlockBean zbb = new zBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
       
       try {
         this.variablecurrMatrix.addObjectInput(zbb);
       }
       catch (Exception e) {
         
         e.printStackTrace();
       } 
     } 
     
     this.handler.addProgram(this.variablecurrMatrix);
     updateMovement(currPiece, map);
   }
 
 
   
   public void updateMovement(Piece currPiece, Map map) {
     Output output = this.handler.startSync();
     
     AnswerSets answers = (AnswerSets)output;
     
     for (AnswerSet a : answers.getOptimalAnswerSets()) {
       
       for (String elem : a.getAnswerSet()) {
         if (elem.contains("speedPiece")) {
           String speedstring = elem.replaceAll("[^0-9]", "");
           this.speed = Integer.parseInt(speedstring);
         } 
       }  try {
         for (Object obj : a.getAtoms()) {
           this.movement = 0;
           for (Object obj2 : a.getAtoms()) {
             if (obj2 instanceof movePiece) {
               movePiece m = (movePiece)obj2;
               this.movement = m.getP();
             } 
           } 
           if (obj instanceof inserisciIBlock) {
             this.position = (inserisciPezzo)obj;
             move(currPiece, this.position, map, this.movement);
             continue;
           } 
           if (obj instanceof inserisciJBlock) {
             this.position = (inserisciPezzo)obj;
             move(currPiece, this.position, map, this.movement);
             continue;
           } 
           if (obj instanceof inserisciLBlock) {
             this.position = (inserisciPezzo)obj;
             move(currPiece, this.position, map, this.movement);
             continue;
           } 
           if (obj instanceof inserisciOBlock) {
             this.position = (inserisciPezzo)obj;
             move(currPiece, this.position, map, this.movement);
             continue;
           } 
           if (obj instanceof inserisciSBlock) {
             this.position = (inserisciPezzo)obj;
             move(currPiece, this.position, map, this.movement);
             continue;
           } 
           if (obj instanceof inserisciTBlock) {
             this.position = (inserisciPezzo)obj;
             move(currPiece, this.position, map, this.movement);
             continue;
           } 
           if (obj instanceof inserisciZBlock) {
             this.position = (inserisciPezzo)obj;
             move(currPiece, this.position, map, this.movement);
           
           }
 
         
         }
 
       
       }
       catch (Exception e) {
         e.printStackTrace();
       } 
     } 
   }
 
 
 
   
   public void move(Piece currPiece, inserisciPezzo position, Map map, int movement) {
     switch (this.speed) {
       case 1:
         this.game.getLoop().setSleepTime(50);
         break;
       case 2:
         this.game.getLoop().setSleepTime(30);
         break;
       default:
         this.game.getLoop().setSleepTime(15);
         break;
     } 
     
     if (!this.game.checkScrollCondition(map, currPiece)) {
       if (movement == 2 && currPiece.canMoveRight(map)) {
         for (int i = 0; i < 4; i++) {
           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[i].getRow(), currPiece.getPiece()[i].getColumn(), 0);
           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
         } 
       }
       if (movement == 1 && currPiece.canMoveLeft(map)) {
         for (int i = 0; i < 4; i++) {
           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[i].getRow(), currPiece.getPiece()[i].getColumn(), 0);
           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
         } 
       }
     } 
 
     
     if (position instanceof inserisciIBlock) {
       if (currPiece.isMoving) {
         
         if (currPiece.getPiece()[0].getRow() > 1 && 
           !currPiece.getState()[((inserisciIBlock)position).getV()]) {
           currPiece.Rotate(map);
           currPiece.setState(true, ((inserisciIBlock)position).getV());
         } 
 
         
         if (currPiece.canMoveLeft(map) && ((inserisciIBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
           
           }
         }
         else if (currPiece.canMoveRight(map) && ((inserisciIBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
           
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
           }
         } 
       } else {
         return;
       } 
     }
 
 
 
 
 
     
     if (position instanceof inserisciJBlock) {
       if (currPiece.isMoving) {
         if (currPiece.getPiece()[0].getRow() > 1) {
           while (!currPiece.getState()[((inserisciJBlock)position).getV()]) {
             currPiece.Rotate(map);
           }
           
           currPiece.setState(true, ((inserisciJBlock)position).getV());
         } 
         
         if (currPiece.canMoveLeft(map) && ((inserisciJBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
           
           }
         }
         else if (currPiece.canMoveRight(map) && ((inserisciJBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
           
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
           }
         } 
       } 
 
       
       if (this.game.checkScrollCondition(map, currPiece)) {
         return;
       }
     } 
 
 
 
 
 
 
     
     if (position instanceof inserisciLBlock) {
       if (currPiece.isMoving) {
         if (currPiece.getPiece()[0].getRow() > 1) {
           while (!currPiece.getState()[((inserisciLBlock)position).getV()]) {
             currPiece.Rotate(map);
           }
           
           currPiece.setState(true, ((inserisciLBlock)position).getV());
         } 
         
         if (currPiece.canMoveLeft(map) && ((inserisciLBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
           
           }
         }
         else if (currPiece.canMoveRight(map) && ((inserisciLBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
           
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
           }
         } 
       } 
 
       
       if (this.game.checkScrollCondition(map, currPiece)) {
         return;
       }
     } 
 
 
 
 
 
     
     if (position instanceof inserisciOBlock) {
       if (currPiece.isMoving) {
         if (currPiece.canMoveLeft(map) && ((inserisciOBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
           
           }
         }
         else if (currPiece.canMoveRight(map) && ((inserisciOBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
           
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
           }
         } 
       } else {
         return;
       } 
     }
 
 
 
 
 
     
     if (position instanceof inserisciSBlock) {
       
       if (currPiece.isMoving) {
         if (currPiece.getPiece()[0].getRow() > 1) {
           while (!currPiece.getState()[((inserisciSBlock)position).getV()]) {
             currPiece.Rotate(map);
           }
           
           currPiece.setState(true, ((inserisciSBlock)position).getV());
         } 
 
         
         if (currPiece.canMoveLeft(map) && ((inserisciSBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
           
           }
         }
         else if (currPiece.canMoveRight(map) && ((inserisciSBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
           
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
           }
         } 
       } 
 
       
       if (this.game.checkScrollCondition(map, currPiece)) {
         return;
       }
     } 
 
 
 
 
 
 
     
     if (position instanceof inserisciTBlock) {
       if (currPiece.isMoving) {
         if (currPiece.getPiece()[0].getRow() > 1) {
           while (!currPiece.getState()[((inserisciTBlock)position).getV()]) {
             currPiece.Rotate(map);
           }
           
           currPiece.setState(true, ((inserisciTBlock)position).getV());
         } 
         
         if (currPiece.canMoveLeft(map) && ((inserisciTBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
           
           }
         }
         else if (currPiece.canMoveRight(map) && ((inserisciTBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
           
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
           }
         } 
       } 
 
       
       if (!this.game.checkScrollCondition(map, currPiece)) {
         return;
       }
     } 
 
 
 
 
 
 
 
 
     
     if (position instanceof inserisciZBlock) {
       if (currPiece.isMoving) {
         if (currPiece.getPiece()[0].getRow() > 1) {
           while (!currPiece.getState()[((inserisciZBlock)position).getV()]) {
             currPiece.Rotate(map);
           }
           
           currPiece.setState(true, ((inserisciZBlock)position).getV());
         } 
         
         if (currPiece.canMoveLeft(map) && ((inserisciZBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
           
           }
         }
         else if (currPiece.canMoveRight(map) && ((inserisciZBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
           
           for (int i = 0; i < 4; i++) {
             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
           }
         } 
       } 
 
 
 
       
       if (this.game.checkScrollCondition(map, currPiece)) {
         return;
       }
     } 
   }
 
 
 
 
 
 
 
   
   public void updateAspCells(Map map) {
     this.currMatrix.clearAll();
     
     for (int i = 0; i < 20; i++) {
       for (int j = 0; j < 10; j++) {
         int value = map.getMatrix()[i][j].getValue();
         try {
           this.currMatrix.addObjectInput(new Cell(i, j, value));
         } catch (Exception e) {
           
           e.printStackTrace();
         } 
       } 
     } 
   }
 
 
 
 
 
   
   public void fitPieces(Map map, Piece currPiece) {
     if (currPiece.canMoveRight(map))
     {
       
       if (map.getMatrix()[currPiece.getPiece()[0].getRow()][currPiece.getPiece()[0].getColumn() + 1].getValue() == 0 && 
         map.getMatrix()[currPiece.getPiece()[0].getRow() + 1][currPiece.getPiece()[0].getColumn() + 1].getValue() != 0) {
         
         for (int i = 0; i < 4; i++) {
           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
         }
       
       }
       else if (map.getMatrix()[currPiece.getPiece()[1].getRow()][currPiece.getPiece()[1].getColumn() + 1].getValue() == 0 && 
         map.getMatrix()[currPiece.getPiece()[1].getRow() + 1][currPiece.getPiece()[1].getColumn() + 1].getValue() != 0) {
         
         for (int i = 0; i < 4; i++) {
           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
 
         
         }
 
       
       }
       else if (map.getMatrix()[currPiece.getPiece()[2].getRow()][currPiece.getPiece()[2].getColumn() + 1].getValue() == 0 && 
         map.getMatrix()[currPiece.getPiece()[2].getRow() + 1][currPiece.getPiece()[2].getColumn() + 1].getValue() != 0) {
         
         for (int i = 0; i < 4; i++) {
           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
         }
       
       }
       else if (map.getMatrix()[currPiece.getPiece()[3].getRow()][currPiece.getPiece()[3].getColumn() + 1].getValue() == 0 && 
         map.getMatrix()[currPiece.getPiece()[3].getRow() + 1][currPiece.getPiece()[3].getColumn() + 1].getValue() != 0) {
         
         for (int i = 0; i < 4; i++) {
           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
         } 
       } 
     }
 
     
     if (currPiece.canMoveLeft(map)) {
       if (map.getMatrix()[currPiece.getPiece()[0].getRow()][currPiece.getPiece()[0].getColumn() - 1].getValue() == 0 && 
         map.getMatrix()[currPiece.getPiece()[0].getRow() + 1][currPiece.getPiece()[0].getColumn() - 1].getValue() != 0) {
         
         for (int i = 0; i < 4; i++) {
           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
         }
       
       }
       else if (map.getMatrix()[currPiece.getPiece()[1].getRow()][currPiece.getPiece()[1].getColumn() - 1].getValue() == 0 && 
         map.getMatrix()[currPiece.getPiece()[1].getRow() + 1][currPiece.getPiece()[1].getColumn() - 1].getValue() != 0) {
         
         for (int i = 0; i < 4; i++) {
           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
 
         
         }
 
       
       }
       else if (map.getMatrix()[currPiece.getPiece()[2].getRow()][currPiece.getPiece()[2].getColumn() - 1].getValue() == 0 && 
         map.getMatrix()[currPiece.getPiece()[2].getRow() + 1][currPiece.getPiece()[2].getColumn() - 1].getValue() != 0) {
         
         for (int i = 0; i < 4; i++) {
           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
         }
       
       }
       else if (map.getMatrix()[currPiece.getPiece()[3].getRow()][currPiece.getPiece()[3].getColumn() - 1].getValue() == 0 && 
         map.getMatrix()[currPiece.getPiece()[3].getRow() + 1][currPiece.getPiece()[3].getColumn() - 1].getValue() != 0) {
         
         for (int i = 0; i < 4; i++) {
           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
         } 
       } 
     }
   }
 
   
   public void updateMovement2(Piece currPiece, Map map) {
     if (currPiece != null)
       move(currPiece, this.position, map, this.movement); 
   }
 }

