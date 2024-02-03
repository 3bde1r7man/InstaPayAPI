package instapay.am.Service;

import org.springframework.beans.factory.annotation.Autowired;

import instapay.am.API.BankAPI;

public class BankTransfer implements BankTransferStrat{
    @Autowired
    private BankAPI bankAPI;
    @Override
    public boolean transfer(String reciver, double amount) {
        return bankAPI.add(reciver, amount);
    }
    
}
