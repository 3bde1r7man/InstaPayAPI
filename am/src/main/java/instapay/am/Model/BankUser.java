package instapay.am.Model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class BankUser extends User{
    private String bankAccNum;

}
