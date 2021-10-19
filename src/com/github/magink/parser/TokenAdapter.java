package com.github.magink.parser;


import com.github.magink.tokenizer.Grammar;
import com.github.magink.tokenizer.LexicalException;
import com.github.magink.tokenizer.Tokenizer;

public class TokenAdapter implements TokenReceiver {

  private Tokenizer tokenizer;
  private Grammar grammar;

  public TokenAdapter(String toTokenize){
    setupWordAndDotGrammar();
    setupTokenizer(toTokenize);
  }
  @Override
  public void next() { 
    try {
      tokenizer.nextToken();
    } catch(LexicalException e) {
      System.out.println(e);
    }
  }
  public boolean hasNext() {
    return tokenizer.getActiveTokenType().equals("END");
  }
  public String getValue(){
    return tokenizer.getActiveTokenValue();
  }
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
