package com.assignment.invoiceApp.repository;

import com.assignment.invoiceApp.model.Invoice;
import com.assignment.invoiceApp.model.InvoiceStatus;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InvoiceRepository {

    // Using the data structure set for storing data like DB
    private final Set<Invoice> invoiceSet = new HashSet<>();

    private static int idNumber = 1;


    public String save(Invoice invoice) {
        invoice.setId(String.valueOf(idNumber++));
        invoiceSet.add(invoice);
        return invoice.getId();
    }

    public Set<Invoice> findAll() {
       return invoiceSet.stream().sorted(Comparator.comparing(Invoice::getId)).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Optional<Invoice> findById(String id) {
       return invoiceSet.stream().filter(invoice -> invoice.getId().equals(id)).findFirst();
    }

    public String update(Invoice currentInvoice) {

        invoiceSet.removeIf(i -> i.getId().equals(currentInvoice.getId()));
        invoiceSet.add(currentInvoice);

        return currentInvoice.getStatus().toString();
    }
}
