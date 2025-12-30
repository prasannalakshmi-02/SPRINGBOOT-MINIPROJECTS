package com.prasanna.atm_simulation.controller;

import com.prasanna.atm_simulation.service.AtmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtmController {

    private final AtmService atmService;

    public AtmController(AtmService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/atm/withdraw")
    public String withdraw(@RequestParam int amount){
        return atmService.withdraw(amount);
    }

    @GetMapping("/atm/deposit")
    public String deposit(@RequestParam int amount){
        atmService.deposit(amount);
        return "Deposit initiated";
    }

}
