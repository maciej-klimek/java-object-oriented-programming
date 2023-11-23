import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LineCounter {

    public static void countLines(String fileName){
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                count++;
            }

            System.out.println("Liczba wierszy w pliku " + fileName + " wynosi: " + count);

        } catch(FileNotFoundException e) {
            System.out.println("Plik " + fileName + " nie istnieje");
            return;
        } catch (Exception e) {
            System.out.println("Niezidentyfikowany blad podczas wczytywania pliku");
            return;
        }
    }
    public static void main(String[] args) {

        try {
            countLines(args[0]);
        } catch (Exception e) {
            System.out.println("Brak argumentów programu");
            System.exit(0);
        }
    }
}
