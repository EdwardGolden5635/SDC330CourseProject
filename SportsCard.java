/**
 * Represents a standard sports card.
 */
public class SportsCard extends Card {

    private String manufacturer;

    public SportsCard() {
        super();
        this.manufacturer = "Unknown";
    }

    public SportsCard(String playerName, String team,
                      int year, String manufacturer) {

        super(playerName, team, year);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void displayInfo() {
        System.out.println("Sports Card");
        super.displayInfo();
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("-----------------------------------");
    }
}