package com.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaService {
    private static JpaService instance;

    private EntityManagerFactory entityManagerFactory;

    public JpaService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate-demo-local");
    }

    public static synchronized JpaService getInstance() {
        //condicio(if(instance== null)? caso1:caso2)
        return instance == null ? instance = new JpaService(): instance;
    }

    public void shutDown(){
        if (entityManagerFactory != null){
            entityManagerFactory.close();
        }

    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
