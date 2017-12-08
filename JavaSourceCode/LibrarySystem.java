import java.util.Scanner;

/**
 * StudentName:Lingxiao Li
 * ID: X291657
 * Email: raymondlx@foxmail.com
 */
/**
 * This is the interface part
 */

public class LibrarySystem {

    public static void main(String[] args) {
        while (true) {
            System.out.println("...................................Welcome to Library System...................................");
            Log log = new Log();
            System.out.println("Please input your ID:");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.nextLine();
            System.out.println("Please input your PIN:");
            String pin = scanner.nextLine();
            System.out.println("Please input the date:");
            String date = scanner.nextLine();
            log.logIn(id, pin, date);
            if(!log.checkValid(id,pin,log.dataBase.UserList)){
                System.out.println("Invalid User, please check your Input!");
                continue;
            }
            else
                System.out.println("Successfully log in..");
            boolean logout = false;
            while (!logout) {
                System.out.println("Please choose the your next step:(Input the number as showed below)");
                System.out.println();
                System.out.println("(1)Search for books");
                System.out.println("(2)Display book information");
                System.out.println("(3)Check Out a book");
                System.out.println("(4)Recall a book");
                System.out.println("(5)Wait for a book");
                System.out.println("(6)Return a book");
                System.out.println("(7)Show all user information");
                System.out.println("...............................................................................................");
                int number = Integer.valueOf(scanner.nextLine());
                switch (number) {
                    case 1:
                        System.out.println("...............Ready for Search...............");
                        System.out.println("Please input the keyword");
                        String keyword = scanner.nextLine();
                        GeneralFunction.search(keyword, log.dataBase.BookList);
                        System.out.println("................End of Search.................");
                        System.out.println("Do you want to Log out? Y/N");
                        String out = scanner.nextLine();
                        if (out.toLowerCase().matches("n"))
                            logout = false;
                        else
                            logout = true;
                        break;
                    case 2:
                        System.out.println("...............Ready for Display...............");
                        System.out.println("Please input the magic number of this book:");
                        String magic = scanner.nextLine();
                        System.out.println("Please input the Copy number:");
                        String copy2 = scanner.nextLine();
                        GeneralFunction.displayBook(magic,copy2,log.dataBase.BookList, log.dataBase.UserList);
                        System.out.println("................End of Display................");
                        System.out.println("Do you want to Log out? Y/N");
                        String out2 = scanner.nextLine();
                        if (out2.toLowerCase().matches("n"))
                            logout = false;
                        else
                            logout = true;
                        break;
                    case 3:
                        System.out.println("...............Ready for Check-Out...............");
                        System.out.println("Please input the magic number:");
                        String magic2 = scanner.nextLine();
                        System.out.println("Please input the Copy number:");
                        String copy = scanner.nextLine();
                        log.CheckOut(log.Type, magic2, copy, log.ID, log.date, log.dataBase.BookList, log.dataBase.UserList);
                        System.out.println("Successfully checked out, data updating...");
                        System.out.println("Here is the information of the book after your check-out:");
                        GeneralFunction.displayBook(magic2,copy,log.dataBase.BookList, log.dataBase.UserList);
                        System.out.println("................End of Check-Out.................");
                        System.out.println("Do you want to Log out? Y/N");
                        String out3 = scanner.nextLine();
                        if (out3.toLowerCase().matches("n"))
                            logout = false;
                        else
                            logout = true;
                        break;
                    case 4:
                        System.out.println("...............Ready for Recall...............");
                        System.out.println("Please input the magic number:");
                        String magic4 = scanner.nextLine();
                        GeneralFunction.recall(magic4, log.date, log.dataBase.BookList, log.dataBase.UserList);
                        System.out.println("................End of Recall.................");
                        System.out.println("Do you want to Log out? Y/N");
                        String out4 = scanner.nextLine();
                        if (out4.toLowerCase().matches("n"))
                            logout = false;
                        else
                            logout = true;
                        break;
                    case 5:
                        System.out.println("...............Ready for Wait-For...............");
                        System.out.println("Please input the magic number:");
                        String magic5 = scanner.nextLine();
                        GeneralFunction.waitfor(magic5, log.dataBase.BookList, log.dataBase.UserList);
                        System.out.println("................End of Wait-For.................");
                        System.out.println("Do you want to Log out? Y/N");
                        String out5 = scanner.nextLine();
                        if (out5.toLowerCase().matches("n"))
                            logout = false;
                        else
                            logout = true;
                        break;
                    case 6:
                        System.out.println("...............Ready for Return a book...............");
                        System.out.println("Please input the magic number:");
                        String magic6 = scanner.nextLine();
                        System.out.println("Please input the Copy number:");
                        String copy6 = scanner.nextLine();
                        GeneralFunction.returnBook(magic6, copy6, log.dataBase.BookList, log.dataBase.UserList);
                        System.out.println("Successfully return!");
                        System.out.println("Database is updating the changes...");
                        System.out.println("Here is the book infor right now:");
                        GeneralFunction.displayBook(magic6, copy6,log.dataBase.BookList, log.dataBase.UserList);
                        System.out.println("...................End of Return....................");
                        System.out.println("Do you want to Log out? Y/N");
                        String out6 = scanner.nextLine();
                        if (out6.toLowerCase().matches("n"))
                            logout = false;
                        else
                            logout = true;
                        break;
                    case 7:
                        System.out.println("...............Ready for Show information...............");
                        GeneralFunction.displayUserAll(log.dataBase.UserList);
                        System.out.println("...................End of Infor....................");
                        System.out.println("Do you want to Log out? Y/N");
                        String out7 = scanner.nextLine();
                        if (out7.toLowerCase().matches("n"))
                            logout = false;
                        else
                            logout = true;
                        break;
                }
            }
            System.out.println("...................................End of Library System...................................");

        }
    }
}
