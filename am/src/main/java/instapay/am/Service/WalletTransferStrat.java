package instapay.am.Service;

public interface WalletTransferStrat {
    boolean transfer(String reciver, double amount);
}
