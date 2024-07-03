package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   // Добавление пользователя
   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   // Чтение всех пользователей
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   // Добавление машины
   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   // Чтение всех машин
   @Override
   public List<Car> listCars() {
      TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getUserByCar(String model, int series) {
      String hql = "from User u where u.car.model = :model and u.car.series = :series";
         TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
         query.setParameter("model", model);
         query.setParameter("series", series);
         return query.setMaxResults(1).getSingleResult();
   }
}
