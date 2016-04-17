package mapinci.code;

import java.util.List;

public class Preferences {

    Double length;
    Double height;
    List<String> type;

    public Preferences(Double length, Double height, List<String> type) {
        this.length = length;
        this.height = height;
        this.type = type;
    }

    public Preferences() {
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }
}
