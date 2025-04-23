package com.example.uavdockingmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UavDockingManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(UavDockingManagementSystemApplication.class, args);
        System.out.println("welcome to the UAV Docking Management System");
        /*
          i need  to make first a database system to manage UAV  ,
         simple data base  (AREA ,  UAV ID , ALLOWENCE , DOCKING STATUS, DOCKING DATE
        */
    }
}
