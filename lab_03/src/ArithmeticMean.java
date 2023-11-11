import java.util.Arrays;

public class ArithmeticMean {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Brak argumentow programu.");
            return;
        }

        if (args.length == 1) {
            System.out.println("Przekazano tylko jedna wartosc: " + args[0]);
            return;
        }

        int sum = 0;
        for (String num : args) {
            sum += Integer.parseInt(num);
        }

        int intMean = sum / args.length;
        int meanRest = sum - intMean * args.length;

        if (meanRest == 0) {
            System.out.println("Srednia arytmetyczna liczb: " + Arrays.toString(args) + " wynosi " + intMean);
        } else {
            System.out.println("Srednia arytmetyczna liczb: " + Arrays.toString(args) + " wynosi " + intMean + ", reszta: " + meanRest);

        }
    }
}