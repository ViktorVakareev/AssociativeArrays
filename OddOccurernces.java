package com.softuni.fundamentals.AArrays_StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OddOccurernces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Map<String, Integer> words = new LinkedHashMap<>();
        Map<String, Integer> filter = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            String word = input[i].toLowerCase();
            words.putIfAbsent(word, 0);
            words.put(word, words.get(word) + 1);
        }
        List<String> print = new ArrayList<>();
        words.entrySet().stream().
                filter(e -> e.getValue() % 2 != 0).
                forEach(e -> print.add(e.getKey()));

      System.out.println(String.join(", ", print));

    }

}

