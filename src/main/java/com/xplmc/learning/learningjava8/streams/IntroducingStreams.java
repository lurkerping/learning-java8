package com.xplmc.learning.learningjava8.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * introducing streams example
 */
public class IntroducingStreams {

    public static void main(String[] args) {
        Dish.DISH_LIST
                .stream()
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .forEach(System.out::println);

        //filter high calories dishes, sort by calorie, return the dish name
        List<String> myFavoriteDishes = Dish.DISH_LIST.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(myFavoriteDishes);

        //filter low calories dishes, sort by calorie desc, return the top 3 dish name
        List<String> top3HighCaloriesDishes = Dish.DISH_LIST.stream()
                .filter(dish -> dish.getCalories() > 200)
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .limit(3)
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(top3HighCaloriesDishes);
    }

}
