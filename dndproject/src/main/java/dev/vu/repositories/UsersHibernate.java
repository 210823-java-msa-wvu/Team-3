package dev.vu.repositories;

import dev.vu.beans.Users;
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
public class UsersHibernate implements UserRepo<Users> {
    private HibernateUtil hu;

    @Autowired
    public UsersHibernate(HibernateUtil hu) {
        this.hu = hu;
    }

    @Override
    public Users add(Users users) {

        Session s = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.save(users);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
        } finally {
            s.close();
        }
        return users;

    }

    @Override
    public Users getById(Integer id) {
        return null;
    }

    @Override
    public Users getByUsername(String username) {

       Session s = HibernateUtil.getSession();
       Users u = null;

       try {

           CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
           CriteriaQuery<Users> criteriaQuery = criteriaBuilder.createQuery(Users.class);

           Root<Users> root = criteriaQuery.from(Users.class);
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
    public List<Users> getAll() {
        return null;
    }

    @Override
    public void update(Users users) {

    }

    @Override
    public void delete(Integer id) {

    }
}
