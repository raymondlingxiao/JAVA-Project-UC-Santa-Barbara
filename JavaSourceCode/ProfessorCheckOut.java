import java.util.ArrayList;

/**
 * Check-out for professors
 */
public class ProfessorCheckOut extends CheckOut {
    public void checkout(String magic, String copy, String ID, String date, ArrayList<Book> bookArrayList, ArrayList<User> userArrayList){
        for(int j=0;j<userArrayList.size();j++){
            if(userArrayList.get(j).getID().matches(ID)&&userArrayList.get(j).getStatus().matches("[Blocked]")
                    &&userArrayList.get(j).getBookNum()<=LimitBooks.ProfessorLimitBooks.getBook()){
                System.out.println("Sorry, you can't check out more books until you return the previous books!");
                return;
            }
        }
        for(int i=0;i<bookArrayList.size();i++){
            if(bookArrayList.get(i).getMagic().matches(magic)&&bookArrayList.get(i).getCopyNum().matches(copy)){
                if(bookArrayList.get(i).getLoanStatus().matches("Unavailable")){
                    System.out.println("Sorry this books is:"+bookArrayList.get(i).getLoanSDate());
                    return;

                }
                //here starts check-out for Professors
                else{
                    //change the record in bookArrayList
                    bookArrayList.get(i).setLoanStatus("Unavailable");
                    bookArrayList.get(i).setLoanSDate(DataBase.updateLoanDate("Professors",date));
                    //change the record in userList
                    for(int j=0;j<userArrayList.size();j++){
                        if(userArrayList.get(j).getID().matches(ID)){
                            userArrayList.get(j).check.add(DataBase.updateLoanDate("Professors",date));
                            userArrayList.get(j).check.add(magic);
                            userArrayList.get(j).check.add(copy);
                            ///plus 1 book after check-out
                            userArrayList.get(j).setBookNum(userArrayList.get(j).getBookNum()+1);

                            userArrayList.get(j).out.add(date);
                            userArrayList.get(j).out.add(magic);
                            userArrayList.get(j).out.add(copy);
                        }
                    }
                }
            }
        }
    }
}
