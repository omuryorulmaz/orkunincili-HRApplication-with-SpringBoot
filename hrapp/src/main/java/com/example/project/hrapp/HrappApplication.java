package com.example.project.hrapp;

import com.example.project.hrapp.applicant.FileUploadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class HrappApplication {

    public static void main(String[] args) {

        new File(FileUploadController.uploadDirectory).mkdir();
        SpringApplication.run(HrappApplication.class, args);
    }

}
