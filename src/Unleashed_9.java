import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unleashed_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<artist>[A-Za-z ]+) @(?<place>[A-Za-z ]+) (?<tickedPrice>[\\d]{1,3}) (?<tickedCount>[\\d]+)");

        LinkedHashMap<String, LinkedHashMap<String, Integer>> venues = new LinkedHashMap<>();
        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String artist = matcher.group("artist");
                String place = matcher.group("place");
                int tickedPrice = Integer.parseInt(matcher.group("tickedPrice"));
                int tickedCount = Integer.parseInt(matcher.group("tickedCount"));
                int money = tickedPrice * tickedCount;
                venues.putIfAbsent(place, new LinkedHashMap<>());
                venues.get(place).putIfAbsent(artist, 0);
                venues.get(place).put(artist, venues.get(place).get(artist) + money);
            }

            input = scanner.nextLine();
        }
        venues.entrySet()
                .stream()
                .forEach(p -> {
                    System.out.println(p.getKey());
                    p.getValue()
                            .entrySet()
                            .stream()
                            .sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue()))
                            .forEach(s -> {
                                System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue());
                            });
                });
    }
}
