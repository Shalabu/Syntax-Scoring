package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SyntaxParserTest {

    @Test
    void testValidChunkShouldReturn0() {
        assertEquals(0, SyntaxParser.parseAndCalculatePoints(TestData.VALID_CHUNK_1));
        assertEquals(0, SyntaxParser.parseAndCalculatePoints(TestData.VALID_CHUNK_2));
        assertEquals(0, SyntaxParser.parseAndCalculatePoints(TestData.VALID_CHUNK_3));
    }

    @Test
    void testSampleLine() {
        assertEquals(SyntaxParser.illegalCharacterLookUp.get('}'), SyntaxParser.parseAndCalculatePoints(TestData.CORRUPTED_CHUNK));
    }

    @Test
    void testSampleInput() {
        assertEquals(26397, SyntaxParser.parseAndCalculatePoints(TestData.SAMPLE_INPUT));
    }
}