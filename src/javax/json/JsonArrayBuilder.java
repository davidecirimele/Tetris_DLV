package javax.json;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface JsonArrayBuilder {
  JsonArrayBuilder add(JsonValue paramJsonValue);
  
  JsonArrayBuilder add(String paramString);
  
  JsonArrayBuilder add(BigDecimal paramBigDecimal);
  
  JsonArrayBuilder add(BigInteger paramBigInteger);
  
  JsonArrayBuilder add(int paramInt);
  
  JsonArrayBuilder add(long paramLong);
  
  JsonArrayBuilder add(double paramDouble);
  
  JsonArrayBuilder add(boolean paramBoolean);
  
  JsonArrayBuilder addNull();
  
  JsonArrayBuilder add(JsonObjectBuilder paramJsonObjectBuilder);
  
  JsonArrayBuilder add(JsonArrayBuilder paramJsonArrayBuilder);
  
  JsonArray build();
}


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/JsonArrayBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */