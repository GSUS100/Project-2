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

import org.junit.Test;
import static org.junit.Assert.*;

public class InternationalTest {

    @Test
    public void testTuitionDueNotStudyAbroad() {
        International student = new International(new Profile("Carl", "Brown", "BU"), Major.CS, 0, false);
        assertEquals(39781, student.tuitionDue(16), 0.0); //full-time with 16 credits
        assertEquals(7741, student.tuitionDue(8), 0.0); //part-time with 8 credits
    }

    @Test
    public void testTuitionDueStudyAbroad() {
        International student = new International(new Profile("Carl", "Brown", "BU"), Major.CS, 0, true);
        assertEquals(0, student.tuitionDue(12), 0.0); //study abroad with any number of credits
    }
}

