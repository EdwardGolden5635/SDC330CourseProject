/**
 * Represents a professionally graded card.
 */
public class GradedCard extends Card {

    private String gradingCompany;
    private double grade;

    public GradedCard() {
        super();
        gradingCompany = "Unknown";
        grade = 0.0;
    }

    public GradedCard(String playerName,
                      String team,
                      int year,
                      String gradingCompany,
                      double grade) {

        super(playerName, team, year);

        this.gradingCompany = gradingCompany;
        this.grade = grade;
    }

    public String getGradingCompany() {
        return gradingCompany;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public void displayInfo() {
        System.out.println("Graded Card");
        super.displayInfo();
        System.out.println("Grading Company: "
                + gradingCompany);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------------------");
    }
}