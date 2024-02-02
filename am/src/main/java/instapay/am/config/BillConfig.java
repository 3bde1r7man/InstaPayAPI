package instapay.am.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import instapay.am.Model.Bill;
import instapay.am.Model.BillStatus;
import instapay.am.Model.BillType;
import instapay.am.Repository.BillRepository;

@Configuration
public class BillConfig {
    @Bean(name = "BillCommandLineRunner")
    public CommandLineRunner commandLineRunner(BillRepository repository) {
        return args -> {
            Bill bill1 = new Bill("123", "3bde1r7man", BillType.WATER, BillStatus.UNPAIED, 100.0 );
            Bill bill2 = new Bill("124", "3bde1r7man", BillType.ELECTRICITY, BillStatus.UNPAIED, 200.0);
            Bill bill3 = new Bill("125", "3bde1r7man", BillType.GAS, BillStatus.UNPAIED, 300.0);
            Bill bill4 = new Bill("126", "2hm3d", BillType.WATER, BillStatus.UNPAIED, 400.0);
            repository.saveAll(
                List.of(bill1, bill2, bill3, bill4)
            );
        };
    }
}
