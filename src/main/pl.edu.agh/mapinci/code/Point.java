package mapinci.code;

import java.util.List;

public class Point {
    Double x;
    Double y;
    Double height;
    List<String> type;

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Double x) {
        this.x = x;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

}
