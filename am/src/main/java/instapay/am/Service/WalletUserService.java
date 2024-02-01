package instapay.am.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instapay.am.API.WalletAPI;
import instapay.am.Repository.UserRepository;
import instapay.am.Util.JsonUtil;


@Service
public class WalletUserService {
    @Autowired
    private WalletAPI walletAPI;
    @Autowired
    private UserRepository userRepository;

    public Object inquireBalance(String userName) {
        if(userName.length() == 0) return JsonUtil.error("Invalid Username");
        if(!userRepository.existsById(userName)) return JsonUtil.error("Username does not exist");
        return JsonUtil.success(Double.toString(walletAPI.accountBalance(userRepository.findById(userName).get().getPhone())));
    }
}
