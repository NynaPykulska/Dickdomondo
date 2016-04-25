package mapinci.controllers;

import mapinci.code.CoordinateSystem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Hubert on 25.04.2016.
 */

@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCoordinates(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Lat", 50.0639147);
        modelAndView.addObject("Lon", 19.923648700000058);
        modelAndView.setViewName("home.jsp");
        return modelAndView;
    }

}
