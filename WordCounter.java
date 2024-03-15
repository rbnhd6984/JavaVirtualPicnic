package org.example.JavaVirtualPicnic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    private Map<String, FoodItem> basket;
    private Map<String, Integer> wordFrequency;
    private String longestWord = "";
    private List<String> longestWords;
    private int totalWords;

    public WordCounter() {
        basket = new HashMap<>();
        basket.put("яблоко", new Fruit("яблоко"));
        basket.put("банан", new Fruit("банан"));
        basket.put("огурец", new Vegetable("огурец"));
        basket.put("морковь", new Vegetable("морковь"));
        basket.put("помидор", new Vegetable("помидор"));
        basket.put("арбуз", new Fruit("арбуз"));
        wordFrequency = new HashMap<>();
        longestWords = new ArrayList<>();
        totalWords = 0;
    }

    public void processFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    totalWords++;
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                        longestWords.clear();
                        longestWords.add(word);
                    } else if (word.length() == longestWord.length() && !longestWords.contains(word)) {
                        longestWords.add(word);
                    }
                }
            }
            System.out.println("Общее количество слов: " + totalWords);
            System.out.println("Самые длинные слова: " + longestWords);
            System.out.println("Частота каждого слова: " + wordFrequency);
            System.out.println("Самые популярные фрукты: " + findMostFrequentFoodItem("фрукт"));
            System.out.println("Самые популярные овощи: " + findMostFrequentFoodItem("овощ"));
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private List<String> findMostFrequentFoodItem(String category) {
        int maxFrequency = 0;
        List<String> mostFrequentFoodItems = new ArrayList<>();
        for (Map.Entry<String, FoodItem> entry : basket.entrySet()) {
            if (entry.getValue().getCategory().equals(category)) {
                int frequency = wordFrequency.getOrDefault(entry.getKey(), 0);
                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                    mostFrequentFoodItems.clear();
                    mostFrequentFoodItems.add(entry.getKey());
                } else if (frequency == maxFrequency && !mostFrequentFoodItems.contains(entry.getKey())) {
                    mostFrequentFoodItems.add(entry.getKey());
                }
            }
        }
        return mostFrequentFoodItems;
    }
}