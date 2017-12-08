/**
 * Use enum to avoid hard coding for the limits of days for
 *different people
 */
public enum LimitDays {
    StudentLimitDays(20),GradudateLimitDays(30),ProfessorLimitDays(40);

    private int day;

    LimitDays(int day){
        this.day = day;
        }

    public int getDay(){
        return this.day;
    }
    public void setDay(int day){
        this.day = day;
    }

}
