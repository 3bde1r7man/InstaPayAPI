package instapay.am.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import instapay.am.Repository.BankRepository;

@Component
public class BankAPI {
    @Autowired
    private BankRepository bankRepository;
    public boolean validBankACC(String bankAccNum) {
        if(bankAccNum.length() == 0) return false;
        return bankRepository.existsById(bankAccNum);
    }
    public double accountBalance(String bankAccNum) {
        if(bankAccNum.length() == 0) return -1.0;
        return bankRepository.findById(bankAccNum).get().getBalance();
    }
    public boolean transfer(String bankAccNum, double amount) {
        if(bankAccNum.length() == 0) return false;
        if(amount < 0) return false;
        if(bankRepository.findById(bankAccNum).get().getBalance() < amount) return false;
        bankRepository.findById(bankAccNum).get().setBalance(bankRepository.findById(bankAccNum).get().getBalance() - amount);
        return true;
    }
}
