
/**
 * @author Giancarlo Andretta, Nelson Reyes
 */
// Student class to represent the student

public abstract class Student implements Comparable<Student> {
    private Profile profile;
    private Major major;
    private int creditCompleted;

    public Student(Profile profile, Major major, int creditCompleted) {
        this.profile = profile;
        this.major = major;
        this.creditCompleted = creditCompleted;
    }

    public Profile getProfile() {
        return profile;
    }

    public Major getMajor() {
        return major;
    }

    public int getCreditCompleted() {
        return creditCompleted;
    }

    /**
     *
     * @return Freshman < 30, Sophomore >= 30 && < 60, Junior creditCompleted >= 60 && creditCompleted < 90, senior otherwise
     */
    public String getStanding() {
        if (creditCompleted < 30) {
            return "Freshman";
        } else if (creditCompleted >= 30 && creditCompleted < 60) {
            return "Sophomore";
        } else if (creditCompleted >= 60 && creditCompleted < 90) {
            return "Junior";
        } else {
            return "Senior";
        }
    }



    public boolean isValid(int creditEnrolled) {
        if(!(creditEnrolled <= 24 && creditEnrolled >= 3))
            return false;
        else
            return true;
    }

    public abstract double tuitionDue(int creditsEnrolled);
    public abstract boolean isResident();






    /**
     * Compares one Object to another
     * @param other an Object
     * @return 0 if o equals this Student, 1 if this fname and lname comes before o,
     *  -1 if this fname and lname comes after o, and -2 if o is not a Student.
     */
    @Override
    public int compareTo(Student other) {
        if(other instanceof Student){
            Student temp = (Student) other;
            int tempCompareVal = ((this.profile).compareTo((temp.profile)));
            if(tempCompareVal == 0 ){
                return 0;
            }else if(tempCompareVal > 0 ){
                return 1;
            }else return -1;
        }else return -2; // not an instance
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }
        Student other = (Student) obj;
        return this.profile.equals(other.profile);
    }
    /**
     * Method to get information on Student instance variables.
     * @return String with profile, major, credit, standing
     */
    @Override
    public String toString() {
        return profile + " (" + major.getCode() + " "+ major+" " +major.getSchool()+") credits completed: "+ creditCompleted + " (" + getStanding()+")";
    }

    /**
     * testbed main method for Student class
     * @param args
     */
//    public static void main(String []args){
//        Student[] compareTest = {
//                new Student(new Profile("John", "Doe", new Date("1/2/2007")), Major.EE ,Integer.parseInt("30")),
//                new Student(new Profile("April", "Doe", new Date("1/20/2003")), Major.EE ,Integer.parseInt("-1")),
//                new Student(new Profile("Jane", "Doe", new Date("5/1/1996")), Major.CS ,Integer.parseInt("30")),
//                new Student(new Profile("Mary", "Lindsey", new Date("12/1/2001")), Major.BAIT ,Integer.parseInt("89")),
//                new Student(new Profile("Deuk", "Ellington", new Date("2/29/2004")), Major.MATH ,Integer.parseInt("46")),
//                new Student(new Profile("Paul", "Siegel", new Date("5/1/1999")), Major.CS ,Integer.parseInt("120"))
//        };
//        System.out.println("Testing (testbed main) compareTo() :");
//        /**
//         * Using the for loop, compare current and next
//         * return0 if o equals this Student, 1 if this fname and lname comes before o,
//         *      *  -1 if this fname and lname comes after o, and -2 if o is not a Student.
//         */
//        for(int i = 0; i< compareTest.length-1; i++){
//            Student current = compareTest[i];
//            Student next = compareTest[i + 1];
//            //current.compareTo(compareTest[i]);
//            System.out.printf("\nTest case %d: %s", i+1, current.compareTo(next)); // if this student comes before -1, 1 after
//            System.out.printf("\nTest case %d: %s\n", i+1, current.compareTo(current)); //return value should be 0, testing for equal
//        }
    }
}