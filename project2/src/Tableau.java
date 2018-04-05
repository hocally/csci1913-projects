/*Todo:
Ask TA about how to do tests
Add comments
???
 */

public class Tableau {
    private Pile[] piles;
    private Deck deck;

    private final boolean cheat = false;

    public Tableau() {
        if (cheat) {
            piles = new Pile[14];
            for (int i = 0; i < piles.length; i++) {
                piles[i] = new Pile();
            }
            //deck = new Deck();
            //deck.shuffle();
            for (int i = 1; i < 13; i++) {
                piles[i].add(new Card(i + 1));
                for (int j = 0; j < 3; j++) {
                    piles[i].add(new Card(i));
                }
            }
            piles[13].add(new Card(1));
            piles[13].add(new Card(13));
            piles[13].add(new Card(13));
            piles[13].add(new Card(13));
        } else {
            piles = new Pile[14];
            for (int i = 0; i < piles.length; i++) {
                piles[i] = new Pile();
            }
            deck = new Deck();
            deck.shuffle();
            for (int i = 1; i < 14; i++) {
                for (int j = 0; j < 4; j++) {
                    piles[i].add(deck.deal());
                }
            }
        }
    }

    private boolean hasWon() {
        for (Pile p : piles) {
            if (!p.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void play() {
        int p = 1;
        Card card;
        while (true) {
            if (piles[p].isEmpty()) {
                if (hasWon()) {
                    System.out.println("You won!");
                    break;
                } else {
                    System.out.println("Pile " + p + " is empty. You lost!");
                    break;
                }
            } else {
                card = piles[p].turn();
                System.out.println("Got a " + card.toString() + " from pile " + p + ".");
                p = card.getRank();
            }
        }
    }
}
