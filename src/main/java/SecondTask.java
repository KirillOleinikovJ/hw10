import com.google.gson.*;

import java.io.*;
import java.util.*;

public class SecondTask {
    private static final String ABSOLUTE_PATH = "C:\\java\\hw10\\src\\main\\java\\file.txt";

    public static void main(String[] args) throws IOException {
        List<User> users = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String toJson = gson.toJson(users);
        InputStream fis = new FileInputStream(ABSOLUTE_PATH);
        Scanner scanner = new Scanner(fis);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String[] words = scanner.nextLine().split(" ");
            String name = words[0];
            int age = Integer.parseInt(words[1]);
            users.add(new User(name, age));
            fis.close();
        }

        FileWriter fileWriter = new FileWriter("users.json");
        gson.toJson(users, fileWriter);
        fileWriter.close();
    }
}
