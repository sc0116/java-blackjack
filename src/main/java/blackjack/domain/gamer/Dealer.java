package blackjack.domain.gamer;

import blackjack.domain.WinDrawLose;
import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dealer extends Gamer {
    private static final String DEALER_NAME = "딜러";
    private static final int HIT_FLAG_SCORE = 16;
    private static final String WIN_DRAW_LOSE_RESULT_DELIMITER = " ";

    private static final Dealer dealer = new Dealer();

    private final Map<WinDrawLose, Integer> winDrawLose = new EnumMap<>(WinDrawLose.class);

    private Dealer() {
        super(DEALER_NAME, new Cards(new ArrayList<>()));
    }

    public static Dealer init() {
        return dealer;
    }

    public boolean checkHitFlag() {
        return getCards().calculateScore() <= HIT_FLAG_SCORE;
    }

    @Override
    public List<Card> getViewCard() {
        return List.of(getCards().getCards().get(0));
    }

    @Override
    public void win() {
        winDrawLose.merge(WinDrawLose.WIN, 1, Integer::sum);
    }

    @Override
    public void draw() {
        winDrawLose.merge(WinDrawLose.DRAW, 1, Integer::sum);
    }

    @Override
    public void lose() {
        winDrawLose.merge(WinDrawLose.LOSE, 1, Integer::sum);
    }

    @Override
    public String getWinDrawLoseString() {
        return winDrawLose.entrySet().stream()
                .map(set -> set.getValue() + set.getKey().getName())
                .collect(Collectors.joining(WIN_DRAW_LOSE_RESULT_DELIMITER));
    }
}