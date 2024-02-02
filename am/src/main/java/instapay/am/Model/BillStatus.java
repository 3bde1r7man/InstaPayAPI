package instapay.am.Model;

public enum BillStatus {
    PAIED, UNPAIED;
    @Override
    public String toString() {
        switch (this) {
            case PAIED:
                return "Paied";
            case UNPAIED:
                return "Unpaied";
            default:
                return null;
        }
    }

    public static BillStatus getBillStatus(String billStatus) {
        switch (billStatus) {
            case "Paied":
                return PAIED;
            case "Unpaied":
                return UNPAIED;
            default:
                return null;
        }
    }
}
