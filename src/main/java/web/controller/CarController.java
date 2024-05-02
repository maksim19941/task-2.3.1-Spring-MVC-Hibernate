package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.servise.CarServiceImp;


@Controller
public class CarController {
    @Autowired
    CarServiceImp carService;
    @GetMapping(value = "/cars")
    public String carView(ModelMap modelMap, @RequestParam(defaultValue = "5") int count) {

        modelMap.addAttribute("cars", carService.getUser(count));
        return "car";
    }

}
