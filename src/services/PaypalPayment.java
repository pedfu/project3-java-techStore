package services;

public class PaypalPayment implements OnlinePayment{
    public final static double PAYMENT_FEE = 0.02;
    public final static double MONTHLY_FEE = 0.01;

    @Override
    public Double paymentTax(double amount) {
        amount += (amount * PAYMENT_FEE);
        return amount;
    }

    @Override
    public Double interest(double amount, int month) {
        amount += (amount * (MONTHLY_FEE * month));
        return amount;
    }
}
