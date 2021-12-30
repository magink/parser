package com.github.magink.parser;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestParser {
  TokenReceiver tokenizer;
  Parser parser;

  @Test
  @DisplayName("Correct word is returned from statement when one statement is parsed.")
  void shouldReturnCorrectWordFromStatement() {
    String input = "I love parsers.";
    String expectedWord = "love";

    tokenizer = new TokenizerAdapter(input);
    parser = new Parser(tokenizer);

    Document doc = parser.parse();
    Sentences sentences = doc.getAllSentences();
    for(Sentence s : sentences) {
      s.nextWord();
      s.nextWord();
      s.previousWord();
      assertEquals(expectedWord, s.getWord().getReadableWord());
    }
  }

  @Test
  @DisplayName("Two statements are returned when two statement are parsed.")
  void shouldReturnTwoStatements() {
    String input = "I love parsers. They are fun.";
    int expectedNumberOfStatements = 2;

    tokenizer = new TokenizerAdapter(input);
    parser = new Parser(tokenizer);

    Document doc = parser.parse();
    Sentences sentences = doc.getAllSentences();
    int countedStatements = 0;
    for(Sentence s : sentences) {
      countedStatements++;
    }
    assertEquals(expectedNumberOfStatements, countedStatements);
  }

  @Test
  @DisplayName("Exclamation sentence is returned.")
  void shouldReturnExclamation() {
    String input = "I love parsers!";
    String expectedType = Exclamation.TYPE;
    tokenizer = new TokenizerAdapter(input);
    parser = new Parser(tokenizer);
    Document doc = parser.parse();
    Sentences sentences = doc.getAllSentences();
    for(Sentence s : sentences) {
      assertEquals(expectedType, s.getEndType());
    }
  }

  @Test
  @DisplayName("Question sentence is returned")
  void shouldReturnQuestion() {
    String input = "Do I love parsers?";
    String expectedType = Question.TYPE;
    tokenizer = new TokenizerAdapter(input);
    parser = new Parser(tokenizer);
    Document doc = parser.parse();
    Sentences sentences = doc.getAllSentences();
    for(Sentence s : sentences) {
      assertEquals(expectedType, s.getEndType());
    }
  }

  @Test
  @DisplayName("All question sentences are returned")
  void shouldReturnAllQuestions() {
    String input = "One question? Then another questions? But not this one. A final question?";
    int expectedNumberOfQuestions = 3;
    
    tokenizer = new TokenizerAdapter(input);
    parser = new Parser(tokenizer);
    Document doc = parser.parse();
    Sentences questionSentences = doc.getQuestions();
    int count = 0;
    for(Sentence s : questionSentences) {
      count++;
    }
    assertEquals(expectedNumberOfQuestions, count);
  }

  @Test
  @DisplayName("All statement sentences are returned")
  void shouldReturnAllStatements() {
    String input = "This is a statement. No this is! Is it? Yes.";
    int expectedNumberOfStatements = 2;

    tokenizer = new TokenizerAdapter(input);
    parser = new Parser(tokenizer);
    Document doc = parser.parse();
    Sentences statementSentences = doc.getStatements();
    int count = 0;
    for(Sentence s : statementSentences) {
      count++;
    }
    assertEquals(expectedNumberOfStatements, count);
  }

  @Test
  @DisplayName("All exclamations are returned")
  void shouldReturnAllExclamations() {
    String input = "Bratan now is the time! Go away necktie. I only ever wanted you to have fun Harry! How did we meet?";
    int expectedNumberOfExclamations = 2;

    tokenizer = new TokenizerAdapter(input);
    parser = new Parser(tokenizer);
    Document doc = parser.parse();
    Sentences exclamationSentences = doc.getExclamations();
    int count = 0;
    for(Sentence s : exclamationSentences) {
      count++;
    }
    assertEquals(expectedNumberOfExclamations, count);
  }

  @Test
  @DisplayName("Entire sentence is returned with end symbol")
  void shouldReturnEntireSentence() {
    String input = "Bratan now is the time!";

    tokenizer = new TokenizerAdapter(input);
    parser = new Parser(tokenizer);
    Document doc = parser.parse();
    Sentences exclamationSentences = doc.getAllSentences();
    for(Sentence s : exclamationSentences) {
      assertEquals(input, s.toString());
    }
  }
}
