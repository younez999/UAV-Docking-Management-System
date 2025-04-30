package com.example.uavdockingmanagementsystem.repository;
import com.example.uavdockingmanagementsystem.model.UAV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UAVRepository extends JpaRepository<UAV, Integer> {
    @Query("SELECT u FROM UAV u LEFT JOIN FETCH u.regions")
    List<UAV> findAllWithRegions();
}


