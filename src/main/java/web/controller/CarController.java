package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.services.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public String cars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1L, "merc", "1"));
        carList.add(new Car(2L, "zhiga", "2"));
        carList.add(new Car(3L, "honda", "3"));
        carList.add(new Car(4L, "ducatti", "4"));
        carList.add(new Car(5L, "porsche", "5"));

        model.addAttribute("carsList", carService.showCars(carList, count));
        return "cars";
    }

}
