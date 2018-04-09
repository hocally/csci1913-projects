/*Todo:
Add comments
???
 */

public class Tableau {
    private Pile[] piles;
    private Deck deck;

    private final boolean cheat = false; //This variable can be set to true to bybass the normal constructor for Tableau and instead build a "cheating" deck: one that always produces a winning condition. It is set to false by default.

    public Tableau() {
	//This constructor has the following if-else statement that allows generation of of winning deck to validate that this condition is indeed possible. The first case generates the winning deck, and the second case constructs the object in the way described in the assignment.
		if (cheat) {
            piles = new Pile[14];
            for (int i = 0; i < piles.length; i++) {
                piles[i] = new Pile();
            }
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
            for (int i = 1; i < piles.length; i++) {
                for (int j = 0; j < 4; j++) {
                    piles[i].add(deck.deal());
                }
            }
        }
    }

    private boolean hasWon() {
        for (int i = 1; i < 14; i++) {
            if (!piles[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean play() {
        int p = 1;
        Card card;
        while (true) {
            if (piles[p].isEmpty()) {
                return p == 1;
                /*
                if (hasWon()) {
                    System.out.println("You won!");
                    break;
                } else {
                    System.out.println("Pile " + p + " is empty. You lost!");
                    break;
                }
                */
            } else {
                card = piles[p].turn();
                //System.out.println("Got a " + card.toString() + " from pile " + p + ".");
                p = card.getRank();
            }
        }
    }
}
