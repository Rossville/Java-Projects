package LibraryManagementSystem;

import java.io.IOException;
import java.time.*;
import java.util.Scanner;

// add , issue, return and search book from a list
enum BookStatus {
    ISSUED,
    AVAILABLE,
    NOT_FOUND
};

public class libraryManagementSystem {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Book[] bookArr = new Book[4];
        bookArr[0] = new Book("The Great Gatsby","F. Scott Fitzgerald","Charles Scribner's Sons", Year.of(1925), BookStatus.AVAILABLE);
        bookArr[1] = new Book("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", Year.of(1960), BookStatus.ISSUED);
        bookArr[2] = new Book("1984", "George Orwell", "Secker & Warbung", Year.of(1949), BookStatus.NOT_FOUND);
        bookArr[3] = new Book("The Lord of the Rings", "J.R.R Tolkien", "George Allen & Unwin", Year.of(1954), BookStatus.AVAILABLE);

        // checking for book database :-
        // for(int i=0; i<bookArr.length; i++){
        //     if(bookArr[i] != null){
        //         System.out.printf("Name: %s \n Author: %s \n Publisher: %s \n Year: %s \n Status: %s\n",
        //         bookArr[i].name,
        //         bookArr[i].author,
        //         bookArr[i].publisher,
        //         bookArr[i].publishedYear,
        //         bookArr[i].status
        //         );
        //     }
        // }
        new Issuer(sc, bookArr);
        sc.close();

    }
}

class Book {
    String name;
    String author;
    String publisher;
    BookStatus status;
    Year publishedYear;

    Book(String name, String author, String publisher, Year publishedYear, BookStatus status) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
        this.status = status;
    }
}


class Issuer{
    String name;
    String address;
    static int id;
    Book bookIssued;

    public Issuer(Scanner sc, Book[] bookArr){
        System.out.println("Enter the name of the Issuer :");
        name = sc.nextLine();
        System.out.println("Enter the address of Issuer :");
        address = sc.nextLine();
        this.issueBook(sc, bookArr);
    }

    private boolean issueBook(Scanner sc, Book[] bookArr){
        int choice;
        System.out.println("Select from the following options to proceed :");
        System.out.println("(1) - Book name \t (2) - Author name");
        System.out.println("(3) - Publisher name \t (4) - Published Year");
        choice = sc.nextInt();
        sc.nextLine();
        int size = bookArr.length;
        switch(choice){
            case 1:{
                // search based upon name
                System.out.println("Enter the name of the book to search :");
                String book_name = sc.nextLine(); 
                Book book = null;
                for(int i=0; i<size; i++){
                    if(bookArr[i] != null){
                        if(bookArr[i].name.equals(book_name) && bookArr[i].status.equals(BookStatus.AVAILABLE)){
                            book = bookArr[i];
                            break;
                        }
                    }
                }
                if(book == null)
                    System.out.println("Not Available");
                else{
                    System.out.printf("Name: %s \nAuthor: %s \nPublisher: %s \nYear: %s \nStatus: %s\n",
                        book.name,
                        book.author,
                        book.publisher,
                        book.publishedYear,
                        book.status
                    );
                }
                break;
            }
            case 2:{
                // search based on Author's name
                System.out.println("Enter the name of book's Author to search :");
                String author_name = sc.nextLine(); 
                for(int i=0; i<size; i++){
                    if(bookArr[i] != null){if(bookArr[i].author.equals(author_name) && bookArr[i].status.equals(BookStatus.AVAILABLE))
                        System.out.println("Available");
                    else
                        System.out.println(bookArr[i].status);}
                }
                break;
            }
            case 3:{
                // search based on Publisher's name
                System.out.println("Enter the name of book's publisher to search :");
                String publisher_name = sc.nextLine(); 
                for(int i=0; i<size; i++){
                    if(bookArr[i] != null){if(bookArr[i].publisher.equals(publisher_name) && bookArr[i].status.equals(BookStatus.AVAILABLE))
                        System.out.println("Available");
                    else
                        System.out.println(bookArr[i].status);}
                }
                break;
            }
            case 4:{
                // search based on Published Year
                System.out.println("Enter the name of book's published Year to search :");
                int published_year = sc.nextInt(); 
                for(int i=0; i<size; i++){
                    if(bookArr[i] != null){if(bookArr[i].publishedYear == Year.of(published_year) && bookArr[i].status.equals(BookStatus.AVAILABLE))
                        System.out.println("Available");
                    else
                        System.out.println(bookArr[i].status);}
                }
                break;
            }
            default: System.out.println("Wrong Input");
        }
        return false; // temporary return statement
    }
}