/*     */ package javax.json;
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
/*     */ public interface JsonValue
/*     */ {
/*     */   public enum ValueType
/*     */   {
/*  65 */     ARRAY,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     OBJECT,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     STRING,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     NUMBER,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     TRUE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     FALSE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     NULL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   public static final JsonValue NULL = new JsonValue()
/*     */     {
/*     */       public JsonValue.ValueType getValueType() {
/* 104 */         return JsonValue.ValueType.NULL;
/*     */       }
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
/*     */       public boolean equals(Object obj) {
/* 120 */         if (obj instanceof JsonValue) {
/* 121 */           return getValueType().equals(((JsonValue)obj).getValueType());
/*     */         }
/* 123 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/* 135 */         return JsonValue.ValueType.NULL.hashCode();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String toString() {
/* 145 */         return "null";
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 152 */   public static final JsonValue TRUE = new JsonValue()
/*     */     {
/*     */       public JsonValue.ValueType getValueType() {
/* 155 */         return JsonValue.ValueType.TRUE;
/*     */       }
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
/*     */       public boolean equals(Object obj) {
/* 169 */         if (obj instanceof JsonValue) {
/* 170 */           return getValueType().equals(((JsonValue)obj).getValueType());
/*     */         }
/* 172 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/* 184 */         return JsonValue.ValueType.TRUE.hashCode();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String toString() {
/* 194 */         return "true";
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 201 */   public static final JsonValue FALSE = new JsonValue()
/*     */     {
/*     */       public JsonValue.ValueType getValueType() {
/* 204 */         return JsonValue.ValueType.FALSE;
/*     */       }
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
/*     */       public boolean equals(Object obj) {
/* 218 */         if (obj instanceof JsonValue) {
/* 219 */           return getValueType().equals(((JsonValue)obj).getValueType());
/*     */         }
/* 221 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/* 233 */         return JsonValue.ValueType.FALSE.hashCode();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String toString() {
/* 243 */         return "false";
/*     */       }
/*     */     };
/*     */   
/*     */   ValueType getValueType();
/*     */   
/*     */   String toString();
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/JsonValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */