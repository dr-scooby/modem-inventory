package com.inventory.jahinventory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;


@Controller
public class InvController {

    private final ModemService modemService;


    // SpringBoot will inject the ModemService
    public InvController(ModemService modemService) {
        this.modemService = modemService;
    }


    @GetMapping("/inv")
    public String greeting(){
        return "index";
    }


    // send the add modem form to the client
    @GetMapping("/inv/addmodem")
    public String addModem(Model model){
        System.out.println("reached add modem");
        // add new modem object and send to client, attached to the web page,
        // thymeleaf takes care of the object
        model.addAttribute("modemobject", new Modems());

        // pass a list of options
        List<String> versions = Arrays.asList("v1", "v1.1", "v2");
        model.addAttribute("versions", versions);

        return "addModem";
    }

    // get the new modem details from the client
    @PostMapping("/inv/addmodem-form")
    public String processAddModem(@ModelAttribute("modemobject") Modems modems,  Model model){
        System.out.println("Model name: " + modems.getName());
        System.out.println("Model : " + modems);

        modemService.addModem(modems);
        model.addAttribute("submittedData", modems);

        return "addmodemsuccess";
    }

    // list all the modems in the DB
    @GetMapping("/inv/listmodems")
    public String getAllModems(Model model){
        System.out.println("list all modems");
        // don't forget to add the list !!!!!!
        List<Modems> modems = modemService.getAllModems();
        model.addAttribute("allmodems" , modems);

        return "listallmodems";
    }

    @GetMapping("/inv/addtvsetbox")
    public String addTVSetBox(){

        return "addTVSetbox";
    }
}
