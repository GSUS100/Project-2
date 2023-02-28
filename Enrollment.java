public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;

    public Enrollment() {
        enrollStudents = new EnrollStudent[4];
        size = 0;
    }

    public EnrollStudent [] getEnrolledStudents()
    {
        return enrollStudents;
    }

    public void add(EnrollStudent enrollStudent) //add to the end of array
    {
        if (size == enrollStudents.length) {
            grow();
        }
        enrollStudents[size++] = enrollStudent;
    }

    public EnrollStudent getStudent(EnrollStudent student) {
        int i = find(student);
        if (i != 1)
            return enrollStudents[i];
        else
            return null;
    }

    private void grow() {
        EnrollStudent[] newEnrollStudents = new EnrollStudent[enrollStudents.length + 4];
        System.arraycopy(enrollStudents, 0, newEnrollStudents, 0, size);
        enrollStudents = newEnrollStudents;
    }


    //move the last one in the array to replace the deleting index position
    public void remove(EnrollStudent enrollStudent) {
        int index = find(enrollStudent);
        if (index == -1) {
            System.out.println("Student not found in EnrolledStudents()");
        } else {
            for (int i = index; i < size - 1; i++) {
                enrollStudents[i] = enrollStudents[i + 1];
            }
            size--;
        }
    }

    public int find(EnrollStudent student) {
        for (int i = 0; i < size; i++) {
            if (enrollStudents[i].equals(student)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(EnrollStudent enrollStudent) {
        return find(enrollStudent) != -1;
    }


    public void print() {
        if (size == 0) {
            System.out.println("Enrolled Students is empty!");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(enrollStudents[i].toString());
                //System.out.println(roster[i].getProfile() + " (" + roster[i].getMajor().getCode()+" "+ roster[i].getMajor()+" "+roster[i].getMajor().getSchool()+ ") credits completed: " + roster[i].getCreditCompleted() + " ("+ roster[i].getStanding()+")");
            }
        }
        System.out.println("* end of enrolled students **");
    } //print the array as is without sorting

    public void printTuitionDue(Roster roster) {
        if (size == 0) {
            System.out.println("Enrolled Students is empty!");
        } else {
            for (int i = 0; i < size; i++) {
                int creditsEnrolled = enrollStudents[i].getCreditsEnrolled();
                Student nstudent = roster.findStudentByProfile(enrollStudents[i].getProfile());
                if(nstudent == null) {
                    System.out.println("Some kind of error happened");
                    return;
                }
                System.out.println(enrollStudents[i].toString() + " Amount Due: $" + nstudent.tuitionDue(creditsEnrolled) );
                //System.out.println(roster[i].getProfile() + " (" + roster[i].getMajor().getCode()+" "+ roster[i].getMajor()+" "+roster[i].getMajor().getSchool()+ ") credits completed: " + roster[i].getCreditCompleted() + " ("+ roster[i].getStanding()+")");
            }
        }



    }


}
