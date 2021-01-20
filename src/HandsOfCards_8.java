import java.util.*;

public class HandsOfCards_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Set<String>> playerPoints = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String[] cardsArray = input.split(": ")[1].split(", ");
            Set<String> cards = new HashSet<>(Arrays.asList(cardsArray));

            if (!playerPoints.containsKey(name)) {
                playerPoints.put(name, cards);
            } else {
                Set<String> currentCart = playerPoints.get(name);
                // временната променлива я добавяме към текущите карти
                // и след това подновяваме мапа.
                playerPoints.put(name, currentCart);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Set<String>> player : playerPoints.entrySet()) {
            int points = calculatePoints(player.getValue());
            System.out.printf("%s: %d%n", player.getKey(), points);
        }
    }

    private static int calculatePoints(Set<String> cards) {
        HashMap<Character, Integer> powers = getLettersPower();
        int sum = 0;
        for (String card : cards) {
            if (card.contains("10")) {
                sum += 10 * powers.get(card.charAt(2));
                continue;
            }
            char first = card.charAt(0);
            char second = card.charAt(1);

            sum += powers.get(first) * powers.get(second);
        }
        return sum;
    }

    private static HashMap<Character, Integer> getLettersPower() {
        HashMap<Character, Integer> powers = new HashMap<>();
        powers.put('1', 1);
        powers.put('2', 2);
        powers.put('3', 3);
        powers.put('4', 4);
        powers.put('5', 5);
        powers.put('6', 6);
        powers.put('7', 7);
        powers.put('8', 8);
        powers.put('9', 9);
        powers.put('J', 11);
        powers.put('Q', 12);
        powers.put('K', 13);
        powers.put('A', 14);
        powers.put('S', 4);
        powers.put('H', 3);
        powers.put('D', 2);
        powers.put('C', 1);

        return powers;
    }

}
