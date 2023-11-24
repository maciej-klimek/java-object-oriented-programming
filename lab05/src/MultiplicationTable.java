import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MultiplicationTable {

    public static void createSettingsFile(String filePath) {
        try {
            // Create a FileWriter object
            FileWriter writer = new FileWriter(filePath);

            writer.write("min_val: 1" + "\n" +
                    "max_val: 10" + "\n" +
                    "min_rep: 10" + "\n" +
                    "max_rep: 25" + "\n" +
                    "percent_to_pass: 75" + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> readSettingsFile(String filePath) {
        Map<String, Integer> settingsMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    int value = Integer.parseInt(parts[1].trim());
                    settingsMap.put(key, value);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return settingsMap;
    }

    public static void play(Map<String, Integer> config) {
        int minVal = config.get("min_val");
        int maxVal = config.get("max_val");
        int minRep = config.get("min_rep");
        int maxRep = config.get("max_rep");
        int percentToPass = config.get("percent_to_pass");

    }
    public static void main(String[] args) {

        String filePath = "settings.txt";
        File file = new File(filePath);
        boolean fileExists = file.exists();

        if (!fileExists) {
            System.out.println("File does not exists.");
            createSettingsFile(filePath);
        }
        Map<String, Integer> config = readSettingsFile(filePath);
        play(config);

    }
}
