package instapay.am.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instapay.am.API.BillAPI;
import instapay.am.API.WalletAPI;
import instapay.am.Model.BankUser;
import instapay.am.Model.BillStatus;
import instapay.am.Repository.UserRepository;
import instapay.am.Util.JsonUtil;


@Service
public class WalletUserService {
    @Autowired
    private WalletAPI walletAPI;
    @Autowired
    private BillAPI billAPI;
    @Autowired
    private UserRepository userRepository;

    public Object inquireBalance(String userName) {
        if(userName.length() == 0) return JsonUtil.error("Invalid Username");
        if(!userRepository.existsById(userName)) return JsonUtil.error("Username does not exist");
        return JsonUtil.success(Double.toString(walletAPI.accountBalance(userRepository.findById(userName).get().getPhone())));
    }

    public Object payBill(String userName, String billCode) {
        if(userName.length() == 0 || billCode.length() == 0) return JsonUtil.error("Invalid Username or Bill Code");
        if(!userRepository.existsById(userName)) return JsonUtil.error("Username does not exist");
        if(!billAPI.validBillCode(billCode)) return JsonUtil.error("Invalid Bill Code");
        if(billAPI.getBillStatus(billCode).equals(BillStatus.PAIED)) return JsonUtil.error("Bill Already Paid");
        if(!billAPI.payBill(billCode, userName)) return JsonUtil.error("Bill Payment Failed");
        if(!walletAPI.subtract(userRepository.findById(userName).get().getPhone(), billAPI.getBillAmount(billCode))) return JsonUtil.error("Insufficient Balance");
        return JsonUtil.success("Bill Paid Successfully");
    }
    
}
