package instapay.am.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import instapay.am.Service.WalletUserService;

@RestController
@RequestMapping("/instapay/wallet")
public class WalletUserController {
    @Autowired
    private WalletUserService walletUserService;


    @GetMapping("/inquire/{userName}")
    public Object inquire(@PathVariable String userName) {
        return walletUserService.inquireBalance(userName);
    }
    
}