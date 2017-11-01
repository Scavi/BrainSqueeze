package com.scavi.brainsqueeze.career;

import org.junit.Assert;
import org.junit.Test;

public class ShuffleTest {

    @Test
    public void test1() {
        Shuffle.Card[] cards = {
                new Shuffle.Card(Shuffle.CardType.Clubs, Shuffle.CardValue.Ace),
                new Shuffle.Card(Shuffle.CardType.Clubs, Shuffle.CardValue.Jack),
                new Shuffle.Card(Shuffle.CardType.Clubs, Shuffle.CardValue.King),
                new Shuffle.Card(Shuffle.CardType.Clubs, Shuffle.CardValue.Queen),
                new Shuffle.Card(Shuffle.CardType.Diamond, Shuffle.CardValue.Ace),
                new Shuffle.Card(Shuffle.CardType.Diamond, Shuffle.CardValue.Jack),
                new Shuffle.Card(Shuffle.CardType.Diamond, Shuffle.CardValue.King),
                new Shuffle.Card(Shuffle.CardType.Diamond, Shuffle.CardValue.Queen),
                new Shuffle.Card(Shuffle.CardType.Hearts, Shuffle.CardValue.Ace),
                new Shuffle.Card(Shuffle.CardType.Hearts, Shuffle.CardValue.Jack),
                new Shuffle.Card(Shuffle.CardType.Hearts, Shuffle.CardValue.King),
                new Shuffle.Card(Shuffle.CardType.Hearts, Shuffle.CardValue.Queen),
                new Shuffle.Card(Shuffle.CardType.Spades, Shuffle.CardValue.Ace),
                new Shuffle.Card(Shuffle.CardType.Spades, Shuffle.CardValue.Jack),
                new Shuffle.Card(Shuffle.CardType.Spades, Shuffle.CardValue.King),
                new Shuffle.Card(Shuffle.CardType.Spades, Shuffle.CardValue.Queen),
        };
        Shuffle.Card[] result = new Shuffle().shuffle(cards);
        for (int i = 0; i < result.length; ++i) {
            Assert.assertNotNull(result[i]);
        }
    }
}
