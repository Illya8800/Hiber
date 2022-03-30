package com.aimprosoft.hopak.transaction;

import javax.persistence.EntityManager;

public interface Rollback <T>{
    T execute(EntityManager em) throws Throwable;
}
