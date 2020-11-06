package ru.lenkoa.lessons.lesson5;

public class Main {
    public static void main(String[] args){
        Employee[] exampleEmployees = new Employee[5];
        exampleEmployees[0] = new Employee("Тайсон Иринович Московский-Парадный",
                "Руководитель отдела обеспечения комфорта персонала", "tayson@ourmail.com",
                "+7(926)000-00-00", 10000, 19);
        exampleEmployees[1] = new Employee("Бонифаций Тайсюшевич Наташин",
                "Зам. по мурлыканью","bonifatius@ourmail.com",
                "+7(926)111-11-11", 5000, 5);
        exampleEmployees[2] = new Employee("Бенито Муссолини",
                "Зам. по потиранию о ноги","benito@ourmail.com",
                "+7(926)222-22-22", 4000, 13);
        exampleEmployees[3] = new Employee("Варвара Богдансдоттир",
                "Ведущий специалист по тыгыдым и беспорядкам","barbra@ourmail.com",
                "+7(926)123-45-76", 5000, 13);
        exampleEmployees[4] = new Employee("Дуся Соседская",
                "Приглашенный консультант по мышам", "dusya@ourmail.com",
                "+7(926)333-33-33", 3000, 14);

        for (int i = 0; i < exampleEmployees.length; i++) {
            if (exampleEmployees[i].getAge() >= 10){
                exampleEmployees[i].printEmployee();
            }
        }

    }


}
