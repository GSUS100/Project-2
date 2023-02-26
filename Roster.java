
/**
 * Roster class
 * @author Yehun Kim, Nelson Reyes
 */

public class Roster {


    private Student[] roster;
    private int size;

    public Roster() {
        roster = new Student[4];
        size = 0;
    }
    //find the class if it roster equals to student
    private int find(Student student) {
        for (int i = 0; i < size; i++) {
            if (roster[i].equals(student)) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        Student[] newRoster = new Student[roster.length + 4];
        System.arraycopy(roster, 0, newRoster, 0, size);
        roster = newRoster;
    }
    //Add student
    /**
     * Adds a student to the data
     * @param student The std to be added
     * @return if the std was added successfully
     */
    public boolean add(Student student) {
        if (size == roster.length) {
            grow();
        }
        roster[size++] = student;
        return true;
    }

    //remove student
    /**
     * Removes a student from the database
     * @param student The student to be removed
     * @return if the student was removed successfully
     */
    public boolean remove(Student student) {
        int index = find(student);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            roster[i] = roster[i + 1];
        }
        size--;
        return true;
    }

    /**
     *
     * @param student using to check the roster contains student.
     * @return if the roster contains student
     */
    public boolean contains(Student student) {
        return find(student) != -1;
    }

    /**
     * print "* Student roster sorted by last name, first name, DOB **"
     * -2.....
     */
    public void sortByProfile () {
        if(size == 0){
            System.out.println("Student roster is empty!");
        }else{
            System.out.println("* Student roster sorted by last name, first name, DOB **");
            for (int i = 0; i < size - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < size; j++) {
                    if (roster[j].compareTo(roster[minIndex]) < 0) {
                        minIndex = j;
                    }
                }
                Student temp = roster[minIndex];
                roster[minIndex] = roster[i];
                roster[i] = temp;
            }
            print();
        }

    }

    /**
     * print method() to print out the roster value
     */
    public void print() {
        if(size == 0){
            System.out.println("Student roster is empty!");
        }else{
            for (int i = 0; i < size; i++) {
                System.out.println(roster[i].toString());
                //System.out.println(roster[i].getProfile() + " (" + roster[i].getMajor().getCode()+" "+ roster[i].getMajor()+" "+roster[i].getMajor().getSchool()+ ") credits completed: " + roster[i].getCreditCompleted() + " ("+ roster[i].getStanding()+")");
            }
        }
        System.out.println("* end of roster **");
    }

    /**
     * print "* Student roster sorted by school, major **"
     */
    public void printBySchoolMajor() {
        if(size == 0){
            System.out.println("Student roster is empty!");
        }else{
            System.out.println("* Student roster sorted by school, major **");
            for (int i = 0; i < size - 1; i++) {
                int MIN_INDEX = i;
                for (int j = i + 1; j < size; j++) {
                    int comp = roster[j].getMajor().compareTo(roster[MIN_INDEX].getMajor());
                    if (comp == 0) {
                        comp = roster[j].compareTo(roster[MIN_INDEX]);
                    }
                    if (comp < 0) {
                        MIN_INDEX = j;
                    }
                }
                Student temp = roster[MIN_INDEX];
                roster[MIN_INDEX] = roster[i];
                roster[i] = temp;
            }
            print();
        }
    }

    /**
     *
     * @param school to sorted by school of major for command L
     */
    public void printBySchool(String school){

        if(size == 0){
            System.out.println("Student roster is empty!");
        }else if(school.equalsIgnoreCase("SAS") || school.equalsIgnoreCase("EE")
                ||school.equalsIgnoreCase("SC&I")||school.equalsIgnoreCase("RBS") ||school.equalsIgnoreCase("SOE")){
            System.out.println("* students in "+ school + "*");
            for(int i = 0; i< size; i ++){
                if(roster[i].getMajor().getSchool().equalsIgnoreCase(school)){
                    System.out.println(roster[i]);
                }
            }
            System.out.println("* end of roster**");
        }
        else{
            System.out.println("Schoold doesn't exist: " + school);
        }
    }



    /**
     * print "* Student roster sorted by standing **"
     */
    public void printByStanding() {
        if(size == 0){
            System.out.println("Student roster is empty!");
        }else{
            System.out.println("* Student roster sorted by standing **");
            for (int i = 0; i < size - 1; i++) {
                int MIN_INDEX = i;
                for (int j = i + 1; j < size; j++) {
                    int comp = Integer.compare(roster[j].getCreditCompleted(), roster[MIN_INDEX].getCreditCompleted());
                    if (comp == 0) {
                        comp = roster[j].compareTo(roster[MIN_INDEX]);
                    }
                    if (comp < 0) {
                        MIN_INDEX = j;
                    }
                }
                Student temp = roster[MIN_INDEX];
                roster[MIN_INDEX] = roster[i];
                roster[i] = temp;
            }
            print();
        }
    }
}


