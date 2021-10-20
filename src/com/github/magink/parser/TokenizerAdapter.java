package com.github.magink.parser;


import com.github.magink.tokenizer.Grammar;
import com.github.magink.tokenizer.LexicalException;
import com.github.magink.tokenizer.Tokenizer;

public class TokenizerAdapter implements TokenReceiver {

  private Tokenizer tokenizer;
  private Grammar grammar;

  public TokenizerAdapter(String toTokenize){
    setupWordAndDotGrammar();
    setupTokenizer(toTokenize);
  }

  @Override
  public void next() { 
    if(hasNext()) {
      try {
        tokenizer.nextToken();
      } catch(LexicalException e) {
        System.out.println(e);
      }
    }
  }

  @Override
  public boolean hasNext() {
    return !tokenizer.getActiveTokenType().equals("END");
  }

  @Override
  public String getValue(){
    return tokenizer.getActiveTokenValue();
  }

  @Override
  public String getType(){
    return tokenizer.getActiveTokenType();
  }

  private void setupTokenizer(String toTokenize) {
    try {
      tokenizer = new Tokenizer(grammar, toTokenize);
    } catch(LexicalException e) {
      System.out.println(e);
    }
  }
  
  private void setupWordAndDotGrammar() {
    grammar = new Grammar();
    grammar.addType(Word.REGEX, Word.TYPE);
    grammar.addType(Dot.REGEX, Dot.TYPE);
  }
}
