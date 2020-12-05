package ru.lenkoa.lessons2.lesson3;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main (String[] args){
        String[] words = {"кот", "котейка", "котэ", "кошак", "кот", "код", "котэ", "котейка",
                "котище",  "котищище",  "код",  "кошак",  "барагоз",  "кот", "код", "кошак",
                "котищище",  "котэ", "котище", "кыш"};

        Map<String, Integer > countedWords = new HashMap<>();

        for (String word : words) {
            if (countedWords.containsKey(word)){
                countedWords.replace(word, countedWords.get(word) + 1);
            } else {
                countedWords.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : countedWords.entrySet()){
            System.out.println(MessageFormat.format("Слово: {0}, Встречается раз: {1}", entry.getKey(), entry.getValue()));
        }
    }
}
