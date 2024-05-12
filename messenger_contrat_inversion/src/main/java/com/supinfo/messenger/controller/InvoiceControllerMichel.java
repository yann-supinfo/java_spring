package com.supinfo.messenger.controller;

import com.supinfo.messenger.entity.Invoice;
import com.supinfo.messenger.service.InvoiceService;
import com.supinfo.messenger.service.InvoiceServiceInterface;
import com.supinfo.messenger.service.InvoiceServiceMichel;

import java.util.Scanner;

public class InvoiceControllerMichel {

    private InvoiceServiceInterface invoiceServiceInterface;

    public InvoiceServiceInterface getInvoiceServiceInterface() {
        return invoiceServiceInterface;
    }

    public void setInvoiceServiceInterface(InvoiceServiceInterface invoiceServiceInterface) {
        this.invoiceServiceInterface = invoiceServiceInterface;
    }

    public void createInvoiceUsingWebForm() {
        System.out.println( "What is customer name?" );
        Scanner sc = new Scanner(System.in);

        String customerName = sc.nextLine();

        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        invoiceServiceInterface.createInvoice(invoice);
    }

}
