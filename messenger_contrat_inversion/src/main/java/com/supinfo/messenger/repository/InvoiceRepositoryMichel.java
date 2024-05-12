package com.supinfo.messenger.repository;

import com.supinfo.messenger.entity.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepositoryMichel implements InvoiceRepositoryInterface {

    private static List<Invoice> invoices= new ArrayList<>();

    public void create (Invoice invoice) {
        invoices.add(invoice);
        System.out.println("Invoice added with code and number " + invoice.getNumber() + " for + " + invoice.getCustomerName());
    }

}