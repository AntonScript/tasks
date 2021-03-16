package model;

public class Cargo {
    private Integer volume;
    private CargoType type;
    private String endpoint;

    public Cargo(Integer volume, CargoType type) {
        this.volume = volume;
        this.type = type;
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
}
