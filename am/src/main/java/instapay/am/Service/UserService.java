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

    public Object bankRegister(BankUser user) {
        return bankRegister.register(user);
    }

    public Object walletRegister(WalletUser user) {
        return walletRegister.register(user);
    }

    public Object getUsers() {
        return userRepository.findAll();
    }
}
