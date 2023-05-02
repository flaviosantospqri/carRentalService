package model.entities;

public class Invoice {
    private Double basicPayment;
    private Double tax;

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public Double getTax() {
        return tax;
    }

    public Double getTotalPayment(){
        return getBasicPayment() + getTax();
    }
}
