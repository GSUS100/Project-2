public class EnrollStudent {
    private Profile profile;
    private int creditsEnrolled;

    public EnrollStudent(Profile profile, int creditsEnrolled) {
        this.profile = profile;
        this.creditsEnrolled = creditsEnrolled;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getCreditsEnrolled() {
        return creditsEnrolled;
    }

    public void setCreditsEnrolled(int creditsEnrolled) {
        this.creditsEnrolled = creditsEnrolled;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EnrollStudent)) {
            return false;
        }
        EnrollStudent enrollStudent = (EnrollStudent) obj;
        return enrollStudent.profile.equals(this.profile);
    }

    @Override
    public String toString() {
        return "Profile: " + profile.toString() + ", Credits Enrolled: " + creditsEnrolled;
    }
}
