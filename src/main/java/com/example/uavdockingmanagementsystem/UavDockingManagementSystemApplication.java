package com.example.uavdockingmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UavDockingManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(UavDockingManagementSystemApplication.class, args);
        System.out.println("welcome to the UAV Docking Management System");
        System.out.println("CONGRATULATIONS  FINALLY IT'S WORKING! :)");
        //FUTURE WORK : DEPLOY THE  PROJECT IN HEROKU ;
        // DB  AND APP ALREADY DOCKERIZED


    }
}
