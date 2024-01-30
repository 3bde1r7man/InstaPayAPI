package instapay.am.Model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OTP {
    private String phoneNumber;
    private String otpCode;
}
