package com.assignment.invoiceApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceOverDue {
    private float lateFee;
    private int overDueDays;
}
