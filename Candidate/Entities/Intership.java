package Entities;

import Validate_and_InputData.InputData;
import java.util.ArrayList;

public class Intership extends Candidate {

    private String majors;
    private String semester;
    private String universityName;

    public Intership() {
    }

    public Intership(String majors, String semester, String universityName, String ID,
            String firstName, String lastName, int birthDate, String address,
            String phone, String email, int type) {
        super(ID, firstName, lastName, birthDate, address, phone, email, type);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    // create intership candidate
    public void createCandidateIntership(ArrayList<Candidate> candi) {
        System.out.println("-------- Intern candidate --------");
        // extends candidate method
        super.createCandidate(candi);
        InputData input = new InputData();

        type = 2;
        majors = input.inputWord(InputData.AlphaBetNumber, "Enter majors: ",
                "Majors must not contain special character. Try again!");
        universityName = input.inputWord(InputData.AlphaBetNumber, "Enter University name: ",
                "University name must not contain special character. Try again!");

        System.out.println("Create Successful!");
    }

}
