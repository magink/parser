package com.github.magink.parser;

/**
 * When something when wrong with the 
 */
public class SyntaxException extends RuntimeException {
  protected SyntaxException(String message){
    super(message);
  }
}
