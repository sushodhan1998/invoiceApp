package com.assignment.invoiceApp;

import com.assignment.invoiceApp.model.InvoiceOverDue;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceOverDueTest {

    @Test
    void testInvoiceOverDueGettersAndSetters() {
        InvoiceOverDue request = new InvoiceOverDue();

        // Set values
        float lateFee = 10.5f;
        int overdueDays = 5;

        request.setLateFee(lateFee);
        request.setOverDueDays(overdueDays);

        // Assert values
        assertEquals(lateFee, request.getLateFee());
        assertEquals(overdueDays, request.getOverDueDays());
    }


}


