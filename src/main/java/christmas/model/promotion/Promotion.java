package christmas.model.promotion;

public class Promotion {

    private final Present present;
    private final Discounts discounts;
    private Badge badge;

    public Promotion(Present present, Discounts discounts) {
        this.present = present;
        this.discounts = discounts;
    }
}
