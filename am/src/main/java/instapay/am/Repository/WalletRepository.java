package instapay.am.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import instapay.am.Repository.FakeAPI.WalletAcc;


@Repository
public interface WalletRepository extends JpaRepository<WalletAcc, String>{
    
}
