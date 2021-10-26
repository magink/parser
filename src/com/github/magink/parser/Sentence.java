package com.github.magink.parser;

import java.util.ArrayList;

import com.github.magink.tokenizer.Token;

public class Sentence extends Node implements EndType {
  private int selectedWord = 0;
  private ArrayList<Word> words;
  private EndType endType;
  
  protected Sentence() {
    endType = new Dot();
    words = new ArrayList<>();
  }
  public String getEndType() {
    return endType.getEndType();
  }
  public void nextWord(){
    selectedWord = (selectedWord < words.size()) ? selectedWord + 1: words.size() ;
  }
  public void previousWord() {
    selectedWord = (selectedWord > 0 ) ? selectedWord - 1 : 0;
  }
  public Word getWord(){
    return words.get(selectedWord);
  }
  public String getWords() {
    StringBuilder sentence = new StringBuilder();
    int i = 0;
    for(Word word: words) {
      sentence.append(word.getReadableWord());
      i++;
      sentence.append(i < words.size() ? " ": endType.getEndType());
    }
    return sentence.toString();
  }
  
  @Override
  protected void parse(Token token) {
    if(token.getType().equals(Word.TYPE)) {
      Word nextWord = new Word(value);
      words.add(nextWord);
    }
  }

  
  
}
