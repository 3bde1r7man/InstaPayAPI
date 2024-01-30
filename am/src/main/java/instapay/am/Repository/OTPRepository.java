package instapay.am.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import instapay.am.Model.OTP;

public interface OTPRepository extends JpaRepository<OTP, String>{
    
}
