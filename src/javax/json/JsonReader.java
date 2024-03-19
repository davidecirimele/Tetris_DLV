package javax.json;

import java.io.Closeable;

public interface JsonReader extends Closeable {
  JsonStructure read();
  
  JsonObject readObject();
  
  JsonArray readArray();
  
  void close();
}


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/JsonReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */