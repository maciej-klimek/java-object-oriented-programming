import java.io.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {

        String fileName = "settings.properties";
        Properties properties = new Properties();
        HashMap<String, Integer> settings = new HashMap<String, Integer>();

        getSettingsData(fileName, properties);
        loadSettings(settings, properties);

        int minValue = settings.get("min_val");
        int maxValue = settings.get("max_val");
        int minReps = settings.get("min_rep");
        int maxReps = settings.get("max_rep");
        int percent = settings.get("percent");

        play(minValue, maxValue, minReps, maxReps, percent);
    }

    private static void getSettingsData(String fileName, Properties properties) {
        try {
            File file = new File(fileName);

            if (!file.exists()) {
                properties.setProperty("wartosc_minimum", "1");
                properties.setProperty("wartosc_maksimum", "10");
                properties.setProperty("powtorzen_minimum", "10");
                properties.setProperty("powtorzen_maksimum", "25");
                properties.setProperty("procent", "70");

                try (OutputStream outputStream = new FileOutputStream(fileName)) {
                    properties.store(outputStream, "Default Configuration");
                    System.out.println("Stworzono plik ustawien");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try (InputStream inputStream = new FileInputStream(fileName)) {
                    properties.load(inputStream);
                    System.out.println("Zaladowano ustawienia");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadSettings(HashMap<String, Integer> settings, Properties properties) {

        settings.put("min_val", Integer.valueOf(properties.getProperty("wartosc_minimum")));
        settings.put("max_val", Integer.valueOf(properties.getProperty("wartosc_maksimum")));
        settings.put("min_rep", Integer.valueOf(properties.getProperty("powtorzen_minimum")));
        settings.put("max_rep", Integer.valueOf(properties.getProperty("powtorzen_maksimum")));
        settings.put("percent", Integer.valueOf(properties.getProperty("procent")));

    }

    public static void play(int minValue, int maxValue, int minReps, int maxReps, int percentToWin) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int correctAnswers = 0;
        int totalReps = 0;
        double accuracy = (double) correctAnswers / totalReps * 100;

        System.out.println("Witaj w grze o mnożeniu");
        System.out.println("Potrzebujesz przynajmniej " + percentToWin + "% poprawnych odpowiedzi żeby wygrać.");
        System.out.println("Musisz odpowiedzieć na niemniej niż " + minReps + " pytan i przekroczyc "  + percentToWin +"% dokładności w nie więcej niż " + maxReps + " pytań.");

        while (totalReps < maxReps) {
            if (accuracy >= percentToWin && totalReps > minReps) {
                break;
            }
            int num1 = random.nextInt((maxValue - minValue) + 1) + minValue;
            int num2 = random.nextInt((maxValue - minValue) + 1) + minValue;

            System.out.print("Ile wynosi " + num1 + " * " + num2 + "?\n");
            int userAnswer = scanner.nextInt();

            int correctAnswer = num1 * num2;

            if (userAnswer == correctAnswer) {
                System.out.println("\nDobrze!");
                correctAnswers++;
            } else {
                System.out.println("\nŹle. Poprawna odpowiedź to: " + correctAnswer);
            }

            totalReps++;
            accuracy = (double) correctAnswers / totalReps * 100;
            System.out.println("Odpowiedziałeś na " + correctAnswers + " z " + totalReps + " pytań dobrze.");
            System.out.println("Dokładnośc: " + accuracy + "%");
            System.out.println("Pozostało ci " + (maxReps - totalReps) + " pytań żeby wygrać");
        }

        System.out.println("\nKoniec!");
        System.out.println("Odpowiedziałeś na " + correctAnswers + " z  " + totalReps + " pytań dobrze.");
        System.out.println("Dokładnośc: " + accuracy + "%");

        if (accuracy >= percentToWin) {
            System.out.println("Gratulacje wygrałeś!");
        } else {
            System.out.println("Przekroczyłeś maksymalną liczbę pytań.");
        }
        scanner.close();
    }
}