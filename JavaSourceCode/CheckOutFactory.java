/**
 * I've used the Factory Method Pattern for Check-out
 * Three different characters can check out due to their type(Students, Professors...)
 * Superclass don't have to know the exact type, let the subclass to initiate.
 */
public class CheckOutFactory {
    public CheckOut CheckOutBooks(String type){
        CheckOut checkOut = null;
        if(type.matches("Students")){
            checkOut = new StudentCheckOut();
        }
        if(type.matches("Graduate Researchers")){
            checkOut = new GraduateCheckOut();
        }
        if(type.matches("Professors")){
            checkOut = new ProfessorCheckOut();
        }

        return checkOut;
    }
}
