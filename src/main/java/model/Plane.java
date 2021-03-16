package model;

public class Plane {
    private Integer volume;
    private PlaneType type;
    private String endpoint;

    public Plane(Integer volume, PlaneType type, String endpoint) {
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

    public PlaneType getType() {
        return type;
    }

    public void setType(PlaneType type) {
        this.type = type;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
