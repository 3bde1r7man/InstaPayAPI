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
public class Bill {
    @Id
    private String code;
    private String userName;
    private BillType billType;
    private BillStatus billStatus;
    private double amount;

}


