package com.example.manytomany.domain.uniDirectional;

import com.example.manytomany.utils.HibernateUtils;
import org.hibernate.SessionFactory;

import java.util.Arrays;

public class UniDirectional {
    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(null));

    public static void main(String[] args) {

    }
}
