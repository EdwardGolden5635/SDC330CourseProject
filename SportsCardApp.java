public class SportsCardApp {

    public static void main(String[] args) {

        System.out.println("-----------------------------------------");
        System.out.println("Sports Card Project Week 3");
        System.out.println("Edward Golden");
        System.out.println("-----------------------------------------\n");

        CardCollection collection = new CardCollection();

        SportsCard sc = new SportsCard("Ken Griffey Jr.", "Mariners", 1989, "Upper Deck");
        GradedCard gc = new GradedCard("Michael Jordan", "Bulls", 1986, "PSA", 9.5);

        collection.addCard(sc);
        collection.addCard(gc);

        collection.displayAll();
    }
}
