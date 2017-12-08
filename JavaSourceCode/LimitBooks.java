/**
 * Use Enum, which the limits of different type user can be modified
 */
public enum LimitBooks {
    StudentLimitBooks(10),GradudateLimitBooks(15),ProfessorLimitBooks(20);

    private int book;

    LimitBooks(int book ){
        this.book = book;
    }

    public int getBook(){
        return this.book;
    }
    public void setBook(int book){
        this.book = book;
    }
}
