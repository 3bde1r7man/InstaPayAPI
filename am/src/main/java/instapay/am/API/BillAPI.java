package instapay.am.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import instapay.am.Model.BillStatus;
import instapay.am.Repository.BillRepository;

@Component
public class BillAPI {
    @Autowired
    private BillRepository billRepository;
    // validate bill code
    public boolean validBillCode(String billCode) {
        if(billCode.length() == 0) return false;
        return billRepository.existsById(billCode);
    }
    // pay bill
    public boolean payBill(String billCode, String userName) {
        if(billCode.length() == 0 || userName.length() == 0) return false;
        if(!billRepository.existsById(billCode)) return false;
        if(!billRepository.findById(billCode).get().getUserName().equals(userName)) return false;
        billRepository.findById(billCode).get().setBillStatus(BillStatus.PAIED);
        return true;
    }
    // get bill amount
    public double getBillAmount(String billCode) {
        if(billCode.length() == 0) return -1.0;
        return billRepository.findById(billCode).get().getAmount();
    }
    // get bill status
    public BillStatus getBillStatus(String billCode) {
        return billRepository.findById(billCode).get().getBillStatus();
    }

}
