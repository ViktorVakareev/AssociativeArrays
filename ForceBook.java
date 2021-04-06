package com.softuni.fundamentals.AArrays_StreamAPI;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> sideMap = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Lumpawaroo")) {
            String[] commandArray = input.split(" \\| ");
            if (commandArray.length == 2) {
                String side = commandArray[0];
                String user = commandArray[1];
                List<String> test = sideMap.get(side);
                sideMap.putIfAbsent(side, new ArrayList<>());
//                sideMap.get(side).add(user);
                sideMap.put(side,test);
            } else {
                String[] commandArray2 = input.split(" -> ");
                String side = commandArray2[1];
                String user = commandArray2[0];

                    if (sideMap.containsValue(user)) {
                        int index = sideMap.get(side).indexOf(user);
                        sideMap.get(side).remove(user);
                        sideMap.get(side).set(index, user);
                    }

                sideMap.putIfAbsent(side, new ArrayList<>());
                sideMap.get(side).add(user);
                System.out.printf("%s joins the %s side!%n", user, side);

            }

            input = scanner.nextLine();
        }
        sideMap.entrySet().

                stream().

                forEach(e ->

                {
                    System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                    for (int i = 0; i < sideMap.get(e.getKey()).size(); i++) {
                        System.out.printf("! %s%n", e.getValue().get(i));
                    }
                });
    }
}
