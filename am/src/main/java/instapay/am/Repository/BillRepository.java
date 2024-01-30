package instapay.am.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import instapay.am.Model.Bill;

public interface BillRepository extends JpaRepository<Bill, String>{
    
}
