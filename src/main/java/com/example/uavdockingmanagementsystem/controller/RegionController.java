package com.example.uavdockingmanagementsystem.controller;

import com.example.uavdockingmanagementsystem.model.Region;
import com.example.uavdockingmanagementsystem.repository.RegionRepository;
import com.example.uavdockingmanagementsystem.repository.UAVRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RegionController {

    @Autowired
    private UAVRepository uavRepository;

    @Autowired
    private RegionRepository regionRepository;

    @PostConstruct
    public void init() {
        // Check if regions exist, if not add some sample regions
        if (regionRepository.count() == 0) {
            System.out.println("No regions found in database. Adding sample regions...");
            regionRepository.save(new Region("North"));
            regionRepository.save(new Region("South"));
            regionRepository.save(new Region("East"));
            regionRepository.save(new Region("West"));
            System.out.println("Sample regions added.");
        } else {
            System.out.println("Regions already exist in database: " + regionRepository.count());
            List<Region> regions = regionRepository.findAll();
            for (Region region : regions) {
                System.out.println("Region: " + region.getRegionName() + " (ID: " + region.getId() + ")");
            }
        }
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Region> regions = regionRepository.findAll();
        System.out.println("Regions found: " + regions.size());
        
        model.addAttribute("uavs", uavRepository.findAllWithRegions());
        model.addAttribute("allRegions", regions);
        return "index";
    }
}
