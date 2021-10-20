package com.github.magink.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestTokenizerAdapter {
  TokenizerAdapter tokenizer;
  
  String toTokenize = "You come at the king you best not miss.";
  
  @BeforeEach 
  void setupTokenizer(){
    tokenizer = new TokenizerAdapter(toTokenize);
  }

  @Test
  @DisplayName("Should get the first token type upon new Tokenizer creation.")
  void shouldGetFirstTokenTypeWhenCreated() {
    assertEquals(tokenizer.getType(), "WORD");
  }

  @Test
  @DisplayName("Should get the another token type when hit.")
  void shouldGetAnotherTokenTypeWhenHit() {
    assertEquals(tokenizer.getType(), "WORD");
  }

  @Test
  @DisplayName("Should get the first token type upon new Tokenizer creation.")
  void shouldGetFirstTokenValueWhenCreated() {
    assertEquals(tokenizer.getValue(), "You");
  }

  @Test
  @DisplayName("Should get the next token when stepping forward.")
  void shouldGetNextTokenOnNext(){
    String currentValue = tokenizer.getValue();
    tokenizer.next();
    assertNotEquals(currentValue, tokenizer.getValue());
  }

  @Test
  @DisplayName("Should get the END token when hitting the edge.")
  void shouldGetLastTokenWhenHittingEdge(){
    for(int i = 0; i < 14; i++) {
      tokenizer.next();
    }
    String currentType = tokenizer.getType();
    assertEquals("END", tokenizer.getType());
  }
}
