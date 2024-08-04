package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceUnit
    private EntityManagerFactory entityManager;


    @Override
    public List<User> getListUser() {
        EntityManager em = entityManager.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        cq.select(cq.from(User.class));
        TypedQuery<User> query = em.createQuery(cq);
        return query.getResultList();
    }


    @Override
    public void save(String name, String surname, int age) {
        EntityManager em = entityManager.createEntityManager();

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(User updtUser, long id) {
        EntityManager em = entityManager.createEntityManager();

        User managedUser = em.find(User.class, id);
        managedUser.setName(updtUser.getName());
        managedUser.setSurname(updtUser.getSurname());
        managedUser.setAge(updtUser.getAge());
        em.getTransaction().begin();
        em.merge(managedUser);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(long id) {
        EntityManager em = entityManager.createEntityManager();

        User user = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public User getUser(long id) {
        EntityManager em = entityManager.createEntityManager();

        return em.find(User.class, id);


    }
}
