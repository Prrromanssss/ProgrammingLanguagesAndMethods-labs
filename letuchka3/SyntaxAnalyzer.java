package letuchka3;

import java.util.Scanner;
/*
<Int>::= <Section> <IntTail> 
<IntTail>::= <Int> | ε 
<Section>::= [ IDENT ] <Pairs> 
<Pairs> ::= IDENT = <Value> <Pairs> | ε
<Value> ::= NUMBER | STRING
 */

import java.util.*;

public class SyntaxAnalyzer {
    private static String input;
    private static int position;

    public static void parseInput(String text) {
        input = text;
        position = 0;

        try {
            parseInt();
            if (position != input.length()) {
                throw new Exception("Extra characters found after parsing.");
            } else {
                System.out.println("Parsing successful.");
            }
        } catch (Exception e) {
            System.out.println("syntax error at (" + getLineNumber(position) + ", " + getColumnNumber(position) + ")");
        }
    }

    private static void parseInt() throws Exception {
        parseSection();
        parseIntTail();
    }

    private static void parseIntTail() throws Exception {
        if (position < input.length() && input.charAt(position) == '[') {
            parseSection();
            parseIntTail();
        }
    }

    private static void parseSection() throws Exception {
        consume('[');
        parsePairs();
        consume(']');
    }

    private static void parsePairs() throws Exception {
        if (position < input.length() && Character.isLetter(input.charAt(position))) {
            consumeIdentifier();
            consume('=');
            parseValue();
            parsePairs();
        }
    }

    private static void parseValue() throws Exception {
        if (position < input.length() && Character.isDigit(input.charAt(position))) {
            consumeNumber();
        } else if (position < input.length() && input.charAt(position) == '"') {
            consumeString();
        } else {
            throw new Exception("Invalid value at position " + position);
        }
    }

    private static void consume(char expected) throws Exception {
        if (position < input.length() && input.charAt(position) == expected) {
            position++;
        } else {
            throw new Exception("Expected '" + expected + "' at position " + position);
        }
    }

    private static void consumeIdentifier() throws Exception {
        if (position < input.length() && Character.isLetter(input.charAt(position))) {
            position++;
            while (position < input.length() && (Character.isLetterOrDigit(input.charAt(position)))) {
                position++;
            }
        } else {
            throw new Exception("Invalid identifier at position " + position);
        }
    }

    private static void consumeNumber() throws Exception {
        if (position < input.length() && Character.isDigit(input.charAt(position))) {
            position++;
            while (position < input.length() && Character.isDigit(input.charAt(position))) {
                position++;
            }
        } else {
            throw new Exception("Invalid number at position " + position);
        }
    }

    private static void consumeString() throws Exception {
        if (position < input.length() && input.charAt(position) == '"') {
            position++;
            while (position < input.length() && input.charAt(position) != '"') {
                if (input.charAt(position) == '\n') {
                    throw new Exception("Newline found within string at position " + position);
                }
                position++;
            }
            if (position == input.length()) {
                throw new Exception("Unterminated string starting at position " + (position - 1));
            }
            position++;
        } else {
            throw new Exception("Invalid string at position " + position);
        }
    }

    private static int getLineNumber(int position) {
        int line = 1;
        for (int i = 0; i < position; i++) {
            if (input.charAt(i) == '\n') {
                line++;
            }
        }
        return line;
    }

    private static int getColumnNumber(int position) {
        int column = 1;
        for (int i = position - 1; i >= 0; i--) {
            if (input.charAt(i) == '\n') {
                break;
            }
            column++;
        }
        return column;
    }
}
