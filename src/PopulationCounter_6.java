import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Map<String, Map<String, Long>> dataPopulations = new LinkedHashMap<>();

        while (!"report".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\|");
            String town = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            dataPopulations.putIfAbsent(country, new HashMap<>());
            dataPopulations.get(country).putIfAbsent(town, population);

        }
        dataPopulations.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().values().stream().reduce(0l, Long::sum)
                        .compareTo(c1.getValue().values().stream().reduce(0L, Long::sum)))
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(),
                            country.getValue().values().stream().reduce(0L, Long::sum));
                    country.getValue().entrySet().stream()
                            .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                            .forEach(c -> System.out.printf("=>%s: %d%n", c.getKey(), c.getValue()));
                });

    }
}
