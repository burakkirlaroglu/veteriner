package com.burak.veteriner.service;

import com.burak.veteriner.entity.Pet;
import com.burak.veteriner.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetService implements IPetService {

    @Autowired
    private PetRepository petRepository;


    @Override
    public String addPet(Pet pet,
                            BindingResult result,
                            Model model) {
        if(result.hasErrors()) {
            return "add-pet";
        }

        this.petRepository.save(pet);
        return "redirect:list";
    }


    @Override
    public String updatePet(long id, Pet pet,
                               BindingResult result, Model model) {
        if(result.hasErrors()) {
            pet.setId(id);
            return "update-pet";
        }

        // update pet
        this.petRepository.save(pet);

        // get all pets ( with update)
        model.addAttribute("pet", this.petRepository.findAll());
        return "index";
    }

    @Override
    public String deletePet(long id, Model model) {
        Pet pet = this.petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pet id : " + id));

        this.petRepository.delete(pet);
        model.addAttribute("pet", this.petRepository.findAll());
        return "index";
    }

    @Override
    public String getPet(String name, Model model) {
        Pet pet = this.petRepository.findByName(name);
        model.addAttribute("pet", pet);

        return "index";
    }

    @Override
    public String showPetForm(Pet pet) {
        return "add-pet";
    }

    @Override
    public String PetsList(Model model) {
        model.addAttribute("pet", this.petRepository.findAll());
        return "index";
    }

    @Override
    public String ShowUpdateForm(long id, Model model) {
        Pet pet = this.petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pet id : " + id));

        model.addAttribute("pet", pet);
        return "update-pet";
    }

}
