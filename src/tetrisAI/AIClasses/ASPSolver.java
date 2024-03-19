/*     */ package tetrisAI.AIClasses;
/*     */ import it.unical.mat.embasp.base.Handler;
/*     */ import it.unical.mat.embasp.base.InputProgram;
/*     */ import it.unical.mat.embasp.base.Output;
/*     */ import it.unical.mat.embasp.languages.ObjectNotValidException;
/*     */ import it.unical.mat.embasp.languages.asp.ASPInputProgram;
/*     */ import it.unical.mat.embasp.languages.asp.ASPMapper;
/*     */ import it.unical.mat.embasp.languages.asp.AnswerSet;
/*     */ import it.unical.mat.embasp.languages.asp.AnswerSets;
/*     */ import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
/*     */ import it.unical.mat.embasp.platforms.desktop.DesktopService;
/*     */ import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import tetrisAI.AIBlocks.iBlock;
import tetrisAI.AIBlocks.jBlock;
/*     */ import tetrisAI.AIBlocks.lBlock;
/*     */ import tetrisAI.AIBlocks.oBlock;
import tetrisAI.AIBlocks.sBlock;
import tetrisAI.AIBlocks.tBlock;
import tetrisAI.AIBlocks.zBlock;
/*     */ import tetrisAI.BlockBeans.iBlockBean;
/*     */ import tetrisAI.BlockBeans.jBlockBean;
/*     */ import tetrisAI.BlockBeans.lBlockBean;
/*     */ import tetrisAI.BlockBeans.oBlockBean;
/*     */ import tetrisAI.BlockBeans.sBlockBean;
/*     */ import tetrisAI.BlockBeans.tBlockBean;
/*     */ import tetrisAI.BlockBeans.zBlockBean;
/*     */ import tetrisAI.InserisciBlocks.inserisciIBlock;
/*     */ import tetrisAI.InserisciBlocks.inserisciJBlock;
/*     */ import tetrisAI.InserisciBlocks.inserisciLBlock;
/*     */ import tetrisAI.InserisciBlocks.inserisciOBlock;
/*     */ import tetrisAI.InserisciBlocks.inserisciPezzo;
/*     */ import tetrisAI.InserisciBlocks.inserisciSBlock;
/*     */ import tetrisAI.InserisciBlocks.inserisciTBlock;
/*     */ import tetrisAI.InserisciBlocks.inserisciZBlock;
/*     */ import tetrisAI.InserisciBlocks.movePiece;
/*     */ 
/*     */ public class ASPSolver {
/*  36 */   private String encodingResource = "encodings/tetris";
/*     */   private Handler handler;
/*     */   private InputProgram currMatrix;
/*     */   private InputProgram variablecurrMatrix;
/*     */   private Map map;
/*     */   private inserisciPezzo position;
/*  42 */   private int movement = 0;
/*     */ 
/*     */   
/*     */   private Game game;
/*     */   
/*     */   private int speed;
/*     */ 
/*     */   
/*     */   public ASPSolver() {
/*  51 */     if (System.getProperty("os.name").equals("Mac OS X")) {
/*     */ 
/*     */       
/*     */       try {
/*  55 */         this.handler = (Handler)new DesktopHandler((DesktopService)new DLV2DesktopService((new File("lib/dlv2-mac")).getCanonicalPath()));
/*  56 */       } catch (IOException e) {
/*     */         
/*  58 */         e.printStackTrace();
/*     */       } 
/*     */ 
/*     */       
/*  62 */       System.out.println("Sistema operativo Mac OS");
/*     */     }
/*  64 */     else if (System.getProperty("os.name").equals("Windows 10")) {
/*     */       
/*     */       try {
/*  67 */         this.handler = (Handler)new DesktopHandler((DesktopService)new DLV2DesktopService((new File("lib/dlv2.exe")).getCanonicalPath()));
/*  68 */       } catch (IOException e) {
/*     */         
/*  70 */         e.printStackTrace();
/*     */       } 
/*     */       
/*  73 */       System.out.println("Sistema operativo Windows 10");
/*     */     } else {
/*     */       
/*  76 */       System.out.println("Errore, sistema operativo non riconosciuto con IDLV");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  82 */       ASPMapper.getInstance().registerClass(Cell.class);
/*  83 */       ASPMapper.getInstance().registerClass(Piece.class);
/*  84 */       ASPMapper.getInstance().registerClass(iBlockBean.class);
/*  85 */       ASPMapper.getInstance().registerClass(jBlockBean.class);
/*  86 */       ASPMapper.getInstance().registerClass(lBlockBean.class);
/*  87 */       ASPMapper.getInstance().registerClass(oBlockBean.class);
/*  88 */       ASPMapper.getInstance().registerClass(sBlockBean.class);
/*  89 */       ASPMapper.getInstance().registerClass(tBlockBean.class);
/*  90 */       ASPMapper.getInstance().registerClass(zBlockBean.class);
/*  91 */       ASPMapper.getInstance().registerClass(inserisciIBlock.class);
/*  92 */       ASPMapper.getInstance().registerClass(inserisciJBlock.class);
/*  93 */       ASPMapper.getInstance().registerClass(inserisciLBlock.class);
/*  94 */       ASPMapper.getInstance().registerClass(inserisciOBlock.class);
/*  95 */       ASPMapper.getInstance().registerClass(inserisciSBlock.class);
/*  96 */       ASPMapper.getInstance().registerClass(inserisciTBlock.class);
/*  97 */       ASPMapper.getInstance().registerClass(inserisciZBlock.class);
/*  98 */       ASPMapper.getInstance().registerClass(movePiece.class);
/*     */     
/*     */     }
/* 101 */     catch (ObjectNotValidException|it.unical.mat.embasp.languages.IllegalAnnotationException e1) {
/* 102 */       e1.printStackTrace();
/*     */     } 
/*     */     
/* 105 */     this.currMatrix = (InputProgram)new ASPInputProgram();
/* 106 */     this.variablecurrMatrix = (InputProgram)new ASPInputProgram();
/*     */     
/* 108 */     for (int i = 0; i < 20; i++) {
/* 109 */       for (int j = 0; j < 10; j++) {
/*     */         try {
/* 111 */           this.currMatrix.addObjectInput(new Cell(i, j, 0));
/* 112 */         } catch (Exception e) {
/*     */           
/* 114 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/*     */     } 
/* 118 */     this.handler.addProgram(this.currMatrix);
/* 119 */     System.out.println(this.currMatrix.getPrograms());
/*     */ 
/*     */ 
/*     */     
/* 123 */     ASPInputProgram aSPInputProgram = new ASPInputProgram();
/*     */     try {
/* 125 */       aSPInputProgram.addFilesPath((new File(this.encodingResource)).getCanonicalPath());
/* 126 */     } catch (IOException e) {
/*     */       
/* 128 */       e.printStackTrace();
/*     */     } 
/* 130 */     this.handler.addProgram((InputProgram)aSPInputProgram);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPiece(Piece currPiece, Map map, Game game) {
/* 136 */     this.variablecurrMatrix.clearAll();
/*     */     
/* 138 */     if (this.game == null) {
/* 139 */       this.game = game;
/*     */     }
/* 141 */     int X1 = currPiece.getPiece()[0].getRow();
/* 142 */     int X2 = currPiece.getPiece()[1].getRow();
/* 143 */     int X3 = currPiece.getPiece()[2].getRow();
/* 144 */     int X4 = currPiece.getPiece()[3].getRow();
/* 145 */     int Y1 = currPiece.getPiece()[0].getColumn();
/* 146 */     int Y2 = currPiece.getPiece()[1].getColumn();
/* 147 */     int Y3 = currPiece.getPiece()[2].getColumn();
/* 148 */     int Y4 = currPiece.getPiece()[3].getColumn();
/*     */     
/* 150 */     if (currPiece instanceof iBlock) {
/* 151 */       int v = ((iBlock)currPiece).getValue();
/* 152 */       iBlockBean ibb = new iBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
/*     */       try {
/* 154 */         this.variablecurrMatrix.addObjectInput(ibb);
/* 155 */       } catch (Exception e) {
/*     */         
/* 157 */         e.printStackTrace();
/*     */       }
/*     */     
/*     */     }
/* 161 */     else if (currPiece instanceof jBlock) {
/* 162 */       int v = ((jBlock)currPiece).getValue();
/* 163 */       jBlockBean jbb = new jBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
/*     */       
/*     */       try {
/* 166 */         this.variablecurrMatrix.addObjectInput(jbb);
/*     */       }
/* 168 */       catch (Exception e) {
/*     */         
/* 170 */         e.printStackTrace();
/*     */       }
/*     */     
/*     */     }
/* 174 */     else if (currPiece instanceof lBlock) {
/* 175 */       int v = ((lBlock)currPiece).getValue();
/* 176 */       lBlockBean lbb = new lBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
/*     */       
/*     */       try {
/* 179 */         this.variablecurrMatrix.addObjectInput(lbb);
/*     */       }
/* 181 */       catch (Exception e) {
/*     */         
/* 183 */         e.printStackTrace();
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 188 */     else if (currPiece instanceof oBlock) {
/* 189 */       int v = ((oBlock)currPiece).getValue();
/* 190 */       oBlockBean obb = new oBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
/*     */       
/*     */       try {
/* 193 */         this.variablecurrMatrix.addObjectInput(obb);
/*     */       }
/* 195 */       catch (Exception e) {
/*     */         
/* 197 */         e.printStackTrace();
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 202 */     else if (currPiece instanceof sBlock) {
/* 203 */       int v = ((sBlock)currPiece).getValue();
/* 204 */       sBlockBean sbb = new sBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
/*     */       
/*     */       try {
/* 207 */         this.variablecurrMatrix.addObjectInput(sbb);
/*     */       }
/* 209 */       catch (Exception e) {
/*     */         
/* 211 */         e.printStackTrace();
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 216 */     else if (currPiece instanceof tBlock) {
/* 217 */       int v = ((tBlock)currPiece).getValue();
/* 218 */       tBlockBean tbb = new tBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
/*     */       
/*     */       try {
/* 221 */         this.variablecurrMatrix.addObjectInput(tbb);
/*     */       }
/* 223 */       catch (Exception e) {
/*     */         
/* 225 */         e.printStackTrace();
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 230 */     else if (currPiece instanceof zBlock) {
/* 231 */       int v = ((zBlock)currPiece).getValue();
/* 232 */       zBlockBean zbb = new zBlockBean(X1, X2, X3, X4, Y1, Y2, Y3, Y4, 0);
/*     */       
/*     */       try {
/* 235 */         this.variablecurrMatrix.addObjectInput(zbb);
/*     */       }
/* 237 */       catch (Exception e) {
/*     */         
/* 239 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 243 */     this.handler.addProgram(this.variablecurrMatrix);
/* 244 */     updateMovement(currPiece, map);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateMovement(Piece currPiece, Map map) {
/* 250 */     Output output = this.handler.startSync();
/*     */     
/* 252 */     AnswerSets answers = (AnswerSets)output;
/*     */     
/* 254 */     for (AnswerSet a : answers.getOptimalAnswerSets()) {
/*     */       
/* 256 */       for (String elem : a.getAnswerSet()) {
/* 257 */         if (elem.contains("speedPiece")) {
/* 258 */           String speedstring = elem.replaceAll("[^0-9]", "");
/* 259 */           this.speed = Integer.parseInt(speedstring);
/*     */         } 
/*     */       }  try {
/* 262 */         for (Object obj : a.getAtoms()) {
/* 263 */           this.movement = 0;
/* 264 */           for (Object obj2 : a.getAtoms()) {
/* 265 */             if (obj2 instanceof movePiece) {
/* 266 */               movePiece m = (movePiece)obj2;
/* 267 */               this.movement = m.getP();
/*     */             } 
/*     */           } 
/* 270 */           if (obj instanceof inserisciIBlock) {
/* 271 */             this.position = (inserisciPezzo)obj;
/* 272 */             move(currPiece, this.position, map, this.movement);
/*     */             continue;
/*     */           } 
/* 275 */           if (obj instanceof inserisciJBlock) {
/* 276 */             this.position = (inserisciPezzo)obj;
/* 277 */             move(currPiece, this.position, map, this.movement);
/*     */             continue;
/*     */           } 
/* 280 */           if (obj instanceof inserisciLBlock) {
/* 281 */             this.position = (inserisciPezzo)obj;
/* 282 */             move(currPiece, this.position, map, this.movement);
/*     */             continue;
/*     */           } 
/* 285 */           if (obj instanceof inserisciOBlock) {
/* 286 */             this.position = (inserisciPezzo)obj;
/* 287 */             move(currPiece, this.position, map, this.movement);
/*     */             continue;
/*     */           } 
/* 290 */           if (obj instanceof inserisciSBlock) {
/* 291 */             this.position = (inserisciPezzo)obj;
/* 292 */             move(currPiece, this.position, map, this.movement);
/*     */             continue;
/*     */           } 
/* 295 */           if (obj instanceof inserisciTBlock) {
/* 296 */             this.position = (inserisciPezzo)obj;
/* 297 */             move(currPiece, this.position, map, this.movement);
/*     */             continue;
/*     */           } 
/* 300 */           if (obj instanceof inserisciZBlock) {
/* 301 */             this.position = (inserisciPezzo)obj;
/* 302 */             move(currPiece, this.position, map, this.movement);
/*     */           
/*     */           }
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/* 311 */       catch (Exception e) {
/* 312 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void move(Piece currPiece, inserisciPezzo position, Map map, int movement) {
/* 321 */     switch (this.speed) {
/*     */       case 1:
/* 323 */         this.game.getLoop().setSleepTime(50);
/*     */         break;
/*     */       case 2:
/* 326 */         this.game.getLoop().setSleepTime(30);
/*     */         break;
/*     */       default:
/* 329 */         this.game.getLoop().setSleepTime(15);
/*     */         break;
/*     */     } 
/*     */     
/* 333 */     if (!this.game.checkScrollCondition(map, currPiece)) {
/* 334 */       if (movement == 2 && currPiece.canMoveRight(map)) {
/* 335 */         for (int i = 0; i < 4; i++) {
/* 336 */           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[i].getRow(), currPiece.getPiece()[i].getColumn(), 0);
/* 337 */           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
/*     */         } 
/*     */       }
/* 340 */       if (movement == 1 && currPiece.canMoveLeft(map)) {
/* 341 */         for (int i = 0; i < 4; i++) {
/* 342 */           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[i].getRow(), currPiece.getPiece()[i].getColumn(), 0);
/* 343 */           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 349 */     if (position instanceof inserisciIBlock) {
/* 350 */       if (currPiece.isMoving) {
/*     */         
/* 352 */         if (currPiece.getPiece()[0].getRow() > 1 && 
/* 353 */           !currPiece.getState()[((inserisciIBlock)position).getV()]) {
/* 354 */           currPiece.Rotate(map);
/* 355 */           currPiece.setState(true, ((inserisciIBlock)position).getV());
/*     */         } 
/*     */ 
/*     */         
/* 359 */         if (currPiece.canMoveLeft(map) && ((inserisciIBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
/* 360 */           for (int i = 0; i < 4; i++) {
/* 361 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
/*     */           
/*     */           }
/*     */         }
/* 365 */         else if (currPiece.canMoveRight(map) && ((inserisciIBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
/*     */           
/* 367 */           for (int i = 0; i < 4; i++) {
/* 368 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
/*     */           }
/*     */         } 
/*     */       } else {
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 381 */     if (position instanceof inserisciJBlock) {
/* 382 */       if (currPiece.isMoving) {
/* 383 */         if (currPiece.getPiece()[0].getRow() > 1) {
/* 384 */           while (!currPiece.getState()[((inserisciJBlock)position).getV()]) {
/* 385 */             currPiece.Rotate(map);
/*     */           }
/*     */           
/* 388 */           currPiece.setState(true, ((inserisciJBlock)position).getV());
/*     */         } 
/*     */         
/* 391 */         if (currPiece.canMoveLeft(map) && ((inserisciJBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
/* 392 */           for (int i = 0; i < 4; i++) {
/* 393 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
/*     */           
/*     */           }
/*     */         }
/* 397 */         else if (currPiece.canMoveRight(map) && ((inserisciJBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
/*     */           
/* 399 */           for (int i = 0; i < 4; i++) {
/* 400 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 406 */       if (this.game.checkScrollCondition(map, currPiece)) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 417 */     if (position instanceof inserisciLBlock) {
/* 418 */       if (currPiece.isMoving) {
/* 419 */         if (currPiece.getPiece()[0].getRow() > 1) {
/* 420 */           while (!currPiece.getState()[((inserisciLBlock)position).getV()]) {
/* 421 */             currPiece.Rotate(map);
/*     */           }
/*     */           
/* 424 */           currPiece.setState(true, ((inserisciLBlock)position).getV());
/*     */         } 
/*     */         
/* 427 */         if (currPiece.canMoveLeft(map) && ((inserisciLBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
/* 428 */           for (int i = 0; i < 4; i++) {
/* 429 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
/*     */           
/*     */           }
/*     */         }
/* 433 */         else if (currPiece.canMoveRight(map) && ((inserisciLBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
/*     */           
/* 435 */           for (int i = 0; i < 4; i++) {
/* 436 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 442 */       if (this.game.checkScrollCondition(map, currPiece)) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 452 */     if (position instanceof inserisciOBlock) {
/* 453 */       if (currPiece.isMoving) {
/* 454 */         if (currPiece.canMoveLeft(map) && ((inserisciOBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
/* 455 */           for (int i = 0; i < 4; i++) {
/* 456 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
/*     */           
/*     */           }
/*     */         }
/* 460 */         else if (currPiece.canMoveRight(map) && ((inserisciOBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
/*     */           
/* 462 */           for (int i = 0; i < 4; i++) {
/* 463 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
/*     */           }
/*     */         } 
/*     */       } else {
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 476 */     if (position instanceof inserisciSBlock) {
/*     */       
/* 478 */       if (currPiece.isMoving) {
/* 479 */         if (currPiece.getPiece()[0].getRow() > 1) {
/* 480 */           while (!currPiece.getState()[((inserisciSBlock)position).getV()]) {
/* 481 */             currPiece.Rotate(map);
/*     */           }
/*     */           
/* 484 */           currPiece.setState(true, ((inserisciSBlock)position).getV());
/*     */         } 
/*     */ 
/*     */         
/* 488 */         if (currPiece.canMoveLeft(map) && ((inserisciSBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
/* 489 */           for (int i = 0; i < 4; i++) {
/* 490 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
/*     */           
/*     */           }
/*     */         }
/* 494 */         else if (currPiece.canMoveRight(map) && ((inserisciSBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
/*     */           
/* 496 */           for (int i = 0; i < 4; i++) {
/* 497 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 503 */       if (this.game.checkScrollCondition(map, currPiece)) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 514 */     if (position instanceof inserisciTBlock) {
/* 515 */       if (currPiece.isMoving) {
/* 516 */         if (currPiece.getPiece()[0].getRow() > 1) {
/* 517 */           while (!currPiece.getState()[((inserisciTBlock)position).getV()]) {
/* 518 */             currPiece.Rotate(map);
/*     */           }
/*     */           
/* 521 */           currPiece.setState(true, ((inserisciTBlock)position).getV());
/*     */         } 
/*     */         
/* 524 */         if (currPiece.canMoveLeft(map) && ((inserisciTBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
/* 525 */           for (int i = 0; i < 4; i++) {
/* 526 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
/*     */           
/*     */           }
/*     */         }
/* 530 */         else if (currPiece.canMoveRight(map) && ((inserisciTBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
/*     */           
/* 532 */           for (int i = 0; i < 4; i++) {
/* 533 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 539 */       if (!this.game.checkScrollCondition(map, currPiece)) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 552 */     if (position instanceof inserisciZBlock) {
/* 553 */       if (currPiece.isMoving) {
/* 554 */         if (currPiece.getPiece()[0].getRow() > 1) {
/* 555 */           while (!currPiece.getState()[((inserisciZBlock)position).getV()]) {
/* 556 */             currPiece.Rotate(map);
/*     */           }
/*     */           
/* 559 */           currPiece.setState(true, ((inserisciZBlock)position).getV());
/*     */         } 
/*     */         
/* 562 */         if (currPiece.canMoveLeft(map) && ((inserisciZBlock)position).getY1() < currPiece.getPiece()[0].getColumn()) {
/* 563 */           for (int i = 0; i < 4; i++) {
/* 564 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
/*     */           
/*     */           }
/*     */         }
/* 568 */         else if (currPiece.canMoveRight(map) && ((inserisciZBlock)position).getY1() > currPiece.getPiece()[0].getColumn()) {
/*     */           
/* 570 */           for (int i = 0; i < 4; i++) {
/* 571 */             currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 579 */       if (this.game.checkScrollCondition(map, currPiece)) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAspCells(Map map) {
/* 593 */     this.currMatrix.clearAll();
/*     */     
/* 595 */     for (int i = 0; i < 20; i++) {
/* 596 */       for (int j = 0; j < 10; j++) {
/* 597 */         int value = map.getMatrix()[i][j].getValue();
/*     */         try {
/* 599 */           this.currMatrix.addObjectInput(new Cell(i, j, value));
/* 600 */         } catch (Exception e) {
/*     */           
/* 602 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fitPieces(Map map, Piece currPiece) {
/* 614 */     if (currPiece.canMoveRight(map))
/*     */     {
/*     */       
/* 617 */       if (map.getMatrix()[currPiece.getPiece()[0].getRow()][currPiece.getPiece()[0].getColumn() + 1].getValue() == 0 && 
/* 618 */         map.getMatrix()[currPiece.getPiece()[0].getRow() + 1][currPiece.getPiece()[0].getColumn() + 1].getValue() != 0) {
/*     */         
/* 620 */         for (int i = 0; i < 4; i++) {
/* 621 */           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
/* 622 */           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
/*     */         }
/*     */       
/*     */       }
/* 626 */       else if (map.getMatrix()[currPiece.getPiece()[1].getRow()][currPiece.getPiece()[1].getColumn() + 1].getValue() == 0 && 
/* 627 */         map.getMatrix()[currPiece.getPiece()[1].getRow() + 1][currPiece.getPiece()[1].getColumn() + 1].getValue() != 0) {
/*     */         
/* 629 */         for (int i = 0; i < 4; i++) {
/* 630 */           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
/* 631 */           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/* 638 */       else if (map.getMatrix()[currPiece.getPiece()[2].getRow()][currPiece.getPiece()[2].getColumn() + 1].getValue() == 0 && 
/* 639 */         map.getMatrix()[currPiece.getPiece()[2].getRow() + 1][currPiece.getPiece()[2].getColumn() + 1].getValue() != 0) {
/*     */         
/* 641 */         for (int i = 0; i < 4; i++) {
/* 642 */           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
/* 643 */           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
/*     */         }
/*     */       
/*     */       }
/* 647 */       else if (map.getMatrix()[currPiece.getPiece()[3].getRow()][currPiece.getPiece()[3].getColumn() + 1].getValue() == 0 && 
/* 648 */         map.getMatrix()[currPiece.getPiece()[3].getRow() + 1][currPiece.getPiece()[3].getColumn() + 1].getValue() != 0) {
/*     */         
/* 650 */         for (int i = 0; i < 4; i++) {
/* 651 */           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
/* 652 */           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() + 1);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 658 */     if (currPiece.canMoveLeft(map)) {
/* 659 */       if (map.getMatrix()[currPiece.getPiece()[0].getRow()][currPiece.getPiece()[0].getColumn() - 1].getValue() == 0 && 
/* 660 */         map.getMatrix()[currPiece.getPiece()[0].getRow() + 1][currPiece.getPiece()[0].getColumn() - 1].getValue() != 0) {
/*     */         
/* 662 */         for (int i = 0; i < 4; i++) {
/* 663 */           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
/* 664 */           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
/*     */         }
/*     */       
/*     */       }
/* 668 */       else if (map.getMatrix()[currPiece.getPiece()[1].getRow()][currPiece.getPiece()[1].getColumn() - 1].getValue() == 0 && 
/* 669 */         map.getMatrix()[currPiece.getPiece()[1].getRow() + 1][currPiece.getPiece()[1].getColumn() - 1].getValue() != 0) {
/*     */         
/* 671 */         for (int i = 0; i < 4; i++) {
/* 672 */           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
/* 673 */           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/* 680 */       else if (map.getMatrix()[currPiece.getPiece()[2].getRow()][currPiece.getPiece()[2].getColumn() - 1].getValue() == 0 && 
/* 681 */         map.getMatrix()[currPiece.getPiece()[2].getRow() + 1][currPiece.getPiece()[2].getColumn() - 1].getValue() != 0) {
/*     */         
/* 683 */         for (int i = 0; i < 4; i++) {
/* 684 */           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
/* 685 */           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
/*     */         }
/*     */       
/*     */       }
/* 689 */       else if (map.getMatrix()[currPiece.getPiece()[3].getRow()][currPiece.getPiece()[3].getColumn() - 1].getValue() == 0 && 
/* 690 */         map.getMatrix()[currPiece.getPiece()[3].getRow() + 1][currPiece.getPiece()[3].getColumn() - 1].getValue() != 0) {
/*     */         
/* 692 */         for (int i = 0; i < 4; i++) {
/* 693 */           map.getSuppMatrix()[currPiece.getPiece()[i].getRow()][currPiece.getPiece()[i].getColumn()] = new EmptyBlock(currPiece.getPiece()[1].getRow(), currPiece.getPiece()[1].getColumn(), 0);
/* 694 */           currPiece.getPiece()[i].setColumn(currPiece.getPiece()[i].getColumn() - 1);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateMovement2(Piece currPiece, Map map) {
/* 702 */     if (currPiece != null)
/* 703 */       move(currPiece, this.position, map, this.movement); 
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/tetrisAI/AIClasses/ASPSolver.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */