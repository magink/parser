package com.github.magink.parser;

/**
 * All types of sentences must implement this interface for a valid sentence must have a type.
 */
public interface EndType {
  /**
   * Return the name of this type.
   * @return The name of this type, e.g. "QUESTION".
   */
  String getEndType();
  /**
   * Return the character symbol for this type
   * @return the character, e.g. "?"
   */
  String getSymbol();
  /**
   * This method returns the entire sentence with end type as a String.
   * This method should call the super method of the base class Sentence first, and then add it's own end symbol before returning
   * @return The complete sentence e.g. "Is this a question?"
   */
  String toString();
}
