package org.example;

import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

           Person person1 = new Person("Samir", 1);
           Person person2 = new Person("Naima", 26);
           Person person3 = new Person("Ulugbek", 24);
           session.save(person1);
           session.save(person2);
           session.save(person3);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
