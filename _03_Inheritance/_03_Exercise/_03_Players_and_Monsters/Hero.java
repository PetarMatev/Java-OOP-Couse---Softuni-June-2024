package Java_OOP_June_2024._03_Inheritance._03_Exercise._03_Players_and_Monsters;

public class Hero {

    private String username;
    private int level;

    public Hero(String username, int level) {
        setUsername(username);
        setLevel(level);
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                this.getUsername(),
                this.getLevel());
    }
}
