package web.services;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> showCars(List<Car> carList, Integer count) {
        if (count == null || count >= carList.size() || count < 0) {
            return carList;
        } else {
            return carList.stream().limit(count).toList();
        }
    }
}
