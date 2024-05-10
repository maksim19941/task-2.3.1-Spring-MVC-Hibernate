package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.servise.CarServiceImp;


@Controller
public class CarController {
    private final CarServiceImp carService;

    public CarController(CarServiceImp carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String carView(ModelMap model, @RequestParam(defaultValue = "5") int count) {
        model.addAttribute("cars", carService.getUserlist(count));
        return "car";
    }

}
