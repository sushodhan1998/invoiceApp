package com.assignment.invoiceApp.service;

import com.assignment.invoiceApp.model.Invoice;
import com.assignment.invoiceApp.model.InvoiceOverDue;
import com.assignment.invoiceApp.model.InvoiceStatus;
import com.assignment.invoiceApp.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public String createInvoice(float amount, LocalDate dueDate) {

        Invoice invoice = new Invoice();
        invoice.setAmount(amount);
        invoice.setDueDate(dueDate);
        invoice.setStatus(InvoiceStatus.PENDING);
        return invoiceRepository.save(invoice);


    }

    public Set<Invoice> getInvoice() {

        return invoiceRepository.findAll();
    }

    public String makePayment(String id, float amount) {

        //Find the id-> get the invoice else throw exception
        Invoice currentInvoice = invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID / Invoice Not Found"));

        currentInvoice.setPaidAmount(currentInvoice.getPaidAmount() + amount);
        if (currentInvoice.getPaidAmount() >= currentInvoice.getAmount()) {
            currentInvoice.setStatus(InvoiceStatus.PAID);
            //If paid fully
            invoiceRepository.update(currentInvoice);
            return currentInvoice.getStatus().toString() +" Successfully!!";
        }

        invoiceRepository.update(currentInvoice);

        float pendingAmount = currentInvoice.getAmount() - currentInvoice.getPaidAmount();

        return InvoiceStatus.PENDING + " Amount is  " + pendingAmount;

    }

    public Set<Invoice> processOverDue(InvoiceOverDue invoiceOverDue) {

        LocalDate todayDate = LocalDate.now();
        Set<Invoice>exisitngInvoiceSet = invoiceRepository.findAll();
        for (Invoice exisitngInvoice : exisitngInvoiceSet) {

            if (exisitngInvoice.getStatus() == InvoiceStatus.PENDING && exisitngInvoice.getDueDate().isBefore(todayDate)) {
                {
                    if (exisitngInvoice.getPaidAmount() == 0)
                        exisitngInvoice.setStatus(InvoiceStatus.VOID);
                    else
                        exisitngInvoice.setStatus(InvoiceStatus.PAID);

                        Invoice revisedInvoice = new Invoice();
                        revisedInvoice.setStatus(InvoiceStatus.PENDING);
                        revisedInvoice.setAmount( (exisitngInvoice.getAmount()-exisitngInvoice.getPaidAmount())  + invoiceOverDue.getLateFee());
                        revisedInvoice.setDueDate(todayDate.plusDays(invoiceOverDue.getOverDueDays()));
                        invoiceRepository.save(revisedInvoice);
                }
                invoiceRepository.update(exisitngInvoice);

            }
        }
        return getInvoice();
    }
    }
