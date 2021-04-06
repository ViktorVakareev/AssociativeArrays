package com.softuni.fundamentals.AArrays_StreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] chars = input.toCharArray();
        Map<Character, Integer> count = new LinkedHashMap<>();

        for (char ch : chars) {
            count.putIfAbsent(ch, 0);
            count.put(ch, count.get(ch) + 1);
        }
        for (Map.Entry<Character, Integer> c : count.entrySet()) {
            if (!c.getKey().equals(' ')) {
                System.out.println(c.getKey() + " -> " + c.getValue());
            }
        }

    }
}
