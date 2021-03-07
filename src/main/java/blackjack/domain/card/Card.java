package blackjack.domain.card;

import java.util.Objects;

public class Card {
    private static final int BLACK_JACK = 21;

    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public String getLetterOfValueAndSuit() {
        return value.getLetter() + suit.getLetter();
    }

    public int getScore() {
        return value.getScore();
    }

    public Value selectValue(int score) {
        if (score > BLACK_JACK) {
            return Value.ACE_OF_ONE;
        }
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }
}
