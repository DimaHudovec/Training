package parsers.saxparser;

/**
 * Created by Dima Hudovec on 11.08.2017.
 */
public enum AirplaneEnum {
    AIRPLANES("airplanes"),
    MODEL("model"),
    ORIGIN("origin"),
    CARGOAIRPLANE("cargoairplane"),
    PASSENGERAIRPLANE("passengerairplane"),
    PRICE("price"),
    RADAR("radar"),
    CARIGECAPACITY("carigecapacity"),
    CAPACITY("capacity"),
    LENGT("lengt"),
    WIDTH("width"),
    HEIGH("heigh"),
    PARAMETERS("parameters");
    private String value;
    private AirplaneEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
