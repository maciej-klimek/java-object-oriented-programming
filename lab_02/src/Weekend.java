import java.text.SimpleDateFormat;
import java.util.Date;

public class Weekend {
    public static void main(String[] args) {
        Date date = new Date();
        int result  = 5 - date.getDay();
        System.out.println("Liczba dni do weekendu: " + result);
    }
}
