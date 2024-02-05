package instapay.am.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instapay.am.API.BankAPI;
import instapay.am.API.BillAPI;
import instapay.am.Model.BankUser;
import instapay.am.Model.BillStatus;
import instapay.am.Repository.UserRepository;
import instapay.am.Util.JsonUtil;

@Service
public class BankUserService {
    @Autowired
    private BankAPI bankAPI;
    @Autowired
    private BillAPI billAPI;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    InstaPayTransfer instaPayTransfer;
    @Autowired
    WalletTransfer walletTransfer;

    // get account balance
    public Object inquireBalance(String userName) {
        if(userName.length() == 0) return JsonUtil.error("Invalid Username");
        if(!userRepository.existsById(userName)) return JsonUtil.error("Username does not exist");
        BankUser bankUser = (BankUser) userRepository.findById(userName).get();
        return JsonUtil.success(Double.toString(bankAPI.accountBalance(bankUser.getBankAccNum())));
    }
    // pay bill
    public Object payBill(String userName, String billCode) {
        if(userName.length() == 0 || billCode.length() == 0) return JsonUtil.error("Invalid Username or Bill Code");
        if(!userRepository.existsById(userName)) return JsonUtil.error("Username does not exist");
        if(!billAPI.validBillCode(billCode)) return JsonUtil.error("Invalid Bill Code");
        if(billAPI.getBillStatus(billCode).equals(BillStatus.PAIED)) return JsonUtil.error("Bill Already Paid");
        if(!billAPI.payBill(billCode, userName)) return JsonUtil.error("Bill Payment Failed");
        BankUser bankUser = (BankUser) userRepository.findById(userName).get();
        if(!bankAPI.subtract(bankUser.getBankAccNum(), billAPI.getBillAmount(billCode))) return JsonUtil.error("Insufficient Balance");
        return JsonUtil.success("Bill Paid Successfully");
    }
    // add amount to account balance
    public boolean addBalance(String userName, double amount) {
        if(userName.length() == 0 || amount <= 0) return false;
        if(!userRepository.existsById(userName)) return false;
        BankUser bankUser = (BankUser) userRepository.findById(userName).get();
        if(!bankAPI.add(bankUser.getBankAccNum(), amount)) return false;
        return true;
    }
    // subtract amount from account balance
    public boolean subtractBalance(String userName, double amount) {
        if(userName.length() == 0 || amount <= 0) return false;
        if(!userRepository.existsById(userName)) return false;
        BankUser bankUser = (BankUser) userRepository.findById(userName).get();
        if(!bankAPI.subtract(bankUser.getBankAccNum(), amount)) return false;
        return true;
    }

    // transfer amount to wallet
    public Object transferToWallet(String userName, String walletAccNum, double amount) {
        if(userName.length() == 0 || amount <= 0 || walletAccNum.length() == 0) return JsonUtil.error("Invalid Username or Amount or Wallet Account Number");
        if(!userRepository.existsById(userName)) return JsonUtil.error("Username does not exist");
        BankUser bankUser = (BankUser) userRepository.findById(userName).get();
        if(!bankAPI.subtract(bankUser.getBankAccNum(), amount)) return JsonUtil.error("Insufficient Balance");
        if(!walletTransfer.transfer(walletAccNum, amount)) {
            bankAPI.add(bankUser.getBankAccNum(), amount);
            return JsonUtil.error("Transfer Failed");
        }
        return JsonUtil.success("Transfer Successfully");
    }
    // transfer amount to bank
    public Object transferToBank(String userName, String bankAccNum, double amount) {
        if(userName.length() == 0 || amount <= 0 || bankAccNum.length() == 0) return JsonUtil.error("Invalid Username or Amount or Bank Account Number");
        if(!userRepository.existsById(userName)) return JsonUtil.error("Username does not exist");
        BankUser bankUser = (BankUser) userRepository.findById(userName).get();
        if(bankUser.getBankAccNum().equals(bankAccNum)) return JsonUtil.error("Cannot Transfer to urself");
        if(!bankAPI.subtract(bankUser.getBankAccNum(), amount)) return JsonUtil.error("Insufficient Balance");
        if(!bankAPI.add(bankAccNum, amount)) {
            bankAPI.add(bankUser.getBankAccNum(), amount);
            return JsonUtil.error("Failed to add balance to bank account");
        }
        return JsonUtil.success("Balance transferred successfully");
    }
    // transfer amount to instapay
    public Object transferToInstaPay(String from, String to, double amount) {
        
        if(from.length() == 0 || to.length() == 0 || amount <= 0) return JsonUtil.error("Invalid Username or Amount");
        if(!userRepository.existsById(from) || !userRepository.existsById(to)) return JsonUtil.error("Username does not exist");
        if(from.equals(to)) return JsonUtil.error("Cannot Transfer to urself");
        BankUser bankUser = (BankUser) userRepository.findById(from).get();
        if(!bankAPI.subtract(bankUser.getBankAccNum(), amount)) return JsonUtil.error("Insufficient Balance");
        if(!instaPayTransfer.transfer(to, amount)) {
            bankAPI.add(bankUser.getBankAccNum(), amount);
            return JsonUtil.error("Transfer Failed");
        }
        return JsonUtil.success("Transfer Successfully");
    }
    

}
