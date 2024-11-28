package com.assignment.invoiceApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    private String id;
    private float amount;
    private float paidAmount;
    private LocalDate dueDate;
    private InvoiceStatus status;


}
