package mapinci.code;

import java.util.LinkedList;
import java.util.List;

public class CoordinateSystem {
    public static List<Vector> picture;

    public CoordinateSystem() {
        picture = new LinkedList<Vector>();
    }

    public List<Vector> getPicture() {
        return picture;
    }

    public void setPicture(List<Vector> picture) {
        CoordinateSystem.picture = picture;
    }
}
