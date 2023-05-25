package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.contact.Ticket;
import com.groupe4.frontoffice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping(value = "/ticket")
    public String registration(Model model, Ticket ticket){
        model.addAttribute("ticket", ticket);;
        return "ticket";
    }
    @PostMapping("/ticket")
    public String userContact(Ticket ticket){
        ticketService.save(ticket);
        return"redirect:/";
    }

}
