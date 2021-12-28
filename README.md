## Parser

This is a parser of simple sentences and different types. More types of sentences can be added by extending the Sentence base class and implementing a new EndType.

## How to use

Create a new Tokenizer Adapter and add it to the Parser. Grammar is set in the adapter class.

```java
TokenReceiver tokenizer = new TokenizerAdapter(input);
Parser parser = new Parser(tokenizer);
```

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `test`: the folder containing tests for the source code

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependencies

This project depends on [tokenizer](https://github.com/magink/tokenizer) and junit.
You can run your custom tokenizer by implementing your own adapter class that implements TokenReceiver.
