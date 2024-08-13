package dolphinarium;

import dolphinarium.core.Controller;
import dolphinarium.core.ControllerImpl;
import dolphinarium.core.Engine;
import dolphinarium.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl();
        engine.run();
    }
}
