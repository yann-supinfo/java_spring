package com.supinfo.messenger.service;

import com.supinfo.messenger.entity.Invoice;
import com.supinfo.messenger.repository.InvoiceRepositoryInterface;

public interface InvoiceServiceInterface {
    void createInvoice(Invoice invoice);
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
}
