public class Pile {
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
