package ru.lenkoa.lessons2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, ArrayList<String>> data = new HashMap<>();

    public void add(String surname, String phone){
        if (!data.containsKey(surname))
            data.put(surname, new ArrayList<>());

        if (!data.get(surname).contains(phone))
            data.get(surname).add(phone);
    }

    public String get(String surname){
        if (!data.containsKey(surname))
            return null;

        StringBuilder phones = new StringBuilder();
        for (String phone : data.get(surname))
            phones.append(phone).append("\n");
        System.out.println(surname + ", телефон(ы): " + phones); // для тестирования
        return phones.toString(); // Возвращаем. Мало ли для чего их искали
    }

    public static void main(String[] args){
        PhoneBook book = new PhoneBook();
        book.add("Иванов", "+7(900)000-00-00");
        book.add("Петров", "+7(911)111-11-11");
        book.add("Петров", "+7(922)222-22-22");

        book.get("Петров");
    }
}
