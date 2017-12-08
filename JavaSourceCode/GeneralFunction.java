import java.util.ArrayList;

/**
 * This class has all GeneralFunction for all types of user(i.e. no need to specify the User Type)
 */
public class GeneralFunction {

    //Display Book infor
    public static void displayBook(String magic, String copy , ArrayList<Book> bookArrayList, ArrayList<User> userArrayList){
        for(int i=0;i<bookArrayList.size();i++){
            if(bookArrayList.get(i).getMagic().matches(magic)&&bookArrayList.get(i).getCopyNum().matches(copy)){
                bookArrayList.get(i).printInfor();
            }
        }
    }

    //Display one user or all user infor
    public static void displayUserAll(ArrayList<User> userArrayList){
        for(int i=0;i<userArrayList.size();i++){
            userArrayList.get(i).printUser();
        }
    }
    public static void displayOneUser(String ID,ArrayList<User> userArrayList){
        for(int i=0;i<userArrayList.size();i++){
            if(userArrayList.get(i).getID().matches(ID)) {
                userArrayList.get(i).printUser();
            }
        }
    }

    //Before I knew about java's 'Calendar', I wrote the method to handle the dataes
    public static String changeDate(String date){
        String[] Date = date.split("/");


        if(Date[1].matches("11")) {
            int time = Integer.valueOf(Date[2]) + 3;
            if (time > 30 && time < 61) {//31+10
                //Date[0] = String.valueOf(Integer.valueOf(Date[0]+1));
                Date[1] = "12";
                Date[2] = String.valueOf(time - 30);
                String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                return str;
            }
            if (time > 62) {
                Date[0] = String.valueOf(Integer.valueOf(Date[0]) + 1);
                Date[1] = "1";
                Date[2] = String.valueOf(time - 61); //one 31 + 31
                String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                return str;
            }
            if(time<=30){
                //Date[1] = String.valueOf(Integer.valueOf(Date[1])+1);
                Date[2] = String.valueOf(time);String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                return str;
            }
        }

        if(Date[1].matches("12")) {
            int time = Integer.valueOf(Date[2]) + 3;
            if (time > 31 && time < 62) {
                Date[0] = String.valueOf(Integer.valueOf(Date[0]) + 1);
                Date[1] = "1";
                Date[2] = String.valueOf(time - 31);
                String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                return str;
            }
            if (time > 62) {
                Date[0] = String.valueOf(Integer.valueOf(Date[0]) + 1);
                Date[1] = "2";
                Date[2] = String.valueOf(time - 62); //one 31 + 31
                String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                return str;
            }
            if(time<=31){
                //Date[1] = String.valueOf(Integer.valueOf(Date[1])+1);
                Date[2] = String.valueOf(time);String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                return str;
            }
        }

        if(Date[1].matches("1||3||5||7||8||10||12")){
            int time = Integer.valueOf(Date[2])+3;
            if(time>31&&time<62){
                Date[1] = String.valueOf(Integer.valueOf(Date[1])+1);
                Date[2] = String.valueOf(time-31);
                String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                return str;
            }
            if(time>62){
                Date[1] = String.valueOf(Integer.valueOf(Date[1])+2);
                Date[2] = String.valueOf(time-61); //one 31 + 30
                String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                return str;
            }
            if(time<=31){
                //Date[1] = String.valueOf(Integer.valueOf(Date[1])+1);
                Date[2] = String.valueOf(time);String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                return str;
            }
        }

        if(Date[1].matches("2")){

            int time = Integer.valueOf(Date[2])+3;
            if(time>28&&time<59){
                Date[1] = String.valueOf(Integer.valueOf(Date[1])+1);
                Date[2] = String.valueOf(time-28);
                String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                return str;
            }
            if(time>59){
                Date[1] = String.valueOf(Integer.valueOf(Date[1])+2);
                Date[2] = String.valueOf(time-59); //one 31 + 30
                String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                return str;
            }
            if(time<=28){
                //Date[1] = String.valueOf(Integer.valueOf(Date[1])+1);
                Date[2] = String.valueOf(time);
                String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                return str;
            }
        }
        String str = Date[0]+"/"+Date[1]+"/"+Date[2];
        return str;

    }


    //Recall Method
    public static void recall(String magic, String date, ArrayList<Book> bookArrayList, ArrayList<User> userArrayList){
        boolean availability = false;
        //First check the book is available or not
        for (int i=0;i<bookArrayList.size();i++){
            if(bookArrayList.get(i).getMagic().matches(magic)&&bookArrayList.get(i).getLoanStatus().matches("Available")){
                availability = true;

            }
            if(bookArrayList.get(i).getMagic().matches(magic)&&bookArrayList.get(i).getLoanStatus().matches("Unavailable")){
                continue;
            }
        }
        if(availability)
            System.out.println("The book you want to recall is available!");
        else{
            for(int j=0;j<userArrayList.size();j++){
                for(int k=0;k<userArrayList.get(j).check.size();k++){
                    if(userArrayList.get(j).check.get(k).matches(magic)){
                        userArrayList.get(j).check.set(k-1,changeDate(date));
                        //show who has the book right now
                        System.out.println(userArrayList.get(j).getName()+"has the book right now.");
                        System.out.println("An email has successfully sent..");
                        System.out.println("The Book infor has been changed in database..");
                    }
                }
            }
            //show changed information
            for(int m=0;m<bookArrayList.size();m++){
                if(bookArrayList.get(m).getMagic().matches(magic)){
                    bookArrayList.get(m).setLoanSDate(changeDate(date));
                    bookArrayList.get(m).printInfor();
                }
            }
        }

    }

    //Return Book Method
    public static void returnBook(String magic,String copy, ArrayList<Book> bookArrayList, ArrayList<User> userArrayList){
        for (int i=0;i<bookArrayList.size();i++){
            if(bookArrayList.get(i).getMagic().matches(magic)&&bookArrayList.get(i).getCopyNum().matches(copy)){
                bookArrayList.get(i).setLoanStatus("Available");
                bookArrayList.get(i).setLoanSDate(null);
            }
        }

        for(int j=0;j<userArrayList.size();j++){

            //check is a ArrayList in my class User to indicates check-out dates
            //out is ArrayList in class User to indicates due-dates
            for(int k=0;k<userArrayList.get(j).check.size();k++) {
                if (userArrayList.get(j).check.get(k).matches(magic)&&
                        userArrayList.get(j).check.get(k+1).matches(copy)){
                    //Minus one BookNum the user has when return
                    userArrayList.get(j).setBookNum(userArrayList.get(j).getBookNum()-1);
                    //Delete in this order will not affect the arraylist
                    userArrayList.get(j).check.remove(k+1);
                    userArrayList.get(j).check.remove(k);
                    userArrayList.get(j).check.remove(k-1);
                }
                if (userArrayList.get(j).out.get(k).matches(magic)&&
                        userArrayList.get(j).out.get(k+1).matches(copy)){
                    userArrayList.get(j).out.remove(k+1);
                    userArrayList.get(j).out.remove(k);
                    userArrayList.get(j).out.remove(k-1);
                }

            }
        }
    }


    //Search Method
    public static void search(String keyword,ArrayList<Book> booklist){
        for(int i=0;i<booklist.size();i++){
            //Title match
            if(booklist.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase())
                    &&booklist.get(i).getCopyNum().matches("1")){
                booklist.get(i).printInfor();
            }
            //Name match
            if(booklist.get(i).getAuthor().toLowerCase().contains(keyword.toLowerCase())
                    &&booklist.get(i).getCopyNum().matches("1")){
                booklist.get(i).printInfor();
            }
            //Subject match
            if(booklist.get(i).getSubject().toLowerCase().contains(keyword.toLowerCase())
                    &&booklist.get(i).getCopyNum().matches("1")){
                booklist.get(i).printInfor();
            }

            //Publisher match
            if(booklist.get(i).getPublisher().toLowerCase().contains(keyword.toLowerCase())
                    &&booklist.get(i).getCopyNum().matches("1")){
                booklist.get(i).printInfor();
            }
            //Year match
            if(booklist.get(i).getYear().toLowerCase().contains(keyword.toLowerCase())
                    &&booklist.get(i).getCopyNum().matches("1")){
                booklist.get(i).printInfor();
            }
            //Magic match
            if(booklist.get(i).getMagic().toLowerCase().contains(keyword.toLowerCase())
                    &&!booklist.get(i).getCopyNum().matches("1")){
                booklist.get(i).printInfor();
            }


        }
    }


    //Wait-for Method
    public static void waitfor(String magic, ArrayList<Book> bookArrayList, ArrayList<User> userArrayList){
        boolean availability = false;
        for (int i=0;i<bookArrayList.size();i++){
            if(bookArrayList.get(i).getMagic().matches(magic)&&bookArrayList.get(i).getLoanStatus().matches("Available")){
                availability = true;
                //System.out.println("The book you want to recall is available!");
            }
            if(bookArrayList.get(i).getMagic().matches(magic)&&bookArrayList.get(i).getLoanStatus().matches("Unavailable")){
                continue;
            }
        }
        if(availability)
            System.out.println("The book you want to Wait-For is available!");
        else{
            System.out.println("A reminder has already been set.You'll get the message once the book is returned..");
        }
    }
}
