package com.github.magink.parser;

import com.github.magink.tokenizer.Token;

public abstract class Node {
  String value;
  protected abstract void parse(Token token);
  public String getValue(){
    return value;
  }
}
