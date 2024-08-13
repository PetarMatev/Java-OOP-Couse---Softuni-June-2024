package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

import java.util.Collection;
import java.util.Iterator;

public class ShopImpl implements Shop {
    @Override
    public void make(Vehicle vehicle, Worker worker) {

        boolean hasWorkerFitTool = worker.getTools().stream().anyMatch(tool -> !tool.isUnfit());

        // While Worker Can Work & Worker has fit Tool & vehicle is not repaired.
        while (worker.canWork() && hasWorkerFitTool && !vehicle.reached()) {
            // 1. Taking Tool that I can fix the vehicle
            Tool toolToUse = worker.getTools().stream().filter(tool -> !tool.isUnfit()).findFirst().get();
            // 2. to use the Instrument
            toolToUse.decreasesPower();
            // 3. to fix the vehicle
            vehicle.making();
            // 4. to make the worker work
            worker.working();

            // 5. Check again if I still have an instrument that can be used to fix the car.
            hasWorkerFitTool = worker.getTools().stream().anyMatch(tool -> !tool.isUnfit());
        }
//
//        Collection<Tool> tools = worker.getTools();
//        Iterator<Tool> iterator = tools.iterator();
//
//        while (iterator.hasNext() ) {
//            Tool tool = iterator.next();
//
//            while (!tool.isUnfit() && worker.canWork() && !vehicle.reached()) {
//                tool.decreasesPower();
//                vehicle.making();
//                worker.working();
//
//                if (tool.isUnfit()) {
//                    break;
//                }
//            }
//
//            if (vehicle.reached()) {
//                break;
//            }
//        }
    }
}
