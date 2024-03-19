package javax.json;

import java.util.List;

public interface JsonArray extends JsonStructure, List<JsonValue> {
  JsonObject getJsonObject(int paramInt);
  
  JsonArray getJsonArray(int paramInt);
  
  JsonNumber getJsonNumber(int paramInt);
  
  JsonString getJsonString(int paramInt);
  
  <T extends JsonValue> List<T> getValuesAs(Class<T> paramClass);
  
  String getString(int paramInt);
  
  String getString(int paramInt, String paramString);
  
  int getInt(int paramInt);
  
  int getInt(int paramInt1, int paramInt2);
  
  boolean getBoolean(int paramInt);
  
  boolean getBoolean(int paramInt, boolean paramBoolean);
  
  boolean isNull(int paramInt);
}


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/JsonArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */