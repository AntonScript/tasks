import logic.MyHandler;
import model.Cargo;
import model.Plane;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Map<String, ArrayDeque<Cargo>> cargoStorage =  new HashMap<>();
        Map<String, ArrayDeque<Plane>> planeStorage =  new HashMap<>();
        Set<String>  lockState = ConcurrentHashMap.newKeySet();
        new Init(cargoStorage,planeStorage);
        MyHandler myHandler = new MyHandler(cargoStorage,planeStorage,executorService,lockState);
        executorService.execute(myHandler);
       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myHandler.notifyAll();*/


    }
}
