package Dz2;

import Dz2.OptionalTask.Book;
import Dz2.OptionalTask.Bookcase;
import Dz2.OptionalTask.Librarian;
import Dz2.Vending.Product;
import Dz2.Vending.VendingMachineModel1;

public class Main {
    public static void main(String[] args) {
        optinalTask();
    }
    static void optinalTask(){
        Bookcase bookcase = new Bookcase(50);
        Librarian librarian = new Librarian();

        librarian.addBook(new Book("Test1", "fan", "Bob", 321), bookcase);
        System.out.println(librarian.getQuantityBook(bookcase));

        librarian.addBook( new Book("Test2", "tr", "Stiv", 321), bookcase);
        System.out.println(librarian.getQuantityBook(bookcase));

        librarian.addBook(new Book("Test3", "roman", "Bob", 128), bookcase);
        librarian.addBook(new Book("Test4", "fan", "Tom", 321), bookcase);
        librarian.addBook(new Book("Test5", "rpg", "Bob", 256), bookcase);
        System.out.println(librarian.getQuantityBook(bookcase));


        System.out.println(librarian.containsBook(new Book("Test1", "fan", "Bob", 321), bookcase));
        System.out.println(librarian.getBook(new Book("Test3", "roman", "Bob", 128), bookcase));
        System.out.println(librarian.getQuantityBook(bookcase));

    }

    static void task1(){
        /*Доделать задания, которые не успели на семинаре.*/
        VendingMachineModel1 vendingMachine = new VendingMachineModel1("test", 1, 100);
        System.out.println(vendingMachine);
        vendingMachine.putProduct(new Product("Аленка", 5), 50);
        vendingMachine.putProduct(new Product("Марс", 5), 50);
        vendingMachine.putProduct(new Product("Твикс", 5), 50);
        System.out.println(vendingMachine);
        vendingMachine.getProduct(new Product("Аленка", 5));
        System.out.println(vendingMachine);

    }
}