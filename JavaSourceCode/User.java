import java.util.ArrayList;

/**
 * This is user class for Students, Graduates and Professors
 * The reason why I don't use strategy pattern is that
 * everytime when I updates the database, I can make the changes on
 * one arrayList.
 *
 * This class has two arrayLists for check-out dates and due-dates
 */
public class User {
    private String Type;
    private String ID;
    private String PIN;
    private String name;
    private String email;
    private String phone;
    private String Status;
    private int BookNum;

    public void setBookNum(int bookNum) {
        BookNum = bookNum;
    }

    public int getBookNum() {
        return BookNum;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    //Check-out-dates
    public ArrayList<String> check = new ArrayList<String>();

    //Due-dates
    public ArrayList<String> out = new ArrayList<String>();

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }


    public String getEmail() {
        return email;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getType() {
        return Type;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setType(String type) {
        Type = type;
    }

    public void printUser(){
        System.out.println(".....................User Infor.....................");
        System.out.println("User Type:"+" "+getType());
        System.out.println("Library ID:"+" "+getID());
        System.out.println("Name:"+" "+getName());
        System.out.println("Email Address:"+" "+getEmail());
        System.out.println("Phone:"+" "+getPhone());
        System.out.println("Has BookNum:"+" "+getBookNum());
        int m=0;
        for(int i=0;i<out.size();i++){
            if(i%3==0){
                System.out.printf("----The Infor about Check-Out-Dates For Books:----\n");
            }
            System.out.println(out.get(i));


        }
        for(int i=0;i<check.size();i++){
            if(i%3==0){
            System.out.printf("----The Infor about Due-Dates For Books:----\n");
            }
            System.out.println(check.get(i));

        }
        System.out.println("Status:"+" "+getStatus());
        System.out.println(".........................END........................");
    }
}
