package com.example.range;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberRangeFormatterTest {

    private final NumberRangeFormatter formatter = new NumberRangeFormatterImpl();

    @Test
    void testSequentialNumbers() {
        assertEquals("1-3", formatter.format(new int[]{1, 2, 3}));
    }

    @Test
    void testNonSequentialNumbers() {
        assertEquals("1,3,5", formatter.format(new int[]{1, 3, 5}));
    }

    @Test
    void testMixed() {
        assertEquals("1-3,5,7-9", formatter.format(new int[]{1,2,3,5,7,8,9}));
    }

    @Test
    void testSingleNumber() {
        assertEquals("4", formatter.format(new int[]{4}));
    }

    @Test
    void testEmptyInput() {
        assertEquals("", formatter.format(new int[]{}));
    }

    @Test
    void testUnsortedInput() {
        assertEquals("1-3,5", formatter.format(new int[]{3, 1, 2, 5}));
    }

    @Test
    void testDuplicate(){
        assertEquals("1-3,5,7-9", formatter.format(new int[]{1,2,2,3,5,7,8,9}));
    }
}
