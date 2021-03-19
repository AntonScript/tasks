package model;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class CargoStorage {
    private ArrayList<Cargo> cargoStorageOrdinary;
    private ArrayList<Cargo> cargoStorageDangerous;
    private ArrayList<Cargo> cargoStoragePerishable;
    private ArrayList<Cargo> cargoStorageAlive;

    public CargoStorage() {
        cargoStorageOrdinary = new ArrayList<>();
        cargoStorageDangerous = new ArrayList<>();
        cargoStoragePerishable = new ArrayList<>();
        cargoStorageAlive = new ArrayList<>();

    }

    public ArrayList<Cargo> getCargoStorageOrdinary() {
        return cargoStorageOrdinary;
    }

    public void setCargoStorageOrdinary(ArrayList<Cargo> cargoStorageOrdinary) {
        this.cargoStorageOrdinary = cargoStorageOrdinary;
    }

    public ArrayList<Cargo> getCargoStorageDangerous() {
        return cargoStorageDangerous;
    }

    public void setCargoStorageDangerous(ArrayList<Cargo> cargoStorageDangerous) {
        this.cargoStorageDangerous = cargoStorageDangerous;
    }

    public ArrayList<Cargo> getCargoStoragePerishable() {
        return cargoStoragePerishable;
    }

    public void setCargoStoragePerishable(ArrayList<Cargo> cargoStoragePerishable) {
        this.cargoStoragePerishable = cargoStoragePerishable;
    }

    public ArrayList<Cargo> getCargoStorageAlive() {
        return cargoStorageAlive;
    }

    public void setCargoStorageAlive(ArrayList<Cargo> cargoStorageAlive) {
        this.cargoStorageAlive = cargoStorageAlive;
    }

    public boolean isEmpty(){
        if (cargoStorageAlive.isEmpty() || cargoStorageDangerous.isEmpty() || cargoStorageOrdinary.isEmpty() || cargoStoragePerishable.isEmpty())
            return false;
        else
            return true;
    }
}
