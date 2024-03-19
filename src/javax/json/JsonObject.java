package javax.json;

import java.util.Map;

public interface JsonObject extends JsonStructure, Map<String, JsonValue> {
  JsonArray getJsonArray(String paramString);
  
  JsonObject getJsonObject(String paramString);
  
  JsonNumber getJsonNumber(String paramString);
  
  JsonString getJsonString(String paramString);
  
  String getString(String paramString);
  
  String getString(String paramString1, String paramString2);
  
  int getInt(String paramString);
  
  int getInt(String paramString, int paramInt);
  
  boolean getBoolean(String paramString);
  
  boolean getBoolean(String paramString, boolean paramBoolean);
  
  boolean isNull(String paramString);
}


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/JsonObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */