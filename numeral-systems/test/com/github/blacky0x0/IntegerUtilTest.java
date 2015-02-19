package com.github.blacky0x0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: blacky
 * Date: 19.02.15
 */
public class IntegerUtilTest {
    @Test
    public void testGetDirectCodeForAbsoluteValue() throws Exception {
        int number = -32;
        String strNumber = "00000000000000000000000000100000";

        assertEquals(strNumber, IntegerUtil.getDirectCodeForAbsoluteValue(number));
    }

    @Test
    public void testGetDirectCode() throws Exception {
        int number = -32;
        String strNumber = "10000000000000000000000000100000";

        assertEquals(strNumber, IntegerUtil.getDirectCode(number));
    }

    @Test
    public void testInvertBits() throws Exception {
        String strNumber = "10000000000000000000000000100000";
        String resultNumber = "01111111111111111111111111011111";

        assertEquals(resultNumber, IntegerUtil.invertBits(strNumber));
    }

    @Test
    public void testGetReverseCode() throws Exception {
        int number = -32;
        String strNumber = "11111111111111111111111111011111";

        assertEquals(strNumber, IntegerUtil.getReverseCode(number));
    }

    @Test
    public void testGetAdditionalCode() throws Exception {
        int number = -32;
        String strNumber = "11111111111111111111111111100000";

        assertEquals(strNumber, IntegerUtil.getAdditionalCode(number));
    }
}
