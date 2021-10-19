package com.github.magink.parser;

import java.util.List;

/**
 * The boundary towards the tokenizer/lexer.
 */
public interface TokenReceiver {
  public void next();
  public boolean hasNext();
  public String getType();
  public String getValue();
}
