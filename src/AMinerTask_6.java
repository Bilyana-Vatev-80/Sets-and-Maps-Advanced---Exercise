import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> minerTask = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            minerTask.putIfAbsent(input, 0);
            int amount = scanner.nextInt();
            scanner.nextLine();

            minerTask.put(input, minerTask.get(input) + amount);
            input = scanner.nextLine();
        }
        minerTask.forEach((k, v) ->
                System.out.printf("%s -> %d%n", k, v));
    }
}
