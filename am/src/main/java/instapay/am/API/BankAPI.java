package instapay.am.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import instapay.am.Repository.BankRepository;

@Component
public class BankAPI {
    @Autowired
    private BankRepository bankRepository;
    // validate bank account number
    public boolean validBankACC(String bankAccNum) {
        if(bankAccNum.length() == 0) return false;
        return bankRepository.existsById(bankAccNum);
    }
    // get account balance
    public double accountBalance(String bankAccNum) {
        if(bankAccNum.length() == 0) return -1.0;
        return bankRepository.findById(bankAccNum).get().getBalance();
    }
    // subtract amount from account balance
    public boolean subtract(String bankAccNum, double amount) {
        if(bankAccNum.length() == 0) return false;
        if(amount < 0) return false;
        if(bankRepository.findById(bankAccNum).get().getBalance() < amount) return false;
        bankRepository.findById(bankAccNum).get().setBalance(bankRepository.findById(bankAccNum).get().getBalance() - amount);
        bankRepository.save(bankRepository.findById(bankAccNum).get());
        return true;
    }
    // add amount to account balance
    public boolean add(String bankAccNum, double amount) {
        if(bankAccNum.length() == 0) return false;
        if(amount < 0) return false;
        bankRepository.findById(bankAccNum).get().setBalance(bankRepository.findById(bankAccNum).get().getBalance() + amount);
        bankRepository.save(bankRepository.findById(bankAccNum).get());
        return true;
    }
}
