package instapay.am.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import instapay.am.API.BankAPI;
import instapay.am.API.WalletAPI;
import instapay.am.Model.BankUser;
import instapay.am.Model.User;
import instapay.am.Repository.UserRepository;

@Component
public class InstaPayTransfer implements WalletTransferStrat, BankTransferStrat{
    @Autowired
    private WalletAPI walletAPI;
    @Autowired
    private BankAPI bankAPI;
    @Autowired
    UserRepository userRepository;
    @Override
    public boolean transfer(String reciver, double amount) {
        User user = userRepository.findById(reciver).get();
        if(user == null) return false;
        if(user.getAccType().toString().equals("Wallet")) {
            return walletAPI.add(user.getPhone(), amount);
        }else if(user.getAccType().toString().equals("Bank")) {
            BankUser bankUser = (BankUser) user;
            return bankAPI.add(bankUser.getBankAccNum(), amount);
        }else{
            return false;
        }
    }
    
}
