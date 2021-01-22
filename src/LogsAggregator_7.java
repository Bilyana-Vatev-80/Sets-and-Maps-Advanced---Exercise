import java.util.*;

public class LogsAggregator_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> time = new HashMap<>();
        Map<String, Set<String>> address = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String ip = tokens[0];
            String name = tokens[1];
            int times = Integer.parseInt(tokens[2]);

            time.putIfAbsent(name, 0);
            time.put(name, time.get(name) + times);

            address.putIfAbsent(name, new TreeSet<>());
            address.get(name).add(ip);
        }
        for (Map.Entry<String, Set<String>> name : address.entrySet()) {
            for (Map.Entry<String, Integer> name2 : time.entrySet()) {
                if (name.getKey().equals(name2.getKey())) {
                    System.out.printf("%s: %d %s%n", name.getKey(), name2.getValue(), name.getValue().toString());
                }
            }
        }
    }
}

