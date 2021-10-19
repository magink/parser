package com.github.magink.parser;

import java.util.ArrayList;
import java.util.Iterator;

public class Sentences implements Iterable {
  private ArrayList<Sentence> sentences; 
  public Sentences() {
    sentences = new ArrayList<>();
  }
  public void addSentence(Sentence newSentence) {
    sentences.add(newSentence);
  }
  @Override
  public Iterator<Sentence> iterator() {
    return sentences.iterator();
  }
}
