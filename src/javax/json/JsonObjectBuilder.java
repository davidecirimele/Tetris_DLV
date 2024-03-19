package javax.json;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface JsonObjectBuilder {
  JsonObjectBuilder add(String paramString, JsonValue paramJsonValue);
  
  JsonObjectBuilder add(String paramString1, String paramString2);
  
  JsonObjectBuilder add(String paramString, BigInteger paramBigInteger);
  
  JsonObjectBuilder add(String paramString, BigDecimal paramBigDecimal);
  
  JsonObjectBuilder add(String paramString, int paramInt);
  
  JsonObjectBuilder add(String paramString, long paramLong);
  
  JsonObjectBuilder add(String paramString, double paramDouble);
  
  JsonObjectBuilder add(String paramString, boolean paramBoolean);
  
  JsonObjectBuilder addNull(String paramString);
  
  JsonObjectBuilder add(String paramString, JsonObjectBuilder paramJsonObjectBuilder);
  
  JsonObjectBuilder add(String paramString, JsonArrayBuilder paramJsonArrayBuilder);
  
  JsonObject build();
}


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/JsonObjectBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */