/**
 * Abstract parent class for all sports cards.
 */
public abstract class Card implements Displayable {

    private String playerName;
    private String team;
    private int year;

    public Card() {
        this.playerName = "Unknown";
        this.team = "Unknown";
        this.year = 0;
    }

    public Card(String playerName, String team, int year) {
        this.playerName = playerName;
        this.team = team;
        this.year = year;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getTeam() {
        return team;
    }

    public int getYear() {
        return year;
    }

    @Override
    public void displayInfo() {
        System.out.println("Player: " + playerName);
        System.out.println("Team: " + team);
        System.out.println("Year: " + year);
    }
}