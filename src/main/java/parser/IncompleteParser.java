package parser;

import java.util.*;
import java.util.function.Predicate;

public class IncompleteParser {
    private IncompleteParser() {
    }

    private static final Stack<Character> linesAnalyzer = new Stack<>();
    public static final Map<Character, Integer> closingCharacterPoints = Map.of(
            '(', 1,
            '[', 2,
            '{', 3,
            '<', 4
    );

    public static Long parseAndCalculatePoints(String linesToParse) {
        if (linesToParse.isEmpty() || linesToParse.isBlank())
            return 0L;

        long[] scores = linesToParse
                .lines()
                .filter(Predicate.not(String::isEmpty))
                .map(String::toCharArray)
                .map(IncompleteParser::findIncompleteLinesPoints)
                .mapToLong(Long::longValue)
                .filter(i -> i > 0) // filter out non incomplete lines.
                .sorted().toArray();
        return scores[(scores.length) / 2];
    }

    private static Long findIncompleteLinesPoints(char[] characters) {
        linesAnalyzer.clear();
        if (isAnEndingCharacter(characters[0]))
            return 0L;

        linesAnalyzer.add(characters[0]);
        for (int i = 1; i < characters.length; i++) {
            if (linesAnalyzer.isEmpty()) {
                if (isAnEndingCharacter(characters[i]))
                    return 0L;
                linesAnalyzer.add(characters[i]);
                continue;
            }

            switch (linesAnalyzer.peek()) {
                case '(':
                    if (characters[i] == ')') {
                        linesAnalyzer.pop();
                    } else if (isAnEndingCharacter(characters[i])) {
                        return 0L; // corrupted chunk
                    } else {
                        linesAnalyzer.add(characters[i]);
                    }
                    break;
                case '{':
                    if (characters[i] == '}') {
                        linesAnalyzer.pop();
                    } else if (isAnEndingCharacter(characters[i])) {
                        return 0L; // corrupted chunk
                    } else {
                        linesAnalyzer.add(characters[i]);
                    }
                    break;
                case '[':
                    if (characters[i] == ']') {
                        linesAnalyzer.pop();
                    } else if (isAnEndingCharacter(characters[i])) {
                        return 0L; // corrupted chunk
                    } else {
                        linesAnalyzer.add(characters[i]);
                    }
                    break;
                case '<':
                    if (characters[i] == '>') {
                        linesAnalyzer.pop();
                    } else if (isAnEndingCharacter(characters[i])) {
                        return 0L; // corrupted chunk
                    } else {
                        linesAnalyzer.add(characters[i]);
                    }
                    break;
                default:
                    break;

            }
        }
        return linesAnalyzer.isEmpty() ? 0 : calculateClosingPoints();
    }

    private static Long calculateClosingPoints() {
        long result = 0;
        while (!IncompleteParser.linesAnalyzer.isEmpty()) {
            result = (result * 5) + closingCharacterPoints.get(IncompleteParser.linesAnalyzer.pop());
        }
        return result;
    }

    private static boolean isAnEndingCharacter(char character) {
        return character == ')' || character == '}' || character == ']' || character == '>';
    }
}
