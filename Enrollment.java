public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;

    public Enrollment() {
        enrollStudents = new EnrollStudent[100];
        size = 0;
    }

    public void add(EnrollStudent enrollStudent) {
        enrollStudents[size] = enrollStudent;
        size++;
    }

    public void remove(EnrollStudent enrollStudent) {
        for (int i = 0; i < size; i++) {
            if (enrollStudents[i].equals(enrollStudent)) {
                enrollStudents[i] = enrollStudents[size - 1];
                enrollStudents[size - 1] = null;
                size--;
                break;
            }
        }
    }

    public boolean contains(EnrollStudent enrollStudent) {
        for (int i = 0; i < size; i++) {
            if (enrollStudents[i].equals(enrollStudent)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(enrollStudents[i]);
        }
    }
}
