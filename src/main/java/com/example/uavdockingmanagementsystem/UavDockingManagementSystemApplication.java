package com.example.uavdockingmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UavDockingManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(UavDockingManagementSystemApplication.class, args);
        System.out.println("welcome to the UAV Docking Management System");
        /*
         futue work is to  add the  region  option to the UI  (ALREADY MADE IN DATABASE )
        */
    }
}
