package com.example.onetomany.domain.unidirectional;

import com.example.onetomany.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.Date;

public class UniDirectional12M {

    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(
            Customer.class,
            Reservation.class));

    public static void main(String[] args) {
        uniDirectional12M();
    }

    public static void uniDirectional12M(){

        Session session=null;
        Transaction tx=null;
        try{
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            Customer customer=new Customer();
            customer.setName("Sauravi Thapa");

            Reservation reservation1=new Reservation();
           reservation1.setDate(new Date());

            Reservation reservation2=new Reservation();
            reservation2.setDate(new Date());

            session.save(reservation1);
            session.save(reservation2);

            customer.setReservationList(Arrays.asList(reservation1,reservation2));

            session.save(customer);
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
