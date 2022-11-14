import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class  BookManager {
    public static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<Book> bookWaitList = new ArrayList<>();
    static String file;
    public static void addBookFromFile(String filename) throws IOException {
        file = filename;
        // tested
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        while(line != null){
            String[] bLine = line.split(",");
            String n = bLine[0];
            String g = bLine[1];
            String a = bLine[2];
            boolean isC = Boolean.parseBoolean(bLine[3]);
            int ID = Integer.parseInt(bLine[4]);
            Book b = new Book(n, g, a, isC, ID);
            addToBookList(b);
            //we can print individual attribute of a book class
            //System.out.println(b.getGenre());
            line = br.readLine();
        }
        br.close();
        //we can print the whole arraylist
//        for (Book b : bookList){
//            System.out.println(b.toString());
//        }
        //we can print any attributes of a specific book
//        System.out.println(bookList.get(0).getBookID());
    }
    public static String printBookList(){
        // tested
        String printed = "";
        for (Book b : bookList){
            printed += b.toString() + "\n";
        }
        return printed;
    }
    public static void printBookWaitList(){
        //tested
        for (Book b : bookWaitList){
            System.out.println(b.toString());
        }
    }
    public static void addToBookList(Book book){
        // tested
        bookList.add(book);
    }
    public static void addToWaitList(Book book){
        //tested
        // add book to waitlist if checked out
        bookWaitList.add(book);
    }
    public static void removeFromBookList(int inBookID){
        //TODO not working - ignoring it for now since we can manipulate bookdata directly from the txt file
        // remove book from bookList
        for(Book b : bookList){
            if(b.getBookID() == inBookID){
                System.out.println("success");
                bookList.remove(b);
            }
        }
        //bookList.remove(book);
    }
    public static void removeFromWaitList(Book book){
        //tested
        // remove from waitlist if checked in
        bookWaitList.remove(book);
    }
    public static void checkOutBook(int inBookID){
        //tested
        // change the book's checkin status to true in bookList
        for (Book b : bookList){
            if (b.getBookID() == inBookID){
                b.isCheckedOut = true;
                // if already checked out then call the addToWaitList method to add the book to waitList
                addToWaitList(b);
            }
        }
        try {
            FileWriter writer = new FileWriter(file);
            for (Book b: bookList){
                writer.write(b.getTitle() + "," + b.getGenre() + "," + b.getAuthor() + "," + b.getCheckedOut() + "," +b.getBookID() + "\n");
            }
            writer.close();
        }catch(IOException ex) {
            System.out.println("Error.");
        }
    }
    public static void checkInBook(int inBookID){
        //tested
        // change the book's checkin status to false in bookList
        for (Book b : bookList){
            if (b.getBookID() == inBookID){
                b.isCheckedOut = false;
                // if checked in and was in waitList then call the removeFromWaitList method
                removeFromWaitList(b);
            }
        }
        try {
            FileWriter writer = new FileWriter(file);
            for (Book b: bookList){
                writer.write("\n"+ b.getTitle() + "," + b.getGenre() + "," + b.getAuthor() + "," + b.getCheckedOut() + "," +b.getBookID());
            }
            writer.close();
        }catch(IOException ex) {
            System.out.println("Error.");
        }
    }
    public static void bookLocation(int inBookID){
        //tested
        // maybe tell the shelf location based on genre and then tell the book ID?
        for (Book b : bookList){
            if (b.getBookID() == inBookID){
                System.out.println("The book is in " + b.getGenre() + " shelf");
                System.out.println("The book's id is " + b.getBookID());
            }
        }
    }
    public static void checkBookStatus(int inBookID){
        //tested
        for(Book b : bookList){
            if(b.getBookID() == inBookID){
                if(b.getCheckedOut() == false){
                    System.out.println("The book is not checked out.");
                }
                else{
                    System.out.println("The book is already checked out.");
                }
            }
        }
    }
    public static void getBookInfo(int inBookID){
        //tested
        boolean bool = false;
        for (Book b : bookList){
            if (b.getBookID() == inBookID){
                bool = true;
                System.out.println(b.toString());
//                System.out.println("Title: " + b.getTitle());
//                System.out.println("Genre: " + b.getGenre());
//                System.out.println("Author: " + b.getAuthor());
//                if(b.getCheckedOut() == false){
//                    System.out.println("Checkin Status: Not checked out");
//                }
            }
        }
        if(bool == false){
            System.out.println("There is no book with this Book ID!");
        }
    }

    public static void searchBook(String keyWord){
        //tested
        //TODO search by keyword?? or individually??
        ArrayList<Book> keyWordList = new ArrayList<>();
        boolean bool = false;
        for(Book b : bookList){
            if(b.getTitle().toLowerCase().contains(keyWord.toLowerCase())){
                bool = true;
                keyWordList.add(b);
            } else if (b.getGenre().toLowerCase().contains(keyWord.toLowerCase())) {
                bool = true;
                keyWordList.add(b);
            } else if (b.getAuthor().toLowerCase().contains(keyWord.toLowerCase())) {
                bool = true;
                keyWordList.add(b);
            }
        }
        if(bool == false){
            System.out.println("There is no book with this keyword!");
        }
        for(Book b : keyWordList){
            System.out.println(b.toString());
        }
    }

    public static void main(String[] args) throws IOException {
//        Book b1 = new Book("my book", "fic", "me", false, 323);
//        Book b2 = new Book("ur book", "sci-fi", "u",false, 832122);
//        ArrayList<Book> BL = new ArrayList<Book>();

        addBookFromFile("book.txt");
        //printBookList();
        checkOutBook(213);
//        printBookList();
//        printBookWaitList();
        getBookInfo(222);
        //searchBook("sci");

//        String s = "abcd";
//        String sPart = "bc";
//        System.out.println(s.cotains);
        //hasWord("Uni");

    }
}
