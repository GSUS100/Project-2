public class NonResident extends Student {

    public NonResident(Profile profile, Major major, int creditCompleted)
    {
        super(profile, major, creditCompleted);
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        double tuitionCost = 29737;
        double universityFee = 3268;

        if(creditsEnrolled < 12) { //If partTime student
            tuitionCost = creditsEnrolled * 966;
            universityFee = .8 * universityFee;
        }
        else if(creditsEnrolled > 16)
        {
            tuitionCost += (creditsEnrolled * 966);
        }

        return tuitionCost + universityFee;
    }

    @Override
    public boolean isResident() {
        return false;
    }


}
