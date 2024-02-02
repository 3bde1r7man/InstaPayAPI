package instapay.am.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import instapay.am.Model.BillStatus;
import instapay.am.Repository.BillRepository;

@Component
public class BillAPI {
    @Autowired
    private BillRepository billRepository;
    
    public boolean validBillCode(String billCode) {
        if(billCode.length() == 0) return false;
        return billRepository.existsById(billCode);
    }

    public boolean payBill(String billCode, String userName) {
        if(billCode.length() == 0 || userName.length() == 0) return false;
        if(!billRepository.existsById(billCode)) return false;
        if(!billRepository.findById(billCode).get().getUserName().equals(userName)) return false;
        billRepository.findById(billCode).get().setBillStatus(BillStatus.PAIED);
        return true;
    }

    public double getBillAmount(String billCode) {
        if(billCode.length() == 0) return -1.0;
        return billRepository.findById(billCode).get().getAmount();
    }

}
