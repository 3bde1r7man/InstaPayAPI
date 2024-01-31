package instapay.am.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instapay.am.API.BankAPI;
import instapay.am.Model.BankUser;
import instapay.am.Repository.UserRepository;
import instapay.am.Util.JsonUtil;

@Service
public class BankUserService {
    @Autowired
    private BankAPI bankAPI;
    @Autowired
    private UserRepository userRepository;
    public Object inquireBalance(String userName) {
        if(userName.length() == 0) return JsonUtil.error("Invalid Username");
        if(!userRepository.existsById(userName)) return JsonUtil.error("Username does not exist");
        BankUser bankUser = (BankUser) userRepository.findById(userName).get();
        return JsonUtil.success(Double.toString(bankAPI.accountBalance(bankUser.getBankAccNum())));
    }
}
