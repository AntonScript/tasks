package logic;

import model.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Loader implements Runnable{
    private ArrayDeque<Plane> planes;
    private CargoStorage cargoStorage;
    private Set<String> lockState;
    private String cityNames;
    private  List<Cargo> result;

    public Loader(
            ArrayDeque<Plane> planes,
            CargoStorage cargoStorage,
            Set<String> lockState,
            String cityNames
    ) {
        this.planes = planes;
        this.cargoStorage = cargoStorage;
        this.lockState = lockState;
        this.cityNames = cityNames;
        result = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            distributor(planes.poll());
        }finally {
            lockState.remove(cityNames);
        }
    }

    public void distributor(Plane plane){
        if(plane.getType().equals(PlaneType.alive))
            alive(plane);
        else if(plane.getType().equals(PlaneType.perishable))
            perishable(plane);
        else if(plane.getType().equals(PlaneType.ordinary))
            dangerous(plane);
    }

    public boolean base(Plane plane,CargoType type){
        List<Cargo> cargos = null;
        if(type.equals(CargoType.alive)){
            cargos = cargoStorage.getCargoStorageAlive();
        }else if(type.equals(CargoType.perishable)){
            cargos = cargoStorage.getCargoStoragePerishable();
        }else if(type.equals(CargoType.dangerous)){
            cargos = cargoStorage.getCargoStorageDangerous();
        }else if(type.equals(CargoType.ordinary)){
            cargos = cargoStorage.getCargoStorageOrdinary();
        }
        boolean flag = true;
        int volume = plane.getVolume();
        for (int i = 0; i < cargos.size(); i++) {
            Cargo cargo = cargos.get(i);
            if(volume >= cargo.getVolume()){
                volume-=cargo.getVolume();
                result.add(cargo);
                if(volume == 0){
                    flag = false;
                    break;
                }
            }
        }
        plane.setVolume(volume);
        return flag;
    }

    public void ordinary(Plane plane){
        base(plane,CargoType.ordinary);
        print(plane);
    }

    public void dangerous(Plane plane){
        if(base(plane,CargoType.dangerous)){
            ordinary(plane);
        }else {
            print(plane);
        }
    }

    public void perishable(Plane plane){
        if(base(plane,CargoType.perishable)){
            dangerous(plane);
        }else {
            print(plane);
        }
    }

    public void alive(Plane plane){
        if(base(plane,CargoType.alive)){
            dangerous(plane);
        }else {
            print(plane);
        }
    }

    public void print(Plane plane){
        System.out.println("====================" +  '\n' + "Plane" + '\n' + plane +  '\n' + "Cargos: "  + '\n' + result);
    }

}
