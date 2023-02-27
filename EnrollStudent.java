public class EnrollStudent {
    private Profile profile;
    private int creditsEnrolled;

    public EnrollStudent(Profile profile, int creditsEnrolled)
    {
        this.profile = profile;
        this.creditsEnrolled = creditsEnrolled;
    }

    public Profile getProfile() {
        return profile;
    }

    public int getCreditsEnrolled() {
        return creditsEnrolled;
    }

    public void setCreditsEnrolled(int creditsEnrolled) {
        this.creditsEnrolled = creditsEnrolled;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EnrollStudent)) return false;

        EnrollStudent enrolledStudent = (EnrollStudent) obj;

        if(!super.equals(enrolledStudent)) return false;

        return enrolledStudent.getCreditsEnrolled() == creditsEnrolled;

    }

    @Override
    public String toString() {
        return profile.toString() + " Credits Enrolled: " + creditsEnrolled;
    }
}
