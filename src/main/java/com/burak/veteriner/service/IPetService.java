package com.burak.veteriner.service;

import com.burak.veteriner.entity.Pet;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface IPetService {

    String addPet(Pet pet, BindingResult result, Model model);

    String updatePet(long id, Pet pet, BindingResult result, Model model);

    String deletePet(long id, Model model);

    String getPet(String name, Model model);

    String showPetForm(Pet pet);

    String PetsList(Model model);

    String ShowUpdateForm(long id, Model model);
}
