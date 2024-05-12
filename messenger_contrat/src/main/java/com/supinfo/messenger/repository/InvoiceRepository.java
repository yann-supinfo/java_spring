package com.supinfo.messenger.repository;

import com.supinfo.messenger.entity.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository implements InvoiceRepositoryInterface {
    private static List<Invoice>  invoices= new ArrayList<>();

    public void create (Invoice invoice) {
        invoices.add(invoice);
        System.out.println("Invoice added with number " + invoice.getNumber() + " for + " + invoice.getCustomerName());
    }
}


