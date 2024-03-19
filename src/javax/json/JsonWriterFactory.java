package javax.json;

import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Map;

public interface JsonWriterFactory {
  JsonWriter createWriter(Writer paramWriter);
  
  JsonWriter createWriter(OutputStream paramOutputStream);
  
  JsonWriter createWriter(OutputStream paramOutputStream, Charset paramCharset);
  
  Map<String, ?> getConfigInUse();
}


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/JsonWriterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */