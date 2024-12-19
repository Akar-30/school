/*
 * You are required to use Stack Data Structure to create a Library System with the following features:

1. Add a book: Allow users to add a new book to the stack.


2. Remove the last added book: Implement a function to remove the top book from the stack.


3. View the top book: Display details of the book currently on top of the stack.


4. Search for a book: Check if a specific book exists in the stack and return its position.


5. Check if the stack is empty: Provide a method to verify if the stack has no books.


6. Display the number of books (stack size): Show the total number of books in the stack.


7. Exit: End the program.
 */

import java.util.Stack;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

public class StackActivity {
    private Stack<Book> bookStack;

    public StackActivity() {
        bookStack = new Stack<>();
    }

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        bookStack.push(book);
        System.out.println("Book added: " + book);
    }

    public void removeBook() {
        if (!bookStack.isEmpty()) {
            Book removedBook = bookStack.pop();
            System.out.println("Removed book: " + removedBook);
        } else {
            System.out.println("The stack is empty. No book to remove.");
        }
    }

    public void viewTopBook() {
        if (!bookStack.isEmpty()) {
            Book topBook = bookStack.peek();
            System.out.println("Top book: " + topBook);
        } else {
            System.out.println("The stack is empty.");
        }
    }

    public void searchBook(String title) {
        int position = -1;
        for (int i = 0; i < bookStack.size(); i++) {
            if (bookStack.get(i).getTitle().equalsIgnoreCase(title)) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            System.out.println("Book found at position: " + position);
        } else {
            System.out.println("Book not found in the stack.");
        }
    }

    public void checkIfEmpty() {
        if (bookStack.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("The stack is not empty.");
        }
    }

    public void displayStackSize() {
        System.out.println("Number of books in the stack: " + bookStack.size());
    }

    public static void main(String[] args) {
        StackActivity library = new StackActivity();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove the last added book");
            System.out.println("3. View the top book");
            System.out.println("4. Search for a book");
            System.out.println("5. Check if the stack is empty");
            System.out.println("6. Display the number of books (stack size)");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    library.removeBook();
                    break;
                case 3:
                    library.viewTopBook();
                    break;
                case 4:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 5:
                    library.checkIfEmpty();
                    break;
                case 6:
                    library.displayStackSize();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
