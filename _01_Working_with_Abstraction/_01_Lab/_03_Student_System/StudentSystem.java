package Java_OOP_June_2024._01_Working_with_Abstraction._01_Lab._03_Student_System;

public class StudentSystem {
    private final StudentRepository studentsRepository;
    private boolean running;

    public StudentSystem() {
        this.studentsRepository = new StudentRepository();
        this.running = true;
    }

    public void parseCommand(String[] args) {
        String command = args[0];

        if (command.equals("Create")) {
            String name = args[1];
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            Student student = new Student(name, age, grade);
            studentsRepository.create(name, student);

        } else if (command.equals("Show")) {
            String name = args[1];
            Student student = studentsRepository.get(name);
            if (student != null) {
                System.out.println(student);
            }

        } else {
            running = false;
        }
    }

    public boolean isRunning() {
        return running;
    }
}
