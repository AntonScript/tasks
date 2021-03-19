package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Objects.equals(volume, plane.volume) && type == plane.type && Objects.equals(endpoint, plane.endpoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, type, endpoint);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "volume=" + volume +
                ", type=" + type +
                ", endpoint='" + endpoint + '\'' +
                '}';
    }
}
