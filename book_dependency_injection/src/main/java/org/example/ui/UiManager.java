package org.example.ui;


import org.example.application.controller.BookController;

import org.example.application.service.AdminBookService;
import org.example.application.service.MemberBookService;
import org.example.application.service.ServiceBookInterface;
import org.example.application.service.StandardBookService;
import org.example.domain.Book;
import org.example.infrastructure.InMemoryBookRepository;
import org.example.infrastructure.MysqlBookRepository;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UiManager {

    private Scanner sc = null;
    private String mode = "welcome";
    private Boolean running = true;
    private BookController bookController = null;

    private StandardBookService standardBookService;
    private MemberBookService memberBookService;
    private AdminBookService adminBookService;

    private InMemoryBookRepository inMemoryBookRepository;
    private MysqlBookRepository mysqlBookRepository;

    private String profil;



    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }



    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public UiManager() {
        this.sc = new Scanner(System.in);
        this.inMemoryBookRepository = new InMemoryBookRepository();
        this.mysqlBookRepository = new MysqlBookRepository();
        this.standardBookService = new StandardBookService(inMemoryBookRepository);
        this.memberBookService = new MemberBookService(mysqlBookRepository);
        this.adminBookService = new AdminBookService(inMemoryBookRepository);
        this.bookController = new BookController(standardBookService);
        setProfil("standard");
    }


    public void handleProfilSelection() {
        System.out.println("Choisissez votre profil : ");
        System.out.println("- standard ");
        System.out.println("- member ");
        System.out.println("- admin ");
        setProfil(sc.next());

        switch (profil) {
            case "standard":
                this.bookController = new BookController(standardBookService);
                break;
            case "member":
                this.bookController = new BookController(memberBookService);
                break;
            case "admin":
                this.bookController = new BookController(adminBookService);
                break;
            default:
                this.bookController = new BookController(standardBookService);

        }

        setMode("welcome");
    }

    public void handleDisplayBook() {
        System.out.println("------- Liste des livres ----------");
        List<Book> books = bookController.getBooks();;

        for (int i = 0; i < books.size(); i++) {
            books.get(i).displayLessInformation(i);
        }
        if (0 == books.size()) {
            System.out.println("Il n'y a aucun livre actuellement..");
        }
        System.out.println("-----------------------------------");
        setMode("welcome");
    }
    public void handleCreateBook() {
        System.out.println("Ajouter un livre à la bibliothèque");
        System.out.println("Nom du livre: ");
        String name = sc.next();
        System.out.println("Auteur: ");
        String author = sc.next();
        System.out.println("Nombre de page: ");
        int pageNumber = Integer.valueOf(sc.next());
        System.out.println("Categorie du livre: ");
        String type = sc.next();
        bookController.addBook(name, author, pageNumber, type);
        setMode("welcome");
    }
    public void handleBorrowBook() {
        System.out.println("Index du livre à emprunter: ");
        int index = Integer.valueOf(sc.next());
        bookController.borrowBook(index);

        setMode("welcome");
    }

    public void handleWelcomeInput() {

        UiMessage.displayWelcomeMessage();
        String userInput = sc.next();

        switch (userInput) {
            case "1":
                setMode("add");
                break;
            case "2":
                setMode("display");
                break;
            case "3":
                setMode("borrow");
                break;
            case "4":
                setMode("profil");
                break;
            case "quit":
                setRunning(false);
                break;
            default:
                System.out.println("Enter valid input");

        }


    }

    public void run() {

        System.out.println("Bienvenue à la bibliothèque");



        while (true) {

            UiMessage.displayProfil(profil);
            switch (mode) {
                case "welcome":
                    handleWelcomeInput();
                    break;
                case "display":
                    handleDisplayBook();
                    break;
                case "add":
                    handleCreateBook();
                    break;
                case "borrow":
                    handleBorrowBook();
                    break;
                case "profil":
                    handleProfilSelection();
                    break;
            }



            if (getRunning() == false) {
                break;
            }
        }
        System.out.println("Au revoir");
    }

}
