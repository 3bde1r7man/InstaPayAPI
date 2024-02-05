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

    
    // get all bills
    public Object getBillsByUserName(String userName){
        if(userName == null || userName.isEmpty()){
            return JsonUtil.error("Invalid username");
        }
        return billRepository.findByUserName(userName);
    }
    // get bills by userName and type
    public Object getBillsByUserNameAndBillTypeAndBillStatus(String userName, BillType type){
        if(userName == null || userName.isEmpty() || type == null || type.toString().isEmpty()){
            return JsonUtil.error("Invalid username or type");
        }
        return billRepository.findByUserNameAndBillTypeAndBillStatus(userName, type, BillStatus.UNPAIED);
    }
    // get all bills
    public Object getAllBills(){
        return billRepository.findAll();
    }
    // get bills by userName
    public Object getBillsByUserNameAndType(String userName, BillType type){
        if(userName == null || userName.isEmpty() || type == null || type.toString().isEmpty()){
            return JsonUtil.error("Invalid username or type");
        }
        return billRepository.findByUserNameAndBillType(userName, type);
    }

}
