package net.proselyte.springmvc.model;

import java.util.Set;

public class Customer {

    private String name;
    private Set projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getProjects() {
        return projects;
    }

    public void setProjects(Set projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", projects=" + projects +
                '}';
    }



}
