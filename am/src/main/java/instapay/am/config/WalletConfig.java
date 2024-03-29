package instapay.am.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import instapay.am.Repository.WalletRepository;
import instapay.am.Repository.FakeAPI.WalletAcc;

@Configuration
public class WalletConfig {
    // add wallet accounts to the database
    @Bean(name = "walletCommandLineRunner")
    CommandLineRunner commandLineRunner(WalletRepository repository) {
        return args -> {
            WalletAcc wallet1 = new WalletAcc("01111111111", 50000.0);
            WalletAcc wallet2 = new WalletAcc("01143022394", 55000.0);
            repository.saveAll(
                List.of(wallet1, wallet2)
            );
        };
    }
}
