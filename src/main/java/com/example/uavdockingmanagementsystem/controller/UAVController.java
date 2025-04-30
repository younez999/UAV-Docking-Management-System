package com.example.uavdockingmanagementsystem.controller;
import com.example.uavdockingmanagementsystem.model.Region;
import com.example.uavdockingmanagementsystem.model.UAV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.uavdockingmanagementsystem.repository.UAVRepository;

@Controller
@RequestMapping("/uav")
public class UAVController {

    @Autowired
    private UAVRepository uavRepository;

    // Show all UAVs
    @GetMapping("/")
    public String getAllUAVs(Model model) {
        model.addAttribute("uavs", uavRepository.findAllWithRegions());
        return "index";  // Ensure "index.html" is in the "src/main/resources/templates" directory
    }

    // Add a new UAV
    @PostMapping("/add")
    public String addUAV(@ModelAttribute UAV uav) {
        uavRepository.save(uav);
        return "redirect:/uav/";
    }

    // Delete UAV by ID
    @GetMapping("/delete/{id}")
    public String deleteUAV(@PathVariable int id) {
        uavRepository.deleteById(id);
        return "redirect:/uav/";
    }
    
    // Update UAV status
    @GetMapping("/update-status/{id}")
    public String updateUAVStatus(@PathVariable int id) {
        UAV uav = uavRepository.findById(id).orElseThrow();
        // Toggle status between AUTHORIZED and UNAUTHORIZED
        if (uav.getStatus() == UAV.Status.AUTHORIZED) {
            uav.setStatus(UAV.Status.UNAUTHORIZED);
        } else {
            uav.setStatus(UAV.Status.AUTHORIZED);
        }
        // The updatedAt field will be automatically updated via @PreUpdate
        uavRepository.save(uav);
        return "redirect:/uav/";
    }
}



