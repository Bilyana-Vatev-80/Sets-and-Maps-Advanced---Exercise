import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> users = new TreeMap<>();

        String input = "";

        while (!"end".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String iP = tokens[0].split("=")[1];
            String userName = tokens[2].split("=")[1];

            users.putIfAbsent(userName, new LinkedHashMap<>());
            users.get(userName).putIfAbsent(iP, 0);
            int count = users.get(userName).get(iP) + 1;
            users.get(userName).put(iP, count);
        }
        for (Map.Entry<String, Map<String, Integer>> entry : users.entrySet()) {
            System.out.println(entry.getKey() + ":");
            Map<String, Integer> integerMap = entry.getValue();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> integerInfo : integerMap.entrySet()) {
                String output = String.format("%s => %d", integerInfo.getKey(), integerInfo.getValue());
                sb.append(output);
                sb.append(", ");
            }
            String res = sb.substring(0, sb.length() - 2);
            System.out.println(res + ".");
        }
    }
}
