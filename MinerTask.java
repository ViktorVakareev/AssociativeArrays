package com.softuni.fundamentals.AArrays_StreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> mine = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());
            mine.putIfAbsent(resource, 0);
            mine.put(resource, mine.get(resource) + quantity);

            input = scanner.nextLine();
        }
        mine.entrySet().
                stream().
                forEach(s-> System.out.println(s.getKey() + " -> " + s.getValue()));
//        for (Map.Entry<String, Integer> s : mine.entrySet()) {
//            System.out.println(s.getKey() + " -> " + s.getValue());
        }
    }

