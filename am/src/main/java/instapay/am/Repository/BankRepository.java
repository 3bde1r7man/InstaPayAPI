package instapay.am.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import instapay.am.Repository.FakeAPI.BankAcc;


@Repository
public interface BankRepository extends JpaRepository<BankAcc, String>{
    
}
