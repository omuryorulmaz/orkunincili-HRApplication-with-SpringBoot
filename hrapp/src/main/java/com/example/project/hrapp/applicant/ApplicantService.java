package com.example.project.hrapp.applicant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository repository;

    public List<Applicant> listAll(){

        return repository.findAll();

    }

    public void save(Applicant applicant){

        repository.save(applicant);
    }

    public Applicant getById(Long id){

        return repository.findById(id).get();
    }



}
