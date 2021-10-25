package com.github.magink.parser;

public abstract class Node {
  String value;
  protected abstract void parse(String type, String value);
  public String getValue(){
    return value;
  }
}
