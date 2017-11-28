/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas_21;

/**
 *
 * @author DAVID
 */
public class Cubierta {
    /**
     * Una matriz de 52 o 54 cartas. Un mazo de 54 cartas contiene dos Jokers,
     * además de las 52 cartas de un mazo de póker regular.
     */
    private Carta[] cubierta;

    /**
     * Keeps track of the number of cards that have been dealt from
     * the deck so far.
     */
    private int cardsUsed;

    /**
     * Constructs a regular 52-card poker deck.  Initially, the cards
     * are in a sorted order.  The shuffle() method can be called to
     * randomize the order.  (Note that "new Deck()" is equivalent
     * to "new Deck(false)".)
     */
    public Cubierta() {
        this(false);  // Just call the other constructor in this class.
    }
    public Cubierta(boolean includeJokers) {
        if (includeJokers)
            cubierta = new Carta[54];
        else
            cubierta = new Carta[52];
        int cardCt = 0; // How many cards have been created so far.
        for ( int suit = 0; suit <= 3; suit++ ) {
            for ( int value = 1; value <= 13; value++ ) {
                cubierta[cardCt] = new Carta(value,suit);
                cardCt++;
            }
        }
        if (includeJokers) {
            cubierta[52] = new Carta(1,Carta.JOKER);
            cubierta[53] = new Carta(2,Carta.JOKER);
        }
        cardsUsed = 0;
    }

    /**
     * Put all the used cards back into the deck (if any), and
     * shuffle the deck into a random order.
     */
    public void barajar() {
        for ( int i = cubierta.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Carta temp = cubierta[i];
            cubierta[i] = cubierta[rand];
            cubierta[rand] = temp;
        }
        cardsUsed = 0;
    }

    /**
     * As cards are dealt from the deck, the number of cards left
     * decreases.  This function returns the number of cards that
     * are still left in the deck.  The return value would be
     * 52 or 54 (depending on whether the deck includes Jokers)
     * when the deck is first created or after the deck has been
     * shuffled.  It decreases by 1 each time the dealCard() method
     * is called.
     */
    public int cardsLeft() {
        return cubierta.length - cardsUsed;
    }

    /**
     * Removes the next card from the deck and return it.  It is illegal
     * to call this method if there are no more cards in the deck.  You can
     * check the number of cards remaining by calling the cardsLeft() function.
     * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public Carta tarjeta_oferta() {
        if (cardsUsed == cubierta.length)
            throw new IllegalStateException("No cards are left in the deck.");
        cardsUsed++;
        return cubierta[cardsUsed - 1];
        // Programming note:  Cards are not literally removed from the array
        // that represents the deck.  We just keep track of how many cards
        // have been used.
    }

    /**
     * Test whether the deck contains Jokers.
     * @return true, if this is a 54-card deck containing two jokers, or false if
     * this is a 52 card deck that contains no jokers.
     */
    public boolean hasJokers() {
        return (cubierta.length == 54);
    }
    
}
