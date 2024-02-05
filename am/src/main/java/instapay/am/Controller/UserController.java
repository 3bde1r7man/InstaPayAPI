package instapay.am.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    // register bank user
    @PostMapping("/bank/register")
    public Object register(@RequestBody BankUser user) {
        if(user.getUserName() != null){
            return userService.bankRegister(user);
        }
        return JsonUtil.error("User is null");
    }
    // register wallet user
    @PostMapping("/wallet/register")
    public Object register(@RequestBody WalletUser user) {
        
        if(user.getUserName() != null){
            return userService.walletRegister(user);
        }
        return JsonUtil.error("User is null");
    }
    // get all users
    @GetMapping("")
    public Object getUsers(){
        return userService.getUsers();
    }

    // get user by userName
    @GetMapping("/{userName}")
    public Object getUser(@PathVariable String userName){
        return userService.getUser(userName);
    }
}
