import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BookManager.addBookFromFile("book.txt");
        LibrarySystem.initializeFrame();
        //System.out.println(BookManager.printBookList());
        //System.out.println("success");
    }
}