package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class Application {
    //Static para poder utilizarlo en el metodo main
    private static JpaService jpaService = JpaService.getInstance();
    public static void main(String[] args) {
        try {
           EntityManagerFactory entityManagerFactory= jpaService.getEntityManagerFactory();
           EntityManager entityManager = entityManagerFactory.createEntityManager();
           EntityTransaction transaction= entityManager.getTransaction();
           transaction.begin();

            entityManager.persist(new ProgrammingLanguage("Java",10));




            transaction.commit();

        } finally {
            jpaService.shutDown();
        }

    }
}
