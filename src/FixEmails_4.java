import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> emailDiary = new LinkedHashMap<>();
        int count = 0;
        String key = null;
        while (!input.equals("stop")) {
            count++;
            if (count % 2 != 0) {
                key = input;
            } else {
                if (!input.endsWith(".uk") && !input.endsWith(".us") && !input.endsWith(".com")) {
                    emailDiary.put(key, input);
                }
            }

            input = scanner.nextLine();
        }
        emailDiary.forEach((k, v) ->
                System.out.printf("%s -> %s%n", k, v));
    }
}
