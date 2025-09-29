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
            е
        }

        dishesForType.add(dishName);
    }

    public ArrayList<String> generateCombos(int comboNumber, ArrayList<String> dishTypes) {
        ArrayList<String> combos = new ArrayList<>();
        for (int i = 0; i <= comboNumber; i++) {
            String combo = generateCombo(dishTypes);
            combos.add(combo);
        }
        return combos;
    }


    public boolean checkType(String type) {
        return dinnersByType.containsKey(type);
    }


    private String generateCombo(ArrayList<String> dishTypes) {
        ArrayList<String> selectedDishes = new ArrayList<>();
        for (String dishType : dishTypes) {
            ArrayList<String> availableDishes = dinnersByType.get(dishType);
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
