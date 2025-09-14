package com.example.range;

import java.util.*;

public class NumberRangeFormatterImpl implements NumberRangeFormatter {

    @Override
    public String format(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        int[] distinctSorted = Arrays.stream(numbers)
                .distinct()
                .sorted()
                .toArray();

        return buildRanges(distinctSorted);
    }
    private String buildRanges(int[] numbers) {
        StringJoiner joiner = new StringJoiner(",");

        int start = numbers[0];
        int end = numbers[0];

        for (int i = 1; i <= numbers.length; i++) {
            if (i < numbers.length && numbers[i] == end + 1) {
                end = numbers[i];
            } else {
                if (start == end) {
                    joiner.add(String.valueOf(start));
                } else {
                    joiner.add(start + "-" + end);
                }

                if (i < numbers.length) {
                    start = numbers[i];
                    end = numbers[i];
                }
            }
        }

        return joiner.toString();
    }

    public static void main(String[] args) {
        NumberRangeFormatterImpl formatter = new NumberRangeFormatterImpl();
        System.out.println(formatter.format(new int[]{1,2,2,3,5,7,8,9}));
    }
}
