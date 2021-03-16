package logic;

import model.Cargo;
import model.Plane;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;

public class MyHandler implements Runnable{
    private Map<String, ArrayDeque<Cargo>> cargoStorage;
    private Map<String, ArrayDeque<Plane>> planeStorage;
    private ExecutorService executorService;
    private Set<String>  lockState;

    public MyHandler(
                    Map<String,
                    ArrayDeque<Cargo>> cargoStorage,
                    Map<String,
                    ArrayDeque<Plane>> planeStorage,
                    ExecutorService executorService,
                    Set<String> lockState
    ) {
        this.cargoStorage = cargoStorage;
        this.planeStorage = planeStorage;
        this.executorService = executorService;
        this.lockState = lockState;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("1111");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /*Set<String> city = cargoStorage.keySet();
            if(city.size() == 0) {
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/

            /*for(String cityNames : city){

            }*/

        }
    }


}
