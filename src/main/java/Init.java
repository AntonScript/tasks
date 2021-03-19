import model.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Init {
    Map<String, CargoStorage> cargoStorage;
    Map<String, ArrayDeque<Plane>> planes;

    public Init(Map<String, CargoStorage> cargoStorage, Map<String, ArrayDeque<Plane>> planes) {
        this.cargoStorage = cargoStorage;
        this.planes = planes;
        startup();
    }

    public void startup(){
        packerPlane(new Plane(15, PlaneType.alive,"Москва"));
        packerPlane(new Plane(100, PlaneType.alive,"Ульяновск"));
        packerPlane(new Plane(15, PlaneType.alive,"Москва"));
        packerCargo(new Cargo(5,CargoType.alive,"Москва"));
        packerCargo(new Cargo(15,CargoType.alive,"Москва"));
        packerCargo(new Cargo(5,CargoType.alive,"Ульяновск"));
        packerCargo(new Cargo(50,CargoType.dangerous,"Ульяновск"));
        packerCargo(new Cargo(25,CargoType.ordinary,"Ульяновск"));


    }

    public void packerPlane(Plane plane){
        if(planes.get(plane.getEndpoint()) == null)
            planes.put(plane.getEndpoint(),new ArrayDeque<>());
        planes.get(plane.getEndpoint()).add(plane);
    }

    public void packerCargo(Cargo cargo){
        if(cargo.getType().equals(CargoType.alive)){
            if(cargoStorage.get(cargo.getEndpoint()) == null)
                cargoStorage.put(cargo.getEndpoint(), new CargoStorage());
            cargoStorage.get(cargo.getEndpoint()).getCargoStorageAlive().add(cargo);
        }else if(cargo.getType().equals(CargoType.perishable)){
            if(cargoStorage.get(cargo.getEndpoint()) == null)
                cargoStorage.put(cargo.getEndpoint(), new CargoStorage());
            cargoStorage.get(cargo.getEndpoint()).getCargoStoragePerishable().add(cargo);
        }else if(cargo.getType().equals(CargoType.dangerous)){
            if(cargoStorage.get(cargo.getEndpoint()) == null)
                cargoStorage.put(cargo.getEndpoint(), new CargoStorage());
            cargoStorage.get(cargo.getEndpoint()).getCargoStorageDangerous().add(cargo);
        }else if(cargo.getType().equals(CargoType.ordinary)){
            if(cargoStorage.get(cargo.getEndpoint()) == null)
                cargoStorage.put(cargo.getEndpoint(), new CargoStorage());
            cargoStorage.get(cargo.getEndpoint()).getCargoStorageOrdinary().add(cargo);
        }

    }
}
