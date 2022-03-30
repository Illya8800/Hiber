package com.aimprosoft.hopak;

import com.aimprosoft.hopak.query.Query;

public class Hibernate {

    public static void main(String[] args) {
        Query query = new Query();
        System.out.println(query.criteriaQuery());
    }
}

