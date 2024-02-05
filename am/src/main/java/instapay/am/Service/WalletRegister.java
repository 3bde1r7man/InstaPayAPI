package instapay.am.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instapay.am.API.WalletAPI;
import instapay.am.Model.User;
import instapay.am.Model.WalletUser;
import instapay.am.Repository.UserRepository;
import instapay.am.Util.JsonUtil;

@Service
public class WalletRegister extends Register {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WalletAPI walletAPI;
    // register wallet user
    @Override
    public Object register(User user) {
        WalletUser walletUser = (WalletUser) user;
        if(walletUser.getUserName().length() == 0 || walletUser.getPassword().length() == 0 || walletUser.getPhone().length() == 0) return false;
        
        if (userRepository.existsById(walletUser.getUserName())) {
            
            return JsonUtil.error("Username already exists");
        }

        if (!isStrongPassword(walletUser.getPassword())) {
            return JsonUtil.error("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
        }

        if (!isEGYPhoneNum(walletUser.getPhone())) {
            return JsonUtil.error("Phone number must be 11 digits and start with 01.");
        }

        if(!walletAPI.validWalletACC(walletUser.getPhone())){
            return JsonUtil.error("Invalid Wallet Account");
        }

        userRepository.save(walletUser);
        return JsonUtil.success("Wallet User Registered Successfully");
    }
}
