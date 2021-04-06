package com.softuni.fundamentals.AArrays_StreamAPI;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> usersMap = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandArray = input.split(" -> ");
            String company = commandArray[0];
            String employeeId = commandArray[1];

            usersMap.putIfAbsent(company, new ArrayList<>());

            if (usersMap.get(company).contains(employeeId)) {
                input = scanner.nextLine();
                continue;
            } else {
                usersMap.get(company).add(employeeId);
            }

            input = scanner.nextLine();
        }
        usersMap.entrySet().
                forEach(e -> {
                    System.out.printf("%s%n", e.getKey());
                    for (int i = 0; i < e.getValue().size(); i++) {
                        System.out.printf("-- %s%n", e.getValue().get(i));
                    }
                });
    }
}
