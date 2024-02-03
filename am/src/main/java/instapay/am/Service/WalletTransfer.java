package instapay.am.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import instapay.am.API.WalletAPI;

@Component
public class WalletTransfer implements WalletTransferStrat, BankTransferStrat{
    @Autowired
    private WalletAPI walletAPI;
    @Override
    public boolean transfer(String reciver, double amount) {
        return walletAPI.add(reciver, amount);
    }
    
}
