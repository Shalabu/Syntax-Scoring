package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncompleteParserTest {

    @Test
    void correctLinesShouldReturn0(){
        assertEquals(0, SyntaxParser.parseAndCalculatePoints(TestData.VALID_CHUNK_1));
        assertEquals(0, SyntaxParser.parseAndCalculatePoints(TestData.VALID_CHUNK_2));
        assertEquals(0, SyntaxParser.parseAndCalculatePoints(TestData.VALID_CHUNK_3));
    }

    @Test
    void incompleteLineShouldReturnCorrectValue(){
        assertEquals(288957, IncompleteParser.parseAndCalculatePoints(TestData.INCOMPLETE_SAMPLE_1));
        assertEquals(5566, IncompleteParser.parseAndCalculatePoints(TestData.INCOMPLETE_SAMPLE_2));
        assertEquals(1480781, IncompleteParser.parseAndCalculatePoints(TestData.INCOMPLETE_SAMPLE_3));
        assertEquals(995444, IncompleteParser.parseAndCalculatePoints(TestData.INCOMPLETE_SAMPLE_4));
        assertEquals(294, IncompleteParser.parseAndCalculatePoints(TestData.INCOMPLETE_SAMPLE_5));
        assertEquals(288957, IncompleteParser.parseAndCalculatePoints(TestData.SAMPLE_INPUT));
    }

    @Test
    void testEmptyString(){
        assertEquals(0, IncompleteParser.parseAndCalculatePoints(""));
    }
}