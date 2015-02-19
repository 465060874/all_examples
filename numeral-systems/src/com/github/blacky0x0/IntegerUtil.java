package com.github.blacky0x0;

import java.util.Arrays;

/**
 * User: blacky
 * Date: 16.02.15
 */
public class IntegerUtil {

    /**
     * Direct code for 32 bits. For absolute value.
     * @param num decimal value
     * @return direct binary code for 32 bits
     */
    public static String getDirectCodeForAbsoluteValue(int num) {
        char[] leadingChars = new char[Integer.numberOfLeadingZeros(Math.abs(num))];
        String result = Integer.toBinaryString(Math.abs(num));
        Arrays.fill(leadingChars, '0');

        if (num == 0)
            return String.valueOf(leadingChars);

        return String.valueOf(leadingChars).concat(result);
    }

    /**
     * Direct code for 32 bits. Exclude negative zero (-0) value.
     *
     * <p>For example:
     * <ul>
     *     <li>-1 -> 10000000000000000000000000000001</li>
     *     <li>&nbsp;1 -> 00000000000000000000000000000001</li>
     * </p>
     * @param num decimal value
     * @return direct binary code for 32 bits
     */
    public static String getDirectCode(int num) {
        String result = getDirectCodeForAbsoluteValue(num);

        if (sign(num) == -1)
            result = "1".concat(result.substring(1));

        return result;
    }

    /**
     * Inverts ones to zeros & the other way around.
     <p>For example:
     * <ul>
     *     <li>1101 -> 0010</li>
     * </p>
     * @param code contains of ones & zeros
     * @return inverted values in string
     */
    public static String invertBits(String code) {
        StringBuilder sb = new StringBuilder(code.length());
        for (char ch : code.toCharArray()) {
            if (ch == '1')
                sb.append('0');
            else
                sb.append('1');
        }

        return sb.toString();
    }

    /**
     * Reverse code for 32 bits. Exclude negative zero (-0) value.
     * @param num decimal value
     * @return reverse binary code for 32 bits
     */
    public static String getReverseCode(int num) {
        if (sign(num) == -1)
            return invertBits(getDirectCodeForAbsoluteValue(num));

        return getDirectCodeForAbsoluteValue(num);
    }

    /**
     * Additional code for 32 bits. Exclude negative zero (-0) value.
     * @param num decimal value
     * @return additional binary code for 32 bits
     */
    public static String getAdditionalCode(int num) {
        char[] leadingChars = new char[Integer.numberOfLeadingZeros(num)];
        String result = Integer.toBinaryString(num);
        Arrays.fill(leadingChars, '0');

        if (num == 0)
            return String.valueOf(leadingChars);

        return String.valueOf(leadingChars).concat(result);
    }

    public static int signBit(float f) {
        return Float.floatToIntBits(f)>>>31;
    }

    public static int sign(int i) {
        if (i == 0) return 0;
        if (i >> 31 == 0) return +1;
        return -1;
    }

    public static String getFormattedCode(String code) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < code.length() / 4; i++) {
            sb.append(code.substring(i * 4, i * 4 + 4));
            sb.append(' ');
        }

        return sb.toString();
    }

    public static String getRuller() {
        return "7654 3210 7654 3210 7654 3210 7654 3210";
    }
}
