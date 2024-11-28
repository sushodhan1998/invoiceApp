package com.assignment.invoiceApp;

import com.assignment.invoiceApp.model.Invoice;
import com.assignment.invoiceApp.model.InvoiceStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceTest {

    @Test
    void testInvoiceCreation() {
        Invoice invoice = new Invoice();
        invoice.setId("1");
        invoice.setAmount(199.99f);
        invoice.setDueDate(LocalDate.of(2021, 9, 11));
        invoice.setStatus(InvoiceStatus.PENDING);

        assertEquals("1", invoice.getId());
        assertEquals(199.99f, invoice.getAmount());
        assertEquals(LocalDate.of(2021, 9, 11), invoice.getDueDate());
        assertEquals(InvoiceStatus.PENDING, invoice.getStatus());
        assertEquals(0f, invoice.getPaidAmount());
    }

    @Test
    void testInvoiceStatus() {
        Invoice invoice = new Invoice();
        invoice.setStatus(InvoiceStatus.PAID);

        assertEquals(InvoiceStatus.PAID, invoice.getStatus());
    }

    @Test
    void testPaidAmountInitialization() {
        Invoice invoice = new Invoice();
        assertEquals(0f, invoice.getPaidAmount());
    }
}

