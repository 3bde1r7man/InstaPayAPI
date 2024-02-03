package instapay.am.Service;

public interface BankTransferStrat {
    boolean transfer(String reciver, double amount);
}
