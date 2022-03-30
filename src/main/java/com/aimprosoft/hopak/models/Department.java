package com.aimprosoft.hopak.models;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;
    private String country;
    private String city;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @BatchSize(size = 3)
    private List<Employee> employee;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "embl")
    private List<Embl> empls;


    public List<Embl> getEmpls() {
        return empls;
    }

    public void setEmpls(List<Embl> empls) {
        this.empls = empls;
    }

    public Department() {
    }

    public Department(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "\nDepartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }
}

