package com.github.magink.parser;


public class Document extends Node {
  
  private Sentences sentences;

  protected Document() {
    sentences = new Sentences();
  }

  public Sentences getSentences() {
    return sentences;
  }

  

  protected void parse(String toParse) {
    // What is it that I want to do here?
  } 
}
