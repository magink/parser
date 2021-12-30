package com.github.magink.parser;

import com.github.magink.tokenizer.Token;

/**
 * The boundary towards the tokenizer/lexer.
 */
public interface TokenReceiver {

  /**
   * Step to next token.
   * @return true if next token could be stepped to, false if not.
   */
  public boolean next();

  /**
   * Gets the current selected token from the tokenizer. 
   * @return the selected token
   */
  public Token getToken();

}
