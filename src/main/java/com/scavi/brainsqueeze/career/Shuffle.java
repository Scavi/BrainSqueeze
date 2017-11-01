package com.scavi.brainsqueeze.career;

import javax.annotation.Nonnull;
import java.util.Random;

public class Shuffle {

    /**
     * Shuffles the given cards
     *
     * @param cards the array of cards
     * @return the shuffled cards
     */
    public Card[] shuffle(@Nonnull Card... cards) {
        Random random = new Random();

        for (int i = 0; i < cards.length; ++i) {
            int newPos = random.nextInt(cards.length - i);
            swap(cards, i, newPos);
        }
        return cards;
    }

    private void swap(Card[] cards, int pos1, int pos2) {
        Card tmp = cards[pos1];
        cards[pos1] = cards[pos2];
        cards[pos2] = tmp;
    }

    public enum CardType {Clubs, Diamond, Hearts, Spades}

    public enum CardValue {V2, V3, V4, V5, V6, V7, V8, V9, V10, Jack, Queen, King, Ace}

    public static class Card {
        private final CardType _type;
        private final CardValue _value;

        public Card(CardType type, CardValue value) {
            _type = type;
            _value = value;
        }

        public CardType getType() {
            return _type;
        }

        public CardValue getValue() {
            return _value;
        }
    }
}
