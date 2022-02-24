package com.koxx4.springbootrestdemo.mvc.controllers;

import com.koxx4.springbootrestdemo.entities.DogMedicine;
import com.koxx4.springbootrestdemo.entities.DogStatus;
import com.koxx4.springbootrestdemo.repository.DogStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shady")
public class ShadyDogController {

    @Autowired
    DogStatusRepository dogRepository;

    @RequestMapping("/status")
    private String showPageWithDogStatus(Model model){
        var dogStatuses = dogRepository.findAll();
        List<List<DogStatus>> pagedDogStatuses = new ArrayList<>();

        int pageSize = 3;
        int pages = (int)Math.ceil((double)dogStatuses.size() / (double)pageSize);
        for(int i = 0; i < pages; i++){
            List<DogStatus> newPage = new ArrayList<>(pageSize);
            for(int j = 0; j < pageSize; j++){
                int nextStatusIndex = (i * pageSize) + j;
                if(nextStatusIndex < dogStatuses.size())
                    newPage.add(dogStatuses.get(nextStatusIndex));
            }
            pagedDogStatuses.add(newPage);
        }

        model.addAttribute("pagedDogStatuses", pagedDogStatuses);
        return "shady-status";
    }

    @RequestMapping("/status/addForm")
    private String showDogStatusForm(Model model){
        var newDogStatus = new DogStatus();
        newDogStatus.setMedicines(new ArrayList<>());
        model.addAttribute("newStatus", newDogStatus);
        return "shady-add-status-form";
    }

    @PostMapping("/status/submitStatus")
    private String addDogStatus(@ModelAttribute("newStatus") DogStatus statusToAdd){
        dogRepository.save(statusToAdd);
        return "redirect:/shady/status";
    }

    @PostMapping(value = "/status/submitStatus", params = {"addMedicineField"})
    private String addMedicineField(@ModelAttribute("newStatus") DogStatus editedStatus){
        editedStatus.addMedicine(new DogMedicine());
        return "shady-add-status-form";
    }
}
