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
// Updating entity in table
//            Person person = session.get(Person.class, 1);
//            person.setAge(28);


            // Saving Entity to the table
//            Person begona = new Person("Begona", 55);
//            session.save(begona);
            
            // Deleting entity from the table

            Person person = session.get(Person.class, 5);
            session.delete(person);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
