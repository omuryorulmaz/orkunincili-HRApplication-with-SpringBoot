package com.example.project.hrapp.job;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String jobTitle;
    private String jobDescription;
    private int numOfHire;
    private String lastDate;


    public Job(String jobTitle,String jobDescription,int numOfHire,String lastDate) {
        this.jobTitle=jobTitle;
        this.jobDescription=jobDescription;
        this.numOfHire=numOfHire;
        this.lastDate=lastDate;
    }

    public Job(){}

    @Override
    public String toString() {
        return String.format(
                "job[id=%d, jobTitle='%s', jobDescription='%s', numOfHire='%d', lastDate='%s']",
                id, jobTitle, jobDescription, numOfHire, lastDate);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getNumOfHire() {
        return numOfHire;
    }

    public void setNumOfHire(int numOfHire) {
        this.numOfHire = numOfHire;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }
}
