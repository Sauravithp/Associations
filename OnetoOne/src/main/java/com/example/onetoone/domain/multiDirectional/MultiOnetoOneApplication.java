package com.example.onetoone.domain.multiDirectional;

import com.example.onetoone.domain.multiDirectional.Address;
import com.example.onetoone.domain.multiDirectional.Person;
import com.example.onetoone.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MultiOnetoOneApplication {

    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(
            Address.class,
            Person.class));

    public static void main(String[] args) {
        unidirectionalTest();
    }

    public static void unidirectionalTest(){

        Session session=null;
        Transaction tx=null;
        try{
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            Address address=new Address();
            address.setState("Iowa");
            address.setZipCode("52557");
            address.setStreet("fourth");


            Person person=new Person();
            person.setName("Sauravi Thapa");
            person.setContact("4414450");
            person.setAddress(address);
            address.setPerson(person);


            session.save(address);
            session.save(person);
            tx.commit();

        }catch (HibernateException ex){
            tx.rollback();
            System.out.println(ex.getMessage());
        }finally {
            session.close();
            System.out.println("Complete session");
        }
    }

}
