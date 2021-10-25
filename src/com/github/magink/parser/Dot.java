package com.github.magink.parser;

public class Dot implements EndType {
  public static final String REGEX = "\\.+";
  public static final String TYPE = "DOT";
  public Dot(){

  }
  @Override
  public String getEndType() {
    return TYPE;
  }
}
