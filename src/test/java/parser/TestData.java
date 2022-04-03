package parser;

public class TestData {
    public static final String SAMPLE_INPUT = "[({(<(())[]>[[{[]{<()<>>\n" +
            "[(()[<>])]({[<{<<[]>>(\n" +
            "{([(<{}[<>[]}>{[]{[(<()>\n" +
            "(((({<>}<{<{<>}{[]{[]{}\n" +
            "[[<[([]))<([[{}[[()]]]\n" +
            "[{[{({}]{}}([{[{{{}}([]\n" +
            "{<[[]]>}<{[{[{[]{()[[[]\n" +
            "[<(<(<(<{}))><([]([]()\n" +
            "<{([([[(<>()){}]>(<<{{\n" +
            "<{([{{}}[<[[[<>{}]]]>[]]";

    public static final String CORRUPTED_CHUNK = "{([(<{}[<>[]}>{[]{[(<()>";
    public static final String VALID_CHUNK_1 = "(((((((((())))))))))";
    public static final String VALID_CHUNK_2 = "{()()()}";
    public static final String VALID_CHUNK_3 = "<([{}])>";
}
