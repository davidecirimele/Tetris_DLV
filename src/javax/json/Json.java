/*     */ package javax.json;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;
/*     */ import java.util.Map;
/*     */ import javax.json.spi.JsonProvider;
/*     */ import javax.json.stream.JsonGenerator;
/*     */ import javax.json.stream.JsonGeneratorFactory;
/*     */ import javax.json.stream.JsonParser;
/*     */ import javax.json.stream.JsonParserFactory;
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
/*     */ public class Json
/*     */ {
/*     */   public static JsonParser createParser(Reader reader) {
/*  90 */     return JsonProvider.provider().createParser(reader);
/*     */   }
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
/*     */   public static JsonParser createParser(InputStream in) {
/* 104 */     return JsonProvider.provider().createParser(in);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonGenerator createGenerator(Writer writer) {
/* 114 */     return JsonProvider.provider().createGenerator(writer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonGenerator createGenerator(OutputStream out) {
/* 124 */     return JsonProvider.provider().createGenerator(out);
/*     */   }
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
/*     */   public static JsonParserFactory createParserFactory(Map<String, ?> config) {
/* 148 */     return JsonProvider.provider().createParserFactory(config);
/*     */   }
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
/*     */   public static JsonGeneratorFactory createGeneratorFactory(Map<String, ?> config) {
/* 173 */     return JsonProvider.provider().createGeneratorFactory(config);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonWriter createWriter(Writer writer) {
/* 185 */     return JsonProvider.provider().createWriter(writer);
/*     */   }
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
/*     */   public static JsonWriter createWriter(OutputStream out) {
/* 198 */     return JsonProvider.provider().createWriter(out);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonReader createReader(Reader reader) {
/* 208 */     return JsonProvider.provider().createReader(reader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonReader createReader(InputStream in) {
/* 220 */     return JsonProvider.provider().createReader(in);
/*     */   }
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
/*     */   public static JsonReaderFactory createReaderFactory(Map<String, ?> config) {
/* 234 */     return JsonProvider.provider().createReaderFactory(config);
/*     */   }
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
/*     */   public static JsonWriterFactory createWriterFactory(Map<String, ?> config) {
/* 248 */     return JsonProvider.provider().createWriterFactory(config);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonArrayBuilder createArrayBuilder() {
/* 257 */     return JsonProvider.provider().createArrayBuilder();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonObjectBuilder createObjectBuilder() {
/* 266 */     return JsonProvider.provider().createObjectBuilder();
/*     */   }
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
/*     */   public static JsonBuilderFactory createBuilderFactory(Map<String, ?> config) {
/* 282 */     return JsonProvider.provider().createBuilderFactory(config);
/*     */   }
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/Json.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */