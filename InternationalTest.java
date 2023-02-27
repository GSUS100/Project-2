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
