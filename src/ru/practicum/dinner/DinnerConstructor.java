package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dinnersByType = new HashMap<>();
    Random random = new Random();


    public void addNewDish(String dishType, String dishName) {
        ArrayList<String> dishesForType;
        if (dinnersByType.containsKey(dishType)) {
            dishesForType = dinnersByType.get(dishType);
        } else {
            dishesForType = new ArrayList<>();
            dinnersByType.put(dishType, dishesForType);
        }

        dishesForType.add(dishName);
    }

    public ArrayList<String> generateCombos(int comboNumber, ArrayList<String> dishTypes) {
        ArrayList<String> combos = new ArrayList<>();
        String combo;
        for (int i = 0; i <= comboNumber; i++) {
            combo = generateCombo(dishTypes);
            combos.add(combo);
        }
        return combos;
    }

    public boolean isMenuEmpty() {
        if (dinnersByType.isEmpty()) {
            System.out.println("Наше меню не содержит ни одной позиции.");
            return true;
        } else {
            return false;
        }
    }

    public boolean checkType(String type) {
        return dinnersByType.containsKey(type);
    }


    private String generateCombo(ArrayList<String> dishTypes) {
        ArrayList<String> selectedDishes = new ArrayList<>();
        ArrayList<String> availableDishes;
        for (String dishType : dishTypes) {
            availableDishes = dinnersByType.get(dishType);
            String selectedDish = getRandomDish(availableDishes);
            selectedDishes.add(selectedDish);
        }
        return String.join(",", selectedDishes);
    }

    private String getRandomDish(ArrayList<String> availableDishes) {
        int numberOfDishesForType = availableDishes.size();
        int dishIndex = random.nextInt(numberOfDishesForType);
        return availableDishes.get(dishIndex);
    }

}
