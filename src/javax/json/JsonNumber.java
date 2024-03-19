package javax.json;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface JsonNumber extends JsonValue {
  boolean isIntegral();
  
  int intValue();
  
  int intValueExact();
  
  long longValue();
  
  long longValueExact();
  
  BigInteger bigIntegerValue();
  
  BigInteger bigIntegerValueExact();
  
  double doubleValue();
  
  BigDecimal bigDecimalValue();
  
  String toString();
  
  boolean equals(Object paramObject);
  
  int hashCode();
}


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/JsonNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */