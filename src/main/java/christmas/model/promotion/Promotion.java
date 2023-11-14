package christmas.model.promotion;

public class Promotion {

    private final Present present;
    private final Discounts discounts;
    private final Badge badge;

    public Promotion(Present present, Discounts discounts, Badge badge) {
        this.present = present;
        this.discounts = discounts;
        this.badge = badge;
    }
}
