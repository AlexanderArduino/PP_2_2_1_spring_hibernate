package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   // Добавление нового Юзера
   void add(User user);

   // Получение всех юзеров из таблицы
   List<User> listUsers();

   // Добавление новой машины
   void add(Car car);

   // Получение всех машин из таблицы
   List<Car> listCars();

   User getUserByCar(String model, int series);

}
