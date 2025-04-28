package com.example.uavdockingmanagementsystem.repository;
import com.example.uavdockingmanagementsystem.model.UAV;
import org.springframework.data.jpa.repository.JpaRepository;




    public interface UAVRepository extends JpaRepository<UAV, Integer> {
    }


