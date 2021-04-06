package com.softuni.fundamentals.AArrays_StreamAPI;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Shadowmourne - requires 250 Shards
//        Valanyr - requires 250 Fragments
//        Dragonwrath - requires 250 Motes
        Map<String, Integer> keyObject = new HashMap<>();
        keyObject.put("motes", 0);
        keyObject.put("shards", 0);
        keyObject.put("fragments", 0);
        Map<String, Integer> junk = new HashMap<>();


        boolean itemObtained = false;
        while (!itemObtained) {
            String[] input = scanner.nextLine().split(" ");
            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String object = input[i + 1].toLowerCase();
                if (object.equals("motes") || object.equals("fragments") || object.equals("shards")) {
                    keyObject.put(object, keyObject.get(object) + quantity);
                    if (keyObject.get("shards") >= 250) {
                        keyObject.put(object, keyObject.get(object) - 250);
                        System.out.println("Shadowmourne obtained!");
                        itemObtained=true;
                        break;
                    } else if (keyObject.get("fragments") >= 250) {
                        keyObject.put(object, keyObject.get(object) - 250);
                        System.out.println("Valanyr obtained!");
                        itemObtained=true;

                        break;
                    } else if (keyObject.get("motes") >= 250) {
                        keyObject.put(object, keyObject.get(object) - 250);
                        System.out.println("Dragonwrath obtained!");
                        itemObtained=true;

                        break;
                    }

                } else {
                    junk.putIfAbsent(object, 0);
                    junk.put(object, junk.get(object) + quantity);
                }

            }
        }
        keyObject.entrySet().
                stream().
                sorted((a, b) -> {
                    int result = b.getValue().compareTo(a.getValue());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                }).forEach(p -> System.out.println(p.getKey() + ": " + p.getValue()));

        junk.entrySet().
                stream().
                forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
