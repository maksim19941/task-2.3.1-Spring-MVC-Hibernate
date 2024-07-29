package web.servise;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service("carServiceImp")
public class CarServiceImp implements CarService {

    private List<Car> cars = new ArrayList<>();

    public CarServiceImp() {
        cars.add(new Car("Bob", "x6", "black"));
        cars.add(new Car("Jek", "a1", "black"));
        cars.add(new Car("Lightning MCQUEEN", "r8", "orange"));
        cars.add(new Car("slepoy Dzho", "ki1", "red"));
        cars.add(new Car("Ignat", "priora", "white"));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(Car car) {
        cars.add(car);
    }

    public List<Car> getCarslist(int count) {
        if (count >= 5) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
}
