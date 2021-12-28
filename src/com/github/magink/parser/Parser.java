package com.github.magink.parser;

import com.github.magink.tokenizer.Token;

public class Parser {

  private Document document;
  TokenReceiver tokenizer;

  public Parser(TokenReceiver tokenizer) {
    this.tokenizer = tokenizer;
    document = new Document();
  }

  public Document parse() {
    do {
      Token token = tokenizer.getToken();
      document.parse(token);     
    } while (tokenizer.next());
    return document;
  }
 
  
}
