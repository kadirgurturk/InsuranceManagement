package org.csystem.app.Account;

import org.csystem.app.Address.Address;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String job;
    private int age;
    private ArrayList<Address> addresses;
    private LocalDate lastVisitDate;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "String.format()";
    }

    public User() {
    }
    public User(UserBuilder build) {
        name = build.name;
        lastName = build.lastName;
        email = build.email;
        password = build.password;
        job = build.job;
        age = build.age;
        addresses = build.addresses;
        lastVisitDate = build.lastVisitDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void updateLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getJob() {
        return job;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public static class UserBuilder
    {
        private String name;
        private String lastName;
        private String email;
        private String password;
        private String job;
        private int age;
        private ArrayList<Address> addresses = new ArrayList<>();
        private LocalDate lastVisitDate;


        public UserBuilder name(String name)
        {
            this.name = name;
            return this;
        }
        public UserBuilder lastname(String lastname)
        {
            this.lastName = lastname;
            return this;
        }
        public UserBuilder email(String email)
        {
            this.email = email;
            return this;
        }
        public UserBuilder password(String password)
        {
            this.password = password;
            return this;
        }
        public UserBuilder job(String job)
        {
            this.job = job;
            return this;
        }
        public UserBuilder age(int age)
        {
            this.age = age;
            return this;
        }
        public UserBuilder address(ArrayList<Address> addresses)
        {
            this.addresses = addresses;
            return this;
        }
        public UserBuilder lastVisitDate(LocalDate lastVisitDate)
        {
            this.lastVisitDate = lastVisitDate;
            return this;
        }
        public User build()
        {
            var user = new User(this);
            return user;
        }


    }
}
