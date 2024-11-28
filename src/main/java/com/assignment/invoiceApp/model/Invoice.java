package com.assignment.invoiceApp.model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;



public class Invoice {

    private String id;

    @Positive(message = "Amount must be positive")
    private float amount;

    @PositiveOrZero(message = "Paid amount must be positive")
    private float paidAmount;

    private LocalDate dueDate;
    private InvoiceStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(float paidAmount) {
        this.paidAmount = paidAmount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }
}
