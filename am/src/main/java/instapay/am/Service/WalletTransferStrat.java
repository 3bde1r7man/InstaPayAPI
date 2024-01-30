package instapay.am.Service;

public interface WalletTransferStrat {
    boolean transfer(String sender, String reciver, double amount);
}
