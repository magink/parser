package com.github.magink.parser;

public class Statement extends Sentence {
  public static final String REGEX = "\\.+";
  public static final String SYMBOL = ".";
  public static final String TYPE = "DOT";
  public Statement() {
    super();
  }
  @Override
  public String getEndType() {
    return TYPE;
  }
  @Override
  public String getSymbol() {
    return SYMBOL;
  }
  @Override 
  public String toString(){
    return super.toString() + SYMBOL;
  }
  
}
