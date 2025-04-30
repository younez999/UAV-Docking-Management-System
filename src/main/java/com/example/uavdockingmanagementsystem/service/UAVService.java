package com.example.uavdockingmanagementsystem.service;
import com.example.uavdockingmanagementsystem.model.UAV;
import com.example.uavdockingmanagementsystem.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.uavdockingmanagementsystem.repository.UAVRepository;
import com.example.uavdockingmanagementsystem.repository.RegionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UAVService {

    @Autowired
    private UAVRepository uavRepository;
    
    @Autowired
    private RegionRepository regionRepository;

    // Add a new UAV
    public UAV addUAV(UAV uav) {
        return uavRepository.save(uav);
    }

    // Get all UAVs
    public List<UAV> getAllUAVs() {
        return uavRepository.findAll();
    }

    // Delete UAV by ID
    public void deleteUAV(int id) {
        uavRepository.deleteById(id);
    }

    // Get UAV by ID
    public Optional<UAV> getUAVById(int id) {
        return uavRepository.findById(id);
    }
    
    /**
     * Add a region to a specific UAV
     */
    @Transactional
    public UAV addRegionToUAV(int uavId, int regionId) {
        Optional<UAV> uavOpt = uavRepository.findById(uavId);
        Optional<Region> regionOpt = regionRepository.findById(regionId);
        
        if (uavOpt.isPresent() && regionOpt.isPresent()) {
            UAV uav = uavOpt.get();
            Region region = regionOpt.get();
            
            // Add the region to the UAV's regions
            uav.getRegions().add(region);
            UAV updatedUAV = uavRepository.save(uav);
            return updatedUAV;
        }
        
        return null;
    }
    
    /**
     * Remove a region from a specific UAV
     */
    @Transactional
    public UAV removeRegionFromUAV(int uavId, int regionId) {
        Optional<UAV> uavOpt = uavRepository.findById(uavId);
        Optional<Region> regionOpt = regionRepository.findById(regionId);
        
        if (uavOpt.isPresent() && regionOpt.isPresent()) {
            UAV uav = uavOpt.get();
            Region region = regionOpt.get();
            
            // Remove the region from the UAV's regions
            uav.getRegions().remove(region);
            UAV updatedUAV = uavRepository.save(uav);
            return updatedUAV;
        }
        
        return null;
    }

    /**
     * Get available regions that are not already assigned to a UAV
     */
    public List<Region> getUnassignedRegionsForUAV(int uavId) {
        Optional<UAV> uavOpt = uavRepository.findById(uavId);
        
        if (uavOpt.isPresent()) {
            UAV uav = uavOpt.get();
            List<Region> allRegions = regionRepository.findAll();
            // Filter out regions that are already assigned to this UAV
            return allRegions.stream()
                    .filter(region -> !uav.getRegions().contains(region))
                    .toList();
        }
        
        return List.of();
    }
    
    /**
     * Get all regions that are assigned to a specific UAV
     */
    public List<Region> getAssignedRegionsForUAV(int uavId) {
        Optional<UAV> uavOpt = uavRepository.findById(uavId);
        
        if (uavOpt.isPresent()) {
            UAV uav = uavOpt.get();
            // Convert set to list
            return uav.getRegions().stream().toList();
        }
        
        return List.of();
    }
}


