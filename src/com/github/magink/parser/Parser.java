package com.github.magink.parser;



public class Parser {

  private Document document;

  public Parser(String toParse) {
    TokenizerAdapter tokenAdapter = new TokenizerAdapter(toParse);
    document = new Document();
    while(tokenAdapter.hasNext()) {
      String tokenType = tokenAdapter.getType();
      if (tokenType.equals(Word.TYPE)) {

      }
      if(tokenType.equals(Dot.TYPE)) {
        document = new Document();
      }
      
      tokenAdapter.next();
    }
    
  }
 
  
}
