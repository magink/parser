package com.github.magink.parser;

import com.github.magink.tokenizer.Token;

public class Document extends Node {
  
  private Sentences sentences;

  protected Document() {
    sentences = new Sentences();
  }

  public Sentences getSentences() {
    return sentences;
  }

  @Override
  protected void parse(Token token) {
    if (token.getType().equals("WORD")) {
      Sentence sentence = new Sentence();
      sentence.parse(token);
      sentences.addSentence(sentence);
    }
  }

}
