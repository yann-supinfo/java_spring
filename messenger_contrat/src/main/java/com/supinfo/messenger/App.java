package com.supinfo.messenger;

import com.supinfo.messenger.controller.InvoiceController;
import com.supinfo.messenger.controller.InvoiceControllerMichel;
import com.supinfo.messenger.entity.Invoice;
import com.supinfo.messenger.repository.InvoiceRepository;
import com.supinfo.messenger.repository.InvoiceRepositoryMichel;
import com.supinfo.messenger.service.InvoiceService;
import com.supinfo.messenger.service.InvoiceServiceMichel;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        System.out.println( "Dans qu'elle configuration êtes vous ?" );
        int configuration = sc.nextInt();

        if (configuration == 1) {
            InvoiceServiceMichel invoiceServiceMichel = new InvoiceServiceMichel();
            InvoiceService invoiceService = new InvoiceService();
            InvoiceRepository invoiceRepository = new InvoiceRepository();
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceServiceMichel.setInvoiceRepository(invoiceRepository);
            InvoiceController invoiceController = new InvoiceController();
            invoiceController.setInvoiceServiceInterface(invoiceServiceMichel);

            invoiceController.createInvoiceUsingConsole();
        } else if (configuration == 2) {
            InvoiceServiceMichel invoiceServiceMichel = new InvoiceServiceMichel();
            InvoiceRepositoryMichel invoiceRepositoryMichel = new InvoiceRepositoryMichel();
            invoiceServiceMichel.setInvoiceRepository(invoiceRepositoryMichel);
            InvoiceControllerMichel invoiceControllerMichel = new InvoiceControllerMichel();

            invoiceControllerMichel.setInvoiceServiceInterface(invoiceServiceMichel);
            invoiceControllerMichel.createInvoiceUsingWebForm();
        }

    }
}
