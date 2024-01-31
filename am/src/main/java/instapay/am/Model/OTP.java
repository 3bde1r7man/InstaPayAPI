package instapay.am.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class OTP {
    @Id
    private String phoneNumber;
    private String otpCode;
}
