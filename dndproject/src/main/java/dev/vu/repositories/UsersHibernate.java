package dev.vu.repositories;

import dev.vu.beans.User;
import dev.vu.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UsersHibernate implements UserRepo<User> {
    private HibernateUtil hu;

    @Autowired
    public UsersHibernate(HibernateUtil hu) {
        this.hu = hu;
    }

    @Override
    public User add(User user) {

        Session s = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.save(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
        } finally {
            s.close();
        }
        return user;

    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public User getByUsername(String username) {

       Session s = HibernateUtil.getSession();
       User u = null;

       try {

           CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
           CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

           Root<User> root = criteriaQuery.from(User.class);
           Predicate predicate = criteriaBuilder.equal(root.get("username"), username);

           criteriaQuery.select(root).where(predicate);

           u = s.createQuery(criteriaQuery).getSingleResult();

       } catch (HibernateException e) {
           e.printStackTrace();
       } finally {
           s.close();
       }

        return u;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer id) {

    }
}
