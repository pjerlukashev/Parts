package net.proselyte.springmvc.model;

import java.util.List;

public class Team {


    private String teamName;
    private List developers;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List getDevelopers() {
        return developers;
    }

    public void setDevelopers(List developers) {
        this.developers = developers;
    }

    public void addDeveloperToTeam(Developer developer) {
        this.developers.add(developer);
    }

    public void removeDeveloperFromTeam(Developer developer) {
        this.developers.remove(developer);
    }

    public void shotTeam() {
        System.out.println(developers);
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", developers=" + developers +
                '}';
    }

}
