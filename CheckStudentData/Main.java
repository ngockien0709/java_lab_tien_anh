
import Entities.*;
import Functions.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Management check = new Management();
        ArrayList<Student> studentList = new ArrayList<>();

        System.out.println("====== Management Student Program ======");
        //get student info
        studentList = check.getStudentInfo(studentList);
        //print out the list
        check.printStudentList(studentList);
        //print out classification Info
        check.getPercent(studentList);
    }

}
