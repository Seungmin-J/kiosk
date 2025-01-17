package kiosk.lv6.model;

public enum DiscountType {
    PNM(10),
    SOLDIER(5),
    STUDENT(3),
    ORDINARY(0);

    private int rate;

    public int getRate() {
        return rate;
    }

    DiscountType(int rate) {
        this.rate = rate;
    }



}
