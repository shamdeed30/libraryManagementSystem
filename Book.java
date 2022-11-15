public class Book {
    private String title;
    boolean isCheckedOut;
    private String genre;
    private String author;
    private int bookID;
    String checkedTo;

    public Book(String _title, String _genre, String _author, boolean isCheckedOut_, int _bookID, String checkedTo) {
        this.title = _title;
        this.genre = _genre;
        this.author = _author;
        this.isCheckedOut = isCheckedOut_;
        this.bookID = _bookID;
        this.checkedTo = checkedTo;
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
    public String getCheckedTo(){
        return this.checkedTo;
    }

//    public String printBook(){
//        String print = "";
//        print += this.getTitle() + ", " + this.getAuthor() + ", " + this.getGenre();
//        return print;
//    }

    @Override
    public String toString(){
        return("Title: " + this.getTitle() + "; Genre: " + this.getGenre() + "; Author: " + this.getAuthor() + "; Checkin Status: " + this.getCheckedOutSt() + "; Book ID: " + this.getBookID() + "; Checket to: " + this.checkedTo);
    }


    public static void main(String[] args){
        Book testBook = new Book("xyz", "fic", "rob", false, 444, "me");
//        testBook.printBook();
        System.out.println(User.checkAcc("sham2"));

    }
}

