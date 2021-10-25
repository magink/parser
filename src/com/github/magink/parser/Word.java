package com.github.magink.parser;

public class Word extends Node {

  public static final String REGEX = "[[a-zA-Z]|åäöÅÄÖ]+";
  public static final String TYPE = "WORD";

  private String readableWord;

  public Word (String readableWord)  {
    this.readableWord = readableWord;
  }

  public String getReadableWord() {
    return readableWord;
  }

  @Override
  protected void parse(String type, String value) {
    if(type.equals(TYPE)){
      readableWord = value;
    }
  }
}
