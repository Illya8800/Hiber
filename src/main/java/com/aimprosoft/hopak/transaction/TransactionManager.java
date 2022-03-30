package com.aimprosoft.hopak.transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

public class TransactionManager {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateTask");

    @Transactional
    public static <T> T transaction(Rollback<T> rollback){

        EntityManager em = emf.createEntityManager();
        T result = null;
        try {
            em.getTransaction().begin();
            result = rollback.execute(em);
            em.getTransaction().commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            em.close();
        }
        return result;
    }
}
