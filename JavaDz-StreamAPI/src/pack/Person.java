package pack;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private int age;
    private String gender;

    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public static void main(String[] args) {
        Collection<Person> list = Arrays.asList(
                new Person("Danya", 20, "MAN"),
                new Person("Masha", 40, "WOMEN"),
                new Person("Misha", 15, "MAN"),
                new Person("Inna", 60, "WOMEN"),
                new Person("Kirill", 35, "MAN"),
                new Person("Vika", 33, "WOMEN")
        );

        System.out.println(
                list.stream().filter(
                        (person -> person.age >= 18)
                ).filter(
                        (person ->
                                (person.gender == "WOMEN" && person.age < 60) ||
                                        (person.gender == "MAN" && person.age < 65)
                        )).collect(Collectors.toList())
        );

        System.out.println(
                list.stream().sorted((p1, p2) -> p1.name.compareTo(p2.name))
                        .collect(Collectors.toList())
        );

        int[] numbers = new int[100];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ((int) (Math.random() * 100));
        }

        System.out.println("максимальное " + Arrays.stream(numbers).max().getAsInt());
        System.out.println("минимальное " + Arrays.stream(numbers).min().getAsInt());
        System.out.println("количество всех чисел " + Arrays.stream(numbers).count());
        System.out.println("среднее " + Arrays.stream(numbers).average());
        System.out.println("сумму " + Arrays.stream(numbers).sum());
    }
}
