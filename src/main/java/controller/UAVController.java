package controller;
import model.UAV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.UAVRepository;


@Controller
@RequestMapping("/uav")
public class UAVController {

    @Autowired
    private UAVRepository uavRepository;

    // Show all UAVs
    @GetMapping("/")
    public String getAllUAVs(Model model) {
        model.addAttribute("uavs", uavRepository.findAll());
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
}



