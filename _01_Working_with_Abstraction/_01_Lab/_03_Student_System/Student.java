package Java_OOP_June_2024._01_Working_with_Abstraction._01_Lab._03_Student_System;

public class Student {
    private final String name;
    private final int age;
    private final double grade;


    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s is %s years old.", name, age) + getGradeCommentary();
    }

    private String getGradeCommentary() {
        if (grade >= 5.00) {
            return " Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            return " Average student.";
        }
        return " Very nice person.";
    }
}
