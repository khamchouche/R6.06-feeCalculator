package org.example;

public class FeeCalculator {
    private static final double CHILD_PRICE_BASE = 100;
    private static final double ADULT_PRICE_BASE = 100;

    public static double calculateFee(Visitor visitor, TicketType ticketType) {
        double fee = 0;

        // calculate price for adults
        if (visitor.age > 14) {
            fee = getFee(ticketType, fee, ADULT_PRICE_BASE, 0.6, 1.2);
        }

        // calculate price for children
        if (visitor.age <= 14) {
            fee = getFee(ticketType, fee, CHILD_PRICE_BASE, 0.2, 0.5);
        }
        return fee;
    }
    private static double calculateAdultFee(TicketType ticketType) {
        if (TicketType.HALF_DAY == ticketType) {
            return (ADULT_PRICE_BASE * 0.6);
        } else if (TicketType.FULL_DAY == ticketType) {
            return(ADULT_PRICE_BASE * 1.2);
        }
        throw (new IllegalArgumentException("TicketType not supported")) ;}


    private static double getFee(TicketType ticketType, double fee, double childPriceBase, double x, double x1) {
        if (TicketType.HALF_DAY == ticketType) {
            fee = childPriceBase * x;
        } else if (TicketType.FULL_DAY == ticketType) {
            fee = childPriceBase * x1;
        }
        return fee;
    }
}
