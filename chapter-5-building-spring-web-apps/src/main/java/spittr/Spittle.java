package spittr;

import java.util.Date;
import java.util.Objects;

import static java.util.Objects.hash;

public class Spittle {
    private final Long id;
    private final String message;
    private final Date time;
    private Double longitude;
    private Double latitude;

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }


    public Spittle(String message, Date time, Double longitude, Double latitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object o) {
        final Spittle that = (Spittle) o;
        return Objects.equals(this.id, that.id) && Objects.equals(this.time, that.time);
    }

    @Override
    public int hashCode() {
        return hash(id) + hash(time);
    }
}