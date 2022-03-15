package com.aimprosoft.hopak;

import javax.persistence.*;

@Entity
@Table(name = "Departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;
    private String name;
    private String country;
    private String city;

    public Department() {
    }

    public Department(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
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
}

