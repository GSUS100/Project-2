
/**
 * @author Yehun Kim, Nelson Reyes
 * The enum class for the majors. You must use an enum class to define the majors, which include a list of the
 * major names, major codes, and school names
 */

/**
 * CS, MATH, ITI, EE, BAIT given major from the project1 + cods, school names
 */
public enum Major {
    CS("01:198", "SAS"),
    MATH("01:640", "SAS"),
    ITI("04:547", "SC&I"),
    EE("14:332","SOE"),
    BAIT("33:136", "RBS");


    private final String code;
    private final String school;

    Major(String code, String school) {
        this.code = code;
        this.school = school;
    }

    /**
     *
     * @return code and school when I need to getCode and getSchool
     */
    public String getCode() {
        return code;
    }

    public String getSchool() {
        return school;
    }
}

