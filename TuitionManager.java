
import java.util.Calendar;
import java.util.Scanner;


public class TuitionManager {
    Scanner sc = new Scanner(System.in);
    Roster roster = new Roster();
    public String dateVal;
    public String lname;
    public String fname;
    public String major;
    public Date date;
    public int credit;
    public String check;

    /**
     Method to add a team member.
     */
    private void add() {

        try {  // invalid credit value
            credit = Integer.parseInt(sc.next());
            if (credit < 0) {
                System.out.println("Credits completed invalid: cannot be negative!");
                return;
            }
        } catch (NumberFormatException e) { ////o Negative number of credit completed
            System.out.println("Credits completed invalid: not an integer!");
            return;
        }
        // check if the date is valid
        //o Any date of birth that is not a valid calendar date
        if (!date.isValid()) {
            System.out.println("DOB invalid: "+ dateVal + " not a valid calendar date!");
            return;
        }
        /**
         * o The date of birth is today or a future date
         * o A student who is less than 16 years old
         * using the Calendar.
         */
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        try {
            dob.setTime(new java.text.SimpleDateFormat("MM/dd/yyyy").parse(dateVal));
        } catch (java.text.ParseException e) {
            System.out.println("Invalid date of birth format. Please enter in MM/DD/YYYY format.");
            return;
        }

        if (dob.after(today)) {
            System.out.println("Date of birth cannot be in the future.");
            return;
        }
        int yearDiff = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        int monthDiff = today.get(Calendar.MONTH) - dob.get(Calendar.MONTH);
        int dayDiff = today.get(Calendar.DAY_OF_MONTH) - dob.get(Calendar.DAY_OF_MONTH);
        if (yearDiff < 16) {
            System.out.println("DOB invalid: " + dateVal + " younger than 16 years old.");
            return;
        } else if (yearDiff == 16) {
            if (monthDiff < 0) {
                System.out.println("DOB invalid: " + dateVal + " younger than 16 years old.");
                return;
            } else if (monthDiff == 0) {
                if (dayDiff < 0) {
                    System.out.println("DOB invalid: " + dateVal + " younger than 16 years old.");
                    return;
                }
            }
        }

        /**
         * if there is an invalid major, print - AA, BB is invalid major.
         * o The major doesn’t exist
         */
        Major majorEnum;
        try {
            majorEnum = Major.valueOf(major);
        } catch (IllegalArgumentException e) {
            System.out.println("Major code invalid: "+ major);
            return;
        }
        // check if the roster already contains a student with the same name
        //using the contains
        Student student = new Student(new Profile(lname, fname, date), Major.valueOf(major),credit);
        Profile profile = new Profile(lname, fname, date);
        if (roster.contains(student)) { //o The student is in the roster already
            System.out.println(profile.toString()+ " is already in the roster!"); //lname + " "+ fname + " "+ dateVal
            return;
        }
        // if the date and student are valid, add the student to the roster
        roster.add(student);
        System.out.println(profile.toString()+ " has been added to the roster.");
    }

    /**
     * remove the student in the list.
     */
    private void remove(){
        lname = sc.next();
        fname = sc.next();
        dateVal = sc.next();
        date = new Date(dateVal);

        Student student = new Student(new Profile(lname, fname, date), Major.valueOf(major),credit);
        Profile profile = new Profile(lname, fname, date);
        //if there is no student, print X is not in the roster..
        if (!roster.contains(student)) {
            System.out.println(profile.toString()+ " is not in the roster.");
            return;
        }

        roster.remove(student);
        //read the file and removed the student.
        System.out.println(profile.toString()+ " removed from the roster.");
    }

    /**
     * to change the student's major
     */
    private void changeMajor(){
        lname = sc.next();
        fname = sc.next();
        dateVal = sc.next();
        major = sc.next().toUpperCase();
        date = new Date(dateVal);
        Major majorEnum;
        try {
            majorEnum = Major.valueOf(major);
        } catch (IllegalArgumentException e) {
            System.out.println("Major code invalid: " + major);
            return;
        }
        Student student = new Student(new Profile(lname, fname, date),Major.valueOf(major),credit);
        Profile profile = new Profile(lname, fname, date);
        if (!roster.contains(student)) {
            System.out.println(profile.toString()+ " is not in the roster.");
            return;
        }

        if(major.equals(major)){
            System.out.println(profile.toString() +" major changed to "+ major);
        }

    }
    try {
        loadStudentRoster();
        System.out.println("Student roster has been loaded.");
    } catch (IOException e) {
        System.out.println("Error: Failed to load student roster.");
        e.printStackTrace();
    }
    
    /**
 * Enroll a student with the number of credits.
 */
private void enroll() {
    lname = sc.next();
    fname = sc.next();
    dateVal = sc.next();
    date = new Date(dateVal);

    try { // Invalid credit value
        credit = Integer.parseInt(sc.next());
        if (credit < 0) {
            System.out.println("Credits completed invalid: cannot be negative!");
            return;
        }
    } catch (NumberFormatException e) { // Negative number of credit completed
        System.out.println("Credits completed invalid: not an integer!");
        return;
    }

    Profile profile = new Profile(lname, fname, date);
    Student student = new Student(profile, null, credit);

    if (roster.contains(student)) {
        roster.remove(student);
    }
    roster.add(student);

    System.out.println(profile.toString() + " has been enrolled.");
}
    
    /**
 * Drop a student from the enrollment list.
 */
private void drop() {
    lname = sc.next();
    fname = sc.next();
    dateVal = sc.next();
    date = new Date(dateVal);

    Student student = new Student(new Profile(lname, fname, date), Major.valueOf(major),credit);
    Profile profile = new Profile(lname, fname, date);
    
    if (!roster.contains(student)) {
        System.out.println(profile.toString() + " is not in the roster.");
        return;
    }

    roster.remove(student);
    System.out.println(profile.toString() + " has been dropped from the roster.");
}
    private void displayEnrollmentList() {
    for(int i = 0; i < enrollmentList.length; i++) {
        System.out.println(enrollmentList[i]);
    }
}
    private void semesterEnd() {
    for (int i = 0; i < creditsCompleted.length; i++) {
        creditsCompleted[i] += enrolledCredits[i];
        if (creditsCompleted[i] >= 120) {
            System.out.println("Student " + (i+1) + " has completed " + creditsCompleted[i] + " credits and is eligible to graduate.");
        }
    }
    /**
     * You MUST keep this
     * method under 40 lines for readability,
     */
    public void run()
    {
        System.out.println("Tuition Manager running...");
        boolean run = false;
        while (!run)
        {
            String command = " ";
            command = sc.next();
            switch (command)
            {
                case "A":
                    lname= sc.next(); fname = sc.next(); dateVal= sc.next(); major = sc.next().toUpperCase() ; date = new Date(dateVal);
                    add(); break;
                case "R":
                    remove(); break;
                case "P":
                    roster.sortByProfile(); break;
                case "PS":
                    roster.printByStanding(); break;
                case "PC":
                    roster.printBySchoolMajor(); break;
                case "L":
                    String school = sc.next();
                    roster.printBySchool(school); break;
                case "C":
                    changeMajor(); break;
                case "E":
                    enroll(); break;
                case "D":
                    drop(); break;
                case "Q":
                    System.out.println("Roster Manager terminated."); System.exit(0); break;
                case "PE":
                    displayEnrollmentList(); break;
                case "SE": 
                    semesterEnd(); break;
                default:
                    System.out.println(command + " is an invalid command!."); break;
            }
        }
    } //run()
}
