package com.assignment.invoiceApp.service;

import com.assignment.invoiceApp.model.Invoice;
import com.assignment.invoiceApp.model.InvoiceOverDue;

import java.time.LocalDate;
import java.util.Set;

public interface InvoiceService {
    String createInvoice(float amount, LocalDate dueDate);
    Set<Invoice> getInvoice();
    String makePayment(String id, float amount);
    Set<Invoice> processOverDue(InvoiceOverDue invoiceOverDue);
}
