package home2;

public class Main {

    public static final int NUMBER_TYPE = 9;


    public static void main(String[] args) {
        Students st = new Students(UtilClass.stud(NUMBER_TYPE));
        st.getStudents();
    }


}
