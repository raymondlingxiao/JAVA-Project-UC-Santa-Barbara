import java.util.ArrayList;

/**
 * Abstract class for check out
 * Used for Factory method pattern
 */
public abstract class CheckOut {
        public abstract void checkout(String magic, String copy, String ID, String date, ArrayList<Book> bookArrayList, ArrayList<User> userArrayList);
}
