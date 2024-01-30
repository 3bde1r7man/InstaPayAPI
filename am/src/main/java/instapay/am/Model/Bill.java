package instapay.am.Model;

import org.springframework.stereotype.Component;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Bill {
    private String code;
    private String user;
    private BillType billType;
    private double price;

    

}


