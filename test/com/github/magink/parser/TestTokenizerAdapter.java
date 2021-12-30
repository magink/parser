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
    assertEquals(tokenizer.getToken().getType(), "WORD");
  }

  @Test
  @DisplayName("Should get another token type when hit.")
  void shouldGetAnotherTokenTypeWhenHit() {
    assertEquals(tokenizer.getToken().getType(), "WORD");
  }

  @Test
  @DisplayName("Should get the first token type upon new Tokenizer creation.")
  void shouldGetFirstTokenValueWhenCreated() {
    assertEquals(tokenizer.getToken().getValue(), "You");
  }

  @Test
  @DisplayName("Should get the next token when stepping forward.")
  void shouldGetNextTokenOnNext(){
    String currentValue = tokenizer.getToken().getValue();
    tokenizer.next();
    assertNotEquals(currentValue, tokenizer.getToken().getValue());
  }

  @Test
  @DisplayName("Should get the END token when hitting the edge.")
  void shouldGetLastTokenWhenHittingEdge(){
    for(int i = 0; i < 14; i++) {
      tokenizer.next();
    }
    String currentType = tokenizer.getToken().getType();
    assertEquals("END", currentType);
  }
}
