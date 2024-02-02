package instapay.am.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import instapay.am.Service.BankUserService;

@RestController
@RequestMapping("/instapay/bank")
public class BankUserController {
    @Autowired
    private BankUserService bankUserService;


    @GetMapping("/inquire/{userName}")
    public Object inquire(@PathVariable String userName) {
        return bankUserService.inquireBalance(userName);
    }

    @PutMapping("/pay_bill")
    public Object payBill(@RequestBody Map<String, String> body) {
        String userName = body.get("userName");
        String billCode = body.get("billCode");
        return bankUserService.payBill(userName, billCode);
    }
}
