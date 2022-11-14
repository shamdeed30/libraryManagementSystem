public class Book {
    String title;
    boolean isCheckedOut;
    String genre;
    String author;
    int bookID;

    public Book(String _title, String _genre, String _author, boolean isCheckedOut_, int _bookID) {
        this.title = _title;
        this.genre = _genre;
        this.author = _author;
        this.isCheckedOut = isCheckedOut_;
        this.bookID = _bookID;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getCheckedOut(){
        return this.isCheckedOut;
    }

    public String getCheckedOutSt() {
        if(this.isCheckedOut == false){
            return "not checked out";
        }
        else{
            return "checked out";
        }
        //return this.isCheckedOut;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getBookID() {
        return this.bookID;
    }

//    public String printBook(){
//        String print = "";
//        print += this.getTitle() + ", " + this.getAuthor() + ", " + this.getGenre();
//        return print;
//    }

    @Override
    public String toString(){
        return("Title: " + this.getTitle() + "; Genre: " + this.getGenre() + "; Author: " + this.getAuthor() + "; Checkin Status: " + this.getCheckedOutSt() + "; Book ID: " + this.getBookID());
    }


    public static void main(String[] args){
        Book testBook = new Book("xyz", "fic", "rob", false, 444);
//        testBook.printBook();
        System.out.println(testBook.toString());
    }
}

