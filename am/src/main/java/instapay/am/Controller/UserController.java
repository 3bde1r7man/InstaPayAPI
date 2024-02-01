package instapay.am.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import instapay.am.Model.BankUser;
import instapay.am.Model.WalletUser;
import instapay.am.Service.UserService;
import instapay.am.Util.JsonUtil;


@RestController
@RequestMapping("/instapay")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public Object login() {
        return JsonUtil.success("Login");
    }

    @PostMapping("/bank/register")
    public Object register(@RequestBody BankUser user) {
        
        if(user.getUserName() != null){
            return userService.bankRegister(user);
        }
        return JsonUtil.error("User is null");
    }

    @PostMapping("/wallet/register")
    public Object register(@RequestBody WalletUser user) {
        
        if(user.getUserName() != null){
            return userService.walletRegister(user);
        }
        return JsonUtil.error("User is null");
    }

    @GetMapping("")
    public Object getUsers(){
        return userService.getUsers();
    }

}
