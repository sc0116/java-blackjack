package domain;

import domain.card.CardDeck;
import domain.player.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerFactoryTest {
    @DisplayName("팩토리에서 생성한 Player 의 유효성 검증")
    @Test
    void createPlayersTest() {
        CardDeck cards = new CardDeck();
        List<String> playerName = new ArrayList<>(Arrays.asList("pobi", "json"));

        Assertions.assertThat(PlayerFactory.create(cards, playerName)).isInstanceOf(Players.class);
    }
}