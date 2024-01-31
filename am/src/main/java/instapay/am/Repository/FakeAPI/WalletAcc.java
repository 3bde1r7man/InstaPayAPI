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
@Table(name = "`WalletAcc`")
public class WalletAcc {
    @Id
    String phone;
    double balance;
}
