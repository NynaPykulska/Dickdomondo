
public class Vector {
    Point start;
    Point end;

    public Vector(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Vector() {
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
