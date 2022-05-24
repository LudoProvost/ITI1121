import java.io.*;

public class SecretMessage {

    public static void encrypt(String inputFile, String outputFile, int key) throws IOException, FileNotFoundException {

        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        InputStreamReader input = new InputStreamReader(inputStream);
        OutputStreamWriter out = new OutputStreamWriter(outputStream);

        int letter = input.read();
        while (letter != -1) {
            out.write(letter + key);
            letter = input.read();
        }
        out.close();
    }

    public static void decrypt(String inputFile, String outputFile, int key) throws IOException, FileNotFoundException {

        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        InputStreamReader input = new InputStreamReader(inputStream);
        OutputStreamWriter out = new OutputStreamWriter(outputStream);

        int letter = input.read();
        while (letter != -1) {
            out.write(letter - key);
            letter = input.read();
        }
        out.close();
    }

    public static void main(String[] args) {

        if (args.length != 4) {
            System.out.println("Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key");
            System.exit(0);
        }

        if (args[0].equals("encrypt")) {


            try {
                encrypt(args[1], args[2], Integer.parseInt(args[3]));
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Cannot read/write file: " + e.getMessage());
            }
        } else if (args[0].equals("decrypt")) {


            try {
                decrypt(args[1], args[2], Integer.parseInt(args[3]));
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Cannot read/write file: " + e.getMessage());
            }
        } else {
            System.out.println("Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key");
            System.exit(0);
        }

    }
}
