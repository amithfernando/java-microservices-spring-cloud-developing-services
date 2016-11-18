package de.ksbrwsk;

public class TollUsage {

    String id;
    String stationId;
    String licensePlate;
    String timestamp;

    public TollUsage() {
    }

    public TollUsage(String id, String stationId, String licensePlate, String timestamp) {
        this.id = id;
        this.stationId = stationId;
        this.licensePlate = licensePlate;
        this.timestamp = timestamp;
    }
}
