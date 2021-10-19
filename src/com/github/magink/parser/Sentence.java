package com.github.magink.parser;

import java.util.ArrayList;

public class Sentence {
  private int current = 0;
  private ArrayList<Word> words;
  private EndType endType;
  
  public Sentence() {
    endType = new Dot();
  }
  public String getEndType() {
    return endType.getEndType();
  }
  public void nextWord(){
    current = (current < words.size()) ? current + 1: words.size();
  }
  public void previousWord() {
    current = (current > 0 ) ? current - 1 : 0;
  }
  public Word getWord(){
    return words.get(current);
  }
  public String getWords() {
    StringBuilder sentence = new StringBuilder();
    words.forEach(word -> {
      sentence.append(word.getReadableWord() + " ");
    });
    sentence.append(endType.getEndType());
    return sentence.toString();
  }
  
}
