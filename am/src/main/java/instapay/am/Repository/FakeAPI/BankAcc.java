package instapay.am.Repository.FakeAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "`BankAcc`")
public class BankAcc {
    @Id
    private String accNo;
    private double balance;
}
