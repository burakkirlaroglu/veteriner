package com.burak.veteriner.controller;

import com.burak.veteriner.entity.Pet;
import com.burak.veteriner.service.PetService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pets/")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("showPetForm")
    public String showFriendForm(Pet pet) {
        return petService.showPetForm(pet);
    }

    @GetMapping(value = "list")
    public String PetsList(Model model) {
        return petService.PetsList(model);
    }

    @GetMapping(value = "find")
    public String getPet(@RequestParam("name") String name, Model model) {
        return petService.getPet(name, model);
    }

    @PostMapping("add")
    public String addPet(Pet pet, BindingResult result, Model model){
        return petService.addPet(pet, result, model);
    }

    @PostMapping("update/{id}")
    public String updatePet(@PathVariable long id, Pet pet, BindingResult result, Model model){
        return petService.updatePet(id, pet, result, model);
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        return petService.ShowUpdateForm(id, model);
    }

    @GetMapping("delete/{id}")
    public String deletePet(@PathVariable long id, Model model){
        return petService.deletePet(id, model);
    }
}
