package com.softuni.fundamentals.AArrays_StreamAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> outerMap = new HashMap<>();
        Map<String, Integer> innerMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String[] commandsArray = input.split("-");
            String user = commandsArray[0];
            String language = commandsArray[1];
            int currentPoints = 0;
            int points = 0;
            if (commandsArray.length == 3) {
                points = Integer.parseInt(commandsArray[2]);
                innerMap.putIfAbsent(language, 0);
                innerMap.put(language, points);
                outerMap.put(user, innerMap);
            } else {
                currentPoints = innerMap.get(language);
                outerMap.get(language).remove(language);
            }

            input = scanner.nextLine();
        }
// result   {username} | {points}
//…
//After that print each language, used in the exam, ordered descending by total
// submission count and then by language name, in the following format:
//Submissions:
//{language} - {submissionsCount}

        System.out.println("Results:");
        outerMap.entrySet().
                stream().
                forEach(e -> {
                    String key = e.getKey();
                    int value = e.getKey().length();
                    System.out.println("Submissions:");
                    for (Map.Entry<String, Integer> s1 : innerMap.entrySet()) {
                        int submissions = innerMap.get(s1.getKey());
                        System.out.printf("%s | %d%n", key, submissions);}
//                        System.out.printf("%s | %d%n", key, value);  // user, points

                    });

                    for (Map.Entry<String, Integer> s1 : innerMap.entrySet()) {
                        int submissions = innerMap.get(s1.getKey());
                        System.out.printf("%s - %d%n", s1.getKey(), submissions);
                    }

//
                    // language, getKey.size()-language);
                }
    }
