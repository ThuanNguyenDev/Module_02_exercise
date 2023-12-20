import java.util.Scanner;
public class BookManager {
    private static class Book {
        private final String title;
        private final String author;

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
    }

    private static class Library {
        private final Book[] books;
        private int numBooks;

        public Library(int capacity) {
            books = new Book[capacity];
            numBooks = 0;
        }

        public void addBook(Book book) {
            if (numBooks < books.length) {
                books[numBooks] = book;
                numBooks++;
                System.out.println("Book added to the library.");
            } else {
                System.out.println("The library is full. Cannot add more books.");
            }
        }

        public void removeBook(Book book) {
            int index = -1;
            for (int i = 0; i < numBooks; i++) {
                if (books[i].getTitle().equals(book.getTitle()) && books[i].getAuthor().equals(book.getAuthor())) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                for (int i = index; i < numBooks - 1; i++) {
                    books[i] = books[i + 1];
                }
                numBooks--;
                System.out.println("Book removed from the library.");
            } else {
                System.out.println("Book not found in the library.");
            }
        }

        public void displayBooks() {
            if (numBooks == 0) {
                System.out.println("No books in the library.");
            } else {
                System.out.println("Books in the library:");
                for (int i = 0; i < numBooks; i++) {
                    System.out.println("Title: " + books[i].getTitle() + ", Author: " + books[i].getAuthor());
                }
            }
        }
    }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Library library = new Library(10);

            int choice;

            do {
                System.out.println("1. Add a book");
                System.out.println("2. Remove a book");
                System.out.println("3. Display all books");
                System.out.println("4. Quit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        scanner.nextLine(); // Clear the buffer
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter book author: ");
                        String author = scanner.nextLine();
                        Book book = new Book(title, author);
                        library.addBook(book);
                        break;
                    case 2:
                        scanner.nextLine(); // Clear the buffer
                        System.out.print("Enter book title: ");
                        title = scanner.nextLine();
                        System.out.print("Enter book author: ");
                        author = scanner.nextLine();
                        book = new Book(title, author);
                        library.removeBook(book);
                        break;
                    case 3:
                        library.displayBooks();
                        break;
                    case 4:
                        System.out.println("Quitting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                System.out.println();
            }
            while (choice != 4);

            scanner.close();
        }
    }

