package com.github.blacky0x0.numeralsystems;

/**
 * User: blacky
 * Date: 16.02.15
 */
public class BinaryDecimalSystem {

    /**
     * Converts a decimal number to binary decimal string.
     *
     * <p>For example: 42 -> 01000010
     * <ul>
     *     <li>4 -> 0100</li>
     *     <li>2 -> 0010</li>
     * </p>
     * @param decimalNumber  a {@code long} value
     * @return a binary decimal string
     */
    public static String toBinaryDecimalNumber(long decimalNumber) {
        StringBuilder sb = new StringBuilder();
        String number = String.valueOf(decimalNumber);

        for (int i = 0; i < number.length(); i++)
            sb.append(binaryDecimalTable[Integer.parseInt(number.substring(i, i + 1))]);

        return sb.toString();
    }

    /**
     * Converts a binary decimal string to decimal number.
     *
     * <p>For example: 01000010 -> 42
     * <ul>
     *     <li>0100 -> 4</li>
     *     <li>0010 -> 2</li>
     * </p>
     * @param binaryDecimalNumber a string value
     * @return a decimal number
     */
    public static long toDecimalNumber(String binaryDecimalNumber) {
        if (binaryDecimalNumber.length() % 4 != 0 )
            throw new IllegalArgumentException("The length must be a multiple of 4");

        int length = binaryDecimalNumber.length() / 4;
        long result = 0;

        for (int i = 0, k = length - 1; i < length; i++, k--) {
            long value = getIntegerFromBinary(String.valueOf(binaryDecimalNumber.subSequence(i * 4, i * 4 + 4)));
            result = result + value * (long) Math.pow(10, k);
        }

        return result;
    }

    public static int getIntegerFromBinary(String binaryNumber) {
        switch (binaryNumber) {
            case "0000":
                return 0;
            case "0001":
                return 1;
            case "0010":
                return 2;
            case "0011":
                return 3;
            case "0100":
                return 4;
            case "0101":
                return 5;
            case "0110":
                return 6;
            case "0111":
                return 7;
            case "1000":
                return 8;
            case "1001":
                return 9;
        }

        throw new IllegalArgumentException("The received string is not a binary-decimal number: " + binaryNumber);
    }

    final static String[] binaryDecimalTable = {
            "0000", // 0
            "0001", // 1
            "0010", // 2
            "0011", // 3
            "0100", // 4
            "0101", // 5
            "0110", // 6
            "0111", // 7
            "1000", // 8
            "1001"  // 9
    };

}
