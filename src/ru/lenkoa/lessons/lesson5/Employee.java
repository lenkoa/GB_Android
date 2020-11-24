package ru.lenkoa.lessons.lesson5;

public class Employee {
    protected String name;
    private String position;
    protected String email;
    protected String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone, int salary, int age){
        this.name = name;
        setPosition(position);
        this.email = email;
        this.phone = phone;
        setSalary(salary);
        setAge(age);
    }

    protected void setPosition(String position) {
        this.position = position;
    }

    protected String getPosition() { return position; }

    protected void setSalary(int salary) {
        if (salary > 0 && salary < 10000000) {
            this.salary = salary;
        }
        else
            this.salary = 0;
    }

    protected int getSalary(){ return salary; }

    protected void setAge(int age) {
        if (age > 0 && age < 110) {
            this.age = age;
        }
        else
            this.age = 0;
    }

    protected int getAge(){ return age; }

    public String toString() {
        return "Сотрудник " + "ФИО='" + name + '\'' + ", должность='" + position + '\'' +
                ", e-mail=" + email + '\'' + ", зарплата=" + salary + '\'' + ", возраст=" + age;
    }

    protected void printEmployee(){
        System.out.println(this);
    }


}


