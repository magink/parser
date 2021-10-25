package com.github.magink.parser;


public class Document extends Node {
  
  private Sentences sentences;

  protected Document() {
    sentences = new Sentences();
  }

  public Sentences getSentences() {
    return sentences;
  }

  protected void parse(String type, String value) {
    if (type.equals("END")) {
      return;
    } else {
      Sentence sentence = new Sentence();
      sentence.parse(type, value);
      sentences.addSentence(sentence);
    }
  } 
}
