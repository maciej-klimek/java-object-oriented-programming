import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class MultiplicationTable {
    public static void main(String[] args) {

        String fileName = "settings.properties";
        Properties properties = new Properties();
        HashMap<String, Integer> settings = new HashMap<String, Integer>();

        getSettingsData(fileName, properties);
        loadSettings(settings, properties);

        System.out.println(settings);
    }

    private static void getSettingsData(String fileName, Properties properties) {
        try {
            File file = new File(fileName);

            if (!file.exists()) {
                properties.setProperty("wartosc_minimum", "1");
                properties.setProperty("wartosc_maksimum", "10");
                properties.setProperty("powtorzen_maksimum", "10");
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
        settings.put("max_rep", Integer.valueOf(properties.getProperty("powtorzen_maksimum")));
        settings.put("percent", Integer.valueOf(properties.getProperty("procent")));

    }
}
