package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/offices")
@SessionAttributes("offices")
public class OfficesController {
    @Autowired
    OfficeService officesService;

    @RequestMapping(method = RequestMethod.GET) //value = { "/offices"},
    public String listOffices(ModelMap model) {
        List<Office> offices = officesService.findAllOffices();
        model.addAttribute("offices", offices);
        return "offices";
    }

    @RequestMapping(value = {"/delete-office-{id}"}, method = RequestMethod.GET)
    public String deleteOffice(@PathVariable int id) {
        officesService.deleteOfficeById(id);
        return "redirect:/offices";
    }


    @RequestMapping(value = {"/edit-office-{id}"}, method = RequestMethod.GET)
    public String updateOffice(@PathVariable int id, ModelMap model) {
        Office office = officesService.findById(id);
        model.addAttribute("office", office);
        model.addAttribute("edit", true);
        return "officereg";
    }


    @RequestMapping(value = {"/edit-office-{id}"}, method = RequestMethod.POST)
    public String updateOffice(@Valid Office office, BindingResult result,
                               ModelMap model, @PathVariable Integer id) {

        if (result.hasErrors()) {
            return "officereg";
        }

        officesService.updateOffice(office);
        model.addAttribute("success", "Office " + office.getId() + " updated successfully");

        return "officeregsuccess";
    }


}

