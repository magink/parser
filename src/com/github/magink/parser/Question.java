package com.github.magink.parser;

public class Question extends Sentence {
  public static final String REGEX = "\\?";
  public static final String SYMBOL = "?";
  public static final String TYPE = "QUESTION";
  public Question () {
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
