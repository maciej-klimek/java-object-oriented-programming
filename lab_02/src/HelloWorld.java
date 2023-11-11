import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {
    public static void main(String[] args) {
        Date data = new Date();
        SimpleDateFormat dataForm = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        String result = dataForm.format(data);
        System.out.println("Dobri, jest teraz: " + result);
    }
}
