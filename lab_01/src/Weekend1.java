
import java.text.SimpleDateFormat;
import java.util.Date;

public class Weekend1 {
    public static void main(String[] args) {

        Date date = new Date();
        int result  = date.getDay();

        if (result == 1) {
            System.out.println("Dziś jest poniedziałek");
        } else if (result == 2) {
            System.out.println("Dziś jest wtorek");
        } else if (result == 3) {
            System.out.println("Dziś jest środa");
        } else if (result == 4) {
            System.out.println("Dziś jest czwartek");
        } else if (result == 5) {
            System.out.println("Dziś jest piątek");
        } else {
            System.out.println("Jest weekend");
        }
    }
}
