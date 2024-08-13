package Java_OOP_June_2024._02_Encapsulation._03_Exercise._05_Football_Team_Generator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void fieldValidator(int value, String skillName) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(skillName + " should be between 0 and 100.");
        }
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        fieldValidator(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        fieldValidator(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        fieldValidator(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        fieldValidator(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        fieldValidator(shooting, "Shooting");
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.00;
    }
}
