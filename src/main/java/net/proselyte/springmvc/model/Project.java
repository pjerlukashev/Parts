package net.proselyte.springmvc.model;

public class Project {

    public static void main(String[] args) {
        Developer developer = new Developer("Eugene", "Suleimanov", "Java", 3000);

        System.out.println("Developer Information:\n");
        System.out.println(developer.toString());
    }

}
