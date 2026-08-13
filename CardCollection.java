import java.util.ArrayList;

public class CardCollection {

    private ArrayList<Card> cards;

    public CardCollection() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void displayAll() {
        for (Card card : cards) {
            card.displayInfo();  // Polymorphism
        }
    }
}
