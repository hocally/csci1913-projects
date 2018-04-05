//  CARD. A playing card. It's immutable.

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
