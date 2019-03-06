package f19l4exercise.opg3_playingcards;

/**
 * VOP eksamne F2014
 * Interface til opgave 3.
 * @author erso
 */
public interface CardInterface {
    // antal kort i et spil
    int NUMBER_OF_CARDS = 52;
    
    // konstante vaerdier for farver:
    int CLUBS = 1;
    int DIAMONDS = 2;
    int HEARTS = 3;
    int SPADES = 4;

    // konstante danske navne på farver:
    String CLUBS_NAME = "Kloer";
    String DIAMONDS_NAME = "Ruder";
    String HEARTS_NAME = "Hjerter";
    String SPADES_NAME = "Spar";
    
    // konstante værdier for es og billedkort. Alle andre kort har pålydende som værdi
    int ACE = 1;
    int JACK = 11;
    int QUEEN = 12;
    int KING = 13;

    // konstante danske forkortelser for es og billedkort
    String ACE_NAME = "Es";
    String JACK_NAME = "Kn";
    String QUEEN_NAME = "Da";
    String KING_NAME = "Ko";
}
