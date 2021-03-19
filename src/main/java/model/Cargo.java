package model;

import java.util.Objects;

public class Cargo {
    private Integer volume;
    private CargoType type;
    private String endpoint;


    public Cargo(Integer volume, CargoType type, String endpoint) {
        this.volume = volume;
        this.type = type;
        this.endpoint = endpoint;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public CargoType getType() {
        return type;
    }

    public void setType(CargoType type) {
        this.type = type;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return Objects.equals(volume, cargo.volume) && type == cargo.type && Objects.equals(endpoint, cargo.endpoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, type, endpoint);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "volume=" + volume +
                ", type=" + type +
                ", endpoint='" + endpoint + '\'' +
                '}';
    }
}
