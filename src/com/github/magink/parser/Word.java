package com.github.magink.parser;

public class Word {

  public static final String REGEX = "[[a-zA-Z]|åäöÅÄÖ]+";
  public static final String TYPE = "WORD";

  private String readableWord;

  public Word (String readableWord)  {
    this.readableWord = readableWord;
  }

  public String getReadableWord() {
    return readableWord;
  }
}
