package com.github.magink.parser;

public class Document {
  
  private Sentences sentences;

  protected Document() {
    sentences = new Sentences();
  }

  public Sentences getAllSentences() {
    return sentences;
  }

  public Sentences getStatements() {
    return getTypeOfSentences(Statement.TYPE);
  }

  public Sentences getQuestions() {
    return getTypeOfSentences(Question.TYPE);
  }

  public Sentences getExclamations() {
    return getTypeOfSentences(Exclamation.TYPE);
  }
  
  protected void addSentence(Sentence sentence) {
    sentences.addSentence(sentence);
  }

  private Sentences getTypeOfSentences(String type){
    Sentences filtered = new Sentences();
    sentences.forEach(s -> {
      if(s.getEndType().equals(type)) {
        filtered.addSentence(s);
      }
    });
    return filtered;
  }
}
