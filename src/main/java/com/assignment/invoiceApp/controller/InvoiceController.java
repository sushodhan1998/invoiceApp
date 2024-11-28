package com.assignment.invoiceApp.controller;


import com.assignment.invoiceApp.model.Invoice;
import com.assignment.invoiceApp.model.InvoiceIdResponse;
import com.assignment.invoiceApp.model.InvoiceOverDue;
import com.assignment.invoiceApp.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    //Create invoices with a specified amount and due date
    @PostMapping()
    public ResponseEntity<InvoiceIdResponse> createInvoice(@Valid @RequestBody Invoice invoicePayload){
      String id = invoiceService.createInvoice(invoicePayload.getAmount(),invoicePayload.getDueDate());
      return new ResponseEntity<>(new InvoiceIdResponse(id), HttpStatus.CREATED);
    }

    //Retrieve all invoices with their details
    @GetMapping()
    public ResponseEntity<Set<Invoice>> getAlInvoices(){
        return ResponseEntity.ok(invoiceService.getInvoice());
    }

    //Pay a specific invoice and update its status accordingly
    @PostMapping("/{id}/payments")
    public ResponseEntity<String> makePayment(@PathVariable String id,@RequestBody Invoice amount){
        String status = invoiceService.makePayment(id,amount.getAmount());
       return ResponseEntity.ok(status);
    }

    //Process overdue invoices by applying late fees
    @PostMapping("/process-overdue")
    public ResponseEntity<Set<Invoice>> processOverDue(@Valid @RequestBody InvoiceOverDue invoiceOverDue){

        Set<Invoice> revisedInvoiceLst = invoiceService.processOverDue(invoiceOverDue);
        return ResponseEntity.ok(revisedInvoiceLst);
    }

}
