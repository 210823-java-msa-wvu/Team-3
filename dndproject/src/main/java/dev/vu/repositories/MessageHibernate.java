package dev.vu.repositories;

import dev.vu.beans.Character;
import dev.vu.beans.Message;
import dev.vu.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageHibernate implements MessageRepo{

    @Autowired
    private HibernateUtil hu;

    @Override
    public Message getById(Integer id) {
        // Get Session
        Session s = hu.getSession();

        // Query the db
        Message a = s.get(Message.class, id);

        // Close our connection
        s.close();

        return a;
    }

    //@Override
    //public Card getByName(String firstName) {
        /*Session s = hu.getSession();
        String query = "from Author where first_name = :first_name";
        Query<Card> q = s.createQuery(query, Card.class);
        q.setParameter("first_name", firstName);

        Card a;
        try {
            a = q.getSingleResult();
            System.out.println("Getting single author by first name: " + a);
        } catch (NoResultException nre) {
            nre.printStackTrace();
            s.close();
            return null;
        }

        s.close();
        return a;*/
    //return null;
    // }

    @Override
    public List<Message> getAll() {
        // Let's use the Query Interface
        /*Session s = hu.getSession();

        // Create a query object
        String query = "from Author"; // this is HQL (NOT native sql -> select * from authors
        Query<Author> q = s.createQuery(query, Author.class);

        List<Author> authors = q.getResultList();

        s.close();

        return authors;*/
        return null;
    }



    @Override
    public Message add(Message a) {
        // Let's use the Transaction Interface - gives us a little more granular control

        /*Session s = hu.getSession();

        // I'm going to use a try catch finally to make sure that our transaction only commits to the database
        // so long as there are no exceptions thrown.

        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.saveOrUpdate(a);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        } finally {
            s.close();
        }*/
        //return a;
        return null;
    }

    @Override
    public void update(Message a) {

        Transaction tx = null;
        try (Session s = hu.getSession()) {
            tx = s.beginTransaction();
            s.update(a);
            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }

    }

    @Override
    public void delete(Integer id) {
        Transaction tx = null;

        try (Session s = hu.getSession()) {
            tx = s.beginTransaction();
            s.delete(id);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }
}
