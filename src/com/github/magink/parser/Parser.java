package com.github.magink.parser;


public class Parser {

  private Document document;
  TokenReceiver tokenizer;

  public Parser(TokenReceiver tokenizer) {
    this.tokenizer = tokenizer;
    document = new Document();
  }

  public Document parse() {
    while(tokenizer.hasNext()) {
      String tokenType = tokenizer.getType();
      String tokenValue = tokenizer.getValue();
      document.parse(tokenType, tokenValue);     
      tokenizer.next();
    }
    return document;
  }
 
  
}
