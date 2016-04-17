import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        init();
    }

    public static void init() {
        CoordinateSystem coordinateSystem  = new CoordinateSystem();
        Point x0y0 = new Point(0.0,0.0);
        Point x1y0 = new Point(1.0,0.0);
        Point x1y1 = new Point(1.0,1.0);
        Point x0y1 = new Point(0.0,1.0);

        Vector vector1 = new Vector(x0y0,x1y0);
        Vector vector2 = new Vector(x1y0,x1y1);
        Vector vector3 = new Vector(x1y1,x0y1);
        Vector vector4 = new Vector(x0y1,x0y0);

        List<Vector> list = new LinkedList<Vector>();
        list.add(vector1);
        list.add(vector2);
        list.add(vector3);
        list.add(vector4);

        coordinateSystem.setPicture(list);
    }

}
