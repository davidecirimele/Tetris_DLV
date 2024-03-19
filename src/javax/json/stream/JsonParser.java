/*     */ package javax.json.stream;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.math.BigDecimal;
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
/*     */ 
/*     */ 
/*     */ public interface JsonParser
/*     */   extends Closeable
/*     */ {
/*     */   boolean hasNext();
/*     */   
/*     */   Event next();
/*     */   
/*     */   String getString();
/*     */   
/*     */   boolean isIntegralNumber();
/*     */   
/*     */   int getInt();
/*     */   
/*     */   long getLong();
/*     */   
/*     */   BigDecimal getBigDecimal();
/*     */   
/*     */   JsonLocation getLocation();
/*     */   
/*     */   void close();
/*     */   
/*     */   public enum Event
/*     */   {
/* 156 */     START_ARRAY,
/*     */ 
/*     */ 
/*     */     
/* 160 */     START_OBJECT,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     KEY_NAME,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     VALUE_STRING,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 179 */     VALUE_NUMBER,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 184 */     VALUE_TRUE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     VALUE_FALSE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     VALUE_NULL,
/*     */ 
/*     */ 
/*     */     
/* 198 */     END_OBJECT,
/*     */ 
/*     */ 
/*     */     
/* 202 */     END_ARRAY;
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/stream/JsonParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */