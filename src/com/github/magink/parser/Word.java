package com.github.magink.parser;

import com.github.magink.tokenizer.Token;

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
  protected void parse(Token token) {
    if(token.getType().equals(TYPE)){
      readableWord = value;
    } else {
      throw new SyntaxException(token.getType() + " didn't match");
    }
  }
}
