package logic;

import model.CargoStorage;
import model.Plane;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class MyHandler implements Runnable{
    private Map<String, CargoStorage> cargoStorage;
    private Map<String, ArrayDeque<Plane>> planes;
    private ExecutorService executorService;
    private Set<String>  lockState;
    private Object m;
    private boolean lock = false;

    public MyHandler(
            Map<String, CargoStorage> cargoStorage,
            Map<String, ArrayDeque<Plane>> planes,
            ExecutorService executorService,
            Set<String> lockState,
            Object m
    ) {
        this.cargoStorage = cargoStorage;
        this.planes = planes;
        this.executorService = executorService;
        this.lockState = lockState;
        this.m = m;
    }

    @Override
    public void run() {
        while (true){
           synchronized (m){
               lock = true;
               Set<String> city = cargoStorage.keySet();
               for(String cityNames : city){
                   if(lockState.contains(cityNames)){
                       lock = false;
                       continue;
                   }else {
                       lockState.add(cityNames);
                       if(planes.get(cityNames).isEmpty()){
                           lockState.remove(cityNames);
                           continue;
                       }
                       if(cargoStorage.get(cityNames).isEmpty()){
                           lockState.remove(cityNames);
                           continue;
                       }
                       lock = false;
                       executorService.submit(new Loader(planes.get(cityNames), cargoStorage.get(cityNames), lockState, cityNames));
                   }
               }
               if(lock) {
                   try {
                       System.out.println("нет возможности выполнить загрузку поэтому поток приостановлен пока не будет добавлен груз или самолет");
                       m.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }

        }
    }


}
