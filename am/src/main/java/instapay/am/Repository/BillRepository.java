package instapay.am.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import instapay.am.Model.Bill;
import instapay.am.Model.BillStatus;
import instapay.am.Model.BillType;

@Repository
public interface BillRepository extends JpaRepository<Bill, String>{
    public List<Bill> findByUserName(String userName);
    public List<Bill> findByUserNameAndBillType(String userName, BillType type);
    public List<Bill> findByUserNameAndBillTypeAndBillStatus(String userName, BillType type, BillStatus status);
}
