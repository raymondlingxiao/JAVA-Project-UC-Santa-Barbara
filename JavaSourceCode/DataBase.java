import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * First, I didn't noticed that java has the 'Calendar' to deal with the dates
 * So I wrote one method myself to handle the dates
 *
 * This class is used for load the information from the txt
 * Then updates the information in the database, set up the due-dates
 * and several formats
 */

public class DataBase {
    public ArrayList<Book> BookList = new ArrayList<Book>();
    public ArrayList<User> UserList = new ArrayList<User>();

    public static String updateLoanDate(String Type,String date){
        String[] Date = date.split("/");
        if(Date[1].matches("11")) {
            if (Type.matches("Students")) {
                int time = Integer.valueOf(Date[2]) + LimitDays.StudentLimitDays.getDay();
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
            if (Type.matches("Graduate Researchers")) {
                int time = Integer.valueOf(Date[2]) + LimitDays.GradudateLimitDays.getDay();
                if (time > 31 && time < 61) {//31+10
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
            if (Type.matches("Professors")) {
                int time = Integer.valueOf(Date[2]) + LimitDays.ProfessorLimitDays.getDay();
                if (time > 31 && time < 61) {//31+10
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
        }
        if(Date[1].matches("12")) {
            if (Type.matches("Students")) {
                int time = Integer.valueOf(Date[2]) + LimitDays.StudentLimitDays.getDay();
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
            if (Type.matches("Graduate Researchers")) {
                int time = Integer.valueOf(Date[2]) + LimitDays.GradudateLimitDays.getDay();
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
            if (Type.matches("Professors")) {
                int time = Integer.valueOf(Date[2]) + LimitDays.ProfessorLimitDays.getDay();
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
        }

        if(Date[1].matches("1||3||5||7||8||10||12")){
            if(Type .matches("Students")){
                int time = Integer.valueOf(Date[2])+LimitDays.StudentLimitDays.getDay();
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
            if(Type.matches("Graduate Researchers")){
                int time = Integer.valueOf(Date[2])+LimitDays.GradudateLimitDays.getDay();
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
                    Date[2] = String.valueOf(time);
                    String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                    return str;
                }
            }
            if(Type.matches("Professors")){
                int time = Integer.valueOf(Date[2])+LimitDays.ProfessorLimitDays.getDay();
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
                    Date[2] = String.valueOf(time);
                    String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                    return str;
                }
            }

            if(Date[1].matches("4||6||9")){
                if(Type .matches("Students")){
                    int time = Integer.valueOf(Date[2])+LimitDays.StudentLimitDays.getDay();
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
                    }if(time<=30){
                        //Date[1] = String.valueOf(Integer.valueOf(Date[1])+1);
                        Date[2] = String.valueOf(time);
                        String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                        return str;
                    }
                }
                if(Type.matches("Graduate Researchers")){
                    int time = Integer.valueOf(Date[2])+LimitDays.GradudateLimitDays.getDay();
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
                    if(time<=30){
                        //Date[1] = String.valueOf(Integer.valueOf(Date[1])+1);
                        Date[2] = String.valueOf(time);
                        String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                        return str;
                    }
                }
                if(Type.matches("Professors")){
                    int time = Integer.valueOf(Date[2])+LimitDays.ProfessorLimitDays.getDay();
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
                    if(time<=30){
                        //Date[1] = String.valueOf(Integer.valueOf(Date[1])+1);
                        Date[2] = String.valueOf(time);
                        String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                        return str;
                    }
                }
            }
            if(Date[1].matches("2")){
                if(Type .matches("Students")){
                    int time = Integer.valueOf(Date[2])+LimitDays.StudentLimitDays.getDay();
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
                if(Type.matches("Graduate Researchers")){
                    int time = Integer.valueOf(Date[2])+LimitDays.GradudateLimitDays.getDay();
                    if(time>28&&time<59){
                        Date[1] = String.valueOf(Integer.valueOf(Date[1])+1);
                        Date[2] = String.valueOf(time-28);
                        String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                        return str;
                    }
                    if(time>62){
                        Date[1] = String.valueOf(Integer.valueOf(Date[1])+2);
                        Date[2] = String.valueOf(time-59); //one 31 + 30
                        String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                        return str;
                    }if(time<=28){
                        //Date[1] = String.valueOf(Integer.valueOf(Date[1])+1);
                        Date[2] = String.valueOf(time);
                        String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                        return str;
                    }
                }
                if(Type.matches("Professors")){
                    int time = Integer.valueOf(Date[2])+LimitDays.ProfessorLimitDays.getDay();
                    if(time>28&&time<59){
                        Date[1] = String.valueOf(Integer.valueOf(Date[1])+1);
                        Date[2] = String.valueOf(time-28);
                        String str = Date[0]+"/"+Date[1]+"/"+Date[2];
                        return str;
                    }
                    if(time>62){
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
            }
            }

        String str = Date[0]+"/"+Date[1]+"/"+Date[2];
        return str;
        }

    public void updateBookList(){
        for(int i=0;i<BookList.size();i++){
            for(int j=0;j<UserList.size();j++){
                if(UserList.get(j).check.contains(BookList.get(i).getMagic())){
                    BookList.get(i).setLoanStatus("Unavailable");
                    for(int k=0;k<UserList.get(j).check.size();k++){
                        if(UserList.get(j).check.get(k).contains(BookList.get(i).getMagic())){
                            BookList.get(i).setLoanSDate(updateLoanDate(UserList.get(j).getType(),UserList.get(j).check.get(k-1)));
                        }
                    }
                }
            }
        }


    }

    public void updateUserList(){
        for(int i=0;i<UserList.size();i++){
            for(int k=0;k<UserList.get(i).check.size();k++){
                if(UserList.get(i).check.get(k).contains("QA")){
                    UserList.get(i).check.set(k-1,updateLoanDate(UserList.get(i).getType(),UserList.get(i).check.get(k-1)));
                    //update bookNum user has
                    UserList.get(i).setBookNum(UserList.get(i).getBookNum()+1);
                }
            }
        }
    }
    public void LoadProfessor(){
        ArrayList<String>temp = new ArrayList<String>();
        String thisline = null;
        int count = 0;
        //Load Student
        try{
            String path = "./Library.data";

            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((thisline = bufferedReader.readLine())!=null){
                if(thisline.matches("::::::::::")||thisline.matches("Books")||thisline.matches("Students")||
                        thisline.matches("Graduate Researchers") )
                    count++;
                if(count<10)
                    continue;
                if (thisline.matches("Professors") || thisline.matches("::::::::::"))
                    continue;
                //here starts read infor
                temp.add(thisline);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        for(int i=0;i<temp.size();i+=6){
            User user = new User();
            if(temp.get(i).contains("["))
                i++;
            user.setType("Professors");
            user.setID(temp.get(i));
            user.setPIN(temp.get(i+1));
            user.setName(temp.get(i+2));
            user.setEmail(temp.get(i+3));
            user.setPhone(temp.get(i+4));
            if((i+5)<temp.size()){
                if(temp.get(i+5).contains("QA")){
                    String[] str = temp.get(i+5).split(":|,");
                    Collections.addAll(user.check,str);
                    Collections.addAll(user.out,str);
                }}
            if((i+6)<temp.size()-6){
                user.setStatus("[Blocked]");
            }
            else
                user.setStatus("[Unblocked]");
            UserList.add(user);
        }

    }
    public void LoadGradute(){

        ArrayList<String>temp = new ArrayList<String>();
        String thisline = null;
        int count = 0;
        //Load Student
        try{
            String path = "./Library.data";

            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((thisline = bufferedReader.readLine())!=null){
                if(thisline.matches("::::::::::")||thisline.matches("Books")||thisline.matches("Students"))
                    count++;
                if(count<7)
                    continue;
                if (thisline.matches("Graduate Researchers") || thisline.matches("::::::::::"))
                    continue;
                if(thisline.matches("Professors"))
                    break;
                //here starts read infor
                temp.add(thisline);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        for(int i=0;i<temp.size();i+=6){
            User user = new User();
            if(temp.get(i).contains("["))
                i++;
            user.setType("Graduate Researchers");
            user.setID(temp.get(i));
            user.setPIN(temp.get(i+1));
            user.setName(temp.get(i+2));
            user.setEmail(temp.get(i+3));
            user.setPhone(temp.get(i+4));
            if((i+5)<temp.size()){
            if(temp.get(i+5).contains("QA")){
                String[] str = temp.get(i+5).split(":|,");
                Collections.addAll(user.check,str);
                Collections.addAll(user.out,str);
            }}
            if((i+6)<temp.size()-6){
                user.setStatus("[Blocked]");
            }
            else
                user.setStatus("[Unblocked]");
            UserList.add(user);
        }

    }
    public void LoadUserInfor(){
        ArrayList<String>temp = new ArrayList<String>();
        String thisline = null;
        int count = 0;
        //Load Student
        try{
            String path = "./Library.data";

            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((thisline = bufferedReader.readLine())!=null){
                if(thisline.matches("::::::::::")||thisline.matches("Books"))
                    count++;
                if(count<4)
                    continue;
                if (thisline.matches("Students") || thisline.matches("::::::::::"))
                    continue;
                if(thisline.matches("Graduate Researchers"))
                    break;
                //here starts read infor
                temp.add(thisline);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        for(int i=0;i<temp.size();i+=6){
            User user = new User();
            if(temp.get(i).contains("["))
                i++;
            user.setType("Students");
            user.setID(temp.get(i));
            user.setPIN(temp.get(i+1));
            user.setName(temp.get(i+2));
            user.setEmail(temp.get(i+3));
            user.setPhone(temp.get(i+4));
            if(temp.get(i+5).contains("QA")){
                String[] str = temp.get(i+5).split(":|,");
                Collections.addAll(user.check,str);
                Collections.addAll(user.out,str);
            }
            if((i+6)<temp.size()-6){
                user.setStatus("[Blocked]");
            }
            else
                user.setStatus("[Unblocked]");
            UserList.add(user);
        }

        LoadGradute();
        LoadProfessor();



    }

    public void LoadBookInfor(){
        String thisline = null;
        ArrayList<String> temp = new ArrayList<String>();
        try{
            String path = "./Library.data";

            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((thisline = bufferedReader.readLine())!=null){
                if(thisline.matches("::::::::::")||thisline.matches("Books"))
                    continue;
                if (thisline.matches("Graduate Researchers") || thisline.matches("Professors")||thisline.matches("Students"))
                    break;
                //here starts read infor
                temp.add(thisline);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        for(int i=0;i<temp.size();i+=7){

            Book book = new Book();
            book.setMagic(temp.get(i));
            book.setTitle(temp.get(i+1));
            book.setAuthor(temp.get(i+2));
            book.setPublisher(temp.get(i+3));
            book.setYear(temp.get(i+4));
            book.setSubject(temp.get(i+5));
            book.setCopyNum(temp.get(i+6));
            book.setLoanStatus("Available");
            book.setLoanSDate(null);
            BookList.add(book);
        }

    }

}
