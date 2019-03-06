package f19l4exercise.opg3_playingcards;

/**
 * VOP eksamen F2014 Tom klasse til opgave 3
 *
 * @author erso
 */
public class Card implements CardInterface {

    private final int face;
    private final int suit;

    public Card(int face, int suit) {
        this.face = face;
        this.suit = suit;
        if (face < ACE || face > KING || suit < CLUBS || suit > SPADES) {
            System.out.println("Ulovligt kort: " + suit + " " + face);
        }
    }

    @Override
    public String toString() {
        String suitName = suit == CLUBS ? CLUBS_NAME : suit == DIAMONDS ? DIAMONDS_NAME : suit == HEARTS ? HEARTS_NAME : SPADES_NAME;
        String faceName = face == ACE ? ACE_NAME : face == JACK ? JACK_NAME : face == QUEEN ? QUEEN_NAME : face == KING ? KING_NAME : String.valueOf(face);
        return suitName + "-" + faceName;
    }
}
