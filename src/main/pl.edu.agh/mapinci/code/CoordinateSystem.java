package mapinci.code;

import java.util.LinkedList;
import java.util.List;

public class CoordinateSystem {
    List<Vector> picture;

    public CoordinateSystem() {
        this.picture = new LinkedList<Vector>();
    }

    public List<Vector> getPicture() {
        return picture;
    }

    public void setPicture(List<Vector> picture) {
        this.picture = picture;
    }
}
