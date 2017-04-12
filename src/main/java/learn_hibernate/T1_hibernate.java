package learn_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fupeng on 2017/4/12.
 */
public class T1_hibernate {
    private static final Logger LOGGER = Logger.getLogger("Hibernate-Tutorial");

    public static void main(String[] args) {
        T1_hibernate main = new T1_hibernate();
        main.run();
    }

    public void run() {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            session = sessionFactory.openSession();
            persistPerson2(session);

            loadPerson(session);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }


    }
    private void persistPerson(Session session) throws Exception {
        try {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Person person = new Person();
            person.setFirstName("Homer");
            person.setLastName("Simpson付鹏1");
            session.save(person);

            transaction.commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw e;
        }
    }

    private void loadPerson(Session session) {
        List<Person> persons = session.createQuery("from Person  as p ").list();
        for (Person project : persons) {
            System.out.println("First: " + project.getFirstName() + " Last " + project.getLastName());
        }
    }

    private void persistPerson2(Session session) throws Exception {
        try {
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Geek geek = new Geek();
            geek.setFirstName("Gavin");
            geek.setLastName("Coffee");
            geek.setFavouriteProgrammingLanguage("Java");
            session.save(geek);
            geek = new Geek();
            geek.setFirstName("Thomas");
            geek.setLastName("Micro");
            geek.setFavouriteProgrammingLanguage("C#");
            session.save(geek);
            geek = new Geek();
            geek.setFirstName("Christian");
            geek.setLastName("Cup");
            geek.setFavouriteProgrammingLanguage("Java");
            session.save(geek);

            Person person = new Person();
            person.setFirstName("Homer");
            person.setLastName("Simpson付鹏1");
            session.save(person);

            Person person2 = new Person();
            person2.setFirstName("Homer");
            person2.setLastName("Simpson");
            session.save(person2);
            IdCard idCard = new IdCard();
            idCard.setIdNumber("4711");
            idCard.setIssueDate(new Date());
            person2.setIdCard(idCard);
            session.save(idCard);

            transaction.commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw e;
        }
    }
}
