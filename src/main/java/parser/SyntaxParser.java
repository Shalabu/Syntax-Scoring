package parser;

import java.util.Map;
import java.util.Stack;
import java.util.function.Predicate;

public final class SyntaxParser {
    private SyntaxParser() {
    }

    private static final Stack<Character> chunksAnalyzer = new Stack<>();
    public static final Map<Character, Integer> illegalCharacterLookUp = Map.of(
            ')', 3,
            ']', 57,
            '}', 1197,
            '>', 25137
    );

    public static Integer parseAndCalculatePoints(String linesToParse) {
        return linesToParse
                .lines()
                .filter(Predicate.not(String::isEmpty))
                .map(String::toCharArray)
                .map(SyntaxParser::findCorruptedAndGetPoints)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static Integer findCorruptedAndGetPoints(char[] characters) {
        chunksAnalyzer.clear();
        chunksAnalyzer.add(characters[0]);
        for (int i = 1; i < characters.length; i++) {
            if (chunksAnalyzer.isEmpty())
                continue;
            switch (chunksAnalyzer.peek()) {
                case '(':
                    if (characters[i] == ')') {
                        chunksAnalyzer.pop();
                    } else if (isAnEndingCharacter(characters[i])) {
                        return illegalCharacterLookUp.get(characters[i]);
                    } else {
                        chunksAnalyzer.add(characters[i]);
                    }
                    break;
                case '{':
                    if (characters[i] == '}') {
                        chunksAnalyzer.pop();
                    } else if (isAnEndingCharacter(characters[i])) {
                        return illegalCharacterLookUp.get(characters[i]);
                    } else {
                        chunksAnalyzer.add(characters[i]);
                    }
                    break;
                case '[':
                    if (characters[i] == ']') {
                        chunksAnalyzer.pop();
                    } else if (isAnEndingCharacter(characters[i])) {
                        return illegalCharacterLookUp.get(characters[i]);
                    } else {
                        chunksAnalyzer.add(characters[i]);
                    }
                    break;
                case '<':
                    if (characters[i] == '>') {
                        chunksAnalyzer.pop();
                    } else if (isAnEndingCharacter(characters[i])) {
                        return illegalCharacterLookUp.get(characters[i]);
                    } else {
                        chunksAnalyzer.add(characters[i]);
                    }
                    break;
                default:
                    chunksAnalyzer.add(characters[i]);

            }
        }
        return 0;
    }

    private static boolean isAnEndingCharacter(char character) {
        return character == ')' || character == '}' || character == ']' || character == '>';
    }
}
