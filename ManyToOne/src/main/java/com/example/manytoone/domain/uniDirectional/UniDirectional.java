package com.example.manytoone.domain.uniDirectional;

import com.example.manytoone.utils.HibernateUtils;
import org.hibernate.SessionFactory;

import java.util.Arrays;

public class UniDirectional {
    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(null));

    public static void main(String[] args) {

    }
}
