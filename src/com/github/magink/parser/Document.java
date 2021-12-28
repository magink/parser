package com.github.magink.parser;

import com.github.magink.tokenizer.Token;

public class Document {
  
  private Sentences sentences;
  private Words tempWords; 
  private Sentence sentence;

  protected Document() {
    sentences = new Sentences();
    tempWords = new Words();
  }

  public Sentences getSentences() {
    return sentences;
  }

  public Sentences getStatements() {
    Sentences statements = new Sentences();
    sentences.forEach(s -> {
      if(s.getEndType().equals(Statement.TYPE)) {
        statements.addSentence(s);
      }
    });
    return statements;
  }

  public Sentences getQuestions() {
    Sentences questions = new Sentences();
    sentences.forEach(s -> {
      if(s.getEndType().equals(Question.TYPE)) {
        questions.addSentence(s);
      }
    });
    return questions;
  }

  public Sentences getExclamations() {
    Sentences exclamations = new Sentences();
    sentences.forEach(s -> {
      if(s.getEndType().equals(Exclamation.TYPE)) {
        exclamations.addSentence(s);
      }
    });
    return exclamations;
  }

  protected void parse(Token token) {
    if((token.getType().equals(Word.TYPE))) {
      Word word = new Word(token.getValue());
      tempWords.add(word);
      return;
    }
    else if (token.getType().equals(Question.TYPE)) {
      sentence = new Question();
    }
    else if(token.getType().equals(Statement.TYPE)) {
      sentence = new Statement();
    }
    else if(token.getType().equals(Exclamation.TYPE)) {
      sentence = new Exclamation();
    } else {
      throw new SyntaxException(token.getType() + " couldn't be parsed");
    }
    sentence.addWords(tempWords);
    tempWords = new Words();
    sentences.addSentence(sentence);
  }

}
