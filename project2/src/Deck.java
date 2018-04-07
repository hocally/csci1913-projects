import java.util.Random;

public class Deck {
    private Card[] deck;
    private Random rand = new Random();
    private int count;

    public Deck() {
        count = 0;
        deck = new Card[52];
        for(int i = 0; i < deck.length; i++) {
            deck[i] = new Card(Math.abs(rand.nextInt()) % 13 + 1);
            count++;
        }
    }

    public Card deal() {
        if(count > 0) {
            return deck[(count--) - 1];
        } else {
            throw new IllegalStateException("No cards left in deck");
        }
    }

    public void shuffle() {
        if(count <= 51) {
            throw new IllegalStateException("Cannot shuffle after dealing has started");
        } else {
            for(int i = deck.length - 1; i > 0; i--) {
                int j = Math.abs(rand.nextInt()) % (i + 1);
                Card temp = deck[i];
                deck[i] = deck[j];
                deck[j] = temp;
            }
        }
    }
}
