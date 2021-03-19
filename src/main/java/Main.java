import logic.MyHandler;
import model.CargoStorage;
import model.Plane;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        Object m = new Object();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Map<String, CargoStorage> cargoStorage =  new HashMap<>();
        Map<String,  ArrayDeque<Plane>> planes = new HashMap<>();
        Set<String>  lockState = ConcurrentHashMap.newKeySet();
        new Init(cargoStorage,planes);
        MyHandler myHandler = new MyHandler(cargoStorage,planes,executorService,lockState,m);
        executorService.execute(myHandler);
        
    }
}
