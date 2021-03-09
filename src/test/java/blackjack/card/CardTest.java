package blackjack.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardNumber;
import blackjack.domain.card.CardType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    @DisplayName("카드가 잘 생성되었는지 확인")
    void create() {
        assertThatCode(() -> new Card(CardNumber.TWO, CardType.CLOVER))
            .doesNotThrowAnyException();
    }

}