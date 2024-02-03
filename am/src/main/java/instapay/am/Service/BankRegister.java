package instapay.am.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instapay.am.Model.User;
import instapay.am.Repository.UserRepository;
import instapay.am.Util.JsonUtil;
import instapay.am.API.BankAPI;
import instapay.am.Model.BankUser;


@Service
public class BankRegister extends Register{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BankAPI bankAPI;
    @Override
    public Object register(User user) {
        BankUser bankUser = (BankUser) user;
        if(bankUser.getUserName().length() == 0 || bankUser.getPassword().length() == 0 || bankUser.getPhone().length() == 0 || bankUser.getBankAccNum().length() == 0) return false;
        
        if (userRepository.existsById(bankUser.getUserName())) {
            return JsonUtil.error("Username already exists");
        }

        if (!isStrongPassword(bankUser.getPassword())) {
            return JsonUtil.error("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
        }

        if (!isEGYPhoneNum(bankUser.getPhone())) {
            return JsonUtil.error("Phone number must be 11 digits and start with 01.");
        }

        if(!bankAPI.validBankACC(bankUser.getBankAccNum())){
            return JsonUtil.error("Invalid Bank Account");
        }

        userRepository.save(bankUser);
        return JsonUtil.success("Bank User Registered Successfully");
    }
    
}
