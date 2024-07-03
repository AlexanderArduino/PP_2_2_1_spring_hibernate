package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {

    // Сервис по добавлению пользователя
    void add(User user);

    // Сервис по получению всех пользователей
    List<User> listUsers();

    // Сервис по добавлению машины
    void add(Car car);

    // Сервис по получению всех машин
    List<Car> listCars();

    // Сервис по добавлению пользователя и машины
    public void add(User user, Car car);

    // Получение пользователя по машине
    public User getUserByCar(String model, int series);
}
