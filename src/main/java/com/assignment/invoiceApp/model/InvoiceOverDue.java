package com.assignment.invoiceApp.model;


import jakarta.validation.constraints.Positive;

public class InvoiceOverDue {

    @Positive(message = "lateFee must be positive")
    private float lateFee;
    private int overDueDays;

    public float getLateFee() {
        return lateFee;
    }

    public void setLateFee(float lateFee) {
        this.lateFee = lateFee;
    }

    public int getOverDueDays() {
        return overDueDays;
    }

    public void setOverDueDays(int overDueDays) {
        this.overDueDays = overDueDays;
    }
}
