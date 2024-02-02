package instapay.am.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import instapay.am.Service.BillService;
import instapay.am.Model.BillType;

@RestController
@RequestMapping("/instapay/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("")
    public Object getBills(){
        return billService.getAllBills();
    }

    @GetMapping("/{userName}")
    public Object getBillsByUserName(@PathVariable String userName){
        return billService.getBillsByUserName(userName);
    }

    @GetMapping("/{userName}/{type}")
    public Object getBillsByType(@PathVariable String userName, @PathVariable String type){
        return billService.getBillsByUserNameAndType(userName, BillType.valueOf(type));
    }

    @GetMapping("/unpaied/{userName}/{type}")
    public Object getUnpaiedBillsByType(@PathVariable String userName, @PathVariable String type){
        return billService.getBillsByUserNameAndBillTypeAndBillStatus(userName, BillType.valueOf(type));
    }
}
