package net.proselyte.springmvc.model;

public class Developer {

    private String firstName;
    private String lastName;
    private String specialty;
    private Integer salary;
    private Team team;

    public Developer() {
    }

    public Developer(String firstName, String lastName, String specialty, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (firstName != null ? !firstName.equals(developer.firstName) : developer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(developer.lastName) : developer.lastName != null) return false;
        if (specialty != null ? !specialty.equals(developer.specialty) : developer.specialty != null) return false;
        if (salary != null ? !salary.equals(developer.salary) : developer.salary != null) return false;
        return team != null ? team.equals(developer.team) : developer.team == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (team != null ? team.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nSpecialty: " + specialty +
                "\nSalary: " + salary +
                "\nTeam: " + team.getTeamName();
    }

}
