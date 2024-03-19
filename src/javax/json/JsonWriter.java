package javax.json;

import java.io.Closeable;

public interface JsonWriter extends Closeable {
  void writeArray(JsonArray paramJsonArray);
  
  void writeObject(JsonObject paramJsonObject);
  
  void write(JsonStructure paramJsonStructure);
  
  void close();
}


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/JsonWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */