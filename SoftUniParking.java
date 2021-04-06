package com.softuni.fundamentals.AArrays_StreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> parkingMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandArray = scanner.nextLine().split(" ");
            String command = commandArray[0];
            switch (command) {
                case ("register"):
                    String name = commandArray[1];
                    String plateNumber = commandArray[2];

                    if (parkingMap.containsKey(name)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", plateNumber);
                        break;
                    } else {
                        parkingMap.putIfAbsent(name, "");
                        parkingMap.put(name, plateNumber);
                    }
                    System.out.printf("%s registered %s successfully%n", name, plateNumber);
                    break;
                case ("unregister"):
                    name = commandArray[1];
                    if (!parkingMap.containsKey(name)) {
                        System.out.printf("ERROR: user %s not found%n", name);
                    } else {
                        parkingMap.remove(name);
                        System.out.printf("%s unregistered successfully%n", name);
                    }
                    break;
            }
        }

        parkingMap.entrySet().stream().forEach(e -> System.out.printf("%s => %s%n", e.getKey(), e.getValue()));
    }
}
