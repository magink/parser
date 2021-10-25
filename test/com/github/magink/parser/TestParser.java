package com.github.magink.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestParser {
  TokenReceiver tokenizer;
  Parser parser;

  @BeforeEach
  void setup() {
    tokenizer = new TokenizerAdapter("This is a normal sentence.");
    parser = new Parser(tokenizer);
  }
  @Test
  @DisplayName("Just something to start with.")
  void testParser() {
    Document doc = parser.parse();
    assertEquals(doc.value, "Just something to start with.");
  }
  
}
