import java.util.ArrayList;

/**
 *The log part basically has the database in the scope
 * Then before user log in, there is a checkValid() for checking
 * the PIN and ID are matched or not
 */
public class Log {
    public CheckOutFactory checkOutFactory = new CheckOutFactory();
    public DataBase dataBase = new DataBase();
    public String ID;
    private String PIN;
    public String date;
    public String Type;

    public String findType(String ID,ArrayList<User> userArrayList){
        for (int i=0;i<userArrayList.size();i++){
            if(userArrayList.get(i).getID().matches(ID)){
                return userArrayList.get(i).getType();
            }
        }
        return null;
    }

    //Here is the Factory method Pattern
    public void CheckOut(String Type, String magic, String copy, String ID, String date, ArrayList<Book> bookArrayList, ArrayList<User> userArrayList){
        CheckOut checkOut;
        checkOut = this.checkOutFactory.CheckOutBooks(Type);
        checkOut.checkout(magic, copy, ID, date, bookArrayList, userArrayList);
    }

    public boolean checkValid(String ID,String PIN,ArrayList<User> userArrayList){
        for(int i=0;i<userArrayList.size();i++){
            if(userArrayList.get(i).getID().matches(ID)&&userArrayList.get(i).getPIN().matches(PIN)){
                return true;
            }
        }
        return false;
    }
    public void logIn(String ID, String PIN,String date){
    this.ID = ID;
    this.PIN = PIN;
    this.date = date;
    this.dataBase.LoadBookInfor();
    this.dataBase.LoadUserInfor();
    this.dataBase.updateUserList();
    this.dataBase.updateBookList();
    this.Type = findType(ID,this.dataBase.UserList);
}



}
