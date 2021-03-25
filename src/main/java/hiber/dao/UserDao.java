package hiber.dao;

import hiber.model.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao {
   void add(User user);
   @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
   User getCarUser(String model, int series);
   List<User> listUsers();
}
