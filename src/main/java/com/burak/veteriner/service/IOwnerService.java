package com.burak.veteriner.service;

import com.burak.veteriner.entity.Owner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface IOwnerService {

    String addOwner(Owner owner, BindingResult result, Model model);

    String updateOwner(long id, Owner owner, BindingResult result, Model model);

    String deleteOwner(long id, Model model);

    String getOwner(String name, Model model);

    String showOwnerForm(Owner owner);

    String ownerList(Model model);

    String showUpdateForm(long id, Model model);

}
