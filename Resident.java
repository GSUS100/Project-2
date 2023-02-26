public class Resident extends Student {

    private int scholarship = 0;

    public Resident(Profile profile, Major major, int creditCompleted)
    {
        super(profile, major, creditCompleted);
    }

    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }

    public int getScholarship() {
        return scholarship;
    }

    /* No need to override isValid from super since there are no new conditions for a resident */

    @Override
    public double tuitionDue(int creditsEnrolled) {
        double tuitionCost = 12546;
        double universityFee = 3268;

        if(creditsEnrolled < 12) { //If partTime student
            tuitionCost = creditsEnrolled * 404;
            universityFee = .8 * universityFee;
        }
        else if(creditsEnrolled > 16)
        {
            tuitionCost += (creditsEnrolled * 404);
        }

        return tuitionCost + universityFee - scholarship;
    }

    @Override
    public boolean isResident() {
        return true;
    }


}
