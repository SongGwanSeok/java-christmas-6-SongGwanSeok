package christmas.model.order;

public record UserOrder(Date visitDate, Orders orders) {

    public Boolean checkBeforeChristmas() {
        return visitDate.isBeforeChristmas();
    }

    public int getDay() {
        return visitDate().getDay();
    }

    public Boolean isVisitWeekday() {
        return !visitDate.isWeekend();
    }

    public Boolean isVisitWeekend() {
        return visitDate.isWeekend();
    }

    public int findMenuTypeCount(MenuType targetType) {
        return orders.findMenuTypeCount(targetType);
    }

    public Boolean isVisitStar() {
        return visitDate.isStar();
    }
}
