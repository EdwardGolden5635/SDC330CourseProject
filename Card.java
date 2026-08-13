public class Card implements Displayable {

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

    protected String getPlayerName() { return playerName; }
    protected String getTeam() { return team; }
    protected int getYear() { return year; }

    @Override
    public void displayInfo() {
        System.out.println("Player: " + playerName);
        System.out.println("Team: " + team);
        System.out.println("Year: " + year);
    }
}
