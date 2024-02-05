package instapay.am.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instapay.am.Model.BankUser;
import instapay.am.Model.WalletUser;
import instapay.am.Repository.UserRepository;


@Service
public class UserService {
    @Autowired
    private BankRegister bankRegister;
    @Autowired
    private WalletRegister walletRegister;

    @Autowired
    private UserRepository userRepository;
    // register bank user
    public Object bankRegister(BankUser user) {
        return bankRegister.register(user);
    }
    // register wallet user
    public Object walletRegister(WalletUser user) {
        return walletRegister.register(user);
    }
    // get all users
    public Object getUsers() {
        return userRepository.findAll();
    }
    // get user by userName
    public Object getUser(String userName) {
        if(userName.length() == 0) return "Invalid Username";
        if(!userRepository.existsById(userName)) return "Username does not exist";
        return userRepository.findById(userName).get();
    }
}
