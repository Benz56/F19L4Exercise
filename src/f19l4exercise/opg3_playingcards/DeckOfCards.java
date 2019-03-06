package f19l4exercise.opg3_playingcards;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * VOP eksamen F2014 Kodeskelet til opgave 3c og 3d
 *
 * @author erso
 */
public class DeckOfCards implements CardInterface {

    private final Card[] deck;

    public DeckOfCards() {
        deck = new Card[NUMBER_OF_CARDS];
        for (int suit = CLUBS; suit <= SPADES; suit++) {
            for (int face = ACE; face <= KING; face++) {
                deck[((suit - 1) * 13 + face) - 1] = new Card(face, suit);
            }
        }
        System.out.println(Arrays.toString(deck));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deck.length; i++) {
            if (i != 0 && i % 4 == 0) {
                sb.append("\n");
            }
            sb.append(deck[i]);
            if (i != deck.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void shuffle(int swaps) {
        for (int i = 0; i < swaps; i++) {
            int card1 = ThreadLocalRandom.current().nextInt(deck.length), card2 = ThreadLocalRandom.current().nextInt(deck.length);
            Card temp = deck[card1];
            deck[card1] = deck[card2];
            deck[card2] = temp;
        }
    }
}
