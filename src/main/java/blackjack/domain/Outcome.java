package blackjack.domain;

import blackjack.domain.card.Score;

public enum Outcome {
    WIN("승"),
    LOSE("패"),
    DRAW("무");

    private final String word;

    Outcome(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
    public static Outcome getInstance(final Score base, final Score counterpart) {
        if (draw(base, counterpart)) {
            return Outcome.DRAW;
        }

        if (win(base, counterpart)) {
            return Outcome.WIN;
        }

        return Outcome.LOSE;
    }

    private static boolean draw(final Score base, final Score counterpart) {
        if (base.isBurst() && counterpart.isBurst()) {
            return true;
        }
        if(base.isBlackJack() && counterpart.isBlackJack()){
            return true;
        }
        if (!base.isBurst() && !counterpart.isBurst() && base.isSameAs(counterpart)) {
            return true;
        }
        return false;
    }

    private static boolean win(final Score base, final Score counterpart) {
        if (base.isBlackJack() && !counterpart.isBlackJack()) {
            return true;
        }
        if(!base.isBurst() && counterpart.isBurst()){
            return true;
        }
        if (!base.isBurst() && base.isHigherThan(counterpart)) {
            return true;
        }
        return false;
    }
}