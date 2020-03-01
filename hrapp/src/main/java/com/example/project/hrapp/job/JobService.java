package com.example.project.hrapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository repository;

    public List<Job> listAll(){

        return repository.findAll();

    }

    public void save(Job job){

        repository.save(job);
    }

    public Job getById(Long id){

        return repository.findById(id).get();
    }

    public void delete(long id){

        repository.deleteById(id);
    }
}
