package vehicleShop.core;

import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

import static vehicleShop.common.ConstantMessages.*;
import static vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    VehicleRepository vehicleRepository;
    WorkerRepository workerRepository;
    Shop shop;

    public ControllerImpl() {
        this.vehicleRepository = new VehicleRepository();
        this.workerRepository = new WorkerRepository();
        this.shop = new ShopImpl();
    }

    @Override
    public String addWorker(String type, String workerName) {

        Worker worker;
        if (type.equals("FirstShift")) {
            worker = new FirstShift(workerName);
        } else if (type.equals("SecondShift")) {
            worker = new SecondShift(workerName);
        } else {
            throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
        }

        workerRepository.add(worker);
        return String.format(ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);
        vehicleRepository.add(vehicle);
        return String.format(SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {

        Tool tool = new ToolImpl(power);
        Worker searchedWorker = workerRepository.findByName(workerName);
        if (searchedWorker == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        searchedWorker.addTool(tool);
        return String.format(SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {

        // 01. Find vehicle by his name;
        Vehicle vehicle = vehicleRepository.findByName(vehicleName);

        // 02. Find all workers by strength above 70;
        List<Worker> workers = workerRepository
                .getWorkers()
                .stream()
                .filter(worker -> worker.getStrength() > 70)
                .collect(Collectors.toList());

        // 03. If I don't have workers throw error:
        if (workers.isEmpty()) {
            throw new IllegalArgumentException(NO_WORKER_READY);
        }

        // 04. Each Worker will try to repair the vehicle
        long countBrokenTools = 0;
        for (Worker worker : workers) {
            shop.make(vehicle, worker);
            countBrokenTools += worker.getTools().stream().filter(tool -> tool.isUnfit()).count();
        }

        String vehicleOutput;
        if (vehicle.reached()) {
            vehicleOutput = String.format(VEHICLE_DONE, vehicle.getName(), "done");
        } else {
            vehicleOutput = String.format(VEHICLE_DONE, vehicle.getName(), "not done");
        }
        String brokenToolOutput = String.format(COUNT_BROKEN_INSTRUMENTS, countBrokenTools);

        return vehicleOutput + brokenToolOutput;
    }

    @Override
    public String statistics() {
        StringBuilder stringBuilder = new StringBuilder();
        long countReadyVehicle = vehicleRepository.getWorkers().stream().filter(vehicle -> vehicle.reached()).count();
        stringBuilder.append(String.format("%d vehicles are ready!", countReadyVehicle)).append(System.lineSeparator());
        stringBuilder.append("Info for workers:").append(System.lineSeparator());

        for (Worker worker : workerRepository.getWorkers()) {
            stringBuilder.append(String.format("Name: %s, Strength: %d", worker.getName(), worker.getStrength())).append(System.lineSeparator());
            long fitTools = worker.getTools().stream().filter(tool -> !tool.isUnfit()).count();
            stringBuilder.append(String.format("Tools: %d fit left", fitTools)).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
