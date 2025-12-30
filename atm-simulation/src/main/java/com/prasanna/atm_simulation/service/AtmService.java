package com.prasanna.atm_simulation.service;

import org.springframework.stereotype.Service;

@Service
public class AtmService {
        // 1. Withdraw Method
        public String withdraw(int amount) {
            System.out.println("💰 [ATM MACHINE] Dispensing " + amount + "...");
            return "SUCCESS: Withdrew " + amount;
        }

        // 2. Deposit Method
        public void deposit(int amount) {
            System.out.println("📥 [ATM MACHINE] Accepting " + amount + "...");
        }

        // 3. Balance Check
        public void checkBalance() {
            System.out.println("📊 [ATM MACHINE] Showing Balance on Screen.");
        }
    }


