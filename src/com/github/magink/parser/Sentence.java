package com.github.magink.parser;

import java.util.ArrayList;

public class Sentence {
  private ArrayList<Word> words;
  private EndType endType;
  
  public Sentence() {
    endType = new Dot();
  }
  public String getEndType() {
    return endType.getEndType();
  }
  
}
