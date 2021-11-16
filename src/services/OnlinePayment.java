package services;

public interface OnlinePayment {
    public Double paymentTax(double amount);
    public Double interest(double amount, int month);
}
