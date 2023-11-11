import java.util.Arrays;

public class FloatArithmeticMean {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Brak argumentow programu.");
        }

        else if (args.length == 1) {
            System.out.println("Przekazano tylko jedna wartosc: " + args[0]);

        } else {
            System.out.println(getOutput(args));
        }
    }

    private static String getOutput(String[] args) {
        String output = "";

        float sum = 0;
        for(String arg : args) {
            float num = Float.parseFloat(arg);
            sum += num;
            output += String.format("%.3f", num) + "\n";

        }
        float mean = sum / args.length;

        output += "---------- \n" + String.format("%.3f", sum) + "\n";
        output += "Średnia arytmetyczna: " + String.format("%.4f", mean);

        return output;
    }
}