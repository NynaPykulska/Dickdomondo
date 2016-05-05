package mapinci.controllers;

import mapinci.code.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hubert on 25.04.2016.
 */

@RestController
@RequestMapping("/")
public class IndexController {
    private CoordinateSystem coordinateSystem  = new CoordinateSystem();
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCoordinates(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();

        init();

        Preferences preferences = new Preferences();
        preferences.setLength(2.0);
        YoloConverter converter = new YoloConverter(preferences,coordinateSystem.getPicture());

        ArrayList<GeoVector> geoVectors = converter.getGeoVector();

        modelAndView.addObject("Lat", 50.0639147);
        modelAndView.addObject("Lon", 19.923648700000058);
        int i = 0;
        for(GeoVector g: geoVectors){
            modelAndView.addObject("lat" + i, g.getDeltaLat());
            modelAndView.addObject("lon" + i, g.getDeltaLong());
            i++;
        }
        modelAndView.setViewName("home");
        return modelAndView;
    }

    public void init() {

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

        this.coordinateSystem.setPicture(list);
    }


}
