package instapay.am.Model;


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
@Table(name = "`User`")
public class User {
    @Id
    protected String userName;
    protected String password;
    protected String name;
    protected String surName;
    protected String email;
    protected String phone;
    protected AccType accType;

    // public String getAccType() {
    //     return accType.toString();
    // }

    // public void setAccType(String accType) {
    //     this.accType = AccType.getAccType(accType);
    // }
}
