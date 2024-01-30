package instapay.am.Model;

import org.springframework.stereotype.Component;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BankUser extends User{
    private String bankAccNum;

}
