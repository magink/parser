package com.github.magink.parser;

import java.util.ArrayList;
import java.util.Iterator;

public class Words implements Iterable<Word> {
  private ArrayList<Word> wordArray;
  protected Words(){
    wordArray = new ArrayList<>();
  }

  @Override
  public Iterator<Word> iterator() {
    return wordArray.iterator();
  }
  @Override
  public String toString(){
    return wordArray.toString();
  }

  protected void add(Word word){
    wordArray.add(word);
  }
  protected Word get(int index) {
    return wordArray.get(index);
  }
  protected int size() {
    return wordArray.size();
  }
}
