package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Jhonny", "Silverhand", "SiLvErCoOl@mail.ru"), new Car("Tesla", 4532));
      userService.add(new User("Adam", "Smasher", "SmasBOOM@mail.ru"), new Car("Firestorm", 1234));
      userService.add(new User("Jaquito", "Welles", "Pasta@mail.ru"), new Car("Valentinos", 2020));
      userService.add(new User("Alt", "Cunningham", "NETRANNERSUPCOOOL@mail.ru"), new Car("Tesla", 4532));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getUserCar().getModel() + " " + user.getUserCar().getSeries());
         System.out.println();
      }


      //System.out.println("Tesla at number 4532 owns: " + userService.getCarUser("Tesla", 4532).getLastName());

      context.close();
   }
}
