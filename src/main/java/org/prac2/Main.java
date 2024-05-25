package org.prac2;

import java.time.LocalDate;
import java.util.*;

public class Main {

    static List<Human> generateList(int n) {
        Random random = new Random();
        List<String> names = Arrays.asList("Stepa", "Gosha", "Loh", "Nikita", "Andrey");
        List<String> lastNames = Arrays.asList("Goroh", "Tilt", "Aleks", "Korol", "Koshey");
        List<Human> humans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String currentName = names.get(random.nextInt(0, 5));
            String currentLastName = lastNames.get(random.nextInt(0,5));
            int age = random.nextInt(1, 100);
            LocalDate birthDate = LocalDate.of(random.nextInt(1900, 2000), random.nextInt(1, 12), random.nextInt(1, 28));
            int weight = random.nextInt(100, 120);
            humans.add(new Human(
                    age,
                    currentName,
                    currentLastName,
                    birthDate,
                    weight
            ));
        }
        return humans;
    }
    public static void main(String[] args) {
        List<Human> humanList = generateList(10);
        System.out.println(humanList);
        OptionalDouble value = humanList.stream().sorted((o1, o2) -> -Integer.compare(o1.age(), o2.age()))
                .filter((h1) -> h1.firstName().startsWith("A"))
                .sorted(Comparator.comparing(Human::birthDate))
                .mapToDouble(Human::weight)
                .average();
        if (value.isPresent()) {
            System.out.println(value.getAsDouble());
        }
    }
}
