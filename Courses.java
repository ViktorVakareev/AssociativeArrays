package com.softuni.fundamentals.AArrays_StreamAPI;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> courseMap = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String commandArray[] = input.split(" : ");
            String courseName = commandArray[0];
            String student = commandArray[1];

            courseMap.putIfAbsent(courseName, new ArrayList<>());
            courseMap.get(courseName).add(student);

            input = scanner.nextLine();
        }

        courseMap.entrySet().stream().
                sorted((a, b) -> b.getValue().size() - a.getValue().size())   //descending count courses
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue().stream().
                            sorted((x, y) -> x.compareTo(y)).   // ascending count student
                            forEach(s -> System.out.println("-- " + s));
                });

//        for (Map.Entry<String, ArrayList<String>> s : courseMap.entrySet()) {
//            System.out.printf("%s: %d%n", s.getKey(), s.getValue().size());
//            for (int i = 0; i < s.getValue().size(); i++) {
//                System.out.printf("-- %s%n", s.getValue().get(i));
//            }
//        }

    }
}
