package com.supinfo.messenger.controller;

import com.supinfo.messenger.entity.Invoice;
import com.supinfo.messenger.service.InvoiceService;
import com.supinfo.messenger.service.InvoiceServiceInterface;

import java.util.Scanner;

public class InvoiceController {

    public InvoiceServiceInterface getInvoiceServiceInterface() {
        return invoiceServiceInterface;
    }

    public void setInvoiceServiceInterface(InvoiceServiceInterface invoiceServiceInterface) {
        this.invoiceServiceInterface = invoiceServiceInterface;
    }

    private InvoiceServiceInterface invoiceServiceInterface;

    public void createInvoiceUsingConsole() {
        System.out.println( "What is customer name?" );
        Scanner sc = new Scanner(System.in);

        String customerName = sc.nextLine();

        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        invoiceServiceInterface.createInvoice(invoice);
    }
}
