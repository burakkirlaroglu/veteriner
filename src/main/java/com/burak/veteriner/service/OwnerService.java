package com.burak.veteriner.service;

import com.burak.veteriner.entity.Owner;
import com.burak.veteriner.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Component
public class OwnerService implements IOwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public String addOwner(Owner owner,
                            BindingResult result,
                            Model model) {
        if(result.hasErrors()) {
            return "add-owner";
        }

        this.ownerRepository.save(owner);
        return "redirect:list";
    }

    @Override
    public String updateOwner(long id, Owner owner,
                               BindingResult result,
                               Model model) {
        if(result.hasErrors()) {
            owner.setId(id);
            return "update-owner";
        }

        // update person
        this.ownerRepository.save(owner);

        // get all friends (with update)
        model.addAttribute("owner", this.ownerRepository.findAll());
        return "index";
    }

    @Override
    public String deleteOwner(long id, Model model) {
        Owner owner = this.ownerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person id : " + id));

        this.ownerRepository.delete(owner);
        model.addAttribute("owner", this.ownerRepository.findAll());
        return "index";
    }

    @Override
    public String getOwner(String name, Model model) {
        return null;
    }

    @Override
    public String showOwnerForm(Owner owner) {
        return "add-owner";
    }

    @Override
    public String ownerList(Model model) {
        if (model != null){
            model.addAttribute("owner", this.ownerRepository.findAll());
            return "index";
        }else {
            model.addAttribute("owner", new Owner());
            return "index";
        }
    }

    @Override
    public String showUpdateForm(long id, Model model) {
        Owner owner = this.ownerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pet id : " + id));

        model.addAttribute("owner", owner);
        return "update-owner";
    }
}
