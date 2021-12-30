## Parser

A parser written in java that can parse tokens into different types of sentences. More types of sentences can be added by extending the Sentence base class and implementing a new EndType. Grammar rules for the tokenizer have to be added in the tokenizer adapter class.

## How to use

Create a new Tokenizer Adapter with your input to parse and add the adapter to the Parser.
Grammar is set in adapter class.

```java
TokenReceiver tokenizer = new TokenizerAdapter(input);
Parser parser = new Parser(tokenizer);
```

The `parse()` method of Parser returns a Document object that the user can get sentences from.

- `Document document = parser.parse();`

To get all sentences

- `Sentences sentences = document.getSentences`

You can also request specific types of sentences. They all inherit from the base type sentence.

- `Sentences sentences = document.getQuestions()`
- `Sentences sentences = document.getStatements()`
- `Sentences sentences = document.getExclamations()`

To iterate over the sentences you can call for an iterator(), if you for example want to use a for-each loop.
`sentences.iterator()`

A Sentence can hold a Words object, a data structure that contains a list of words and methods for manipulation, as well as methods for selecting and returning a single or all Word object.
`question.nextWord()`
`question.previousWord()`
`Word word = question.getWord()`
`Words words = question.getWords()`

A sentence can return a String representation of itself
`String s = statement.toString() // Output: "This is the returned statement."

### Creating your own adapter class against receiver interface

By implementing an adapter class against TokenReceiver interface you can supply your own tokenizer.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `test`: the folder containing tests for the source code

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Tests

If you want to run the tests you need to add junit for your build tools or download `junit-platform-console-standalone-1.8.0.jar` or later and add it to your Reference Libraries.

## Dependencies

This project depends on [tokenizer](https://github.com/magink/tokenizer) and junit.
You can run your custom tokenizer by creating your own adapter class that implements TokenReceiver or run with the tokenizer jar library that comes with this project.
