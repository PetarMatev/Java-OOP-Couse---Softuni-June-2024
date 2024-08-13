package furnitureFactory;

import furnitureFactory.core.Controller;
import furnitureFactory.core.ControllerImpl;
import furnitureFactory.core.Engine;
import furnitureFactory.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl();
        engine.run();
    }
}