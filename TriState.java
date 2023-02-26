public class TriState extends NonResident {

    private String state;

    public TriState(Profile profile, Major major, int creditCompleted, String state)
    {
        super(profile, major, creditCompleted);
        this.state = state;
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        double tuitionCost = 29737;
        double universityFee = 3268;
        double discount = 0;

        if(creditsEnrolled < 12) { //If partTime student
            tuitionCost = creditsEnrolled * 966;
            universityFee = .8 * universityFee;
        }
        else if(creditsEnrolled > 16)
        {
            tuitionCost += (creditsEnrolled * 966);
        }

        switch(state) {
            case "NY":
                discount = 4000;
            case "CT":
                discount = 5000;
        }

        return tuitionCost + universityFee - discount;
    }


}
