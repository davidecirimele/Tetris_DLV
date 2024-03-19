/*     */ package javax.json.spi;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.ServiceLoader;
/*     */ import javax.json.JsonArrayBuilder;
/*     */ import javax.json.JsonBuilderFactory;
/*     */ import javax.json.JsonException;
/*     */ import javax.json.JsonObjectBuilder;
/*     */ import javax.json.JsonReader;
/*     */ import javax.json.JsonReaderFactory;
/*     */ import javax.json.JsonWriter;
/*     */ import javax.json.JsonWriterFactory;
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
/*     */ public abstract class JsonProvider
/*     */ {
/*     */   private static final String DEFAULT_PROVIDER = "org.glassfish.json.JsonProviderImpl";
/*     */   
/*     */   public static JsonProvider provider() {
/*  87 */     ServiceLoader<JsonProvider> loader = ServiceLoader.load(JsonProvider.class);
/*  88 */     Iterator<JsonProvider> it = loader.iterator();
/*  89 */     if (it.hasNext()) {
/*  90 */       return it.next();
/*     */     }
/*     */     
/*     */     try {
/*  94 */       Class<?> clazz = Class.forName("org.glassfish.json.JsonProviderImpl");
/*  95 */       return (JsonProvider)clazz.newInstance();
/*  96 */     } catch (ClassNotFoundException x) {
/*  97 */       throw new JsonException("Provider org.glassfish.json.JsonProviderImpl not found", x);
/*     */     }
/*  99 */     catch (Exception x) {
/* 100 */       throw new JsonException("Provider org.glassfish.json.JsonProviderImpl could not be instantiated: " + x, x);
/*     */     } 
/*     */   }
/*     */   
/*     */   public abstract JsonParser createParser(Reader paramReader);
/*     */   
/*     */   public abstract JsonParser createParser(InputStream paramInputStream);
/*     */   
/*     */   public abstract JsonParserFactory createParserFactory(Map<String, ?> paramMap);
/*     */   
/*     */   public abstract JsonGenerator createGenerator(Writer paramWriter);
/*     */   
/*     */   public abstract JsonGenerator createGenerator(OutputStream paramOutputStream);
/*     */   
/*     */   public abstract JsonGeneratorFactory createGeneratorFactory(Map<String, ?> paramMap);
/*     */   
/*     */   public abstract JsonReader createReader(Reader paramReader);
/*     */   
/*     */   public abstract JsonReader createReader(InputStream paramInputStream);
/*     */   
/*     */   public abstract JsonWriter createWriter(Writer paramWriter);
/*     */   
/*     */   public abstract JsonWriter createWriter(OutputStream paramOutputStream);
/*     */   
/*     */   public abstract JsonWriterFactory createWriterFactory(Map<String, ?> paramMap);
/*     */   
/*     */   public abstract JsonReaderFactory createReaderFactory(Map<String, ?> paramMap);
/*     */   
/*     */   public abstract JsonObjectBuilder createObjectBuilder();
/*     */   
/*     */   public abstract JsonArrayBuilder createArrayBuilder();
/*     */   
/*     */   public abstract JsonBuilderFactory createBuilderFactory(Map<String, ?> paramMap);
/*     */ }


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/spi/JsonProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */