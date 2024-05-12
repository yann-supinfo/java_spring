package com.supinfo.messenger;

import com.supinfo.messenger.controller.InvoiceController;
import com.supinfo.messenger.controller.InvoiceControllerMichel;
import com.supinfo.messenger.entity.Invoice;
import com.supinfo.messenger.repository.InvoiceRepository;
import com.supinfo.messenger.repository.InvoiceRepositoryInterface;
import com.supinfo.messenger.repository.InvoiceRepositoryMichel;
import com.supinfo.messenger.service.InvoiceService;
import com.supinfo.messenger.service.InvoiceServiceInterface;
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


        System.out.println( "Qu'elle est la classe du service ?" );
        String serviceClass = sc.nextLine();
        System.out.println( "Qu'elle est la classe repository ?" );
        String repositoryClass = sc.nextLine();

        InvoiceController invoiceController = new InvoiceController();
        InvoiceServiceInterface invoiceServiceInterface = null;
        InvoiceRepositoryInterface invoiceRepositoryInterface = null;

        try {
            invoiceServiceInterface =  (InvoiceServiceInterface) Class.forName(serviceClass).getDeclaredConstructor().newInstance();
            invoiceRepositoryInterface = (InvoiceRepositoryInterface) Class.forName(repositoryClass).getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        invoiceController.setInvoiceServiceInterface(invoiceServiceInterface);
        invoiceServiceInterface.setInvoiceRepository(invoiceRepositoryInterface);
        invoiceController.createInvoiceUsingConsole();


    }
}
