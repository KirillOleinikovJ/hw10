import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstTask {
    public void printNumber(File file) {
        Pattern pattern = Pattern.compile("(\\(\\d{3}\\) |\\d{3}-)\\d{3}-\\d{4}");
        Matcher matcher;
        if (!file.exists()) {
            System.out.println("not exist");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                matcher = pattern.matcher(line);
                if (matcher.find())
                    System.out.println("line = " + line);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String ABSOLUTE_PATH = "C:\\java\\hw10\\target\\file.txt";

    public static void main(String[] args) {
        FirstTask ft = new FirstTask();
        File file = new File(ABSOLUTE_PATH);
        ft.printNumber(file);
    }
}
