package com.aimprosoft.hopak;

import javax.persistence.*;
import java.util.List;

public class Hibernate {

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("DepartmentU");

    public static void main(String[] args) {

        getDepartment();
        entityManagerFactory.close();
    }

    public static void getDepartment(){
        EntityManager em = entityManagerFactory.createEntityManager();

        TypedQuery<Department> query = em.createQuery("SELECT d FROM Department d",Department.class);

        List<Department> departments = query.getResultList();

        for(Department d : departments)
            System.out.println(d.toString());
    }

    public static void addDepartment(){
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = null;

try {

        et = em.getTransaction();
        et.begin();
        Department department = new Department("Hауuвцbdwer","Huber","Huber");
        em.persist(department);
        et.commit();

        em.close();


}catch (Exception e){
    e.printStackTrace();
}
    }

}
