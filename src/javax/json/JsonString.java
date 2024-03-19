package javax.json;

public interface JsonString extends JsonValue {
  String getString();
  
  CharSequence getChars();
  
  boolean equals(Object paramObject);
  
  int hashCode();
}


/* Location:              /Users/davidecirimele/Documents/Roba USB/Tetris2/Tetris.jar!/javax/json/JsonString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */