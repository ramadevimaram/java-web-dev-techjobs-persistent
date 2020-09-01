package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
    //A field for a longer description of the skill
    @NotNull(message = "Description is Required")
    @NotBlank(message = "Skill cannot be blank!")
    @Size(min=3,max=300, message = "Description must be between 2 and 100 characters")
    private String description;

    @ManyToMany(mappedBy="skills")
    private final List<Job> jobs = new ArrayList<>();

    public Skill(){}

    public String getDescription() {
        return description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}