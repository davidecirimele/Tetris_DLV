package javax.json.stream;

import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Map;

public interface JsonGeneratorFactory {
  JsonGenerator createGenerator(Writer paramWriter);
  
  JsonGenerator createGenerator(OutputStream paramOutputStream);
  
  JsonGenerator createGenerator(OutputStream paramOutputStream, Charset paramCharset);
  
  Map<String, ?> getConfigInUse();
}


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/stream/JsonGeneratorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */