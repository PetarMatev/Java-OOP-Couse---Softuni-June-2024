package Java_OOP_June_2024._02_Encapsulation._03_Exercise._05_Football_Team_Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static String[] input = null;
    private static final List<Team> teamlist = new ArrayList<>();

    public static void main(String[] args) {
        readFromConsole(scan);
        while (!input[0].equals("END")) {
            try {
                executeCommand();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
            readFromConsole(scan);
        }
    }

    private static void executeCommand() {
        String mainCommand = input[0];
        String teamName = input[1];
        switch (mainCommand) {
            case "Team":
                Team team = new Team(teamName);
                teamlist.add(team);
                break;
            case "Add":
                addPlayerToTeam(input, teamlist, teamName);
                break;
            case "Remove":
                removePlayerFromTeam(input, teamlist, teamName);
                break;
            case "Rating":
                showTeamRating(teamlist, teamName);
                break;
        }
    }

    private static void readFromConsole(Scanner scan) {
        input = scan.nextLine().split(";");
    }

    private static void showTeamRating(List<Team> teamList, String teamName) {
        Team searchedTeam = teamList.stream().filter(t -> t.getName().equals(teamName)).findFirst().orElse(null);
        if (searchedTeam == null) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        } else {
            System.out.println(searchedTeam.getName() + " - " + Math.round(searchedTeam.getRating()));
        }
    }

    private static void addPlayerToTeam(String[] info, List<Team> teamList, String teamName) {

        String playerName = info[2];
        int endurance = Integer.parseInt(info[3]);
        int sprint = Integer.parseInt(info[4]);
        int dribble = Integer.parseInt(info[5]);
        int passing = Integer.parseInt(info[6]);
        int shooting = Integer.parseInt(info[7]);

        Team searchedTeam = teamList.stream().filter(t -> t.getName().equals(teamName)).findFirst().orElse(null);

        if (searchedTeam == null) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        } else {
            try {
                Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                searchedTeam.addPlayer(player);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void removePlayerFromTeam(String[] info, List<Team> teamList, String teamName) {
        String playerName = info[2];
        Team searchedTeam = teamList.stream().filter(t -> t.getName().equals(teamName)).findFirst().orElse(null);

        if (searchedTeam == null) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        } else {
            try {
                searchedTeam.removePlayer(playerName);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
