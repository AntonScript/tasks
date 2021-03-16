import model.Cargo;
import model.CargoType;
import model.Plane;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Init {
    Map<String, ArrayDeque<Cargo>> cargoStorage;
    Map<String, ArrayDeque<Plane>> planeStorage;

    public Init(Map<String, ArrayDeque<Cargo>> cargoStorage, Map<String, ArrayDeque<Plane>> planeStorage) {
        this.cargoStorage = cargoStorage;
        this.planeStorage = planeStorage;
    }

    public void startup(){

    }
}
