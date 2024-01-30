package instapay.am.Model;

public enum BillType {
    GAS, ELECTRICITY, WATER;

    @Override
    public String toString() {
        switch (this) {
            case GAS:
                return "Gas";
            case ELECTRICITY:
                return "Electricity";
            case WATER:
                return "Water";
            default:
                return null;
        }
    }


    public static BillType getBillType(String billType) {
        switch (billType) {
            case "Gas":
                return GAS;
            case "Electricity":
                return ELECTRICITY;
            case "Water":
                return WATER;
            default:
                return null;
        }
    }
}
