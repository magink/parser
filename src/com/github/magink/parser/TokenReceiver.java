package com.github.magink.parser;

/**
 * The boundary towards the tokenizer/lexer.
 */
public interface TokenReceiver {

  /**
   * Step to next token.
   */
  public void next();
  
  /**
   * @return true if there is a next token
   */
  public boolean hasNext();

  /**
   * @return the type of the current token
   */
  public String getType();

  /**
   * @return the value of the current token
   */
  public String getValue();
}
