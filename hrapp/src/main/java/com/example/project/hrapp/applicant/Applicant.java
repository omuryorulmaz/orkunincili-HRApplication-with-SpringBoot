package com.example.project.hrapp.applicant;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String thoughts;
    private String jobName;

    @Autowired
    public Applicant(String name, String email, String phone, String address, String thoughts,String jobName) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.thoughts = thoughts;
        this.jobName = jobName;
    }

    public Applicant(){}

    @Override
    public String toString() {
        return String.format(
                "job[id=%d, name='%s', email='%s', phone='%d', address='%s', toughts='%s']",
                id, name, email, phone, address,thoughts);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
