package home2;

public final class Students {
    private final Student[] students;

    public Students(Student[] students) {
        this.students = students;
    }

    public void getStudents() {
        for (Student s : students) {
            System.out.println(s.discript());
            s.hours();
        }
    }

}
