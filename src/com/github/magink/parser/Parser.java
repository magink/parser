package com.github.magink.parser;

import com.github.magink.tokenizer.Token;


public class Parser {

  private Document document;
  private TokenReceiver tokenizer;
  private Words tempWords;
  private Sentence sentence; 

  public Parser(TokenReceiver tokenizer) {
    this.tokenizer = tokenizer;
    document = new Document();
    tempWords = new Words();
  }

  public Document parse() {
    do {
      Token token = tokenizer.getToken();
      parse(token);     
    } while (tokenizer.next());
    return document;
  }

  protected void parse(Token token) {
    if(isWord(token)) {
      Word word = new Word(token.getValue());
      tempWords.add(word);
      return;
    }
    else if (isQuestion(token)) {
      sentence = new Question();
    }
    else if(isStatement(token)) {
      sentence = new Statement();
    }
    else if(isExclamation(token)) {
      sentence = new Exclamation();
    } else {
      throw new SyntaxException(token.getType() + " couldn't be parsed");
    }
    sentence.addWords(tempWords);
    tempWords = new Words();
    document.addSentence(sentence);
  }

  private boolean isWord(Token token) {
    return token.getType().equals(Word.TYPE);
  }

  private boolean isQuestion(Token token) {
    return token.getType().equals(Question.TYPE);
  }

  private boolean isStatement(Token token) {
    return token.getType().equals(Statement.TYPE);
  }

  private boolean isExclamation(Token token) {
    return token.getType().equals(Exclamation.TYPE);
  }
}
