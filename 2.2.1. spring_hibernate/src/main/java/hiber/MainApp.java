package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      // Добавление в таблицу отдельно пользователей
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      // Добавление в таблицу отдельно машин
      userService.add(new Car("Porshe", 1));
      userService.add(new Car("Lincoln", 2));
      userService.add(new Car("LADA", 3));
      userService.add(new Car("Infinity", 4));

      //=========================================
      // Добавление пользователя сразу с машиной
      userService.add(new User("User100", "LastName100", "user100@mail.ru"),
              new Car("Car100", 100));

      //Отображение всех пользователей из таблицы User
      List<User> users = userService.listUsers();
      for (User a : users) {
         System.out.println("Id = "+a.getId());
         System.out.println("First Name = "+a.getFirstName());
         System.out.println("Last Name = "+a.getLastName());
         System.out.println("Email = "+a.getEmail());
         System.out.println();
      }

      // Отображение всех машин из таблицы Car
      List<Car> cars = userService.listCars();
      for (Car car : cars) {
         System.out.println("model = "+car.getModel());
         System.out.println("series = "+car.getSeries());
         System.out.println();
      }

      // Получение пользователя по модели и серии машины
      User user = userService.getUserByCar("Car100", 100);
      System.out.println("User, who have car: " + user.getCar().getModel()
                           + user.getCar().getSeries());
      System.out.println("id: " + user.getId());
      System.out.println("name: " + user.getFirstName());
      System.out.println("LastName: " + user.getLastName());
      System.out.println("Email: " + user.getEmail());
      //=========================================

      context.close();
   }
}
