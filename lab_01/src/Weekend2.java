import java.time.DayOfWeek;
import java.time.LocalDate;

public class Weekend2 {
    public static int getDayNumber(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }

    public static void main(String[] arg){
        String[] dayArray = {"poniedziałek", "wtorek", "środa", "czwartek", "piątek", "Mamy weekend!"};
        int currDay = getDayNumber(LocalDate.now());
        if (currDay < 6) {
            System.out.println("Dziś " + dayArray[currDay - 1] + ", do weekendu zostało " + (5 - currDay) + " dni.");
        } else {
            System.out.println("Mamy weekend!");
        }
    }
}
