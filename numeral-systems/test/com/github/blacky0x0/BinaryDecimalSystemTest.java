package com.github.blacky0x0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: blacky
 * Date: 19.02.15
 */
public class BinaryDecimalSystemTest {
    @Test
    public void testToBinaryDecimalNumber() throws Exception {
        int number = 3691;
        String strNumber = "0011011010010001";

        assertEquals(strNumber, BinaryDecimalSystem.toBinaryDecimalNumber(number));
    }

    @Test
    public void testToDecimalNumber() throws Exception {
        int number = 8072;
        String strNumber = "1000000001110010";

        assertEquals(number, BinaryDecimalSystem.toDecimalNumber(strNumber));
    }

}
