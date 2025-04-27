package service;
import model.UAV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UAVRepository;

import java.util.List;
import java.util.Optional;

@Service

public class UAVService {



        @Autowired
        private UAVRepository uavRepository;

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
    }


