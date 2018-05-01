//This is my (ocall018@umn.edu) submission for the second project for CS1913. I have appended some sample output at the end of the file in a comment block.

import java.util.Random;

class Perditio {
    public static void main(String args[]) {
        Tableau tableau = new Tableau();
        tableau.play();
    }
}

class Tableau {
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

class Pile {
    private class Layer {
        private Card card;
        private Layer next;

        public Layer(Card card, Layer next) {
            this.card = card;
            this.next = next;
        }
    }

    private Layer head;

    public Pile() {
        head = null;
    }

    public void add(Card card) {
        head = new Layer(card, head);
    }

    public Card turn() {
        if(isEmpty()) {
            throw new IllegalStateException("No cards left in pile");
        } else {
            Card temp = head.card;
            head = head.next;
            return temp;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}

class Deck {
    private Card[] deck;
    private Random rand = new Random();
    private int count;

    public Deck() {
        count = 0;
        deck = new Card[52];
        for(int i = 1; i <= 13; i++) {
            for(int j = 0; j < 4; j++) {
                deck[count++] = new Card(i);
            }
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
                int j = rand.nextInt(i+1);
                Card temp = deck[i];
                deck[i] = deck[j];
                deck[j] = temp;
            }
        }
    }
}

final class Card
{

//  RANK NAME. Printable names of card ranks. We don't use index 0.

    private static final String[] rankName =
            {
                    "",        //   0
                    "ace",     //   1
                    "two",     //   2
                    "three",   //   3
                    "four",    //   4
                    "five",    //   5
                    "six",     //   6
                    "seven",   //   7
                    "eight",   //   8
                    "nine",    //   9
                    "ten",     //  10
                    "jack",    //  11
                    "queen",   //  12
                    "king"     //  13
            };

    private int rank;  //  Card rank, between 1 and 13.

//  CARD. Constructor. Make a new CARD with a given RANK.

    public Card(int rank)
    {
        if (1 <= rank && rank <= 13)
        {
            this.rank = rank;
        }
        else
        {
            throw new IllegalArgumentException("Illegal rank.");
        }
    }

//  GET RANK. Return the RANK of this CARD.

    public int getRank()
    {
        return rank;
    }

//  TO STRING. Return a STRING that describes this CARD, for printing only.

    public String toString()
    {
        return rankName[rank];
    }
}
/*Sample output:
Losing game
Got a eight from pile 1.
Got a three from pile 8.
Got a queen from pile 3.
Got a five from pile 12.
Got a ace from pile 5.
Got a two from pile 1.
Got a six from pile 2.
Got a five from pile 6.
Got a eight from pile 5.
Got a seven from pile 8.
Got a three from pile 7.
Got a five from pile 3.
Got a six from pile 5.
Got a ace from pile 6.
Got a ace from pile 1.
Got a ten from pile 1.
Got a king from pile 10.
Got a three from pile 13.
Got a ten from pile 3.
Got a three from pile 10.
Got a nine from pile 3.
Got a two from pile 9.
Got a two from pile 2.
Got a five from pile 2.
Got a queen from pile 5.
Got a ten from pile 12.
Got a king from pile 10.
Got a seven from pile 13.
Got a nine from pile 7.
Got a six from pile 9.
Got a seven from pile 6.
Got a ten from pile 7.
Got a king from pile 10.
Got a eight from pile 13.
Got a jack from pile 8.
Got a king from pile 11.
Got a jack from pile 13.
Got a jack from pile 11.
Got a nine from pile 11.
Got a nine from pile 9.
Got a eight from pile 9.
Got a six from pile 8.
Got a four from pile 6.
Got a four from pile 4.
Got a two from pile 4.
Got a four from pile 2.
Got a four from pile 4.
Got a jack from pile 4.
Got a ace from pile 11.
Pile 1 is empty. You lost!

Winning game
Got a two from pile 1.
Got a eight from pile 2.
Got a ace from pile 8.
Got a king from pile 1.
Got a king from pile 13.
Got a queen from pile 13.
Got a two from pile 12.
Got a five from pile 2.
Got a jack from pile 5.
Got a jack from pile 11.
Got a queen from pile 11.
Got a ten from pile 12.
Got a five from pile 10.
Got a ten from pile 5.
Got a five from pile 10.
Got a two from pile 5.
Got a ace from pile 2.
Got a four from pile 1.
Got a jack from pile 4.
Got a ten from pile 11.
Got a ace from pile 10.
Got a six from pile 1.
Got a three from pile 6.
Got a four from pile 3.
Got a two from pile 4.
Got a six from pile 2.
Got a seven from pile 6.
Got a five from pile 7.
Got a seven from pile 5.
Got a seven from pile 7.
Got a king from pile 7.
Got a nine from pile 13.
Got a king from pile 9.
Got a three from pile 13.
Got a nine from pile 3.
Got a six from pile 9.
Got a nine from pile 6.
Got a jack from pile 9.
Got a queen from pile 11.
Got a six from pile 12.
Got a seven from pile 6.
Got a queen from pile 7.
Got a four from pile 12.
Got a ten from pile 4.
Got a three from pile 10.
Got a eight from pile 3.
Got a nine from pile 8.
Got a eight from pile 9.
Got a eight from pile 8.
Got a four from pile 8.
Got a three from pile 4.
Got a ace from pile 3.
You won!
*/

