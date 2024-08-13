package restaurant.core;

import restaurant.common.Command;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EngineImpl implements Engine {
    private final Controller controller;
    private final Scanner scanner;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.scanner.nextLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        result = switch (command) {
            case AddWaiter -> addWaiter(data);
            case AddClient -> addClient(data);
            case RemoveWaiter -> removeWaiter(data);
            case RemoveClient -> removeClient(data);
            case TakeOrders -> startWorking(data);
            case GetStatistics -> getStatistics();
            case Exit -> Command.Exit.name();
        };

        return result;
    }


    private String addWaiter(String[] data) {
        return this.controller.addWaiter(data[0], data[1]);
    }

    private String addClient(String[] data) {
        String clientName = data[0];
        String[] order = Arrays.stream(data).skip(1).toArray(String[]::new);
        return controller.addClient(clientName, order);
    }

    private String removeWaiter(String[] data) {
        return this.controller.removeWaiter(data[0]);
    }

    private String removeClient(String[] data) {
        return this.controller.removeClient(data[0]);
    }

    private String startWorking(String[] data) {
        return this.controller.startWorking(data[0]);
    }

    private String getStatistics() {
        return this.controller.getStatistics();
    }


}
