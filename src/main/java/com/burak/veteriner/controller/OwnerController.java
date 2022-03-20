package com.burak.veteriner.controller;


import com.burak.veteriner.entity.Owner;
import com.burak.veteriner.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner/")
public class OwnerController {


    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("showOwnerForm")
    public String showOwnerForm(Owner owner) {
        return ownerService.showOwnerForm(owner);
    }

    @GetMapping(value = "list")
    public String personList(Model model) {
        return ownerService.ownerList(model);
    }

    @PostMapping("add")
    public String addPerson(Owner owner, BindingResult result, Model model){
        return ownerService.addOwner(owner, result, model);
    }

    @PostMapping("update/{id}")
    public String updateOwner(@PathVariable long id, Owner owner, BindingResult result, Model model){
        return ownerService.updateOwner(id, owner, result, model);
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        return ownerService.showUpdateForm(id, model);
    }

    @GetMapping("delete/{id}")
    public String deleteOwner(@PathVariable long id, Model model){
        return ownerService.deleteOwner(id, model);
    }
}
