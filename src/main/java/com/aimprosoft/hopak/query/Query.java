package com.aimprosoft.hopak.query;

import com.aimprosoft.hopak.models.Department;
import com.aimprosoft.hopak.models.Employee;
import com.aimprosoft.hopak.transaction.TransactionManager;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Query {

    public List<Department> getAllDepartments(){
        return TransactionManager.transaction(em -> {
            TypedQuery<Department> query = em.createQuery("SELECT d FROM Department d",Department.class);
            return query.getResultList();
        });
    }

    public Department getDepartment(){
        return TransactionManager.transaction(em -> {
            Department department = em.find(Department.class, 2L);
            System.out.println(department.getEmployee().size());
            return department;
        });
    }

    public Department addDepartment(Department department){
        return TransactionManager.transaction(em -> {
            em.persist(department);
            return department;
        });
    }

    public List<Department> criteriaQuery() {
        return TransactionManager.transaction(em -> {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Department> criteria = cb.createQuery(Department.class);
            Root<Department> d = criteria.from(Department.class);

            TypedQuery<Department> query;
            query = em.createQuery(criteria.select(d).where(
                    cb.equal(d.get("id"), 1L)
            ));

            return query.getResultList();
        });
    }

    public Employee getEmployee(){
        return TransactionManager.transaction(em -> {
            return em.find(Employee.class, 2L);
        });
    }
}
