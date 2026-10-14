package ru.academits.alaeva.lambdas_main;

import ru.academits.alaeva.lambdas.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Андрей", 18));
        persons.add(new Person("Андрей", 25));
        persons.add(new Person("Богдана", 10));
        persons.add(new Person("Виталий", 15));
        persons.add(new Person("Дмитрий", 30));
        persons.add(new Person("Евгения", 40));
        persons.add(new Person("Жак", 6));
        persons.add(new Person("Зоя", 30));
        persons.add(new Person("Дмитрий", 40));

        System.out.println("Список persons:");

        for (Person person : persons) {
            System.out.println(person.getName() + ", " + person.getAge());
        }

        // пункт А И Б получить список уникальных имен + вывести список в формате Имена: А, Б, С
        System.out.println("============Список уникальных имен:=============");
        List<String> uniqueNames = persons.stream()
                .map(person -> person.getName())
                .distinct()
                .collect(Collectors.toList());// возвращаем список

        // вывод уникальных имен через stream
        String names = uniqueNames.stream()
                .collect(Collectors.joining(", ", "Имена: ", "."));
        System.out.println(names);

// пункт В Список людей младше 18 и их средний возраст
        System.out.println("============ Список людей младше 18 и их средний возраст:=============");

        List<Person> personsUnder18 = persons.stream()
                .filter(person -> person.getAge() < 18)
                .collect(Collectors.toList());

        for (Person p : personsUnder18) {
            System.out.println(p.getName() + ", " + p.getAge());
        }

        double averageAge = personsUnder18.stream()
                .mapToInt(person -> person.getAge())
                .average()
                .orElse(0);

        System.out.printf("Средний возраст: %.2f%n", averageAge);

        // Г. при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст
        System.out.println("Map, в котором ключи – имена, а значения – средний возраст: ");

        Map<String, Double> averageAgeByName = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getName,
                        Collectors.averagingInt(Person::getAge)
                )); // возвращаем Map

        System.out.println(averageAgeByName);

        // Д. получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста
        System.out.println("============ Список людей, возраст которых от 20 до 45, имена в порядке убывания возраста: =============");

        persons.stream()
                .filter(person -> person.getAge() <= 45 && person.getAge() >= 20)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .map(person -> person.getName())
                .forEach(name-> System.out.println(name));
    }
}