package com.example.onetomany.domain.multidirectional;

import com.example.onetomany.domain.multidirectional.Customer;
import com.example.onetomany.domain.multidirectional.Reservation;
import com.example.onetomany.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.Date;

public class MultiDirectional12M {

    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(
            Customer.class,
            Reservation.class));

    public static void main(String[] args) {
        multiDirectional12M();
    }

    public static void multiDirectional12M() {

        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Customer customer = new Customer();
            customer.setName("Sauravi Thapa");

            Reservation reservation1 = new Reservation();
            reservation1.setDate(new Date());
            reservation1.setCustomer(customer);

            Reservation reservation2 = new Reservation();
            reservation2.setDate(new Date());
            reservation2.setCustomer(customer);

            session.save(reservation1);
            session.save(reservation2);

            customer.setReservationList(Arrays.asList(reservation1, reservation2));

            session.save(customer);
            tx.commit();

        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println(ex.getMessage());
        } finally {
            session.close();
            System.out.println("Complete session");
        }
    }
}
