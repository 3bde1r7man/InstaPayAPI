package instapay.am.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instapay.am.Repository.BillRepository;
import instapay.am.Util.JsonUtil;
import instapay.am.Model.BillStatus;
import instapay.am.Model.BillType;


@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;

    boolean payBill(String code, String userName){
        return true;
    }
    
    public Object getBillsByUserName(String userName){
        if(userName == null || userName.isEmpty()){
            return JsonUtil.error("Invalid username");
        }
        return billRepository.findByUserName(userName);
    }

    public Object getBillsByUserNameAndBillTypeAndBillStatus(String userName, BillType type){
        if(userName == null || userName.isEmpty() || type == null || type.toString().isEmpty()){
            return JsonUtil.error("Invalid username or type");
        }
        return billRepository.findByUserNameAndBillTypeAndBillStatus(userName, type, BillStatus.UNPAIED);
    }

    public Object getAllBills(){
        return billRepository.findAll();
    }

    public Object getBillsByUserNameAndType(String userName, BillType type){
        if(userName == null || userName.isEmpty() || type == null || type.toString().isEmpty()){
            return JsonUtil.error("Invalid username or type");
        }
        return billRepository.findByUserNameAndBillType(userName, type);
    }

}
