/**
 * Book class contains all the information about one book
 * LoanStatus shows whether this book is available or not
 * LoanSDate shows the available date for this book
 */
public class Book {
    private String magic;
    private String title;
    private String author;
    private String publisher;
    private String year;
    private String subject;
    private String copyNum;
    private String LoanStatus;
    private String LoanSDate;

    public String getLoanStatus(){return this.LoanStatus;}

    public String getLoanSDate() {
        return LoanSDate;
    }

    public void setLoanSDate(String loanSDate) {
        LoanSDate = loanSDate;
    }

    public void setLoanStatus(String loanStatus) {
        LoanStatus = loanStatus;
    }

    public String getMagic(){
        return this.magic;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getPublisher(){
        return this.publisher;
    }
    public String getSubject(){
        return this.subject;
    }
    public String getYear(){
        return this.year;
    }
    public String getCopyNum(){
        return this.copyNum;
    }
    public void setCopyNum(String newCopy){
        this.copyNum = newCopy;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public void printInfor(){
        System.out.println("...............Book Infor...............");
        System.out.println("Magic Number:"+" "+getMagic());
        System.out.println("Title:"+" "+getTitle());
        System.out.println("Author:"+" "+getAuthor());
        System.out.println("Publisher:"+" "+getPublisher());
        System.out.println("Year:"+" "+getYear());
        System.out.println("Subject:"+" "+getSubject());
        System.out.println("Copy Number:"+" "+getCopyNum());
        System.out.println("LoanStatus:"+" "+getLoanStatus());
        if(getLoanSDate()!=null) {
            System.out.println("Unavailable till..:" + " " + getLoanSDate());
        }
        else
            System.out.println("Available to loan!");
        System.out.println("...................END.................");
    }
}
