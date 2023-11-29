import java.io.*;
import java.net.*;
import java.nio.file.AccessDeniedException;

public class FileAndURLCopy {

    private static File sourceFile = null;
    private static File targetFile = null;

    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Nie podano argumentów programu");
            return;
        }

        String sourceFileName = args[0];
        String targetFileName;
        if(args.length == 1) {
            String[] urlSegments = sourceFileName.split("/");
            targetFileName = urlSegments[urlSegments.length - 1]  + ".html";
        }
        else {
            targetFileName = args[1];
        }
        readContent(sourceFileName, targetFileName);
    }

    public static void readContent(String source, String target) {

        if(isURL(source)) {
            try {
                URL url = new URL(source);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                if(isValidURL(connection)) {
                    targetFile = new File(target);
                    if(targetFile.isDirectory()) {
                        String[] urlSegments = source.split("/");
                        target = urlSegments[urlSegments.length - 1]  + ".html";
                        targetFile = new File(targetFile, target);
                        boolean created = targetFile.createNewFile();
                        if(!created) {
                            System.out.println("Nie udało się utworzyć pliku " + target);
                            System.exit(0);
                        }
                    }
                    copyURL(connection, targetFile);
                }
                else {
                    System.out.println("Podany adres: " + source + " jest nieprawidlowy.");
                    System.exit(0);
                }
            }

            catch(SocketException e) {
                System.out.println("Brak połączenia sieciowego");
                System.exit(0);
            }
            catch(UnknownHostException e) {
                System.out.println("Podany adres: " + source + " jest nieprawidłowy.");
                System.exit(0);
            }
            catch(FileNotFoundException e){
                String[] text = e.getMessage().split(" ");
                System.out.println("Plik " + text[0] + " nie istnieje");
                System.exit(0);
            }
            catch(AccessDeniedException e) {
                String[] text = e.getMessage().split(" ");
                System.out.println("Brak Wymaganych uprawnień do zapisu pliku " + text[0]);
                System.exit(0);
            }
            catch(IOException e) {
                String[] text = e.getMessage().split(" ");
                System.out.println("Wystąpił błąd przy operacji na pliku " + text[0]);
                System.exit(0);
            }
        } else {
            try {
                sourceFile = new File(source);

                if(sourceFile.isDirectory()) {
                    System.out.println("Plik " + source + " jest katalogiem");
                    System.exit(0);
                }

                targetFile = new File(target);

                if(!targetFile.exists()) {
                    boolean created = targetFile.createNewFile();
                    if(!created) {
                        System.out.println("Nie udało się utworzyć pliku " + target);
                        System.exit(0);
                    }
                } else if(targetFile.isDirectory()) {
                    targetFile = new File(targetFile, source);
                    boolean created = targetFile.createNewFile();
                    if(!created) {
                        System.out.println("Nie udało się utworzyć pliku " + target);
                        System.exit(0);
                    }
                }

                copyFile(sourceFile, targetFile);
            }
            catch(FileNotFoundException e){
                String[] text = e.getMessage().split(" ");
                System.out.println("Plik " + text[0] + " nie istnieje");
                System.exit(0);
            }
            catch(AccessDeniedException e) {
                String[] text = e.getMessage().split(" ");
                System.out.println("Brak Wymaganych uprawnień do zapisu pliku " + text[0]);
                System.exit(0);
            }
            catch(IOException e) {
                String[] text = e.getMessage().split(" ");
                System.out.println("Wystąpił błąd przy operacji na pliku " + text[0]);
                System.exit(0);
            }


        }
    }

    public static void copyFile(File source, File target) throws IOException {

        try (InputStream inStream = new FileInputStream(source);
             OutputStream outStream = new FileOutputStream(target)){

            byte[] buffer = new byte[4096];
            int bytesRead;

            while((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }
    }

    private static boolean isURL(String input) {
        return input.startsWith("http://") || input.startsWith("https://");
    }

    private static boolean isValidURL(HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();
        return(responseCode >= 200 && responseCode < 300);
    }

    public static void copyURL(HttpURLConnection connection, File targetFile) throws IOException {
        try (InputStream inStream = connection.getInputStream();
             OutputStream outStream = new FileOutputStream(targetFile)){

            byte[] buffer = new byte[4096];
            int bytesRead;
            while((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
