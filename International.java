public class International extends NonResident {

    private boolean isStudyAbroad;

    public International(Profile profile, Major major, int creditCompleted, boolean isStudyAbroad)
    {
        super(profile, major, creditCompleted);
        this.isStudyAbroad = isStudyAbroad;
    }

    @Override
    public boolean isValid(int creditEnrolled) {
        if(super.isValid(creditEnrolled))
        {
            if(!isStudyAbroad)
            {
                if(creditEnrolled >= 12)
                    return true;
                else
                    return false;
            }
            else
            {
                if(creditEnrolled <= 12)
                    return true;
                else
                    return false;
            }
        }
        else
            return false;
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        double tuitionCost = 29737;
        double universityFee = 3268;
        double healthInFee = 3268;

        if(creditsEnrolled < 12) { //If partTime student
            tuitionCost = creditsEnrolled * 966;
            universityFee = .8 * universityFee;
            healthInFee = 0;
        }
        else if(creditsEnrolled > 16)
        {
            tuitionCost += (creditsEnrolled * 966);
        }

        if(isStudyAbroad)
            tuitionCost = 0;

        return tuitionCost + universityFee + healthInFee;
    }

    @Override
    public boolean isResident() {
        return false;
    }


}


