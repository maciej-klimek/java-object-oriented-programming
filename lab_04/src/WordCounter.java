import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class WordCounter {

    private static boolean l = true;
    private static boolean c = true;
    private static boolean w = true;

    private static int lineCount = 0;
    private static int charCount = 0;
    private static int wordCount = 0;

    private static String fileName = null;

    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Brak argumentów programu");
            System.exit(0);
        }

        try {
            readCommandLineArgs(args);
        }
        catch(Exception e) {
            System.out.println("Wystąpił błąd podczas czytania argumentów programu.");
            System.exit(0);
        }

        counter();

        if(l) {
            System.out.println("wierszy: " + lineCount);
        }
        if(c) {
            System.out.println("znaków: " + charCount);
        }
        if(w) {
            System.out.println("słów: " + wordCount);
        }

    }

    public static void counter() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = reader.readLine()) != null) {
                if(l) lineCount++;
                if(c) {
                    charCount += line.length();
                }
                if(w) {
                    String[] words = line.split(" ");
                    if (!words[0].isEmpty()) {
                        wordCount += words.length;
                    }
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Plik " + fileName + " nie istnieje.");
            System.exit(0);
        }
        catch(Exception e) {
            System.out.println("Wystąpił błąd podczas czytania pliku: " + fileName);
            System.exit(0);
        }
    }

    public static void readCommandLineArgs(String[] args) {

        boolean fileFound = false;

        for(String arg : args) {
            if(arg.startsWith("-")) {
                for(char option : arg.substring(1).toCharArray()) {
                    if(option == 'l') l = false;
                    else if(option == 'c') c = false;
                    else if(option == 'w') w = false;
                    else {
                        System.out.println("Nieznana opcja: " + option);
                        System.exit(0);
                    }
                }
            }
            else {
                fileName = arg;
                fileFound = true;
            }
        }

        if(!fileFound) {
            System.out.println("Brak nazwy pliku.");
            System.exit(0);
        }
    }
}