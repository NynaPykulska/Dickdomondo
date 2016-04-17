/**
 * Created by m on 17.04.16.
 */
public class GeoVector {

    //West - East
    private double deltaLong;

    //North - South
    private double deltaLat;

    public GeoVector(double deltaLong, double deltaLat) {
        this.deltaLong = deltaLong;
        this.deltaLat = deltaLat;
    }

    public double getDeltaLong() {
        return deltaLong;
    }

    public double getDeltaLat() {
        return deltaLat;
    }
}
