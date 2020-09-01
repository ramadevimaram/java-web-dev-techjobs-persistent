package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//will be mapped to one of our tables. Make sure the class has the @Entity annotation
@Entity
public class Employer extends AbstractEntity {
    //should have a string field for location.Add the field for location with validation.
    @NotNull(message = "Location is required")
    @Size(min=2, max=100, message = "Location must be between 2 and 100 characters")
    private String location;

    @OneToMany//(mappedBy = "employer")
    @JoinColumn
    private final List<Job> jobs = new ArrayList<>();

    //Hibernate to create an object.
    public Employer(){}

    // In addition, add getters and setters to Employer.
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
