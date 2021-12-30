package com.github.magink.parser;


import com.github.magink.tokenizer.Grammar;
import com.github.magink.tokenizer.GrammarTokenizer;
import com.github.magink.tokenizer.LexicalException;
import com.github.magink.tokenizer.Token;
import com.github.magink.tokenizer.Tokenizer;

public class TokenizerAdapter implements TokenReceiver {

  private Tokenizer tokenizer;
  private Grammar grammar;

  public TokenizerAdapter(String toTokenize){
    setupGrammar();
    setupTokenizer(toTokenize);
  }

  @Override
  public boolean next() { 
    try {
      tokenizer.nextToken();
    } catch(LexicalException e) {
      return false; // throw new SyntaxException("Tokenizer couldn't parse this " + e.message)
    }
    return !tokenizer.getActiveTokenType().equals("END");
  }
  
  @Override
  public Token getToken() {
    return tokenizer.getActiveToken();
  }

  private void setupTokenizer(String toTokenize) {
    try {
      tokenizer = new GrammarTokenizer(grammar, toTokenize);
    } catch(LexicalException e) {
      System.out.println(e);
    }
  }
  
  private void setupGrammar() {
    grammar = new Grammar();
    grammar.addType(Word.REGEX, Word.TYPE);
    grammar.addType(Statement.REGEX, Statement.TYPE);
    grammar.addType(Exclamation.REGEX, Exclamation.TYPE);
    grammar.addType(Question.REGEX, Question.TYPE);
  }


}
