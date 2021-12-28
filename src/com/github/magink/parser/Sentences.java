package com.github.magink.parser;

import java.util.ArrayList;
import java.util.Iterator;

public class Sentences implements Iterable<Sentence> {

  private ArrayList<Sentence> sentenceList; 
  
  public Sentences() {
    sentenceList = new ArrayList<>();
  }

  public void addSentence(Sentence newSentence) {
    sentenceList.add(newSentence);
  }

  @Override
  public Iterator<Sentence> iterator() {
    return sentenceList.iterator();
  }
}
