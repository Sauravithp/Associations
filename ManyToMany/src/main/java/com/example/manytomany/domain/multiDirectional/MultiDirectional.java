package com.example.manytomany.domain.multiDirectional;

import com.example.manytoone.utils.HibernateUtils;
import org.hibernate.SessionFactory;

import java.util.Arrays;

public class MultiDirectional {
    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(null));

    public static void main(String[] args) {

    }
}
