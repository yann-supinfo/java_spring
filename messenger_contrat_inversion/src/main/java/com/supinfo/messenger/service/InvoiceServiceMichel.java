package com.supinfo.messenger.service;

import com.supinfo.messenger.entity.Invoice;
import com.supinfo.messenger.repository.InvoiceRepository;
import com.supinfo.messenger.repository.InvoiceRepositoryInterface;
import com.supinfo.messenger.repository.InvoiceRepositoryMichel;

public class InvoiceServiceMichel implements InvoiceServiceInterface  {

    private static long lastnumber = 112L;

    private InvoiceRepositoryInterface invoiceRepository;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createInvoice(Invoice invoice) {
        invoice.setNumber(String.valueOf("INV"+(++lastnumber)));
        invoiceRepository.create(invoice);
    }



}
