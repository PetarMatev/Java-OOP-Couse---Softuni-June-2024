package Java_OOP_June_2024._01_Working_with_Abstraction._01_Lab._03_Student_System;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {

    private final Map<String, Student> studentsByName;

    public StudentRepository() {
        this.studentsByName = new HashMap<>();
    }

    public void create(String name, Student student) {
        studentsByName.putIfAbsent(name, student);
    }

    public Student get(String name) {
        return studentsByName.get(name);
    }

}
