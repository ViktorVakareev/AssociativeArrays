package com.softuni.fundamentals.AArrays_StreamAPI;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<Double>> gradesMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            gradesMap.putIfAbsent(name, new ArrayList<>());
            gradesMap.get(name).add(grade);
        }
        gradesMap.entrySet().
                stream().
                sorted((a, b) -> {           // СОРТИРАНЕ
                    double firstAverage = a.getValue().  // List<Double> e value!(key e String)
                            stream(). //iterate po List<Double>
                            mapToDouble(Double::doubleValue).   // правя Лист-а ЧИСЛОВ
                            average().   // изчислявам average ot el-tite na List-a
                            getAsDouble();  // взимам си ст-ст double
                    double secondAverage = b.getValue().  // List<Double> e value!(key e String)
                            stream(). //iterate po List<Double>
                            mapToDouble(Double::doubleValue). //правя ел-тите double
                            average().   // правя average от ел-тите на List<Double>
                            getAsDouble();

                    return Double.compare(secondAverage, firstAverage); // descending order by average value
                }).
                forEach(e -> { // ПЕЧАТ+ПРОВЕРКА<=4.50
                    double average = e.getValue().
                            stream().
                            mapToDouble(Double::doubleValue).
                            average().
                            getAsDouble();
                    if (average >= 4.50) {
                        System.out.printf("%s -> %.2f%n", e.getKey(), average);
                    }

                });

    }
}
