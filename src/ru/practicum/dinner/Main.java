package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dinnerConstructor;
    static Scanner scanner;

    public static void main(String[] args) {
        dinnerConstructor = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine().trim();
            switch (command) {
                case "1" -> addNewDish();
                case "2" -> generateDishCombo();
                case "3" -> System.out.println("Программа завершена. \nСпасибо за использование");
                default -> System.out.println("Такой команды нет."); //Should we throw exception here?
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine().trim();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine().trim();

        dinnerConstructor.addNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        // Check if in out HashMap are some dished and categories to cunstruct smth.
        if (dinnerConstructor.isMenuEmpty()) {
            return;
        }
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine().trim();

        //реализуйте ввод типов блюд
        ArrayList<String> selectedTypes = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dinnerConstructor.checkType(nextItem)) {
                selectedTypes.add(nextItem);
            } else {
                System.out.println("Такой тип блюд мы еще не умеем готовить. Попробуйте что-нибудь другое!");
            }
            nextItem = scanner.nextLine();
        }

        ArrayList<String> generatedCombos = dinnerConstructor.generateCombos(numberOfCombos, selectedTypes);
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбинация " + i);
            System.out.println(generatedCombos.get(i));
        }
    }
}
