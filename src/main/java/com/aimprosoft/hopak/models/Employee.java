package com.aimprosoft.hopak.models;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Employees")
@BatchSize(size = 3)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "working_hours")
    private Integer workingHours;

    @Column(name = "date_birth")
    private Date dateBirth;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Gender sex;

    @Column(name = "department_id")
    private Long departmentId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, String email, Integer workingHours, Date dateBirth, Gender sex, Long departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.workingHours = workingHours;
        this.dateBirth = dateBirth;
        this.sex = sex;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Integer workingHours) {
        this.workingHours = workingHours;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", workingHours=" + workingHours +
                ", dateBirth=" + dateBirth +
                ", sex=" + sex +
                ", departmentId=" + departmentId +
                '}';
    }
}

