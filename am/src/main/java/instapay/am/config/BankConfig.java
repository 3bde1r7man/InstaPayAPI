package instapay.am.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import instapay.am.Repository.BankRepository;
import instapay.am.Repository.FakeAPI.BankAcc;

@Configuration
public class BankConfig {
    @Bean(name = "bankCommandLineRunner")
    CommandLineRunner commandLineRunner(BankRepository repository) {
        return args -> {
            BankAcc bankAcc1 = new BankAcc("4820", 50000.0);
            BankAcc bankAcc2 = new BankAcc("0987654321", 2000.0);
            repository.saveAll(
                List.of(bankAcc1, bankAcc2)
            );
        };
    }
}
