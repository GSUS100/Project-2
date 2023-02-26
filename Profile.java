
/**
 * Profile class to represent the student profile
 * @author Yehun Kim, Nelson Reyes
 */
class Profile implements Comparable<Profile> {
    private String lname;
    private String fname;
    private Date dob;

    /**
     * must override the toString(), equals(), and compareTo()
     * @param lname
     * @param fname
     * @param dob
     */
    public Profile(String lname, String fname, Date dob) {
        this.lname = lname;
        this.fname = fname;
        this.dob = dob;
    }

    public String getLname() {
        return lname;
    }

    public String getFname() {
        return fname;
    }

    public Date getDob() {
        return dob;
    }

    /**
     *
     * @param profile the object to be compared.
     * @return fname and dob
     */
    @Override
    public int compareTo(Profile profile) {
        int result = lname.compareTo(profile.getLname());
        if (result == 0) {
            result = fname.compareTo(profile.getFname());
            if (result == 0) {
                result = dob.compareTo(profile.getDob());
                if (result == 0) {
                    return 0;
                }
                else if (result < 0) {
                    return -1;
                }else{
                    return 0;
                }
            }
        }
        return result;
    }

    /**
     *
     * @param obj
     * @return false if lname.equalsIgnoreCase.lname is false also fname
     * for the checking the lower letter and upper letter of student's name
     * --> jone Doe and Jone Doe are same student. (if they have same dob)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Profile)) return false;

        Profile profile = (Profile) obj;

        if (!lname.equalsIgnoreCase(profile.lname)) return false;
        if (!fname.equalsIgnoreCase(profile.fname)) return false;
        return dob.equals(profile.dob);
    }

    @Override
    public String toString() {
        return lname + " " + fname + " " + dob;
    }
}