package instapay.am.Model;

public enum AccType {
    BANK,
    WALLET;
    @Override
    public String toString() {
        switch(this) {
            case BANK: return "Bank";
            case WALLET: return "Wallet";
            default: throw new IllegalArgumentException();
        }
    }

    public static AccType getAccType(String accType) {
        switch (accType) {
            case "Bank":
                return BANK;
            case "Wallet":
                return WALLET;
            default:
                return null;
        }
    }
}

