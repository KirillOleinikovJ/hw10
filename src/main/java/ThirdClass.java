import java.io.*;
import java.util.*;

public class ThirdClass {
    private static final String ABSOLUTE_PATH = "C:\\java\\hw10\\target\\words.txt";

    public static void main(String[] args) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        try (InputStream fis = new FileInputStream(ABSOLUTE_PATH)) {
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextLine()) {
                int count = 1;
                String line = scanner.nextLine();
                String[] splitedLine = line.split(" ");
                for (String str : splitedLine) {
                    if (wordCount.containsKey(str)) {
                        int tempCount = wordCount.get(str) + 1;
                        wordCount.put(str, tempCount);
                    } else {
                        wordCount.put(str, count);
                    }
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Comparator<String> comporator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return wordCount.get(o1).compareTo(wordCount.get(o2)) > 0 ? 1 : -1;
            }
        };
        Map<String, Integer> result = new TreeMap<>(comporator.reversed());
        result.putAll(wordCount);
        System.out.println("result.toString() = " + result.toString());
    }
}
