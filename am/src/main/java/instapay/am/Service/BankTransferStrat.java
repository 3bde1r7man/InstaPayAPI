package instapay.am.Service;

public interface BankTransferStrat {
    boolean transfer(String sender, String reciver, double amount);
}
