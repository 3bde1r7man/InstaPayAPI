package instapay.am.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import instapay.am.Repository.WalletRepository;

@Component
public class WalletAPI {
    @Autowired
    private WalletRepository walletRepository;
    // validate wallet account number
    public boolean validWalletACC(String walletAccNum) {
        if(walletAccNum.length() == 0) return false;
        return walletRepository.existsById(walletAccNum);
    }
    // get account balance
    public double accountBalance(String AccNum) {
        if(AccNum.length() == 0) return -1.0;
        return walletRepository.findById(AccNum).get().getBalance();
    }
    // subtract amount from account balance
    public boolean subtract(String walletAccNum, double amount) {
        if(walletAccNum.length() == 0) return false;
        if(amount < 0) return false;
        if(walletRepository.findById(walletAccNum).get().getBalance() < amount) return false;
        walletRepository.findById(walletAccNum).get().setBalance(walletRepository.findById(walletAccNum).get().getBalance() - amount);
        walletRepository.save(walletRepository.findById(walletAccNum).get());
        return true;
    }
    // add amount to account balance
    public boolean add(String walletAccNum, double amount) {
        if(walletAccNum.length() == 0) return false;
        if(amount < 0) return false;
        walletRepository.findById(walletAccNum).get().setBalance(walletRepository.findById(walletAccNum).get().getBalance() + amount);
        walletRepository.save(walletRepository.findById(walletAccNum).get());
        return true;
    }
}
