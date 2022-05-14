package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("user1", "lastName1", "user1@mail.com");
      User user2 = new User("user2", "lastName2", "user2@mail.com");
      User user3 = new User("user3", "lastName3", "user3@mail.com");
      User user4 = new User("user4", "lastName4", "user4@mail.com");

      Car car1 = new Car("BMW", 2000);
      Car car2 = new Car("Jiguli", 1970);
      Car car3 = new Car("Audi", 2001);
      Car car4 = new Car("Mozeratti", 2022);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
         System.out.println(" ");
      }

      System.out.println(userService.findOwner("jiguli", 1970));
      System.out.println(" ");



      context.close();
   }
}
