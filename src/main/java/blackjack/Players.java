package blackjack;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players fromNames(List<String> names) {
        validate(names);
        return new Players(toPlayers(names));
    }

    private static List<Player> toPlayers(List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private static void validate(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);

        if (names.size() != nameSet.size()) {
            throw new IllegalArgumentException("참가자 이름은 중복될 수 없습니다.");
        }
    }
}