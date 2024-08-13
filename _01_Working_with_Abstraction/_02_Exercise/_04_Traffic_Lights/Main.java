package Java_OOP_June_2024._01_Working_with_Abstraction._02_Exercise._04_Traffic_Lights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Color[] colors = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Color::valueOf).toArray(Color[]::new);

        int n = Integer.parseInt(scan.nextLine());

        List<TrafficLight> trafficLightList = new ArrayList<>();
        for(Color color : colors) {
            // create new TrafficLight which has color of this color.
            TrafficLight trafficLight = new TrafficLight(color);
            trafficLightList.add(trafficLight);
        }

        // list of TrafficLights
        for (int i=0; i < n; i++) {
            // change the color
            for (TrafficLight trafficLight : trafficLightList) {
                trafficLight.changeColor();
                System.out.print(trafficLight.getColor() + " ");
            }
            System.out.println();
        }
    }
}
