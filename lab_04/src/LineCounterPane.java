import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LineCounterPane {

    public static void countLines(String fileName){
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                count++;
            }

            JOptionPane.showMessageDialog(null, "Liczba wierszy w pliku " + fileName + " wynosi: " + count);

        } catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Plik " + fileName + " nie istnieje");
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Niezidentyfikowany blad podczas wczytywania pliku");
            return;
        }
    }
    public static void main(String[] args) {

        String fileName = JOptionPane.showInputDialog("Podaj nazwe pliku");
        try {
            countLines(fileName);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Brak argumentów programu");
            System.exit(0);
        }
    }
}

