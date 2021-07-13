package com.audit.demo.app.dao;

import com.audit.demo.app.entity.Data;

public class UserDao {
    public Data exampleDataForJohnDoe() {
        Data data = new Data();
        data.setFirstname("John");
        data.setLastname("Doe");
        data.setStreet("Example Street 1");
        data.setZipCode("12345");
        data.setCity("Example City");
        return data;
    }
}
