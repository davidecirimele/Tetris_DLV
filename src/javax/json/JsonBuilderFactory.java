package javax.json;

import java.util.Map;

public interface JsonBuilderFactory {
  JsonObjectBuilder createObjectBuilder();
  
  JsonArrayBuilder createArrayBuilder();
  
  Map<String, ?> getConfigInUse();
}


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/JsonBuilderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */