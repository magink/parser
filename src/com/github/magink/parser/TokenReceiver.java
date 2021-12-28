package com.github.magink.parser;

import com.github.magink.tokenizer.Token;

/**
 * The boundary towards the tokenizer/lexer.
 */
public interface TokenReceiver {

  /**
   * Step to next token.
   */
  public boolean next();

  /**
   * @return the current token
   */
  public Token getToken();

}
