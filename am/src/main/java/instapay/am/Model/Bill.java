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
    private String user;
    private BillType billType;
    private double price;

}


