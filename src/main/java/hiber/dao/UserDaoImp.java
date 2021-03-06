package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   public User getCarUser(String model, int series){
      Query query = sessionFactory.getCurrentSession()
              .createQuery("SELECT user from User user where" +
              " user.userCar.model = (:setModel) AND user.userCar.series = (:setSeries)", User.class);
      query.setParameter("setModel", model);
      query.setParameter("setSeries", series);
      return (User) query.getSingleResult();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
