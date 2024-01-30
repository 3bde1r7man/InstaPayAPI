package instapay.am.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import instapay.am.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    
}
