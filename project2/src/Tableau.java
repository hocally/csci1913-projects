public class Tableau {
    private Pile[] piles;
    private Deck deck;

    public Tableau() {
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

    private boolean hasWon() {
        for (int i = 1; i < 14; i++) {
            if (!piles[i].isEmpty()) {
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
