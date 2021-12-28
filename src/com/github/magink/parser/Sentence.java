package com.github.magink.parser;

public abstract class Sentence implements EndType {

  private Words wordList;
  private int selectedWord;

  protected Sentence() {
    wordList = new Words();
    selectedWord = 0;
  }
  protected void addWords(Words words) {
    wordList = words;
  }
  public Words getWords() {
    return wordList;
  }
  public Word getWord() {
    return wordList.get(selectedWord);
  }
  public void nextWord() {
    if(selectedWord < wordList.size()) {
      selectedWord++;
    }
  }
  public void previousWord() {
    if(selectedWord > 0) {
      selectedWord--;
    }
  }
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    wordList.forEach(word -> builder.append(word.getReadableWord() + " "));
    return builder.toString().trim();
  }
}
