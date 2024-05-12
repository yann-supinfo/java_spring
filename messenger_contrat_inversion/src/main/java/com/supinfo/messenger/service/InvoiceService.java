package com.supinfo.messenger.service;

import com.supinfo.messenger.entity.Invoice;
import com.supinfo.messenger.repository.InvoiceRepository;
import com.supinfo.messenger.repository.InvoiceRepositoryInterface;

public class InvoiceService implements InvoiceServiceInterface {
    private long lastnumber = 0L;

    private InvoiceRepositoryInterface invoiceRepository;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createInvoice(Invoice invoice) {
        invoice.setNumber(String.valueOf(++lastnumber));
        invoiceRepository.create(invoice);
    }

}
